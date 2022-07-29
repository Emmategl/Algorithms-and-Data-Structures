
import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Grades{
public static void main(String[] args) {
        int amount = StdIn.readInt();
        StdIn.readLine();
        String[] a = new String[amount];
        String[] b = new String[amount];
        String[] c = new String[amount];
        String[] d = new String[amount];
   
        for (int i = 0; i < amount; i++) {
            String [] line = StdIn.readLine().split(" ");
            String name = line[0];
            String grade = line[1];
            String grades = Gradess(grade);
            a[i] = String.valueOf(name).trim();
            b[i] = String.valueOf(grades).trim();

            for (int e = 0; e < amount; e++) {
                Queue<String> q = new Queue<String>();
                q.enqueue(b[e]);
                q.enqueue(a[e]);
                c[e] = String.valueOf(q);
            }
        }
        for (String string : c) {
            Insertion.sort(c);
            for (int i = 0; i < c.length; i++) {
                d[i] = c[i].substring(2);
            }
        }
        for (String string : d) {
            StdOut.println(string.trim());
        }
    }

    public static String Gradess(String grade) {
        String intGrade = "0";

        if (grade.equals("A")){
            intGrade = "1";
        }
        if (grade.equals("B")){
            intGrade = "2";
        }
        if (grade.equals("C")){
            intGrade = "3";
        }
        if (grade.equals("D")){
            intGrade = "4";
        }
        if (grade.equals("E")){
            intGrade = "5";
        }
        if (grade.equals("FX")){
            intGrade = "6";
        }
        if (grade.equals("F")){
            intGrade = "7";
        }
        return intGrade;
        }
}

