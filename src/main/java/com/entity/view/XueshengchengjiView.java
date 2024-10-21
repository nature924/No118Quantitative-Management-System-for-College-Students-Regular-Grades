package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.XueshengchengjiEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 学生成绩
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("xueshengchengji")
public class XueshengchengjiView extends XueshengchengjiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 学科的值
	*/
	@ColumnInfo(comment="学科的字典表值",type="varchar(200)")
	private String xuekeValue;

	//级联表 教师
		/**
		* 工号
		*/

		@ColumnInfo(comment="工号",type="varchar(200)")
		private String jiaoshiUuidNumber;
		/**
		* 教师姓名
		*/

		@ColumnInfo(comment="教师姓名",type="varchar(200)")
		private String jiaoshiName;
		/**
		* 头像
		*/

		@ColumnInfo(comment="头像",type="varchar(255)")
		private String jiaoshiPhoto;
		/**
		* 联系方式
		*/

		@ColumnInfo(comment="联系方式",type="varchar(200)")
		private String jiaoshiPhone;
		/**
		* 邮箱
		*/

		@ColumnInfo(comment="邮箱",type="varchar(200)")
		private String jiaoshiEmail;
		/**
		* 假删
		*/

		@ColumnInfo(comment="假删",type="int(11)")
		private Integer jiaoshiDelete;
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

	//重复字段
			/**
			* 重复字段 的types
			*/
			@ColumnInfo(comment="重复字段 的types",type="Integer")
			private Integer sexTypes;
				@ColumnInfo(comment="重复字段 的值",type="varchar(200)")
				private String sexValue;


	public XueshengchengjiView() {

	}

	public XueshengchengjiView(XueshengchengjiEntity xueshengchengjiEntity) {
		try {
			BeanUtils.copyProperties(this, xueshengchengjiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
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


	//级联表的get和set 教师

		/**
		* 获取： 工号
		*/
		public String getJiaoshiUuidNumber() {
			return jiaoshiUuidNumber;
		}
		/**
		* 设置： 工号
		*/
		public void setJiaoshiUuidNumber(String jiaoshiUuidNumber) {
			this.jiaoshiUuidNumber = jiaoshiUuidNumber;
		}

		/**
		* 获取： 教师姓名
		*/
		public String getJiaoshiName() {
			return jiaoshiName;
		}
		/**
		* 设置： 教师姓名
		*/
		public void setJiaoshiName(String jiaoshiName) {
			this.jiaoshiName = jiaoshiName;
		}

		/**
		* 获取： 头像
		*/
		public String getJiaoshiPhoto() {
			return jiaoshiPhoto;
		}
		/**
		* 设置： 头像
		*/
		public void setJiaoshiPhoto(String jiaoshiPhoto) {
			this.jiaoshiPhoto = jiaoshiPhoto;
		}

		/**
		* 获取： 联系方式
		*/
		public String getJiaoshiPhone() {
			return jiaoshiPhone;
		}
		/**
		* 设置： 联系方式
		*/
		public void setJiaoshiPhone(String jiaoshiPhone) {
			this.jiaoshiPhone = jiaoshiPhone;
		}

		/**
		* 获取： 邮箱
		*/
		public String getJiaoshiEmail() {
			return jiaoshiEmail;
		}
		/**
		* 设置： 邮箱
		*/
		public void setJiaoshiEmail(String jiaoshiEmail) {
			this.jiaoshiEmail = jiaoshiEmail;
		}

		/**
		* 获取： 假删
		*/
		public Integer getJiaoshiDelete() {
			return jiaoshiDelete;
		}
		/**
		* 设置： 假删
		*/
		public void setJiaoshiDelete(Integer jiaoshiDelete) {
			this.jiaoshiDelete = jiaoshiDelete;
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

	//重复字段
			/**
			* 获取： 重复字段 的types
			*/
			public Integer getSexTypes() {
			return sexTypes;
			}
			/**
			* 设置： 重复字段 的types
			*/
			public void setSexTypes(Integer sexTypes) {
			this.sexTypes = sexTypes;
			}
				public String getSexValue() {
				return sexValue;
				}
				public void setSexValue(String sexValue) {
				this.sexValue = sexValue;
				}

	@Override
	public String toString() {
		return "XueshengchengjiView{" +
			", xuekeValue=" + xuekeValue +
			", yonghuUuidNumber=" + yonghuUuidNumber +
			", yonghuName=" + yonghuName +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuEmail=" + yonghuEmail +
			", yonghuDelete=" + yonghuDelete +
			", jiaoshiUuidNumber=" + jiaoshiUuidNumber +
			", jiaoshiName=" + jiaoshiName +
			", jiaoshiPhoto=" + jiaoshiPhoto +
			", jiaoshiPhone=" + jiaoshiPhone +
			", jiaoshiEmail=" + jiaoshiEmail +
			", jiaoshiDelete=" + jiaoshiDelete +
			"} " + super.toString();
	}
}
