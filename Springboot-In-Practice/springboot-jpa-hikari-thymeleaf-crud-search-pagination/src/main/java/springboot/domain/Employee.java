package springboot.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Entity
@Table(name = "employee")
@Data
public class Employee {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;

	@Column(name = "emp_name", length = 50, nullable = true)
	private String empName;

	@Column(name = "emp_position", length = 50, nullable = true)
	private String empPosition;

	@Column(name = "emp_salary", nullable = true)
	private Float empSalary;

}
