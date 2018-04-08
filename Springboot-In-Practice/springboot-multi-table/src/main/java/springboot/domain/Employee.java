package springboot.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Employee
 *
 * @author LiuDeCai
 * @date 2018/04/08
 */
@Entity
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "employee_name")
    private String employeeName;

    private String description;

    @ManyToOne
    private Department department;

    @ManyToMany
    private Set<Role> roles;

    @Column(name = "create_time")
    private Date createTime;

}
