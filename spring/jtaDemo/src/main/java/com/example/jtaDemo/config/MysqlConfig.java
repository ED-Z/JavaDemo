package com.example.jtaDemo.config;


import javax.sql.DataSource;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.annotation.MapperScan;

//	配置文件
@Configuration
//	定义MyBatis的扫描
@MapperScan(
        //	指定扫描包
        basePackages= {"com.example.jtaDemo.dao.mapper.mysqlMapper"},
        //	限定扫描类
        annotationClass=Mapper.class,
        //	指定 sqlSessionTemplate，忽略sqlSessionFactory的配置
        //	sqlSessionTemplate优先级大于sqlSessionFactory
        sqlSessionTemplateRef="mysqlSqlSessionTemplate"
)

public class MysqlConfig {


    @Bean
    @ConfigurationProperties(prefix = "spring.mysql.datasource")
    public DataSource mysqlDataSource() {
        return new AtomikosDataSourceBean();
    }


    @Bean
    public SqlSessionFactory mysqlSqlSessionFactory(@Qualifier("mysqlDataSource") DataSource dataSource )throws Exception{
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        return bean.getObject();
    }

    @Bean(name="mysqlSqlSessionTemplate")
    public SqlSessionTemplate mysqlSqlSessionTemplate(@Qualifier("mysqlSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}

