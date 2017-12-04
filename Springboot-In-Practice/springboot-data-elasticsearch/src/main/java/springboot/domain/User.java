package springboot.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.Data;

/**
 * @description: User对象实体
 * @dateTime: Create On 2017-12-03 21:48:00
 * @author: Mr-LiuDC
 * @email: 1911939348@qq.com
 *
 */
@Data
@Document(indexName = "spring_data_elasticsearch", type = "user")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String name;

	private Date birthday;

	private Date creatTime;

	private String motto;

	public User(String name, Date birthday, Date creatTime, String motto) {
		super();
		this.name = name;
		this.birthday = birthday;
		this.creatTime = creatTime;
		this.motto = motto;
	}

	public User() {
		super();
	}

}
