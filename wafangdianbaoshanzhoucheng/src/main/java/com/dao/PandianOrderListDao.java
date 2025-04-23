package com.dao;

import com.entity.PandianOrderListEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.PandianOrderListView;

/**
 * 盘点详情 Dao 接口
 *
 * @author 
 */
public interface PandianOrderListDao extends BaseMapper<PandianOrderListEntity> {

   List<PandianOrderListView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
