package com.entity.model;

import com.entity.ShebeiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 设备
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ShebeiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 设备名称
     */
    private String shebeiName;


    /**
     * 设备类型
     */
    private Integer shebeiTypes;


    /**
     * 设备数量
     */
    private Integer shebeiNumber;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 设备详情
     */
    private String shebeiContent;


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
	 * 获取：设备名称
	 */
    public String getShebeiName() {
        return shebeiName;
    }


    /**
	 * 设置：设备名称
	 */
    public void setShebeiName(String shebeiName) {
        this.shebeiName = shebeiName;
    }
    /**
	 * 获取：设备类型
	 */
    public Integer getShebeiTypes() {
        return shebeiTypes;
    }


    /**
	 * 设置：设备类型
	 */
    public void setShebeiTypes(Integer shebeiTypes) {
        this.shebeiTypes = shebeiTypes;
    }
    /**
	 * 获取：设备数量
	 */
    public Integer getShebeiNumber() {
        return shebeiNumber;
    }


    /**
	 * 设置：设备数量
	 */
    public void setShebeiNumber(Integer shebeiNumber) {
        this.shebeiNumber = shebeiNumber;
    }
    /**
	 * 获取：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：添加时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：设备详情
	 */
    public String getShebeiContent() {
        return shebeiContent;
    }


    /**
	 * 设置：设备详情
	 */
    public void setShebeiContent(String shebeiContent) {
        this.shebeiContent = shebeiContent;
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
