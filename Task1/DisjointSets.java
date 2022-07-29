import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import edu.princeton.cs.algs4.UF;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class DisjointSets {
    List<Set<Integer>> L;
    int n;
    UF ufNew;
    
    public DisjointSets(int n){
        ufNew = new UF(n);
        L = new LinkedList<Set<Integer>>();
        for(int i =0; i<n; i++){
            Set<Integer> S = new HashSet<Integer>();
            S.add(i);
            L.add(S);
        }
    }

    public boolean query(int s, int t){
     if(ufNew.find(s)==ufNew.find(t)){
         return true;
     }
     return false;
    }

    public void union2(int s, int t){
        ufNew.union(s, t);
    }

        public void move (int s, int t){
            Set<Integer> S=null, T=null;
            for (Set<Integer> M: L){
                if (M.contains(s)) S=M;
                if (M.contains(t)) T=M;
            }
            if(S!=T){
                S.remove(s);
                T.add(s);
            }
        }

    public static void main(String[] args) {
        int n = StdIn.readInt();
        int m = StdIn.readInt();
        StdIn.readLine();
        DisjointSets uf = new DisjointSets(n);

        for (int i = 0; i < m; i++){
            String [] line = StdIn.readLine().split(" ");
            String q = line[0];
            int s = Integer.parseInt(line[1]);
            int t = Integer.parseInt(line[2]);
            if("1".equals(q)) {
            uf.union2(s,t);
            } else if ("2".equals(q)){
                uf.move(s,t);
            } 
            else{
                StdOut.println(uf.query(s, t) ? "1" : "0");
            }
        }
    }
}
