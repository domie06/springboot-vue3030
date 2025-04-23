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

import com.entity.GongyinghsangEntity;

import com.service.GongyinghsangService;
import com.entity.view.GongyinghsangView;
import com.service.YuangongService;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 供应商
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/gongyinghsang")
public class GongyinghsangController {
    private static final Logger logger = LoggerFactory.getLogger(GongyinghsangController.class);

    @Autowired
    private GongyinghsangService gongyinghsangService;


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
        PageUtils page = gongyinghsangService.queryPage(params);

        //字典表数据转换
        List<GongyinghsangView> list =(List<GongyinghsangView>)page.getList();
        for(GongyinghsangView c:list){
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
        GongyinghsangEntity gongyinghsang = gongyinghsangService.selectById(id);
        if(gongyinghsang !=null){
            //entity转view
            GongyinghsangView view = new GongyinghsangView();
            BeanUtils.copyProperties( gongyinghsang , view );//把实体数据重构到view中

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
    public R save(@RequestBody GongyinghsangEntity gongyinghsang, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,gongyinghsang:{}",this.getClass().getName(),gongyinghsang.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role)){
            return R.error(511,"权限为空");
        }
        Wrapper<GongyinghsangEntity> queryWrapper = new EntityWrapper<GongyinghsangEntity>()
            .eq("gongyinghsang_name", gongyinghsang.getGongyinghsangName())
            .eq("gongyinghsang_types", gongyinghsang.getGongyinghsangTypes())
            .eq("gongyinghsang_xinyong_types", gongyinghsang.getGongyinghsangXinyongTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        GongyinghsangEntity gongyinghsangEntity = gongyinghsangService.selectOne(queryWrapper);
        if(gongyinghsangEntity==null){
            gongyinghsang.setInsertTime(new Date());
            gongyinghsang.setCreateTime(new Date());
            gongyinghsangService.insert(gongyinghsang);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody GongyinghsangEntity gongyinghsang, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,gongyinghsang:{}",this.getClass().getName(),gongyinghsang.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role)){
        return R.error(511,"权限为空");
        }
        //根据字段查询是否有相同数据
        Wrapper<GongyinghsangEntity> queryWrapper = new EntityWrapper<GongyinghsangEntity>()
            .notIn("id",gongyinghsang.getId())
            .andNew()
            .eq("gongyinghsang_name", gongyinghsang.getGongyinghsangName())
            .eq("gongyinghsang_types", gongyinghsang.getGongyinghsangTypes())
            .eq("gongyinghsang_xinyong_types", gongyinghsang.getGongyinghsangXinyongTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        GongyinghsangEntity gongyinghsangEntity = gongyinghsangService.selectOne(queryWrapper);
        if(gongyinghsangEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      gongyinghsang.set
            //  }
            gongyinghsangService.updateById(gongyinghsang);//根据id更新
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
        gongyinghsangService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }






}

