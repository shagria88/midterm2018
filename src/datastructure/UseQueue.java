package datastructure;


import java.util.LinkedList;
import java.util.Queue;

public class UseQueue {

	public static void main(String[] args) {
		/*
		 * Demonstrate how to use Queue that includes add,peek,remove,pool elements.
		 * Use For Each loop and while loop with Iterator to retrieve data.
		 *
		 */
		Queue<String> q = new LinkedList<String>();

		//Adding elements to the Queue
		q.add("Rick");
		q.add("Alma");
		q.add("Victoria");
		q.add("Nancy");
		q.add("Dora");

		System.out.println("Elements in Queue:"+q);

		/*
		 * We can remove element from Queue using remove() method,
		 * this would remove the first element from the Queue
		 */
		System.out.println("Removed element: "+q.remove());

		/*
		 * element() method - this returns the head of the
		 * Queue. Head is the first element of Queue
		 */
		System.out.println("Head: "+q.element());

		/*
		 * poll() method - this removes and returns the
		 * head of the Queue. Returns null if the Queue is empty
		 */
		System.out.println("poll(): "+q.poll());

		/*
		 * peek() method - it works same as element() method,
		 * however it returns null if the Queue is empty
		 */
		System.out.println("peek(): "+q.peek());

		//Again displaying the elements of Queue
		System.out.println("Elements in Queue:"+q);
	}
}
