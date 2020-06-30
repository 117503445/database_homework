package com.wizzstudio.database_homework.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


@Configuration
public class SwaggerConfig extends WebMvcConfigurationSupport {
    @Value("${swaggerhost}")
    private String swaggerHost;
    /**
     * 当前版本
     */
    @Value("${app.version}")
    private String version;
    /**
     * 打包时间
     */
    @Value("${app.build.time}")
    private String buildTime;

    @Bean
    public Docket createRestApi() {
        System.out.println(swaggerHost);
        System.out.println(version);
        System.out.println(buildTime);
        return new Docket(DocumentationType.SWAGGER_2).host(swaggerHost)
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build().apiInfo(new ApiInfoBuilder()
                        .title("database homework")
                        .description("XDU 数据库 实验 学生成绩管理系统 后端")
                        .version(String.format("%s %s UTC+0", version, buildTime))
                        .contact(new Contact("Qht", "https://www.117503445.top", "t117503445@gmail.com"))
                        .build());
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

}