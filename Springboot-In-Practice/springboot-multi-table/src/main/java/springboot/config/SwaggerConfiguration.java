package springboot.config;

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

/**
 * Swagger配置
 * 
 * @author LiuDeCai
 * @date 2018/04/06
 * 
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("springboot.web")).paths(PathSelectors.any()).build();
	}

	private ApiInfo apiInfo() {
		Contact contact = new Contact("刘德财", "", "liudecai@postop.cn");
		return new ApiInfoBuilder().title("springboot-multi-table").description("RESTful API后端接口").contact(contact).build();
	}

}
