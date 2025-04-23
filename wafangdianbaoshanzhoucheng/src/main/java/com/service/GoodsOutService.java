package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.GoodsOutEntity;
import java.util.Map;

/**
 * 销售 服务类
 */
public interface GoodsOutService extends IService<GoodsOutEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);
}