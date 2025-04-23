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
 * 供应商
 *
 * @author 
 * @email
 */
@TableName("gongyinghsang")
public class GongyinghsangEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public GongyinghsangEntity() {

	}

	public GongyinghsangEntity(T t) {
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
     * 供应商名称
     */
    @TableField(value = "gongyinghsang_name")

    private String gongyinghsangName;


    /**
     * 供应商类型
     */
    @TableField(value = "gongyinghsang_types")

    private Integer gongyinghsangTypes;


    /**
     * 供应商信用等级名称
     */
    @TableField(value = "gongyinghsang_xinyong_types")

    private Integer gongyinghsangXinyongTypes;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 供应商详情
     */
    @TableField(value = "gongyinghsang_content")

    private String gongyinghsangContent;


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
	 * 设置：供应商名称
	 */
    public String getGongyinghsangName() {
        return gongyinghsangName;
    }


    /**
	 * 获取：供应商名称
	 */

    public void setGongyinghsangName(String gongyinghsangName) {
        this.gongyinghsangName = gongyinghsangName;
    }
    /**
	 * 设置：供应商类型
	 */
    public Integer getGongyinghsangTypes() {
        return gongyinghsangTypes;
    }


    /**
	 * 获取：供应商类型
	 */

    public void setGongyinghsangTypes(Integer gongyinghsangTypes) {
        this.gongyinghsangTypes = gongyinghsangTypes;
    }
    /**
	 * 设置：供应商信用等级名称
	 */
    public Integer getGongyinghsangXinyongTypes() {
        return gongyinghsangXinyongTypes;
    }


    /**
	 * 获取：供应商信用等级名称
	 */

    public void setGongyinghsangXinyongTypes(Integer gongyinghsangXinyongTypes) {
        this.gongyinghsangXinyongTypes = gongyinghsangXinyongTypes;
    }
    /**
	 * 设置：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：添加时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：供应商详情
	 */
    public String getGongyinghsangContent() {
        return gongyinghsangContent;
    }


    /**
	 * 获取：供应商详情
	 */

    public void setGongyinghsangContent(String gongyinghsangContent) {
        this.gongyinghsangContent = gongyinghsangContent;
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
        return "Gongyinghsang{" +
            "id=" + id +
            ", gongyinghsangName=" + gongyinghsangName +
            ", gongyinghsangTypes=" + gongyinghsangTypes +
            ", gongyinghsangXinyongTypes=" + gongyinghsangXinyongTypes +
            ", insertTime=" + insertTime +
            ", gongyinghsangContent=" + gongyinghsangContent +
            ", createTime=" + createTime +
        "}";
    }
}
