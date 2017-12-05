package springboot.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Person {

	@Id
	@GeneratedValue
	private Integer id;

	private String name;

	private Integer age;

}
