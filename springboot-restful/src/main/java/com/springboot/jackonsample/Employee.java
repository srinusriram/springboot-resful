package com.springboot.jackonsample;

public class Employee {

	String name;
	String age;
	String deptName;
	iDepartment dept;

	/**
	 * @return the dept
	 */
	public iDepartment getDept() {
		return dept;
	}

	/**
	 * @param dept
	 *            the dept to set
	 */
	public void setDept(iDepartment dept) {
		this.dept = dept;
	}

	/**
	 * @return the deptName
	 */
	public String getDeptName() {
		return deptName;
	}

	/**
	 * @param deptName
	 *            the deptName to set
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", deptName=" + deptName + "]";
	}

	/**
	 * @param name
	 * @param age
	 * @param deptName
	 * @param dept
	 */
	public Employee(String name, String age, String deptName, iDepartment dept) {
		super();
		this.name = name;
		this.age = age;
		this.deptName = deptName;
		this.dept = dept;
	}

	/**
	 * @param name
	 * @param age
	 * @param deptName
	 */
	public Employee(String name, String age, String deptName) {
		super();
		this.name = name;
		this.age = age;
		this.deptName = deptName;
	}

	/**
	 * 
	 */
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the age
	 */
	public String getAge() {
		return age;
	}

	/**
	 * @param age
	 *            the age to set
	 */
	public void setAge(String age) {
		this.age = age;
	}
}
