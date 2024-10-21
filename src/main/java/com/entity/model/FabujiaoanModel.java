package com.entity.model;

import com.entity.FabujiaoanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 教案信息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class FabujiaoanModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 教案名称
     */
    private String fabujiaoanName;


    /**
     * 教案图片
     */
    private String fabujiaoanPhoto;


    /**
     * 教案类型
     */
    private Integer fabujiaoanTypes;


    /**
     * 教案详情
     */
    private String fabujiaoanContent;


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

    }
