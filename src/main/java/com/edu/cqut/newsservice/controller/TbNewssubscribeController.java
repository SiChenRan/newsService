package com.edu.cqut.newsservice.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.edu.cqut.newsservice.entity.TbNewsinfofresh;
import com.edu.cqut.newsservice.entity.TbNewssubscribe;
import com.edu.cqut.newsservice.entity.TbNewssum;
import com.edu.cqut.newsservice.entity.TbNewsuser;
import com.edu.cqut.newsservice.service.ITbNewsinfofreshService;
import com.edu.cqut.newsservice.service.ITbNewssubscribeService;
import com.edu.cqut.newsservice.service.ITbNewssumService;
import com.edu.cqut.newsservice.service.ITbNewsuserService;
import com.edu.cqut.newsservice.util.TableResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    @Autowired
    private ITbNewssumService sumService;
    @Autowired
    private ITbNewsinfofreshService infoService;

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
        wrapper1.eq("user_id", user.getUserId());
        return TableResult.ok("成功", 0, subscribeService.list(wrapper1));
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

    @GetMapping("/getNewSubInfo")
    public TableResult<TbNewsinfofresh> getNewSubInfo(String userName) {
        QueryWrapper<TbNewsuser> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name", userName);
        TbNewsuser user = userService.getOne(wrapper);
        QueryWrapper wrapper1 = new QueryWrapper<>();
        wrapper1.eq("user_id", user.getUserId());
        List<TbNewssubscribe> subscribeList = subscribeService.list(wrapper1);
        boolean flag = false;
        for (int i = 0; i < subscribeList.size(); i++) {
            if (subscribeList.get(i).getTypeId() == 7) {
                flag = true;
                break;
            }
        }

        long currentSumOfNews = infoService.count();
        TbNewssum sum = sumService.getById(1);
        long preSumOfNews = sum.getNewsCount();
        if (currentSumOfNews == preSumOfNews || !flag)
            return TableResult.ok("无最新新闻", 200, new ArrayList<>());
        else {
            List<TbNewsinfofresh> newsList = infoService.list();
            List<TbNewsinfofresh> freshNewsList = new ArrayList<>();
            for (long i = preSumOfNews; i < currentSumOfNews; i++) {
                freshNewsList.add(newsList.get((int) i));
            }
            sum.setNewsCount((int) currentSumOfNews);
            sumService.updateById(sum);
            return TableResult.ok("有最新新闻", 200, freshNewsList);
        }
    }

    @GetMapping("/getNewSub")
    public TableResult<TbNewsinfofresh> getNewSub(String userName) {
        QueryWrapper<TbNewsuser> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name", userName);
        TbNewsuser user = userService.getOne(wrapper);
        QueryWrapper wrapper1 = new QueryWrapper<>();
        wrapper1.eq("user_id", user.getUserId());
        List<TbNewssubscribe> subscribeList = subscribeService.list(wrapper1);
        boolean flag = false;
        for (int i = 0; i < subscribeList.size(); i++) {
            if (subscribeList.get(i).getTypeId() == 7) {
                flag = true;
                break;
            }
        }

        long currentSumOfNews = infoService.count();
        TbNewssum sum = sumService.getById(1);
        long preSumOfNews = sum.getNewsCount();
        if (currentSumOfNews == preSumOfNews || !flag)
            return TableResult.ok("无最新新闻", 200, new ArrayList<>());
        else {
            List<TbNewsinfofresh> newsList = infoService.list();
            List<TbNewsinfofresh> freshNewsList = new ArrayList<>();
            for (long i = preSumOfNews; i < currentSumOfNews; i++) {
                freshNewsList.add(newsList.get((int) i));
            }
            return TableResult.ok("有最新新闻", 200, freshNewsList);
        }
    }
}
