package com.gslab.java8.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Introduction {

	public static void main(String[] args) {
		
		List<String> demo = new ArrayList<>(Arrays.asList("kartik","karekar" ));
		
		System.out.println(demo);
		System.out.println("Remove ::"+ demo.removeIf((name) -> name.equalsIgnoreCase("karekar")));
		System.out.println(demo);
		
		Queue<Object> data = new PriorityQueue<>();
		data.add(10);
		data.add(20);
		
		System.out.println(data.poll());
		System.out.println(data.peek());
		
		List<Integer> data2 = new Stack<Integer>();
		data2.add(50);
		data2.add(60);
		data2.add(70);
		System.out.println(data2);
		System.out.println(data2.remove(1));
		System.out.println(data2);
		
//		demo.
	}

}
