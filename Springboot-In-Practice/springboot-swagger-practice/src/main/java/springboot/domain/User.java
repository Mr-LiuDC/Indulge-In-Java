package springboot.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@ApiModelProperty(value = "用户ID")
	private String id;

	@Column(nullable = false)
	@NotNull(message = "昵称不能为空null")
	@NotEmpty(message = "昵称必填")
	@Size(min = 3, max = 150)
	@ApiModelProperty(value = "用户昵称")
	private String username;

	@Column(nullable = false)
	@NotNull(message = "密码不能为空null")
	@NotEmpty(message = "密码必填")
	@Size(min = 6, max = 80)
	@ApiModelProperty(value = "用户密码")
	private String password;

	@ApiModelProperty(value = "用户年龄")
	private int age;

	@Column(nullable = false, unique = true)
	@Email(message = "请确保邮箱格式正确")
	@NotEmpty(message = "邮箱信息必填")
	@ApiModelProperty(value = "用户邮箱")
	private String email;

	@Column(name = "create_time")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
	@ApiModelProperty(value = "用户创建时间")
	private Date createTime;

}
