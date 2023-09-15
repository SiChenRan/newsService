package com.edu.cqut.newsservice.util;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;

public class Generator {
    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/newsdb?useUnicode=true&characterEncoding=utf8&useSSL=true&serverTimezone=Asia/Shanghai", "root", "szc.2002").globalConfig(builder -> {
            builder.author("Haibara") // 设置作者
                    .outputDir("C:\\Workspace\\newsService\\src\\main\\java"); // 指定输出目录
        }).packageConfig(builder -> {
            builder.parent("com.edu.cqut.newsservice"); // 设置父包名
        }).strategyConfig(builder -> {
            builder.addInclude("tb_newsmanager"); // 设置需要生成的表名
        }).execute();
    }
}
