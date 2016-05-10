package com.ulrica.springfox.demo.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurerAdapter{

	 @Bean
	    public Docket api() { 
	        return new Docket(DocumentationType.SWAGGER_2)  
	          .groupName("test-api") //  此处修改无效
	          .select()                                  
	          .apis(RequestHandlerSelectors.basePackage("com.ulrica.springfox.demo.controller"))       
	          .paths(PathSelectors.ant("/rest/service/*"))      //PathSelectors.any()    
	          .build()
	          .apiInfo(apiInfo());                                           
	    }
	 
	 private ApiInfo apiInfo() {
		 ApiInfo apiInfo = new ApiInfo(
				    "API 导航",//大标题
	                "API Document管理",//小标题
	                "1.0",//版本
	                "NO terms of service",
	                new Contact("weifj", "", "weifj@dist.com.cn"),//作者联系方式
	                "",//链接显示文字
	                ""//网站链接
	        );
		 return apiInfo;
		}

	 @Override
	 public void addResourceHandlers(ResourceHandlerRegistry registry) {
	     registry.addResourceHandler("swagger-ui.html")
	       .addResourceLocations("classpath:/META-INF/resources/");
	  
	     registry.addResourceHandler("/webjars/**")
	       .addResourceLocations("classpath:/META-INF/resources/webjars/");
	 }
	 
}
