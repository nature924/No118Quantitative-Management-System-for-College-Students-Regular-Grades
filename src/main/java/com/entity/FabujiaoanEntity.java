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
 * 教案信息
 *
 * @author 
 * @email
 */
@TableName("fabujiaoan")
public class FabujiaoanEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public FabujiaoanEntity() {

	}

	public FabujiaoanEntity(T t) {
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
     * 教案名称
     */
    @ColumnInfo(comment="教案名称",type="varchar(200)")
    @TableField(value = "fabujiaoan_name")

    private String fabujiaoanName;


    /**
     * 教案图片
     */
    @ColumnInfo(comment="教案图片",type="varchar(200)")
    @TableField(value = "fabujiaoan_photo")

    private String fabujiaoanPhoto;


    /**
     * 教案类型
     */
    @ColumnInfo(comment="教案类型",type="int(11)")
    @TableField(value = "fabujiaoan_types")

    private Integer fabujiaoanTypes;


    /**
     * 教案详情
     */
    @ColumnInfo(comment="教案详情",type="text")
    @TableField(value = "fabujiaoan_content")

    private String fabujiaoanContent;


    /**
     * 创建时间
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
	 * 获取：教案名称
	 */
    public String getFabujiaoanName() {
        return fabujiaoanName;
    }
    /**
	 * 设置：教案名称
	 */

    public void setFabujiaoanName(String fabujiaoanName) {
        this.fabujiaoanName = fabujiaoanName;
    }
    /**
	 * 获取：教案图片
	 */
    public String getFabujiaoanPhoto() {
        return fabujiaoanPhoto;
    }
    /**
	 * 设置：教案图片
	 */

    public void setFabujiaoanPhoto(String fabujiaoanPhoto) {
        this.fabujiaoanPhoto = fabujiaoanPhoto;
    }
    /**
	 * 获取：教案类型
	 */
    public Integer getFabujiaoanTypes() {
        return fabujiaoanTypes;
    }
    /**
	 * 设置：教案类型
	 */

    public void setFabujiaoanTypes(Integer fabujiaoanTypes) {
        this.fabujiaoanTypes = fabujiaoanTypes;
    }
    /**
	 * 获取：教案详情
	 */
    public String getFabujiaoanContent() {
        return fabujiaoanContent;
    }
    /**
	 * 设置：教案详情
	 */

    public void setFabujiaoanContent(String fabujiaoanContent) {
        this.fabujiaoanContent = fabujiaoanContent;
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

    @Override
    public String toString() {
        return "Fabujiaoan{" +
            ", id=" + id +
            ", fabujiaoanName=" + fabujiaoanName +
            ", fabujiaoanPhoto=" + fabujiaoanPhoto +
            ", fabujiaoanTypes=" + fabujiaoanTypes +
            ", fabujiaoanContent=" + fabujiaoanContent +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
