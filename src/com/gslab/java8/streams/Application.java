package com.gslab.java8.streams;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application {

	List<Employee> employees;

	public Application() {
		this.employees = new ArrayList<>();
		this.employees
				.addAll(Arrays.asList(
						new Employee(102, "Nahush", "Senior Software engineer", "Crypto Money", "CIS", 3),
						new Employee(101, "Kartik", "Senior Software engineer", "Extended Care", "CIS", 5),
						new Employee(103, "Swapnil", "Lead Software engineer", "Extended Care", "CIS", 2),
						new Employee(104, "Sanket", "Software engineer", "Crypto Money", "CIS", 10),
						new Employee(105, "Bhushan", "Lead Software engineer", "Extended Care", "CIS", 8)));
	}

	/**
	 * @param args
	 */
	public static void main(String args[]) {
		Application app = new Application();

		//Get the stream first from the collection.
		Stream<Employee> employeeStream = app.employees.stream();
		
		System.out.println("Company's strength ::" + employeeStream.count());
		// Since the count operation has already closed the stream we need to reopen the
		// stream.
		employeeStream = app.employees.stream();
		
		/* allMatch
		 * Evaluate the function for every item in the stream. 
		 * Terminating operation. -- return boolean
		 */
		boolean isGreaterThanAYear = employeeStream.allMatch((employee) -> employee.getYearsOfExperience() > 1);
		System.out.println(isGreaterThanAYear ? "All employess having year of experoence greather than one."
				: "You may have some Trainee engineer.");

		// Since the allMatch operation has already closed the stream we need to reopen
		// the stream.
		// anyMatch - Terminating operation. -- return boolean
		// This operation will evaluate until any match condition found once it found it
		// terminate.
		employeeStream = app.employees.stream();
		boolean isGreaterThanFourYear = employeeStream.anyMatch((employee) -> {
			System.out.println("Condition evaluating for employee name=" + employee.getName() + ", YearsOfExperience="
					+ employee.getYearsOfExperience());
			return employee.getYearsOfExperience() > 4;
		});

		System.out.println("Does any one has experience greater than 4 ? " + (isGreaterThanFourYear ? "Yes" : "No"));

		// collect use to convert the stream into required collection type.
		/*
		 * The collect method. Which convert the elements in the stream into the required collection.
		 * java.util.stream.Collectors : used for reduction of stream. it has many static methods to convert the stream into the required collection.
		 * toList() - convert the collection into list.
		 * toSet() - convert the collection into set.
		 */
		employeeStream = app.employees.stream();
		List<Employee> empList = employeeStream.collect(Collectors.toList());
		for (Employee index : empList) {
			System.out.println(index);
		}

		employeeStream = app.employees.stream();
		Map<String, List<Employee>> nameDesignationMap = employeeStream
				.collect(Collectors.groupingBy(Employee::getDesignation));

		for (String key : nameDesignationMap.keySet()) {
			System.out.println(MessageFormat.format("{0} \n {1}", key, nameDesignationMap.get(key)));
		}

		// The collect will use a collector as a parameter. Defining the collectors as per user's choice.
		// collectors groupingBy will take 2 Arguments :
		/*
		 * 1.classifier - a classifier function mapping input elements to
		 * 2.keysdownstream - a Collector implementing the downstream reduction
		 */

		System.out.println("\nMapping according to senior level Experience :\n\n");
		employeeStream = app.employees.stream();
		Map<Integer, List<Employee>> experienceMap = employeeStream.collect(Collectors.groupingBy((emp) -> {
			return emp.getYearsOfExperience() > 5 ? emp.getYearsOfExperience() : 5;
		}, Collectors.toList()));

		for (Integer key : experienceMap.keySet()) {
			System.out.println(MessageFormat.format("\nGreat!! {0} Years with GS lab \n {1}",
					key > 5 ? key : "Less than 5", experienceMap.get(key)));
		}

		// Get any random element from stream.
		employeeStream = app.employees.stream();
		Optional<Employee> emp = employeeStream.findAny();
		if (emp.isPresent()) {
			System.out.println("\nRandom Employee details ::" + emp.get());
		}

		/*
		 * sort default sort the elements from the stream in natural order.
		 * Otherwise need to mentioned the sorting criteria using the Comparator.
		 * Comparator has static method comparing which can be used to specify the sorting condition. 
		 */
		// Sorting the values.
		employeeStream = app.employees.stream();
		employeeStream.sorted(Comparator.comparing(Employee::getDesignation)).forEach((e) -> {
			System.out.println("\nEmployee names :" + e.getName() + " designation=" + e.getDesignation());
		});
		
		/* consecutive operations on streams
		 * 
		 */
		
		employeeStream = app.employees.stream();
		employeeStream.skip(1).map((e) -> {
			e.setProject(e.getProject().equalsIgnoreCase("Crypto Money") ? "One Taxi" : e.getProject());
			return e;

		}).limit(3).forEach(System.out::println);

		Stream<String> languages = Stream.of("PostgresSQL", "Computer Graphics", "RabbitMQ", "Advanced Algorithum",
				"PostgresSQL", "JAVA8", "RabbitMQ", "Caching using Hazelcast", "RabbitMQ", "PostgresSQL");
		languages.distinct().forEach(System.out::println); // remove duplicate elements.

		
		/*
		 * reduction operations on stream. max , min
		 * will reduce the stream to a single value element return from the stream after checking the comparator condition on the stream.
		 */
		employeeStream = app.employees.stream();
		
		Optional<Employee> empWithMaxExperience = employeeStream.max(Comparator.comparing(Employee::getYearsOfExperience)); //
		  if(empWithMaxExperience.isPresent()) { // 
			  System.out.println("\nMAX :: " +empWithMaxExperience.get());
		  }
		  
		  //Map convert Employee stream to employee name's stream.
		  employeeStream = app.employees.stream();
		  employeeStream.flatMap((e) -> e.getName().chars().mapToObj((i) -> (char)i)).forEach(System.out::println);;
		  
	}	  
}
