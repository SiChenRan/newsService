package com.edu.cqut.newsservice.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.edu.cqut.newsservice.entity.TbNewsinfofresh;
import com.edu.cqut.newsservice.entity.TbNewstype;
import com.edu.cqut.newsservice.service.ITbNewsinfofreshService;
import com.edu.cqut.newsservice.service.ITbNewstypeService;
import com.edu.cqut.newsservice.util.TableResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Haibara
 * @since 2023-09-15
 */
@RestController
@CrossOrigin
@RequestMapping("/newsType")
public class TbNewstypeController {
    @Autowired
    private ITbNewstypeService typeService;
    @Autowired
    private ITbNewsinfofreshService newsService;

    @GetMapping("/getTypeList")
    public TableResult<TbNewstype> getTypeList() {
        return TableResult.ok("成功",0, typeService.list());
    }

    @GetMapping("/getTypeNewsCount")
    public TableResult<TbNewsinfofresh> getTypeNewsCount(Integer typeId){
        QueryWrapper<TbNewsinfofresh> wrapper = new QueryWrapper<>();
        wrapper.eq("type_id",typeId);
        return TableResult.ok("成功",0, newsService.list(wrapper));
    }
}
