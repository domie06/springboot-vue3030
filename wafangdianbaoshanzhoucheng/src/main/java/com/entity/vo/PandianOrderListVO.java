package com.entity.vo;

import com.entity.PandianOrderListEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 盘点详情
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("pandian_order_list")
public class PandianOrderListVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
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

}
