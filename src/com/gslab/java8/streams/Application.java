package com.gslab.java8.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Application {

	List<Employee> employees;
	
	public Application() {
		this.employees = new ArrayList<>();
		this.employees.addAll(Arrays.asList(
		new Employee(101, "Kartik", "Software engineer", "Extended Care", "CIS", 5),
		new Employee(102, "Nahush", "Software engineer", "Extended Care", "CIS", 3),
		new Employee(103, "Swapnil", "Software engineer", "Extended Care", "CIS", 2),
		new Employee(104, "Sanket", "Software engineer", "Extended Care", "CIS", 10),
		new Employee(105, "Bhushan", "Software engineer", "Extended Care", "CIS", 8)));
	}
	
	public static void main(String args[]) {
		Application app = new Application();
		
		Stream<Employee> employeeStream = app.employees.stream();
		System.out.println("Company's strenght ::"+employeeStream.count());
		
		//Since the count operation has already closed the stream we need to reopne the stream.
		employeeStream = app.employees.stream();
		employeeStream.sorted(Comparator.comparing(Employee::getName).reversed()).forEach(System.out::println);
		
		employeeStream = app.employees.stream();
		
		Optional<Employee> empWithMaxExperience = employeeStream.max(Comparator.comparing(Employee::getYearsOfExperience));
		if(empWithMaxExperience.isPresent()) {
			System.out.println("\nMAX :: " + empWithMaxExperience.get());
		}
		
		employeeStream = app.employees.stream();
		employeeStream.peek((emp) -> emp.setName(emp.getName().toUpperCase())).forEach(System.out::println);
	}
}
