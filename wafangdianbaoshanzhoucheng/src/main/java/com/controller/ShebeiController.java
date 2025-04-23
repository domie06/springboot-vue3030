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

import com.entity.ShebeiEntity;

import com.service.ShebeiService;
import com.entity.view.ShebeiView;
import com.service.YuangongService;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 设备
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/shebei")
public class ShebeiController {
    private static final Logger logger = LoggerFactory.getLogger(ShebeiController.class);

    @Autowired
    private ShebeiService shebeiService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;



    //级联表service
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
        PageUtils page = shebeiService.queryPage(params);

        //字典表数据转换
        List<ShebeiView> list =(List<ShebeiView>)page.getList();
        for(ShebeiView c:list){
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
        ShebeiEntity shebei = shebeiService.selectById(id);
        if(shebei !=null){
            //entity转view
            ShebeiView view = new ShebeiView();
            BeanUtils.copyProperties( shebei , view );//把实体数据重构到view中

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
    public R save(@RequestBody ShebeiEntity shebei, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,shebei:{}",this.getClass().getName(),shebei.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role)){
            return R.error(511,"权限为空");
        }
        Wrapper<ShebeiEntity> queryWrapper = new EntityWrapper<ShebeiEntity>()
            .eq("shebei_name", shebei.getShebeiName())
            .eq("shebei_types", shebei.getShebeiTypes())
            .eq("shebei_number", shebei.getShebeiNumber())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShebeiEntity shebeiEntity = shebeiService.selectOne(queryWrapper);
        if(shebeiEntity==null){
            shebei.setInsertTime(new Date());
            shebei.setCreateTime(new Date());
            shebeiService.insert(shebei);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ShebeiEntity shebei, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,shebei:{}",this.getClass().getName(),shebei.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role)){
        return R.error(511,"权限为空");
        }
        //根据字段查询是否有相同数据
        Wrapper<ShebeiEntity> queryWrapper = new EntityWrapper<ShebeiEntity>()
            .notIn("id",shebei.getId())
            .andNew()
            .eq("shebei_name", shebei.getShebeiName())
            .eq("shebei_types", shebei.getShebeiTypes())
            .eq("shebei_number", shebei.getShebeiNumber())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShebeiEntity shebeiEntity = shebeiService.selectOne(queryWrapper);
        if(shebeiEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      shebei.set
            //  }
            shebeiService.updateById(shebei);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        shebeiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }






}

