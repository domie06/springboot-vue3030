package com.entity.vo;

import com.entity.PandianOrderEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 盘点
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("pandian_order")
public class PandianOrderVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 操作人
     */

    @TableField(value = "yuangong_id")
    private Integer yuangongId;


    /**
     * 盘点名
     */

    @TableField(value = "pandian_order_name")
    private String pandianOrderName;


    /**
     * 盘点时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 备注
     */

    @TableField(value = "pandian_order_content")
    private String pandianOrderContent;


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
	 * 设置：盘点名
	 */
    public String getPandianOrderName() {
        return pandianOrderName;
    }


    /**
	 * 获取：盘点名
	 */

    public void setPandianOrderName(String pandianOrderName) {
        this.pandianOrderName = pandianOrderName;
    }
    /**
	 * 设置：盘点时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：盘点时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：备注
	 */
    public String getPandianOrderContent() {
        return pandianOrderContent;
    }


    /**
	 * 获取：备注
	 */

    public void setPandianOrderContent(String pandianOrderContent) {
        this.pandianOrderContent = pandianOrderContent;
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
