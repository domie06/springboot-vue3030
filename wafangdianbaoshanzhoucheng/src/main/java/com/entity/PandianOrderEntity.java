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
 * 盘点
 *
 * @author 
 * @email
 */
@TableName("pandian_order")
public class PandianOrderEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public PandianOrderEntity() {

	}

	public PandianOrderEntity(T t) {
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
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

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

    @Override
    public String toString() {
        return "PandianOrder{" +
            "id=" + id +
            ", yuangongId=" + yuangongId +
            ", pandianOrderName=" + pandianOrderName +
            ", insertTime=" + insertTime +
            ", pandianOrderContent=" + pandianOrderContent +
            ", createTime=" + createTime +
        "}";
    }
}
