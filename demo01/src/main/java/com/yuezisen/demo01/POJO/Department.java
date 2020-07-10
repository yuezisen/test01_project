package com.yuezisen.demo01.POJO;

public class Department {

	private Integer id;
	private String departmentName;
	private Integer EmpId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Integer getEmpId() {
		return EmpId;
	}

	public void setEmpId(Integer empId) {
		EmpId = empId;
	}

	@Override public String toString() {
		return "Department{" + "id=" + id + ", departmentName='" + departmentName + '\'' + ", EmpId=" + EmpId + '}';
	}
}
