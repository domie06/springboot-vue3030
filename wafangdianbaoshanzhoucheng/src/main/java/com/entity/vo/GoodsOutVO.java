package com.entity.vo;

import com.entity.GoodsOutEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 销售
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("goods_out")
public class GoodsOutVO implements Serializable {
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
     * 操作人
     */

    @TableField(value = "yuangong_id")
    private Integer yuangongId;


    /**
     * 操作人
     */

    @TableField(value = "huiyuan_id")
    private Integer huiyuanId;


    /**
     * 单号
     */

    @TableField(value = "goods_out_danhao_number")
    private String goodsOutDanhaoNumber;


    /**
     * 售卖数量
     */

    @TableField(value = "goods_out_number")
    private Integer goodsOutNumber;


    /**
     * 售卖时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 备注
     */

    @TableField(value = "goods_out_content")
    private String goodsOutContent;


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
	 * 设置：操作人
	 */
    public Integer getHuiyuanId() {
        return huiyuanId;
    }


    /**
	 * 获取：操作人
	 */

    public void setHuiyuanId(Integer huiyuanId) {
        this.huiyuanId = huiyuanId;
    }
    /**
	 * 设置：单号
	 */
    public String getGoodsOutDanhaoNumber() {
        return goodsOutDanhaoNumber;
    }


    /**
	 * 获取：单号
	 */

    public void setGoodsOutDanhaoNumber(String goodsOutDanhaoNumber) {
        this.goodsOutDanhaoNumber = goodsOutDanhaoNumber;
    }
    /**
	 * 设置：售卖数量
	 */
    public Integer getGoodsOutNumber() {
        return goodsOutNumber;
    }


    /**
	 * 获取：售卖数量
	 */

    public void setGoodsOutNumber(Integer goodsOutNumber) {
        this.goodsOutNumber = goodsOutNumber;
    }
    /**
	 * 设置：售卖时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：售卖时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：备注
	 */
    public String getGoodsOutContent() {
        return goodsOutContent;
    }


    /**
	 * 获取：备注
	 */

    public void setGoodsOutContent(String goodsOutContent) {
        this.goodsOutContent = goodsOutContent;
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
