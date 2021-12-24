package com.edz.example;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.edz.commons.mapper.ZCommonMapper;
import com.edz.commons.pojo.ZBaseObject;
import com.edz.commons.service.ZCommonService;
import com.edz.commons.service.impl.ZCommonServiceImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CodeGenerator {

    public static void main(String[] args) {
        List<String> tables = new ArrayList<>();
        tables.add("t_student");
//        tables.add("p_question");
//        tables.add("p_answer");
//        tables.add("p_correct");

        FastAutoGenerator.create("jdbc:mysql://localhost:3306/test","root","")
                .globalConfig(builder -> {
                    builder.author("edz")               //作者
                            .outputDir(System.getProperty("user.dir")+"\\src\\main\\java")    //输出路径(写到java目录)
                            .commentDate("yyyy-MM-dd")
                            .fileOverride();            //开启覆盖之前生成的文件

                })
                .packageConfig(builder -> {
                    builder.parent("com.example.mp")
                            .moduleName("system")
                            .entity("entity")
                            .service("service")
                            .serviceImpl("service.impl")
                            .controller("controller")
                            .mapper("mapper")
                            .xml("mapper")
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml,System.getProperty("user.dir")+"\\src\\main\\resources\\mapper"));
                })
                .strategyConfig(builder -> {
                    builder.addInclude(tables)
                            .addTablePrefix("t_")
                            .entityBuilder()
                            .superClass(ZBaseObject.class)
                            .enableChainModel()
                            .enableLombok()
                            .enableTableFieldAnnotation()
//                            .addIgnoreColumns(String...)
                            .serviceBuilder()
                            .superServiceClass(ZCommonService.class)
                            .superServiceImplClass(ZCommonServiceImpl.class)
                            .formatServiceFileName("%sService")
                            .formatServiceImplFileName("%sServiceImpl")
                            .controllerBuilder()
                            .formatFileName("%sController")
                            .enableRestStyle()
                            .mapperBuilder()
                            .superClass(ZCommonMapper.class)
                            .enableMapperAnnotation()
                            .enableBaseResultMap()
                            .enableBaseColumnList()
                            .formatMapperFileName("%sMapper")
                            .enableMapperAnnotation()
                            .formatXmlFileName("%sMapper");
                })
                .templateConfig(builder -> {
                    builder.serviceImpl("/templates/serviceImpl.java")
                            .build();
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();

    }


}
