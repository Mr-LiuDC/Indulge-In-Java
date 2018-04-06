package springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;

/**
 * JacksonConfiguration
 * 
 * @author LiuDeCai
 * @date 2018/04/06
 *
 */
@Configuration
public class JacksonConfiguration {

	/**
	 * 处理循环懒加载问题，需要加入jackson-datatype-hibernate5依赖
	 * 
	 * @return
	 */
	@Bean
	protected Module module() {
		return new Hibernate5Module();
	}

	/**
	 * 与上面效果等同 
	 * 加上@Bean 与上面的方式二选一
	 * 
	 * @return
	 */
	public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
		MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
		ObjectMapper objectMapper = jsonConverter.getObjectMapper();
		objectMapper.registerModule(new Hibernate5Module());
		return jsonConverter;
	}

}
