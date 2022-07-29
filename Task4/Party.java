public class Party implements Comparable<Party>{
    private Double quotient;
    private double votes;
    private double seats;

	public Party(double votes){
        this.votes = votes;
        this.quotient = votes;
        this.seats = 0;
    }

    public void setQuotient() {
        this.quotient = votes / (seats + 1);
    }

    public double getSeat(){
        return seats;
    }

    public void setSeat(double seats) {
        this.seats = seats;
    }

    //Looking up how to override compareTo i got help from this page: https://algs4.cs.princeton.edu/12oop/Date.java.html
    //Updated this compareTo based on the solution to Grades: https://github.itu.dk/pages/algorithms/ads-website-spring-2021/notes/lecture-05/
    @Override
    public int compareTo(Party that) {
    if (this.quotient < that.quotient) return -1;
    if (this.quotient > that.quotient) return 1;
    return this.quotient.compareTo(that.quotient);
    }
}
