import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.Scanner;

public class main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
			int numOperations = sc.nextInt();
			Stack<Integer> stack = new Stack<>();
			Queue<Integer> queue = new LinkedList<>();
			PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(Collections.reverseOrder());
			
            boolean ItsAStack = true;
            boolean ItsAQueue = true;
            boolean ItsAPriorityQ = true;

			for (int i=0;i<numOperations;i++) {
                int number = sc.nextInt();
                int integer = sc.nextInt();
				if (number == 1) {
					if (ItsAStack) {
						stack.push(integer);};
					if (ItsAQueue) {
						queue.add(integer);}
					if (ItsAPriorityQ) {
						priorityQueue.add(integer);}
				} else if (number == 2) {
					if (ItsAStack && (stack.isEmpty() || !stack.pop().equals(integer))){
					ItsAStack = false;}
					if (ItsAQueue && (queue.isEmpty() || !queue.remove().equals(integer))){
					ItsAQueue = false;}
					if (ItsAPriorityQ && (priorityQueue.isEmpty() || !priorityQueue.remove().equals(integer))){
					ItsAPriorityQ = false;}
				}
			}
			
			if ((ItsAStack && ItsAQueue) || (ItsAStack && ItsAPriorityQ) || (ItsAQueue && ItsAPriorityQ)){
				System.out.println("not sure");}
			else if (ItsAStack) {
				System.out.println("stack");}
			else if (ItsAQueue) {
				System.out.println("queue");}
			else if (ItsAPriorityQ) {
				System.out.println("priority queue");}
			else {
				System.out.println("impossible");}
		}
        sc.close();
    }
}