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

import com.entity.GoodsInEntity;

import com.service.GoodsInService;
import com.entity.view.GoodsInView;
import com.service.GongyinghsangService;
import com.entity.GongyinghsangEntity;
import com.service.GoodsService;
import com.entity.GoodsEntity;
import com.service.YuangongService;
import com.entity.YuangongEntity;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 入库
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/goodsIn")
public class GoodsInController {
    private static final Logger logger = LoggerFactory.getLogger(GoodsInController.class);

    @Autowired
    private GoodsInService goodsInService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;



    //级联表service
    @Autowired
    private GongyinghsangService gongyinghsangService;
    @Autowired
    private GoodsService goodsService;
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
        PageUtils page = goodsInService.queryPage(params);

        //字典表数据转换
        List<GoodsInView> list =(List<GoodsInView>)page.getList();
        for(GoodsInView c:list){
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
        GoodsInEntity goodsIn = goodsInService.selectById(id);
        if(goodsIn !=null){
            //entity转view
            GoodsInView view = new GoodsInView();
            BeanUtils.copyProperties( goodsIn , view );//把实体数据重构到view中

            //级联表
            GongyinghsangEntity gongyinghsang = gongyinghsangService.selectById(goodsIn.getGongyinghsangId());
            if(gongyinghsang != null){
                BeanUtils.copyProperties( gongyinghsang , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setGongyinghsangId(gongyinghsang.getId());
            }
            //级联表
            GoodsEntity goods = goodsService.selectById(goodsIn.getGoodsId());
            if(goods != null){
                BeanUtils.copyProperties( goods , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setGoodsId(goods.getId());
            }
            //级联表
            YuangongEntity yuangong = yuangongService.selectById(goodsIn.getYuangongId());
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
    public R save(@RequestBody GoodsInEntity goodsIn, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,goodsIn:{}",this.getClass().getName(),goodsIn.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role)){
            return R.error(511,"权限为空");
        }
        else if("员工".equals(role)){
            goodsIn.setYuangongId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        }
        GoodsEntity goodsEntity = goodsService.selectById(goodsIn.getGoodsId());
        if(goodsEntity == null || goodsEntity.getGoodsNumber() == null){
            return R.error(511,"商品为空或者商品数量为空");
        }
        goodsEntity.setGoodsNumber(goodsEntity.getGoodsNumber()+goodsIn.getGoodsInNumber());
        goodsService.updateById(goodsEntity);
        goodsIn.setInsertTime(new Date());
        goodsIn.setCreateTime(new Date());
        goodsInService.insert(goodsIn);
        return R.ok();
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody GoodsInEntity goodsIn, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,goodsIn:{}",this.getClass().getName(),goodsIn.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role)){
        return R.error(511,"权限为空");
        }
        else if("员工".equals(role)){
            goodsIn.setYuangongId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        }

        GoodsInEntity oldGoodsInEntity = goodsInService.selectById(goodsIn.getId());
        GoodsEntity oldGoodsEntity = goodsService.selectById(oldGoodsInEntity.getGoodsId());//老的
        if(oldGoodsEntity == null || oldGoodsEntity.getGoodsNumber() == null){
            return R.error(511,"修改前商品为空或者修改前商品数量为空");
        }
        oldGoodsEntity.setGoodsNumber(oldGoodsEntity.getGoodsNumber() - oldGoodsInEntity.getGoodsInNumber());// 老的数量
        goodsService.updateById(oldGoodsEntity);// 更改老的数据

        GoodsEntity newGoodsEntity = goodsService.selectById(goodsIn.getGoodsId());//新的
        if(newGoodsEntity == null || newGoodsEntity.getGoodsNumber() == null){
            return R.error(511,"修改后商品为空或者修改后商品数量为空");
        }
        newGoodsEntity.setGoodsNumber(newGoodsEntity.getGoodsNumber() + goodsIn.getGoodsInNumber());// 新的数量


        goodsService.updateById(newGoodsEntity);// 更改新的数据
        goodsInService.updateById(goodsIn);//根据id更新
        return R.ok();

    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        goodsInService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }






}

