package datastructure;

import java.util.ArrayList;

public class UseArrayList {

	public static void main(String[] args) {
		/*
		 * Demonstrate how to use ArrayList that includes add,peek,remove,retrieve elements.
		 * Use For Each loop and while loop with Iterator to retrieve data.
		 * Store all the sorted data into one of the databases.
		 * 
		 */
		ArrayList<String> alist = new ArrayList<String>();
		alist.add("Steve");
		alist.add("Tim");
		alist.add("Lucy");
		alist.add("Pat");
		alist.add("Angela");
		alist.add("Tom");


		System.out.println(alist);
		alist.add(3, "Steve");
		System.out.println(alist);
	}
}


