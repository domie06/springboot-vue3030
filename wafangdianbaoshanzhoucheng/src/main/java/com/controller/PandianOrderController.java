package com.controller;


import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.StringUtil;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.PandianOrderEntity;

import com.service.PandianOrderService;
import com.entity.view.PandianOrderView;
import com.service.YuangongService;
import com.entity.YuangongEntity;
import com.service.PandianOrderListService;
import com.entity.PandianOrderListEntity;
import com.service.GoodsService;
import com.entity.GoodsEntity;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 盘点
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/pandianOrder")
public class PandianOrderController {
    private static final Logger logger = LoggerFactory.getLogger(PandianOrderController.class);

    @Autowired
    private PandianOrderService pandianOrderService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;



    //级联表service
    @Autowired
    private YuangongService yuangongService;
    // 列表详情的表级联service
    @Autowired
    private PandianOrderListService pandianOrderListService;
//    @Autowired
//    private YonghuService yonghuService;

    @Autowired
    private GoodsService goodsService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role)){
            return R.error(511,"权限为空");
        }
        else if("员工".equals(role)){
            params.put("yuangongId",request.getSession().getAttribute("userId"));
        }
        params.put("orderBy","id");
        PageUtils page = pandianOrderService.queryPage(params);

        //字典表数据转换
        List<PandianOrderView> list =(List<PandianOrderView>)page.getList();
        for(PandianOrderView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        PandianOrderEntity pandianOrder = pandianOrderService.selectById(id);
        if(pandianOrder !=null){
            //entity转view
            PandianOrderView view = new PandianOrderView();
            BeanUtils.copyProperties( pandianOrder , view );//把实体数据重构到view中

            //级联表
            YuangongEntity yuangong = yuangongService.selectById(pandianOrder.getYuangongId());
            if(yuangong != null){
                BeanUtils.copyProperties( yuangong , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setYuangongId(yuangong.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody PandianOrderEntity pandianOrder, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,pandianOrder:{}",this.getClass().getName(),pandianOrder.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role)){
            return R.error(511,"权限为空");
        }
        else if("员工".equals(role)){
            pandianOrder.setYuangongId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        }
        pandianOrder.setInsertTime(new Date());
        pandianOrder.setCreateTime(new Date());
        pandianOrderService.insert(pandianOrder);
        return R.ok();
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody PandianOrderEntity pandianOrder, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,pandianOrder:{}",this.getClass().getName(),pandianOrder.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role)){
        return R.error(511,"权限为空");
        }
        else if("员工".equals(role)){
            pandianOrder.setYuangongId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        }
        Wrapper<PandianOrderEntity> wrapper = new EntityWrapper<>();
        wrapper.eq("pandian_order_name",pandianOrder.getPandianOrderName());
        PandianOrderEntity one = pandianOrderService.selectOne(wrapper);
        if(one != null){
            return R.error("盘点名字已被使用");
        }
        pandianOrderService.updateById(pandianOrder);//根据id更新
        return R.ok();
    }


    /**
    * 盘点
    */
    @RequestMapping("/outPandianOrderList")
    public R inPandianOrderList(@RequestBody  Map<String, Object> params,HttpServletRequest request){
        logger.debug("outPandianOrderList方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));


        Date date = new Date();//当前时间
        Integer userId = (Integer) request.getSession().getAttribute("userId");//当前登录人的id
        String tableName = (String) request.getSession().getAttribute("tableName");//当前登录人的表名

        String role = String.valueOf(request.getSession().getAttribute("role"));
        Object yuangongId1 = params.get("yuangongId");
        if(yuangongId1 == null  && !"员工".equals(role)){
            return R.error("操作人不能为空");
        }else if("员工".equals(role)){
            yuangongId1 = String.valueOf(request.getSession().getAttribute("userId"));
        }
        String yuangongId = String.valueOf(yuangongId1) ; //操作人
        String pandianOrderName = (String) params.get("pandianOrderName"); // 盘点名

        Wrapper<PandianOrderEntity> wrapper = new EntityWrapper<>();
        wrapper.eq("pandian_order_name",pandianOrderName);
        PandianOrderEntity one = pandianOrderService.selectOne(wrapper);
        if(one != null){
            return R.error("盘点名字已被使用");
        }

        HashMap<String, Integer> map = (HashMap<String, Integer>) params.get("map");// id 和 数量
        if(map == null || map.size() ==0){
            return R.error("添加不能为空");
        }else{
            Set<String> ids = map.keySet(); // 获取添加数据的ids
            Map<String, Integer> oldGoodsMap = new HashMap<>();//老的商品信息
            List<GoodsEntity> goodsList = goodsService.selectList(new EntityWrapper<GoodsEntity>().in("id", ids));
            if(goodsList == null  || goodsList.size() ==0 || map.size() != goodsList.size() ){
                return R.error("查询物资为空 或者 盘点物资和数据库中不一致,请去列表中查找确认");
            }else{
                for(GoodsEntity goods : goodsList){
                    oldGoodsMap.put(String.valueOf(goods.getId()),goods.getGoodsNumber());// 把盘点前的商品给添加进去
                    goods.setGoodsNumber(map.get(String.valueOf(goods.getId())));//设置商品数量为传过来的商品数量
                }
            }

                //添加当前列表
            PandianOrderEntity pandianOrderEntity = new PandianOrderEntity();//新增订单
            pandianOrderEntity.setYuangongId(Integer.valueOf(yuangongId));
            pandianOrderEntity.setPandianOrderName(pandianOrderName);
            pandianOrderEntity.setInsertTime(date);
            pandianOrderEntity.setCreateTime(date);
            pandianOrderService.insert(pandianOrderEntity);

                //详情表的添加
            List<PandianOrderListEntity> pandianOrderLists = new ArrayList<>();
            for(String i:ids){
                PandianOrderListEntity entity = new PandianOrderListEntity();
                entity.setPandianOrderId(pandianOrderEntity.getId());
                entity.setGoodsId(Integer.valueOf(i));
                entity.setGoodsQianNumber(oldGoodsMap.get(i));
                entity.setPandianOrderListNumber(map.get(i));
                entity.setInsertTime(date);
                entity.setCreateTime(date);
                pandianOrderLists.add(entity);
            }
            pandianOrderListService.insertBatch(pandianOrderLists);
            goodsService.updateBatchById(goodsList);
            return R.ok();
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        pandianOrderService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }






}

