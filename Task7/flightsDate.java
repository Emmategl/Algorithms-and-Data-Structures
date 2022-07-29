
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.time.LocalTime;

/* with help from - and with use of - https://algs4.cs.princeton.edu/code/javadoc/edu/princeton/cs/algs4/ST.html
and from https://algs4.cs.princeton.edu/32bst/BST.java.html
*/

public class flightsDate {
    static STNew<LocalTime, String> st;
    public static void main(String[] args) {
        String [] firstLine = StdIn.readLine().split(" ");
        int numFlights = Integer.parseInt(firstLine[0]);
        int numOperations= Integer.parseInt(firstLine[1]);
        st = new STNew<LocalTime, String>();

        for (int i = 0; i < numFlights; i++) {
            String [] lines = StdIn.readLine().split(" ");
            String[] stamp = lines[0].split(":");
            int hour = Integer.parseInt(stamp[0]);
            int minutes = Integer.parseInt(stamp[1]);
            int seconds= Integer.parseInt(stamp[2]);
            LocalTime timeStamp = LocalTime.of(hour, minutes, seconds);
            String destination = lines[1];
            st.put(timeStamp, destination);
        }

        for (int i = 0; i < numOperations; i++) {
            String [] lines = StdIn.readLine().split(" ");
            String command = lines[0];

            String[] stamp = lines[1].split(":");
            int hour = Integer.parseInt(stamp[0]);
            int minutes = Integer.parseInt(stamp[1]);
            int seconds= Integer.parseInt(stamp[2]);
            LocalTime timeStamp = LocalTime.of(hour, minutes, seconds);

            if (command.equals("destination")){
                if(st.contains(timeStamp)){

                    StdOut.println(st.get(timeStamp));
                }
                else {
                    StdOut.println("-");
                }
            }
            if (command.equals("cancel")){
                st.delete(timeStamp);
            }
            if (command.equals("delay")){
                int amountAdded = Integer.parseInt(lines[2]);
                LocalTime tm = timeStamp.plusSeconds(amountAdded);
                String des = st.get(timeStamp);
                st.delete(timeStamp);
                st.put(tm,des);
            }
            if (command.equals("reroute")){
                String secondL = lines[2];
                st.put(timeStamp, secondL);
            }

            if (command.equals("count")){
                String[] stamp2 = lines[2].split(":");
                int hour2 = Integer.parseInt(stamp2[0]);
                int minutes2 = Integer.parseInt(stamp2[1]);
                int seconds2= Integer.parseInt(stamp2[2]);
                LocalTime timeStamp2 = LocalTime.of(hour2, minutes2, seconds2);
                System.out.println(st.range(timeStamp, timeStamp2));
            }

            if (command.equals("next")){
                LocalTime smallest = st.ceiling(timeStamp);
                String l = smallest.toString();
                if (l.length() == 5){
                    l += ":00";
                }
                StdOut.println(l + " " + st.get(smallest));
                
            }
        }    

    }
} 
