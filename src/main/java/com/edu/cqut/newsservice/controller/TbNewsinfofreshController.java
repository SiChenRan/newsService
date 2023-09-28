package com.edu.cqut.newsservice.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.edu.cqut.newsservice.entity.TbNewsinfofresh;
import com.edu.cqut.newsservice.entity.TbNewsuser;
import com.edu.cqut.newsservice.mapper.TbNewsinfofreshMapper;
import com.edu.cqut.newsservice.service.ITbNewsinfofreshService;
import com.edu.cqut.newsservice.util.TableResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Haibara
 * @since 2023-09-15
 */
@RestController
@CrossOrigin//允许跨域请求
@RequestMapping("/news")
public class TbNewsinfofreshController {

    @Autowired//自动从Spring容器中获取对象给变量赋值
    private ITbNewsinfofreshService newsinfofreshService;
    @Autowired
    private TbNewsinfofreshMapper newsinfofreshMapper;

    /*
      增删改查的开发顺序，1.查询，2.修改，3.新增，4.删除
     */

    /**
     * @param limit 每页行数
     * @param page  第几页
     * @return page1
     */
//    @Auth(roles = {"ADMIN","SALES","SUPERVISOR","MANAGER"})
    @GetMapping("/getNewsList")
    public TableResult<TbNewsinfofresh> getNewsList(Integer limit, Integer page, HttpServletRequest request) {
        if (limit == null && page == null) {
            List<TbNewsinfofresh> newsinfofreshList = newsinfofreshService.list();
            // getTotal()方法返回表里的总记录数,getRecords()方法返回当前页的数据列表
            return TableResult.ok("查询成功", newsinfofreshList.size(), newsinfofreshList);

        } else {
            Page<TbNewsinfofresh> newsinfoPage = new Page<>(page, limit);
            Page<TbNewsinfofresh> page1 = newsinfofreshService.page(newsinfoPage); // 调用service层的page方法,返回分页
            // getTotal()方法返回表里的总记录数,getRecords()方法返回当前页的数据列表
            return TableResult.ok("查询成功", page1.getTotal(), page1.getRecords());
        }
    }

//    public TableResult<TbNewsinfofresh> getNewsListByTypeId(Integer limit, Integer page, HttpServletRequest request, Integer typeId) {
//        System.out.println(typeId);
//        QueryWrapper<TbNewsinfofresh> wrapper = new QueryWrapper<>();
//        wrapper.eq("type_id", typeId);
//        Page<TbNewsinfofresh> newsinfoPage = new Page<>();
//        IPage<TbNewsinfofresh> page1 = newsinfofreshService.page(newsinfoPage, wrapper);
//        // getTotal()方法返回表里的总记录数,getRecords()方法返回当前页的数据列表
//        return TableResult.ok("查询成功", page1.getTotal(), page1.getRecords());
//    }

    //    @GetMapping("/list")
    @GetMapping("/getNewsListByTypeId")

    public Map<String, Object> getNewsListByTypeId(Integer typeId) {
        Map<String, Object> result = new HashMap<>();

        //构建一个查询的wrapper
        QueryWrapper<TbNewsinfofresh> wrapper = new QueryWrapper<>();
        //未删除
        wrapper.eq("type_id", typeId);
        //创建时间降序
        wrapper.orderByDesc("create_date");

        List<TbNewsinfofresh> list = newsinfofreshMapper.selectList(wrapper);
        result.put("data", list);
        return result;
    }

    @GetMapping("/getNewsInfo")
    public TableResult<TbNewsinfofresh> getNewsById(Integer newsfreId) {
        System.out.println(newsfreId);
        TbNewsinfofresh newsinfofresh = newsinfofreshService.getById(newsfreId);
        return TableResult.ok("查看成功", newsinfofresh);
    }

    @GetMapping("/getNewsInfoByTitle")
    public TableResult<TbNewsinfofresh> getNewsById(String newsTitle) {
        System.out.println(newsTitle);
        QueryWrapper<TbNewsinfofresh> wrapper = new QueryWrapper<>();
        wrapper.eq("news_title", newsTitle);
        TbNewsinfofresh newsinfofresh = newsinfofreshService.getOne(wrapper);
        return TableResult.ok("查看成功", newsinfofresh);
    }

    //    @Auth(roles = {"SALES","ADMIN"})
    @PostMapping("/updateNews")
    public TableResult<TbNewsinfofresh> updateNews(TbNewsinfofresh news) {
        newsinfofreshService.updateById(news);
        return TableResult.ok("修改用户信息成功！");
    }

    //    @Auth(roles = {"SALES","ADMIN"})
    @PostMapping("/addNews")//映射的地址与方法名没有关系
    public TableResult<TbNewsinfofresh> addNews(TbNewsinfofresh news) {
        newsinfofreshService.save(news);
        return TableResult.ok("新增客户信息成功！");
    }

    //    @Auth(roles = {"SALES","ADMIN"})
    @PostMapping("/deleteNews")//映射的地址与方法名没有关系
    public TableResult<TbNewsuser> deleteNews(Integer[] ids) {//参数名要和前端的ajax方法中的data参数里面的属性名字一致
        newsinfofreshService.removeByIds(Arrays.asList(ids));//asList用于将数组转化为List
        return TableResult.ok("删除客户信息成功！");
    }
}
