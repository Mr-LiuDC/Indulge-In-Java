package springboot.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Role
 *
 * @author LiuDeCai
 * @date 2018/04/08
 */
@Entity
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "role_name")
    private String roleName;

    private String description;

    @Column(name = "create_time")
    private Date createTime;

}
