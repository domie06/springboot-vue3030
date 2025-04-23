package com.entity.view;

import com.entity.GoodsOutEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 销售
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("goods_out")
public class GoodsOutView extends GoodsOutEntity implements Serializable {
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

		//级联表 huiyuan
			/**
			* 会员姓名
			*/
			private String huiyuanName;
			/**
			* 会员手机号
			*/
			private String huiyuanPhone;
			/**
			* 会员身份证号
			*/
			private String huiyuanIdNumber;
			/**
			* 会员照片
			*/
			private String huiyuanPhoto;

		//级联表 yuangong
			/**
			* 员工姓名
			*/
			private String yuangongName;
			/**
			* 员工手机号
			*/
			private String yuangongPhone;
			/**
			* 员工身份证号
			*/
			private String yuangongIdNumber;
			/**
			* 员工照片
			*/
			private String yuangongPhoto;

	public GoodsOutView() {

	}

	public GoodsOutView(GoodsOutEntity goodsOutEntity) {
		try {
			BeanUtils.copyProperties(this, goodsOutEntity);
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














				//级联表的get和set huiyuan
					/**
					* 获取： 会员姓名
					*/
					public String getHuiyuanName() {
						return huiyuanName;
					}
					/**
					* 设置： 会员姓名
					*/
					public void setHuiyuanName(String huiyuanName) {
						this.huiyuanName = huiyuanName;
					}
					/**
					* 获取： 会员手机号
					*/
					public String getHuiyuanPhone() {
						return huiyuanPhone;
					}
					/**
					* 设置： 会员手机号
					*/
					public void setHuiyuanPhone(String huiyuanPhone) {
						this.huiyuanPhone = huiyuanPhone;
					}
					/**
					* 获取： 会员身份证号
					*/
					public String getHuiyuanIdNumber() {
						return huiyuanIdNumber;
					}
					/**
					* 设置： 会员身份证号
					*/
					public void setHuiyuanIdNumber(String huiyuanIdNumber) {
						this.huiyuanIdNumber = huiyuanIdNumber;
					}
					/**
					* 获取： 会员照片
					*/
					public String getHuiyuanPhoto() {
						return huiyuanPhoto;
					}
					/**
					* 设置： 会员照片
					*/
					public void setHuiyuanPhoto(String huiyuanPhoto) {
						this.huiyuanPhoto = huiyuanPhoto;
					}















				//级联表的get和set yuangong
					/**
					* 获取： 员工姓名
					*/
					public String getYuangongName() {
						return yuangongName;
					}
					/**
					* 设置： 员工姓名
					*/
					public void setYuangongName(String yuangongName) {
						this.yuangongName = yuangongName;
					}
					/**
					* 获取： 员工手机号
					*/
					public String getYuangongPhone() {
						return yuangongPhone;
					}
					/**
					* 设置： 员工手机号
					*/
					public void setYuangongPhone(String yuangongPhone) {
						this.yuangongPhone = yuangongPhone;
					}
					/**
					* 获取： 员工身份证号
					*/
					public String getYuangongIdNumber() {
						return yuangongIdNumber;
					}
					/**
					* 设置： 员工身份证号
					*/
					public void setYuangongIdNumber(String yuangongIdNumber) {
						this.yuangongIdNumber = yuangongIdNumber;
					}
					/**
					* 获取： 员工照片
					*/
					public String getYuangongPhoto() {
						return yuangongPhoto;
					}
					/**
					* 设置： 员工照片
					*/
					public void setYuangongPhoto(String yuangongPhoto) {
						this.yuangongPhoto = yuangongPhoto;
					}





}
