package com.edu.cqut.newsservice.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.edu.cqut.newsservice.entity.TbNewsuser;
import com.edu.cqut.newsservice.service.ITbNewsuserService;
import com.edu.cqut.newsservice.util.TableResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Haibara
 * @since 2023-09-15
 */
@RestController//给前端返回json数据
@RequestMapping("/user")
@CrossOrigin//允许跨域请求
public class TbNewsuserController {

    @Autowired//自动从Spring容器中获取对象给变量赋值
    private ITbNewsuserService iTbNewsuserService;

    /*
      增删改查的开发顺序，1.查询，2.修改，3.新增，4.删除
     */

    /**
     * @param limit 每页行数
     * @param page  第几页
     * @return page1
     */
//    @Auth(roles = {"ADMIN","SALES","SUPERVISOR","MANAGER"})
    @GetMapping("/getUserList")
    public TableResult<TbNewsuser> getUserList(Integer limit, Integer page, HttpServletRequest request) {
        System.out.println(request.getAttribute("suId"));
        System.out.println(request.getAttribute("suName"));
        System.out.println(request.getAttribute("suRole"));
        if (limit == null && page == null) {
            List<TbNewsuser> newsuserList = iTbNewsuserService.list();
            // getTotal()方法返回表里的总记录数,getRecords()方法返回当前页的数据列表
            return TableResult.ok("查询成功", newsuserList.size(), newsuserList);

        } else {
            Page<TbNewsuser> newsuserPage = new Page<>(page, limit);
            Page<TbNewsuser> page1 = iTbNewsuserService.page(newsuserPage); // 调用service层的page方法,返回分页
            // getTotal()方法返回表里的总记录数,getRecords()方法返回当前页的数据列表
            return TableResult.ok("查询成功", page1.getTotal(), page1.getRecords());
        }
    }

    @GetMapping("/getPublishers")
    public TableResult<TbNewsuser> getPublishers(TbNewsuser user) {
        QueryWrapper<TbNewsuser> wrapper = new QueryWrapper<>();
        wrapper.eq("publish_right", 2);
        Page<TbNewsuser> publisher = new Page<>();
        IPage<TbNewsuser> page1 = iTbNewsuserService.page(publisher, wrapper);
        return TableResult.ok("成功", page1.getTotal(), page1.getRecords());
    }

    //    @Auth(roles = {"SALES","ADMIN"})
    @PostMapping("/updateUser")
    public TableResult<TbNewsuser> updateCustomer(TbNewsuser user) {
        iTbNewsuserService.updateById(user);
        return TableResult.ok("修改用户信息成功！");
    }

    //    @Auth(roles = {"SALES","ADMIN"})
    @PostMapping("/addUser")//映射的地址与方法名没有关系
    public TableResult<TbNewsuser> addCustomer(TbNewsuser user) {
        iTbNewsuserService.save(user);
        return TableResult.ok("新增客户信息成功！");
    }

    //    @Auth(roles = {"SALES","ADMIN"})
    @PostMapping("/deleteUser")//映射的地址与方法名没有关系
    public TableResult<TbNewsuser> deleteCustomer(Integer[] ids) {//参数名要和前端的ajax方法中的data参数里面的属性名字一致
        iTbNewsuserService.removeByIds(Arrays.asList(ids));//asList用于将数组转化为List
        return TableResult.ok("删除客户信息成功！");
    }

}
