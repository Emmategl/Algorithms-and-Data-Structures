import edu.princeton.cs.algs4.MaxPQ;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

//Inspired by question on Piazza by Anonymous Beaker

public class Main {

    public static void main(String[] args) {

        //Through intput find the number of parties and the number of available seats in the parliament.
        String [] firstLine = StdIn.readLine().split(" ");
        int numOfParties = Integer.parseInt(firstLine[0]);
        int availableSeats = Integer.parseInt(firstLine[1]);
        int[] numOfVotes = new int[numOfParties];

        //Through input findthe number of votes for each party
        for (int i = 0; i < numOfParties; i++) {
          String [] nextLines = StdIn.readLine().split(" ");
          numOfVotes[i] = Integer.parseInt(nextLines[0]);
        }     

        //Create an array of all parties and create an priority queue.
        Party[] arrayOfParties = new Party[numOfParties];
        MaxPQ<Party> priorityQueue = new MaxPQ<Party>();

        //Create the parties and initialise with their amount of votes. Insert these parties into the priority queue.
        for (int i = 0; i <numOfParties; i++){
            arrayOfParties[i] = new Party(numOfVotes[i]);
            priorityQueue.insert(arrayOfParties[i]);
        } 

        //Find the party with the most votes and add 1 seat to this party.
        //Change the quotient based on D’Hondt’s method.
        //Insert the party (with it's new quotient and updated amount of seats) back into the queue.
        for (int i = availableSeats; i > 0; i--) {
          Party mostVotes = priorityQueue.delMax();
          mostVotes.setSeat(mostVotes.getSeat()+1);
          mostVotes.setQuotient();
          priorityQueue.insert(mostVotes);
        }
        
        //print out the number of seats in the list for each party in the array.
        for (Party party : arrayOfParties) {
          StdOut.println((int) party.getSeat());
        }
    }

}
