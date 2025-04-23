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
 * 设备
 *
 * @author 
 * @email
 */
@TableName("shebei")
public class ShebeiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ShebeiEntity() {

	}

	public ShebeiEntity(T t) {
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
     * 设备名称
     */
    @TableField(value = "shebei_name")

    private String shebeiName;


    /**
     * 设备类型
     */
    @TableField(value = "shebei_types")

    private Integer shebeiTypes;


    /**
     * 设备数量
     */
    @TableField(value = "shebei_number")

    private Integer shebeiNumber;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 设备详情
     */
    @TableField(value = "shebei_content")

    private String shebeiContent;


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
	 * 设置：设备名称
	 */
    public String getShebeiName() {
        return shebeiName;
    }


    /**
	 * 获取：设备名称
	 */

    public void setShebeiName(String shebeiName) {
        this.shebeiName = shebeiName;
    }
    /**
	 * 设置：设备类型
	 */
    public Integer getShebeiTypes() {
        return shebeiTypes;
    }


    /**
	 * 获取：设备类型
	 */

    public void setShebeiTypes(Integer shebeiTypes) {
        this.shebeiTypes = shebeiTypes;
    }
    /**
	 * 设置：设备数量
	 */
    public Integer getShebeiNumber() {
        return shebeiNumber;
    }


    /**
	 * 获取：设备数量
	 */

    public void setShebeiNumber(Integer shebeiNumber) {
        this.shebeiNumber = shebeiNumber;
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
	 * 设置：设备详情
	 */
    public String getShebeiContent() {
        return shebeiContent;
    }


    /**
	 * 获取：设备详情
	 */

    public void setShebeiContent(String shebeiContent) {
        this.shebeiContent = shebeiContent;
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
        return "Shebei{" +
            "id=" + id +
            ", shebeiName=" + shebeiName +
            ", shebeiTypes=" + shebeiTypes +
            ", shebeiNumber=" + shebeiNumber +
            ", insertTime=" + insertTime +
            ", shebeiContent=" + shebeiContent +
            ", createTime=" + createTime +
        "}";
    }
}
