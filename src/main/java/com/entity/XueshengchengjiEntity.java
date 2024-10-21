package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 学生成绩
 *
 * @author 
 * @email
 */
@TableName("xueshengchengji")
public class XueshengchengjiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public XueshengchengjiEntity() {

	}

	public XueshengchengjiEntity(T t) {
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
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 学生
     */
    @ColumnInfo(comment="学生",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 教师
     */
    @ColumnInfo(comment="教师",type="int(11)")
    @TableField(value = "jiaoshi_id")

    private Integer jiaoshiId;


    /**
     * 成绩
     */
    @ColumnInfo(comment="成绩",type="int(11)")
    @TableField(value = "chengji")

    private Integer chengji;


    /**
     * 时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat
    @ColumnInfo(comment="时间",type="date")
    @TableField(value = "xueshengchengji_time")

    private Date xueshengchengjiTime;


    /**
     * 学科
     */
    @ColumnInfo(comment="学科",type="int(11)")
    @TableField(value = "xueke_types")

    private Integer xuekeTypes;


    /**
     * 成绩详情
     */
    @ColumnInfo(comment="成绩详情",type="text")
    @TableField(value = "xueshengchengji_content")

    private String xueshengchengjiContent;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="添加时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间  listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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
	 * 获取：学生
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 设置：学生
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：教师
	 */
    public Integer getJiaoshiId() {
        return jiaoshiId;
    }
    /**
	 * 设置：教师
	 */

    public void setJiaoshiId(Integer jiaoshiId) {
        this.jiaoshiId = jiaoshiId;
    }
    /**
	 * 获取：成绩
	 */
    public Integer getChengji() {
        return chengji;
    }
    /**
	 * 设置：成绩
	 */

    public void setChengji(Integer chengji) {
        this.chengji = chengji;
    }
    /**
	 * 获取：时间
	 */
    public Date getXueshengchengjiTime() {
        return xueshengchengjiTime;
    }
    /**
	 * 设置：时间
	 */

    public void setXueshengchengjiTime(Date xueshengchengjiTime) {
        this.xueshengchengjiTime = xueshengchengjiTime;
    }
    /**
	 * 获取：学科
	 */
    public Integer getXuekeTypes() {
        return xuekeTypes;
    }
    /**
	 * 设置：学科
	 */

    public void setXuekeTypes(Integer xuekeTypes) {
        this.xuekeTypes = xuekeTypes;
    }
    /**
	 * 获取：成绩详情
	 */
    public String getXueshengchengjiContent() {
        return xueshengchengjiContent;
    }
    /**
	 * 设置：成绩详情
	 */

    public void setXueshengchengjiContent(String xueshengchengjiContent) {
        this.xueshengchengjiContent = xueshengchengjiContent;
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
	 * 获取：创建时间  listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间  listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Xueshengchengji{" +
            ", id=" + id +
            ", yonghuId=" + yonghuId +
            ", jiaoshiId=" + jiaoshiId +
            ", chengji=" + chengji +
            ", xueshengchengjiTime=" + DateUtil.convertString(xueshengchengjiTime,"yyyy-MM-dd") +
            ", xuekeTypes=" + xuekeTypes +
            ", xueshengchengjiContent=" + xueshengchengjiContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
