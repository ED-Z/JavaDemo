package com.example.jtaDemo.config;

import javax.sql.DataSource;
import com.atomikos.jdbc.AtomikosDataSourceBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.*;
import tk.mybatis.spring.annotation.MapperScan;

@Configuration
@MapperScan(
        //	指定扫描包
        basePackages= {"com.example.jtaDemo.dao.mapper.pgsqlMapper"},
        //	限定扫描类
        annotationClass=Mapper.class,
        //	指定 sqlSessionTemplate，忽略sqlSessionFactory的配置
        //	sqlSessionTemplate优先级大于sqlSessionFactory
        sqlSessionTemplateRef="pgSessionTemplate"
)
public class PgSqlConfig {


    @Bean
    @ConfigurationProperties(prefix = "spring.pgsql.datasource")
    public DataSource pgsqlDataSource() {
        return new AtomikosDataSourceBean();
    }

    @Bean
    public SqlSessionFactory pgSqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(pgsqlDataSource());
        return factoryBean.getObject();
    }

    @Bean("pgSessionTemplate")
    public SqlSessionTemplate pgSessionTemplate(@Qualifier("pgSqlSessionFactory") SqlSessionFactory pgSqlSessionFactory) throws Exception{
        return new SqlSessionTemplate(pgSqlSessionFactory);
    }

}
