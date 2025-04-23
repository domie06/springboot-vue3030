package com.entity.vo;

import com.entity.GongyinghsangEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 供应商
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("gongyinghsang")
public class GongyinghsangVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 公告名称
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

    @TableField(value = "insert_time")
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
	 * 设置：公告名称
	 */
    public String getGongyinghsangName() {
        return gongyinghsangName;
    }


    /**
	 * 获取：公告名称
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

}
