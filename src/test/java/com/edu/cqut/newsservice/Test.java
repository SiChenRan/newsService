package com.edu.cqut.newsservice;

import com.edu.cqut.newsservice.service.ITbNewsinfofreshService;
import com.edu.cqut.newsservice.service.impl.TbNewsinfofreshServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

public class Test {
    public static void main(String[] args) {
        ITbNewsinfofreshService service = new TbNewsinfofreshServiceImpl();
        System.out.println(service.count());
    }
}
