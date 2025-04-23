package com.entity.view;

import com.entity.PandianOrderListEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 盘点详情
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("pandian_order_list")
public class PandianOrderListView extends PandianOrderListEntity implements Serializable {
    private static final long serialVersionUID = 1L;



		//级联表 goods
			/**
			* 商品名字
			*/
			private String goodsName;
			/**
			* 商品种类
			*/
			private Integer goodsTypes;
				/**
				* 商品种类的值
				*/
				private String goodsValue;
			/**
			* 商品数量
			*/
			private Integer goodsNumber;
			/**
			* 商品图片
			*/
			private String goodsPhoto;
			/**
			* 单位
			*/
			private String danwei;
			/**
			* 单价
			*/
			private Double danjia;
			/**
			* 商品详情
			*/
			private String goodsContent;
			/**
			* 是否删除
			*/
			private Integer flag;

		//级联表 pandian_order
			/**
			* 操作人
			*/
			private Integer yuangongId;
			/**
			* 盘点名
			*/
			private String pandianOrderName;
			@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
			@DateTimeFormat
			/**
			* 盘点时间
			*/
			private Date insertTime;
			/**
			* 备注
			*/
			private String pandianOrderContent;

	public PandianOrderListView() {

	}

	public PandianOrderListView(PandianOrderListEntity pandianOrderListEntity) {
		try {
			BeanUtils.copyProperties(this, pandianOrderListEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

















				//级联表的get和set goods
					/**
					* 获取： 商品名字
					*/
					public String getGoodsName() {
						return goodsName;
					}
					/**
					* 设置： 商品名字
					*/
					public void setGoodsName(String goodsName) {
						this.goodsName = goodsName;
					}
					/**
					* 获取： 商品种类
					*/
					public Integer getGoodsTypes() {
						return goodsTypes;
					}
					/**
					* 设置： 商品种类
					*/
					public void setGoodsTypes(Integer goodsTypes) {
						this.goodsTypes = goodsTypes;
					}


						/**
						* 获取： 商品种类的值
						*/
						public String getGoodsValue() {
							return goodsValue;
						}
						/**
						* 设置： 商品种类的值
						*/
						public void setGoodsValue(String goodsValue) {
							this.goodsValue = goodsValue;
						}
					/**
					* 获取： 商品数量
					*/
					public Integer getGoodsNumber() {
						return goodsNumber;
					}
					/**
					* 设置： 商品数量
					*/
					public void setGoodsNumber(Integer goodsNumber) {
						this.goodsNumber = goodsNumber;
					}
					/**
					* 获取： 商品图片
					*/
					public String getGoodsPhoto() {
						return goodsPhoto;
					}
					/**
					* 设置： 商品图片
					*/
					public void setGoodsPhoto(String goodsPhoto) {
						this.goodsPhoto = goodsPhoto;
					}
					/**
					* 获取： 单位
					*/
					public String getDanwei() {
						return danwei;
					}
					/**
					* 设置： 单位
					*/
					public void setDanwei(String danwei) {
						this.danwei = danwei;
					}
					/**
					* 获取： 单价
					*/
					public Double getDanjia() {
						return danjia;
					}
					/**
					* 设置： 单价
					*/
					public void setDanjia(Double danjia) {
						this.danjia = danjia;
					}
					/**
					* 获取： 商品详情
					*/
					public String getGoodsContent() {
						return goodsContent;
					}
					/**
					* 设置： 商品详情
					*/
					public void setGoodsContent(String goodsContent) {
						this.goodsContent = goodsContent;
					}
					/**
					* 获取： 是否删除
					*/
					public Integer getFlag() {
						return flag;
					}
					/**
					* 设置： 是否删除
					*/
					public void setFlag(Integer flag) {
						this.flag = flag;
					}








				//级联表的get和set pandian_order
					/**
					* 获取： 操作人
					*/
					public Integer getYuangongId() {
						return yuangongId;
					}
					/**
					* 设置： 操作人
					*/
					public void setYuangongId(Integer yuangongId) {
						this.yuangongId = yuangongId;
					}
					/**
					* 获取： 盘点名
					*/
					public String getPandianOrderName() {
						return pandianOrderName;
					}
					/**
					* 设置： 盘点名
					*/
					public void setPandianOrderName(String pandianOrderName) {
						this.pandianOrderName = pandianOrderName;
					}
					/**
					* 获取： 盘点时间
					*/
					public Date getInsertTime() {
						return insertTime;
					}
					/**
					* 设置： 盘点时间
					*/
					public void setInsertTime(Date insertTime) {
						this.insertTime = insertTime;
					}
					/**
					* 获取： 备注
					*/
					public String getPandianOrderContent() {
						return pandianOrderContent;
					}
					/**
					* 设置： 备注
					*/
					public void setPandianOrderContent(String pandianOrderContent) {
						this.pandianOrderContent = pandianOrderContent;
					}













}
