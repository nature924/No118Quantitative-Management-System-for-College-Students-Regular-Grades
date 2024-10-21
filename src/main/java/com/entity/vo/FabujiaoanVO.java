package com.entity.vo;

import com.entity.FabujiaoanEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 教案信息
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("fabujiaoan")
public class FabujiaoanVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 教案名称
     */

    @TableField(value = "fabujiaoan_name")
    private String fabujiaoanName;


    /**
     * 教案图片
     */

    @TableField(value = "fabujiaoan_photo")
    private String fabujiaoanPhoto;


    /**
     * 教案类型
     */

    @TableField(value = "fabujiaoan_types")
    private Integer fabujiaoanTypes;


    /**
     * 教案详情
     */

    @TableField(value = "fabujiaoan_content")
    private String fabujiaoanContent;


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
	 * 设置：教案名称
	 */
    public String getFabujiaoanName() {
        return fabujiaoanName;
    }


    /**
	 * 获取：教案名称
	 */

    public void setFabujiaoanName(String fabujiaoanName) {
        this.fabujiaoanName = fabujiaoanName;
    }
    /**
	 * 设置：教案图片
	 */
    public String getFabujiaoanPhoto() {
        return fabujiaoanPhoto;
    }


    /**
	 * 获取：教案图片
	 */

    public void setFabujiaoanPhoto(String fabujiaoanPhoto) {
        this.fabujiaoanPhoto = fabujiaoanPhoto;
    }
    /**
	 * 设置：教案类型
	 */
    public Integer getFabujiaoanTypes() {
        return fabujiaoanTypes;
    }


    /**
	 * 获取：教案类型
	 */

    public void setFabujiaoanTypes(Integer fabujiaoanTypes) {
        this.fabujiaoanTypes = fabujiaoanTypes;
    }
    /**
	 * 设置：教案详情
	 */
    public String getFabujiaoanContent() {
        return fabujiaoanContent;
    }


    /**
	 * 获取：教案详情
	 */

    public void setFabujiaoanContent(String fabujiaoanContent) {
        this.fabujiaoanContent = fabujiaoanContent;
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
