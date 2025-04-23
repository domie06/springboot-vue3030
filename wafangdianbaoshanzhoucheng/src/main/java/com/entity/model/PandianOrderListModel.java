package com.entity.model;

import com.entity.PandianOrderListEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 盘点详情
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class PandianOrderListModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 盘点
     */
    private Integer pandianOrderId;


    /**
     * 商品
     */
    private Integer goodsId;


    /**
     * 盘点前数量
     */
    private Integer goodsQianNumber;


    /**
     * 盘点后数量
     */
    private Integer pandianOrderListNumber;


    /**
     * 插入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：盘点
	 */
    public Integer getPandianOrderId() {
        return pandianOrderId;
    }


    /**
	 * 设置：盘点
	 */
    public void setPandianOrderId(Integer pandianOrderId) {
        this.pandianOrderId = pandianOrderId;
    }
    /**
	 * 获取：商品
	 */
    public Integer getGoodsId() {
        return goodsId;
    }


    /**
	 * 设置：商品
	 */
    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }
    /**
	 * 获取：盘点前数量
	 */
    public Integer getGoodsQianNumber() {
        return goodsQianNumber;
    }


    /**
	 * 设置：盘点前数量
	 */
    public void setGoodsQianNumber(Integer goodsQianNumber) {
        this.goodsQianNumber = goodsQianNumber;
    }
    /**
	 * 获取：盘点后数量
	 */
    public Integer getPandianOrderListNumber() {
        return pandianOrderListNumber;
    }


    /**
	 * 设置：盘点后数量
	 */
    public void setPandianOrderListNumber(Integer pandianOrderListNumber) {
        this.pandianOrderListNumber = pandianOrderListNumber;
    }
    /**
	 * 获取：插入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：插入时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
