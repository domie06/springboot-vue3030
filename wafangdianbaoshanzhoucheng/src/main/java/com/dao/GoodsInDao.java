package com.dao;

import com.entity.GoodsInEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.GoodsInView;

/**
 * 入库 Dao 接口
 *
 * @author 
 */
public interface GoodsInDao extends BaseMapper<GoodsInEntity> {

   List<GoodsInView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
