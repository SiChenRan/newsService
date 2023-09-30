package com.edu.cqut.newsservice.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.edu.cqut.newsservice.entity.TbNewssubscribe;
import com.edu.cqut.newsservice.entity.TbNewsuser;
import com.edu.cqut.newsservice.service.ITbNewssubscribeService;
import com.edu.cqut.newsservice.service.ITbNewsuserService;
import com.edu.cqut.newsservice.util.TableResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Haibara
 * @since 2023-09-30
 */
@RestController
@CrossOrigin
@RequestMapping("/subscribe")
public class TbNewssubscribeController {
    @Autowired
    private ITbNewssubscribeService subscribeService;
    @Autowired
    private ITbNewsuserService userService;

    @GetMapping("/getSumOfSubscribe")
    public TableResult<TbNewssubscribe> getSumOfSubscribe(Integer typeId) {
        QueryWrapper<TbNewssubscribe> wrapper = new QueryWrapper<>();
        wrapper.eq("type_id", typeId);
        return TableResult.ok("成功", 0, subscribeService.list(wrapper));
    }

    @GetMapping("/getUserSubscribeList")
    public TableResult<TbNewssubscribe> getUserSubscribeList(String userName) {
        QueryWrapper<TbNewsuser> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name", userName);
        TbNewsuser user = userService.getOne(wrapper);
        QueryWrapper wrapper1 = new QueryWrapper<>();
        wrapper1.eq("user_id",user.getUserId());
        return TableResult.ok("成功",0,subscribeService.list(wrapper1));
    }

    @PostMapping("/subscribeType")
    public TableResult<TbNewssubscribe> add(Integer typeId, String userName) {
        QueryWrapper<TbNewsuser> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name", userName);
        TbNewsuser user = userService.getOne(wrapper);
        TbNewssubscribe subscribe = new TbNewssubscribe();
        subscribe.setUserId(user.getUserId());
        subscribe.setTypeId(typeId);
        subscribeService.save(subscribe);
        return TableResult.ok("订阅成功");
    }

    @PostMapping("/deSubscribe")
    public TableResult<TbNewssubscribe> delete(Integer typeId, String userName) {
        QueryWrapper<TbNewsuser> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name", userName);
        TbNewsuser user = userService.getOne(wrapper);
        QueryWrapper<TbNewssubscribe> deleteWrapper = new QueryWrapper<>();
        Map<String, Object> queryParamsMap = new HashMap<>();
        queryParamsMap.put("type_id", typeId);
        queryParamsMap.put("user_id", user.getUserId());
        deleteWrapper.allEq(queryParamsMap);
        subscribeService.remove(deleteWrapper);
        return TableResult.ok("取消订阅成功");
    }
}
