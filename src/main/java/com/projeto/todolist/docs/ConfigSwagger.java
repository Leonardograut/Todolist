package com.projeto.todolist.docs;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;



@EnableSwagger2
@Configuration
public class ConfigSwagger {
    

    
    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
        .useDefaultResponseMessages(false)
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.projeto.todolist.controller"))
        .paths(PathSelectors.any())
        .build()
        .useDefaultResponseMessages(true)
        .apiInfo(apiInfo());
    }


    private ApiInfo apiInfo (){
        return new ApiInfoBuilder()
          .title("To do list Documentado")
          .description("Aplicaçao de Tarefas")
          .version("1.0.8")
          .contact(new Contact("Leonardo Nascimento","https://github.com/Leonardograut","omgleo@live.com"))
          .build(); 
    }
}
