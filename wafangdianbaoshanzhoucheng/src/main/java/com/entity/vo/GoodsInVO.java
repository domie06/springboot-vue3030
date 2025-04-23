package com.entity.vo;

import com.entity.GoodsInEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 入库
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("goods_in")
public class GoodsInVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 商品
     */

    @TableField(value = "goods_id")
    private Integer goodsId;


    /**
     * 供应商
     */

    @TableField(value = "gongyinghsang_id")
    private Integer gongyinghsangId;


    /**
     * 操作人
     */

    @TableField(value = "yuangong_id")
    private Integer yuangongId;


    /**
     * 单号
     */

    @TableField(value = "goods_in_danhao_number")
    private String goodsInDanhaoNumber;


    /**
     * 入库数量
     */

    @TableField(value = "goods_in_number")
    private Integer goodsInNumber;


    /**
     * 入库时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 备注
     */

    @TableField(value = "goods_in_content")
    private String goodsInContent;


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
	 * 设置：供应商
	 */
    public Integer getGongyinghsangId() {
        return gongyinghsangId;
    }


    /**
	 * 获取：供应商
	 */

    public void setGongyinghsangId(Integer gongyinghsangId) {
        this.gongyinghsangId = gongyinghsangId;
    }
    /**
	 * 设置：操作人
	 */
    public Integer getYuangongId() {
        return yuangongId;
    }


    /**
	 * 获取：操作人
	 */

    public void setYuangongId(Integer yuangongId) {
        this.yuangongId = yuangongId;
    }
    /**
	 * 设置：单号
	 */
    public String getGoodsInDanhaoNumber() {
        return goodsInDanhaoNumber;
    }


    /**
	 * 获取：单号
	 */

    public void setGoodsInDanhaoNumber(String goodsInDanhaoNumber) {
        this.goodsInDanhaoNumber = goodsInDanhaoNumber;
    }
    /**
	 * 设置：入库数量
	 */
    public Integer getGoodsInNumber() {
        return goodsInNumber;
    }


    /**
	 * 获取：入库数量
	 */

    public void setGoodsInNumber(Integer goodsInNumber) {
        this.goodsInNumber = goodsInNumber;
    }
    /**
	 * 设置：入库时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：入库时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：备注
	 */
    public String getGoodsInContent() {
        return goodsInContent;
    }


    /**
	 * 获取：备注
	 */

    public void setGoodsInContent(String goodsInContent) {
        this.goodsInContent = goodsInContent;
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
