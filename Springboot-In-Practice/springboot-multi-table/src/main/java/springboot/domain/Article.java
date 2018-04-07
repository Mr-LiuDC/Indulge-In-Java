package springboot.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 文章Article
 * 
 * @author LiuDeCai
 *
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value = "文章ID")
	private Long id;

	@ApiModelProperty(value = "文章标题")
	private String title;

	@ApiModelProperty(value = "文章封面图")
	private String cover;

	@ApiModelProperty(value = "文章内容")
	private String content;

	@ManyToOne(fetch = FetchType.LAZY)
	@ApiModelProperty(value = "文章作者")
	private User user;

	@ApiModelProperty(value = "创建时间")
	private Date createTime;

}
