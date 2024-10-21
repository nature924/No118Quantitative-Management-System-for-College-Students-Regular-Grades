package com.dao;

import com.entity.FabujiaoanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.FabujiaoanView;

/**
 * 教案信息 Dao 接口
 *
 * @author 
 */
public interface FabujiaoanDao extends BaseMapper<FabujiaoanEntity> {

   List<FabujiaoanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
