package com.entity.model;

import com.entity.PandianOrderEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 盘点
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class PandianOrderModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 操作人
     */
    private Integer yuangongId;


    /**
     * 盘点名
     */
    private String pandianOrderName;


    /**
     * 盘点时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 备注
     */
    private String pandianOrderContent;


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
	 * 获取：操作人
	 */
    public Integer getYuangongId() {
        return yuangongId;
    }


    /**
	 * 设置：操作人
	 */
    public void setYuangongId(Integer yuangongId) {
        this.yuangongId = yuangongId;
    }
    /**
	 * 获取：盘点名
	 */
    public String getPandianOrderName() {
        return pandianOrderName;
    }


    /**
	 * 设置：盘点名
	 */
    public void setPandianOrderName(String pandianOrderName) {
        this.pandianOrderName = pandianOrderName;
    }
    /**
	 * 获取：盘点时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：盘点时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：备注
	 */
    public String getPandianOrderContent() {
        return pandianOrderContent;
    }


    /**
	 * 设置：备注
	 */
    public void setPandianOrderContent(String pandianOrderContent) {
        this.pandianOrderContent = pandianOrderContent;
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
