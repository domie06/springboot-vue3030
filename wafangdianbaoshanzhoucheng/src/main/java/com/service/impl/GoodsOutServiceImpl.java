package com.service.impl;

import com.utils.StringUtil;
import org.springframework.stereotype.Service;
import java.lang.reflect.Field;
import java.util.*;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;

import com.dao.GoodsOutDao;
import com.entity.GoodsOutEntity;
import com.service.GoodsOutService;
import com.entity.view.GoodsOutView;

/**
 * 销售 服务实现类
 */
@Service("goodsOutService")
@Transactional
public class GoodsOutServiceImpl extends ServiceImpl<GoodsOutDao, GoodsOutEntity> implements GoodsOutService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<GoodsOutView> page =new Query<GoodsOutView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
