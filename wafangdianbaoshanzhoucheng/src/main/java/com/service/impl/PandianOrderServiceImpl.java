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

import com.dao.PandianOrderDao;
import com.entity.PandianOrderEntity;
import com.service.PandianOrderService;
import com.entity.view.PandianOrderView;

/**
 * 盘点 服务实现类
 */
@Service("pandianOrderService")
@Transactional
public class PandianOrderServiceImpl extends ServiceImpl<PandianOrderDao, PandianOrderEntity> implements PandianOrderService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<PandianOrderView> page =new Query<PandianOrderView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
