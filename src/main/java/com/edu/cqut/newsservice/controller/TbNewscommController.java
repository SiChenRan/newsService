package com.edu.cqut.newsservice.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.edu.cqut.newsservice.entity.TbNewscomm;
import com.edu.cqut.newsservice.entity.TbNewsinfofresh;
import com.edu.cqut.newsservice.entity.TbNewsuser;
import com.edu.cqut.newsservice.mapper.TbNewscommMapper;
import com.edu.cqut.newsservice.service.ITbNewscommService;
import com.edu.cqut.newsservice.service.ITbNewsinfofreshService;
import com.edu.cqut.newsservice.service.ITbNewsuserService;
import com.edu.cqut.newsservice.util.TableResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
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
 * @since 2023-09-22
 */
@RestController
@CrossOrigin
@RequestMapping("/newsComm")
public class TbNewscommController {
    @Autowired
    private ITbNewscommService newscommService;
    @Autowired
    private ITbNewsuserService newsuserService;
    @Autowired
    private ITbNewsinfofreshService newsinfoService;
    @Autowired
    private TbNewscommMapper commMapper;
    private List<TbNewscomm> commentsList = new ArrayList<>();

    @PostMapping("/postComm")
    public TableResult<TbNewscomm> postComm(String comment, Integer newsfreId, String user) {
        QueryWrapper<TbNewsuser> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name", user);
        int userId = newsuserService.getOne(wrapper).getUserId();
        TbNewscomm comm = new TbNewscomm();
        comm.setCommContent(comment);
        comm.setCommStatus(1);
        comm.setCreateDate(LocalDateTime.now());
        comm.setUserId(userId);
        comm.setNewsfreId(newsfreId);
        newscommService.save(comm);
        return TableResult.ok("发布成功");
    }

    @GetMapping("/getComments")
    public Map<String, Object> getComments(Integer newsfreId) {
        Map<String, Object> result = new HashMap<>();
        //构建一个查询的wrapper
        QueryWrapper<TbNewscomm> wrapper = new QueryWrapper<>();
        //未删除
        wrapper.eq("newsfre_id", newsfreId);
        //创建时间降序
        wrapper.orderByDesc("create_date");
        List<TbNewscomm> list = commMapper.selectList(wrapper);
        result.put("data", list);
        return result;
    }

    @GetMapping("/getSelfComments")
    public TableResult<TbNewscomm> getSelfComments(String userName) {
        QueryWrapper<TbNewsuser> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name", userName);
        QueryWrapper<TbNewscomm> commWrapper = new QueryWrapper<>();
        commWrapper.eq("user_id", newsuserService.getOne(wrapper).getUserId());
        commentsList = newscommService.list(commWrapper);
        List<TbNewsinfofresh> newsList = newsinfoService.list();
        for (int i = 0; i < commentsList.size(); i++) {
            if (i >= 453) {
                break;
            }
            commentsList.get(i).setNews(newsList.get(commentsList.get(i).getNewsfreId() - 1));
        }
        return TableResult.ok("成功", 0, commentsList);
    }

    @PostMapping("/deleteSelfComment")
    public TableResult<TbNewscomm> deleteComment(Integer commentId) {
        newscommService.removeById(commentId);
        return TableResult.ok("删除成功");
    }
}
