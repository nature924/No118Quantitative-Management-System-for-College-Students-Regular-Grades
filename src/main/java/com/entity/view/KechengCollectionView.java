package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.KechengCollectionEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 课程收藏
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("kecheng_collection")
public class KechengCollectionView extends KechengCollectionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 类型的值
	*/
	@ColumnInfo(comment="类型的字典表值",type="varchar(200)")
	private String kechengCollectionValue;

	//级联表 课程资源
		/**
		* 课程名称
		*/

		@ColumnInfo(comment="课程名称",type="varchar(200)")
		private String kechengName;
		/**
		* 课程封面
		*/

		@ColumnInfo(comment="课程封面",type="varchar(200)")
		private String kechengPhoto;
		/**
		* 课程视频
		*/

		@ColumnInfo(comment="课程视频",type="varchar(200)")
		private String kechengVideo;
		/**
		* 课程文件
		*/

		@ColumnInfo(comment="课程文件",type="varchar(200)")
		private String kechengFile;
		/**
		* 学科
		*/
		@ColumnInfo(comment="学科",type="int(11)")
		private Integer xuekeTypes;
			/**
			* 学科的值
			*/
			@ColumnInfo(comment="学科的字典表值",type="varchar(200)")
			private String xuekeValue;
					 
		/**
		* 课程资源 的 教师
		*/
		@ColumnInfo(comment="教师",type="int(11)")
		private Integer kechengJiaoshiId;
		/**
		* 赞
		*/

		@ColumnInfo(comment="赞",type="int(11)")
		private Integer zanNumber;
		/**
		* 踩
		*/

		@ColumnInfo(comment="踩",type="int(11)")
		private Integer caiNumber;
		/**
		* 课程类型
		*/
		@ColumnInfo(comment="课程类型",type="int(11)")
		private Integer kechengTypes;
			/**
			* 课程类型的值
			*/
			@ColumnInfo(comment="课程类型的字典表值",type="varchar(200)")
			private String kechengValue;
		/**
		* 课程详情
		*/

		@ColumnInfo(comment="课程详情",type="text")
		private String kechengContent;
	//级联表 学生
		/**
		* 学号
		*/

		@ColumnInfo(comment="学号",type="varchar(200)")
		private String yonghuUuidNumber;
		/**
		* 学生姓名
		*/

		@ColumnInfo(comment="学生姓名",type="varchar(200)")
		private String yonghuName;
		/**
		* 头像
		*/

		@ColumnInfo(comment="头像",type="varchar(255)")
		private String yonghuPhoto;
		/**
		* 联系方式
		*/

		@ColumnInfo(comment="联系方式",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 学生身份证号
		*/

		@ColumnInfo(comment="学生身份证号",type="varchar(200)")
		private String yonghuIdNumber;
		/**
		* 邮箱
		*/

		@ColumnInfo(comment="邮箱",type="varchar(200)")
		private String yonghuEmail;
		/**
		* 假删
		*/

		@ColumnInfo(comment="假删",type="int(11)")
		private Integer yonghuDelete;



	public KechengCollectionView() {

	}

	public KechengCollectionView(KechengCollectionEntity kechengCollectionEntity) {
		try {
			BeanUtils.copyProperties(this, kechengCollectionEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 类型的值
	*/
	public String getKechengCollectionValue() {
		return kechengCollectionValue;
	}
	/**
	* 设置： 类型的值
	*/
	public void setKechengCollectionValue(String kechengCollectionValue) {
		this.kechengCollectionValue = kechengCollectionValue;
	}


	//级联表的get和set 课程资源

		/**
		* 获取： 课程名称
		*/
		public String getKechengName() {
			return kechengName;
		}
		/**
		* 设置： 课程名称
		*/
		public void setKechengName(String kechengName) {
			this.kechengName = kechengName;
		}

		/**
		* 获取： 课程封面
		*/
		public String getKechengPhoto() {
			return kechengPhoto;
		}
		/**
		* 设置： 课程封面
		*/
		public void setKechengPhoto(String kechengPhoto) {
			this.kechengPhoto = kechengPhoto;
		}

		/**
		* 获取： 课程视频
		*/
		public String getKechengVideo() {
			return kechengVideo;
		}
		/**
		* 设置： 课程视频
		*/
		public void setKechengVideo(String kechengVideo) {
			this.kechengVideo = kechengVideo;
		}

		/**
		* 获取： 课程文件
		*/
		public String getKechengFile() {
			return kechengFile;
		}
		/**
		* 设置： 课程文件
		*/
		public void setKechengFile(String kechengFile) {
			this.kechengFile = kechengFile;
		}
		/**
		* 获取： 学科
		*/
		public Integer getXuekeTypes() {
			return xuekeTypes;
		}
		/**
		* 设置： 学科
		*/
		public void setXuekeTypes(Integer xuekeTypes) {
			this.xuekeTypes = xuekeTypes;
		}


			/**
			* 获取： 学科的值
			*/
			public String getXuekeValue() {
				return xuekeValue;
			}
			/**
			* 设置： 学科的值
			*/
			public void setXuekeValue(String xuekeValue) {
				this.xuekeValue = xuekeValue;
			}
		/**
		* 获取：课程资源 的 教师
		*/
		public Integer getKechengJiaoshiId() {
			return kechengJiaoshiId;
		}
		/**
		* 设置：课程资源 的 教师
		*/
		public void setKechengJiaoshiId(Integer kechengJiaoshiId) {
			this.kechengJiaoshiId = kechengJiaoshiId;
		}

		/**
		* 获取： 赞
		*/
		public Integer getZanNumber() {
			return zanNumber;
		}
		/**
		* 设置： 赞
		*/
		public void setZanNumber(Integer zanNumber) {
			this.zanNumber = zanNumber;
		}

		/**
		* 获取： 踩
		*/
		public Integer getCaiNumber() {
			return caiNumber;
		}
		/**
		* 设置： 踩
		*/
		public void setCaiNumber(Integer caiNumber) {
			this.caiNumber = caiNumber;
		}
		/**
		* 获取： 课程类型
		*/
		public Integer getKechengTypes() {
			return kechengTypes;
		}
		/**
		* 设置： 课程类型
		*/
		public void setKechengTypes(Integer kechengTypes) {
			this.kechengTypes = kechengTypes;
		}


			/**
			* 获取： 课程类型的值
			*/
			public String getKechengValue() {
				return kechengValue;
			}
			/**
			* 设置： 课程类型的值
			*/
			public void setKechengValue(String kechengValue) {
				this.kechengValue = kechengValue;
			}

		/**
		* 获取： 课程详情
		*/
		public String getKechengContent() {
			return kechengContent;
		}
		/**
		* 设置： 课程详情
		*/
		public void setKechengContent(String kechengContent) {
			this.kechengContent = kechengContent;
		}
	//级联表的get和set 学生

		/**
		* 获取： 学号
		*/
		public String getYonghuUuidNumber() {
			return yonghuUuidNumber;
		}
		/**
		* 设置： 学号
		*/
		public void setYonghuUuidNumber(String yonghuUuidNumber) {
			this.yonghuUuidNumber = yonghuUuidNumber;
		}

		/**
		* 获取： 学生姓名
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 学生姓名
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}

		/**
		* 获取： 联系方式
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 联系方式
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 学生身份证号
		*/
		public String getYonghuIdNumber() {
			return yonghuIdNumber;
		}
		/**
		* 设置： 学生身份证号
		*/
		public void setYonghuIdNumber(String yonghuIdNumber) {
			this.yonghuIdNumber = yonghuIdNumber;
		}

		/**
		* 获取： 邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
		}

		/**
		* 获取： 假删
		*/
		public Integer getYonghuDelete() {
			return yonghuDelete;
		}
		/**
		* 设置： 假删
		*/
		public void setYonghuDelete(Integer yonghuDelete) {
			this.yonghuDelete = yonghuDelete;
		}


	@Override
	public String toString() {
		return "KechengCollectionView{" +
			", kechengCollectionValue=" + kechengCollectionValue +
			", yonghuUuidNumber=" + yonghuUuidNumber +
			", yonghuName=" + yonghuName +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuEmail=" + yonghuEmail +
			", yonghuDelete=" + yonghuDelete +
			", kechengName=" + kechengName +
			", kechengPhoto=" + kechengPhoto +
			", kechengVideo=" + kechengVideo +
			", kechengFile=" + kechengFile +
			", zanNumber=" + zanNumber +
			", caiNumber=" + caiNumber +
			", kechengContent=" + kechengContent +
			"} " + super.toString();
	}
}
