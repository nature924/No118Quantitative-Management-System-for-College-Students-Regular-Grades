
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 教案信息
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/fabujiaoan")
public class FabujiaoanController {
    private static final Logger logger = LoggerFactory.getLogger(FabujiaoanController.class);

    private static final String TABLE_NAME = "fabujiaoan";

    @Autowired
    private FabujiaoanService fabujiaoanService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private DictionaryService dictionaryService;//字典表
    @Autowired
    private ForumService forumService;//论坛
    @Autowired
    private JiaoshiService jiaoshiService;//教师
    @Autowired
    private KechengService kechengService;//课程资源
    @Autowired
    private KechengCollectionService kechengCollectionService;//课程收藏
    @Autowired
    private KechengLiuyanService kechengLiuyanService;//课程留言
    @Autowired
    private NewsService newsService;//公告信息
    @Autowired
    private XueshengchengjiService xueshengchengjiService;//学生成绩
    @Autowired
    private YonghuService yonghuService;//学生
    @Autowired
    private UsersService usersService;//用户表


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("学生".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("教师".equals(role))
            params.put("jiaoshiId",request.getSession().getAttribute("userId"));
        CommonUtil.checkMap(params);
        PageUtils page = fabujiaoanService.queryPage(params);

        //字典表数据转换
        List<FabujiaoanView> list =(List<FabujiaoanView>)page.getList();
        for(FabujiaoanView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        FabujiaoanEntity fabujiaoan = fabujiaoanService.selectById(id);
        if(fabujiaoan !=null){
            //entity转view
            FabujiaoanView view = new FabujiaoanView();
            BeanUtils.copyProperties( fabujiaoan , view );//把实体数据重构到view中
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody FabujiaoanEntity fabujiaoan, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,fabujiaoan:{}",this.getClass().getName(),fabujiaoan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<FabujiaoanEntity> queryWrapper = new EntityWrapper<FabujiaoanEntity>()
            .eq("fabujiaoan_name", fabujiaoan.getFabujiaoanName())
            .eq("fabujiaoan_types", fabujiaoan.getFabujiaoanTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        FabujiaoanEntity fabujiaoanEntity = fabujiaoanService.selectOne(queryWrapper);
        if(fabujiaoanEntity==null){
            fabujiaoan.setCreateTime(new Date());
            fabujiaoanService.insert(fabujiaoan);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody FabujiaoanEntity fabujiaoan, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,fabujiaoan:{}",this.getClass().getName(),fabujiaoan.toString());
        FabujiaoanEntity oldFabujiaoanEntity = fabujiaoanService.selectById(fabujiaoan.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(fabujiaoan.getFabujiaoanPhoto()) || "null".equals(fabujiaoan.getFabujiaoanPhoto())){
                fabujiaoan.setFabujiaoanPhoto(null);
        }

            fabujiaoanService.updateById(fabujiaoan);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<FabujiaoanEntity> oldFabujiaoanList =fabujiaoanService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        fabujiaoanService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<FabujiaoanEntity> fabujiaoanList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            FabujiaoanEntity fabujiaoanEntity = new FabujiaoanEntity();
//                            fabujiaoanEntity.setFabujiaoanName(data.get(0));                    //教案名称 要改的
//                            fabujiaoanEntity.setFabujiaoanPhoto("");//详情和图片
//                            fabujiaoanEntity.setFabujiaoanTypes(Integer.valueOf(data.get(0)));   //教案类型 要改的
//                            fabujiaoanEntity.setFabujiaoanContent("");//详情和图片
//                            fabujiaoanEntity.setCreateTime(date);//时间
                            fabujiaoanList.add(fabujiaoanEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        fabujiaoanService.insertBatch(fabujiaoanList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }




    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = fabujiaoanService.queryPage(params);

        //字典表数据转换
        List<FabujiaoanView> list =(List<FabujiaoanView>)page.getList();
        for(FabujiaoanView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        FabujiaoanEntity fabujiaoan = fabujiaoanService.selectById(id);
            if(fabujiaoan !=null){


                //entity转view
                FabujiaoanView view = new FabujiaoanView();
                BeanUtils.copyProperties( fabujiaoan , view );//把实体数据重构到view中

                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody FabujiaoanEntity fabujiaoan, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,fabujiaoan:{}",this.getClass().getName(),fabujiaoan.toString());
        Wrapper<FabujiaoanEntity> queryWrapper = new EntityWrapper<FabujiaoanEntity>()
            .eq("fabujiaoan_name", fabujiaoan.getFabujiaoanName())
            .eq("fabujiaoan_types", fabujiaoan.getFabujiaoanTypes())
//            .notIn("fabujiaoan_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        FabujiaoanEntity fabujiaoanEntity = fabujiaoanService.selectOne(queryWrapper);
        if(fabujiaoanEntity==null){
            fabujiaoan.setCreateTime(new Date());
        fabujiaoanService.insert(fabujiaoan);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

