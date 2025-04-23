package com.entity.view;

import com.entity.GongyinghsangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 供应商
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("gongyinghsang")
public class GongyinghsangView extends GongyinghsangEntity implements Serializable {
    private static final long serialVersionUID = 1L;
		/**
		* 供应商类型的值
		*/
		private String gongyinghsangValue;
		/**
		* 供应商信用等级名称的值
		*/
		private String gongyinghsangXinyongValue;



	public GongyinghsangView() {

	}

	public GongyinghsangView(GongyinghsangEntity gongyinghsangEntity) {
		try {
			BeanUtils.copyProperties(this, gongyinghsangEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 供应商类型的值
			*/
			public String getGongyinghsangValue() {
				return gongyinghsangValue;
			}
			/**
			* 设置： 供应商类型的值
			*/
			public void setGongyinghsangValue(String gongyinghsangValue) {
				this.gongyinghsangValue = gongyinghsangValue;
			}
			/**
			* 获取： 供应商信用等级名称的值
			*/
			public String getGongyinghsangXinyongValue() {
				return gongyinghsangXinyongValue;
			}
			/**
			* 设置： 供应商信用等级名称的值
			*/
			public void setGongyinghsangXinyongValue(String gongyinghsangXinyongValue) {
				this.gongyinghsangXinyongValue = gongyinghsangXinyongValue;
			}













}
