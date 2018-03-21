package springboot.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户User
 *
 * @author LiuDeCai
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "用户ID")
    private Long id;

    @ApiModelProperty(value = "用户姓名")
    private String name;

    @ApiModelProperty(value = "用户密码")
    private String password;

    @ApiModelProperty(value = "创建时间")
    @Column(name = "create_time")
    private Date createTime;

}
