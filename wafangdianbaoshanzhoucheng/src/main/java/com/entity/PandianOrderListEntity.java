package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 盘点详情
 *
 * @author 
 * @email
 */
@TableName("pandian_order_list")
public class PandianOrderListEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public PandianOrderListEntity() {

	}

	public PandianOrderListEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 盘点
     */
    @TableField(value = "pandian_order_id")

    private Integer pandianOrderId;


    /**
     * 商品
     */
    @TableField(value = "goods_id")

    private Integer goodsId;


    /**
     * 盘点前数量
     */
    @TableField(value = "goods_qian_number")

    private Integer goodsQianNumber;


    /**
     * 盘点后数量
     */
    @TableField(value = "pandian_order_list_number")

    private Integer pandianOrderListNumber;


    /**
     * 插入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：盘点
	 */
    public Integer getPandianOrderId() {
        return pandianOrderId;
    }


    /**
	 * 获取：盘点
	 */

    public void setPandianOrderId(Integer pandianOrderId) {
        this.pandianOrderId = pandianOrderId;
    }
    /**
	 * 设置：商品
	 */
    public Integer getGoodsId() {
        return goodsId;
    }


    /**
	 * 获取：商品
	 */

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }
    /**
	 * 设置：盘点前数量
	 */
    public Integer getGoodsQianNumber() {
        return goodsQianNumber;
    }


    /**
	 * 获取：盘点前数量
	 */

    public void setGoodsQianNumber(Integer goodsQianNumber) {
        this.goodsQianNumber = goodsQianNumber;
    }
    /**
	 * 设置：盘点后数量
	 */
    public Integer getPandianOrderListNumber() {
        return pandianOrderListNumber;
    }


    /**
	 * 获取：盘点后数量
	 */

    public void setPandianOrderListNumber(Integer pandianOrderListNumber) {
        this.pandianOrderListNumber = pandianOrderListNumber;
    }
    /**
	 * 设置：插入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：插入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "PandianOrderList{" +
            "id=" + id +
            ", pandianOrderId=" + pandianOrderId +
            ", goodsId=" + goodsId +
            ", goodsQianNumber=" + goodsQianNumber +
            ", pandianOrderListNumber=" + pandianOrderListNumber +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
