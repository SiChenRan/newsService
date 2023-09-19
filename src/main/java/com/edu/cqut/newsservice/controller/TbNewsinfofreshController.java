package com.edu.cqut.newsservice.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.edu.cqut.newsservice.entity.TbNewsinfofresh;
import com.edu.cqut.newsservice.entity.TbNewsuser;
import com.edu.cqut.newsservice.service.ITbNewsinfofreshService;
import com.edu.cqut.newsservice.util.TableResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Haibara
 * @since 2023-09-15
 */
@RestController
@CrossOrigin
@RequestMapping("/news")
public class TbNewsinfofreshController {

    @Autowired//自动从Spring容器中获取对象给变量赋值
    private ITbNewsinfofreshService newsinfofreshService;

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
    public TableResult<TbNewsinfofresh> getUserList(Integer limit, Integer page, HttpServletRequest request) {
        if (limit == null && page == null) {
            List<TbNewsinfofresh> newsinfofreshList = newsinfofreshService.list();
            // getTotal()方法返回表里的总记录数,getRecords()方法返回当前页的数据列表
            return TableResult.ok("查询成功",newsinfofreshList.size(),newsinfofreshList);

        } else {
            Page<TbNewsinfofresh> newsinfoPage = new Page<>(page, limit);
            Page<TbNewsinfofresh> page1 = newsinfofreshService.page(newsinfoPage); // 调用service层的page方法,返回分页
            // getTotal()方法返回表里的总记录数,getRecords()方法返回当前页的数据列表
            return TableResult.ok("查询成功", page1.getTotal(), page1.getRecords());
        }
    }

    //    @Auth(roles = {"SALES","ADMIN"})
    @PostMapping("/updateUser")
    public TableResult<TbNewsinfofresh> updateCustomer(TbNewsinfofresh news) {
        newsinfofreshService.updateById(news);
        return TableResult.ok("修改用户信息成功！");
    }

    //    @Auth(roles = {"SALES","ADMIN"})
    @PostMapping("/addUser")//映射的地址与方法名没有关系
    public TableResult<TbNewsinfofresh> addCustomer(TbNewsinfofresh news) {
        newsinfofreshService.save(news);
        return TableResult.ok("新增客户信息成功！");
    }

    //    @Auth(roles = {"SALES","ADMIN"})
    @PostMapping("/deleteUser")//映射的地址与方法名没有关系
    public TableResult<TbNewsuser> deleteCustomer(Integer[] ids) {//参数名要和前端的ajax方法中的data参数里面的属性名字一致
        newsinfofreshService.removeByIds(Arrays.asList(ids));//asList用于将数组转化为List
        return TableResult.ok("删除客户信息成功！");
    }
}
