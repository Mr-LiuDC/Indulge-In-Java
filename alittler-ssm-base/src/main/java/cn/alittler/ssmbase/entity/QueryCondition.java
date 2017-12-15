package cn.alittler.ssmbase.entity;

import java.util.Date;

/**
 * @description: 查询条件设置
 * @date: Created on 2016年11月20日
 * @author: Mr-LiuDC
 * 
 */
public class QueryCondition {

	private String personAddr;

	private Integer gender;

	private Date birthday;

	private String name;

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPersonAddr() {
		return personAddr;
	}

	public void setPersonAddr(String personAddr) {
		this.personAddr = personAddr;
	}

	@Override
	public String toString() {
		return "QueryCondition [gender=" + gender + ", birthday=" + birthday + ", name=" + name + ", personAddr="
				+ personAddr + "]";
	}

}
