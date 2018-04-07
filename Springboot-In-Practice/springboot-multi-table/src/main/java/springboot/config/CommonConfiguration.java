package springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

/**
 * 常规配置
 * 
 * @author LiuDeCai
 * @date 2018/04/07
 *
 */
@Configuration
public class CommonConfiguration {

	/**
	 * 文件上传解析器
	 * 
	 * @return
	 */
	@Primary
	@Bean
	public CommonsMultipartResolver commonsMultipartResolver() {
		return new CommonsMultipartResolver();
	}

	@Bean
	public StandardServletMultipartResolver standardServletMultipartResolver() {
		return new StandardServletMultipartResolver();
	}

}
