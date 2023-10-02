package com.edu.cqut.newsservice.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.edu.cqut.newsservice.entity.TbNewsinfofresh;
import com.edu.cqut.newsservice.entity.TbNewsread;
import com.edu.cqut.newsservice.entity.TbNewsuser;
import com.edu.cqut.newsservice.service.ITbNewsinfofreshService;
import com.edu.cqut.newsservice.service.ITbNewsreadService;
import com.edu.cqut.newsservice.service.ITbNewsuserService;
import com.edu.cqut.newsservice.util.TableResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Haibara
 * @since 2023-09-22
 */
@RestController
@CrossOrigin
@RequestMapping("/read")
public class TbNewsreadController {
    @Autowired
    ITbNewsreadService readService;
    @Autowired
    ITbNewsuserService userService;
    @Autowired
    ITbNewsinfofreshService newsService;

    @PostMapping("/logReadHistory")
    public TableResult<TbNewsread> logReadHistory(Integer newsId, String userName) {
        QueryWrapper<TbNewsuser> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name", userName);
        TbNewsuser user = userService.getOne(wrapper);
        TbNewsread read = new TbNewsread();
        read.setCreateDate(LocalDateTime.now());
        read.setUserId(user.getUserId());
        read.setNewsfreId(newsId);
        readService.save(read);
        return TableResult.ok("成功");
    }

    @GetMapping("/getNewsReadCount")
    public TableResult<TbNewsread> getNewsReadCount(Integer newsId) {
        QueryWrapper<TbNewsread> wrapper = new QueryWrapper<>();
        wrapper.eq("newsfre_id", newsId);
        return TableResult.ok("成功", 0, readService.list(wrapper));
    }

    @GetMapping("/getSelfHistory")
    public TableResult<TbNewsread> getSelfHistory(String userName) {
        QueryWrapper<TbNewsuser> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name", userName);
        List<TbNewsinfofresh> newsList = newsService.list();
        QueryWrapper<TbNewsread> readWrapper = new QueryWrapper<>();
        readWrapper.eq("user_id", userService.getOne(wrapper).getUserId());
        List<TbNewsread> reads = readService.list(readWrapper);
        for (int i = 0; i < reads.size(); i++) {
            reads.get(i).setNews(newsList.get(reads.get(i).getNewsfreId() - 1));
        }
        return TableResult.ok("成功", 0, reads);
    }

    @PostMapping("/deleteSelfHistory")
    public TableResult<TbNewsread> deleteSelfHistory(Integer readId) {
        readService.removeById(readId);
        return TableResult.ok("成功");
    }
}
