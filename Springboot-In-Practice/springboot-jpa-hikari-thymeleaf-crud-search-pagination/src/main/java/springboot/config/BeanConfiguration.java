package springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.dialect.springdata.SpringDataDialect;

@Configuration
public class BeanConfiguration {
	
	@Bean
    public SpringDataDialect springDataDialect() {
        return new SpringDataDialect();
    }

}
