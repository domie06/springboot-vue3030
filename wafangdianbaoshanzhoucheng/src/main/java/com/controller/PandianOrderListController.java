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

import com.entity.PandianOrderListEntity;

import com.service.PandianOrderListService;
import com.entity.view.PandianOrderListView;
import com.service.GoodsService;
import com.entity.GoodsEntity;
import com.service.PandianOrderService;
import com.entity.PandianOrderEntity;
import com.service.YuangongService;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 盘点详情
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/pandianOrderList")
public class PandianOrderListController {
    private static final Logger logger = LoggerFactory.getLogger(PandianOrderListController.class);

    @Autowired
    private PandianOrderListService pandianOrderListService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;



    //级联表service
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private PandianOrderService pandianOrderService;
    @Autowired
    private YuangongService yuangongService;


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
        PageUtils page = pandianOrderListService.queryPage(params);

        //字典表数据转换
        List<PandianOrderListView> list =(List<PandianOrderListView>)page.getList();
        for(PandianOrderListView c:list){
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
        PandianOrderListEntity pandianOrderList = pandianOrderListService.selectById(id);
        if(pandianOrderList !=null){
            //entity转view
            PandianOrderListView view = new PandianOrderListView();
            BeanUtils.copyProperties( pandianOrderList , view );//把实体数据重构到view中

            //级联表
            GoodsEntity goods = goodsService.selectById(pandianOrderList.getGoodsId());
            if(goods != null){
                BeanUtils.copyProperties( goods , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setGoodsId(goods.getId());
            }
            //级联表
            PandianOrderEntity pandianOrder = pandianOrderService.selectById(pandianOrderList.getPandianOrderId());
            if(pandianOrder != null){
                BeanUtils.copyProperties( pandianOrder , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setPandianOrderId(pandianOrder.getId());
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
    public R save(@RequestBody PandianOrderListEntity pandianOrderList, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,pandianOrderList:{}",this.getClass().getName(),pandianOrderList.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role)){
            return R.error(511,"权限为空");
        }
        pandianOrderList.setInsertTime(new Date());
        pandianOrderList.setCreateTime(new Date());
        pandianOrderListService.insert(pandianOrderList);
        return R.ok();
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody PandianOrderListEntity pandianOrderList, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,pandianOrderList:{}",this.getClass().getName(),pandianOrderList.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role)){
        return R.error(511,"权限为空");
        }
        pandianOrderListService.updateById(pandianOrderList);//根据id更新
        return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        pandianOrderListService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }






}

