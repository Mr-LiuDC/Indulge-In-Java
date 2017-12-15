package cn.alittler.ssmbase.entity;

import java.util.Date;

/**
 * @description: PersonDao接口类
 * @date: Created on 2016年11月20日
 * @author: Mr-LiuDC
 *
 */
public class Person {
	private Integer personId;

	private String name;

	private Integer gender;

	private String personAddr;

	private Date birthday;

	public Integer getPersonId() {
		return personId;
	}

	public void setPersonId(Integer personId) {
		this.personId = personId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getPersonAddr() {
		return personAddr;
	}

	public void setPersonAddr(String personAddr) {
		this.personAddr = personAddr == null ? null : personAddr.trim();
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "Person [personId=" + personId + ", name=" + name + ", gender=" + gender + ", personAddr=" + personAddr
				+ ", birthday=" + birthday + "]";
	}

}