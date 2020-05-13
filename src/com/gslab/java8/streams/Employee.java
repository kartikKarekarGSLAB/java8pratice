package com.gslab.java8.streams;

public class Employee {

	private Integer id;
	private String name;
	private String designation;
	private String project;
	private String pratice;
	private Integer yearsOfExperience;
		
	public Employee() {
		super();
	}
	
	public Employee(Integer id, String name, String designation, String project, String pratice, Integer yearsOfExperience) {
		super();
		this.id = id;
		this.name = name;
		this.designation = designation;
		this.project = project;
		this.pratice = pratice;
		this.yearsOfExperience = yearsOfExperience;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	public String getPratice() {
		return pratice;
	}
	public void setPratice(String pratice) {
		this.pratice = pratice;
	}
	public Integer getYearsOfExperience() {
		return yearsOfExperience;
	}

	public void setYearsOfExperience(Integer yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", designation=" + designation + ", project=" + project
				+ ", pratice=" + pratice + ", yearsOfExperience=" + yearsOfExperience + "]";
	}
	
}
