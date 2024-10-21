package com.dao;

import com.entity.XueshengchengjiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.XueshengchengjiView;

/**
 * 学生成绩 Dao 接口
 *
 * @author 
 */
public interface XueshengchengjiDao extends BaseMapper<XueshengchengjiEntity> {

   List<XueshengchengjiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
