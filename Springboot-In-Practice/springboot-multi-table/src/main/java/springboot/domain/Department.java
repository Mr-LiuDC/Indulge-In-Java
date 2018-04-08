package springboot.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Department
 *
 * @author LiuDeCai
 * @date 2018/04/08
 */
@Entity
@Data
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "department_name")
    private String departmentName;

    private String description;

    @Column(name = "create_time")
    private Date createTime;

}
