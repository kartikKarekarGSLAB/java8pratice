package com.gslab.java8.collection;

import java.util.ArrayList;
import java.util.List;

public class ArrayListDemo {

	private List<String> list;
	
	public ArrayListDemo() {
		super();
		this.list = null;
	}
	
	public List<String> getList() {
		return list;
	}


	public void setList(List<String> list) {
		this.list = list;
	}

	public void init() {
		this.list = new ArrayList<>();
		list.add("Kartik1");
		list.add("Kartik2");
		list.add("Kartik3");
		
	}

	public static void main(String[] args) {
		ArrayListDemo application =  new ArrayListDemo();
		application.init();
		System.out.println(application.getList().size());
		
		
		/*
		 * Spliterators, like other Iterators, are for traversing the elements of a source. 
		 * A source can be a Collection, an IO channel or a generator function.
		 * 
		 * It is included in JDK 8 for support of efficient parallel traversal(parallel programming) i
		 * n addition to sequential traversal.
		 * 
		 */
		application.getList().spliterator().forEachRemaining((e) -> System.out.println(e));
	}



}
