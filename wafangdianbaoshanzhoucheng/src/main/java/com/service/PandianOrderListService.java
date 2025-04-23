package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.PandianOrderListEntity;
import java.util.Map;

/**
 * 盘点详情 服务类
 */
public interface PandianOrderListService extends IService<PandianOrderListEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);
}