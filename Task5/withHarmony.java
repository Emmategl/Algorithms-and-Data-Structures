import java.util.HashMap;

import edu.princeton.cs.algs4.Bipartite;
    import edu.princeton.cs.algs4.DepthFirstPaths;
    import edu.princeton.cs.algs4.Graph;
    import edu.princeton.cs.algs4.StdIn;
    import edu.princeton.cs.algs4.StdOut;

public class withHarmony {
    public static void main(String[] args) {
            String [] firstLine = StdIn.readLine().split(" ");
            int vertices = Integer.parseInt(firstLine[0]);
            int edges= Integer.parseInt(firstLine[1]);
            HashMap<Edge, Integer> hm = new HashMap<Edge, Integer>();

            Edge e = new Edge();
            Graph g = new Graph(vertices);

            for (int i = 0; i < edges; i++) {
                int edgeU=  StdIn.readInt();
                int edgeV = StdIn.readInt();
                int conflictEdge = StdIn.readInt();
                e.setVertices(edgeU, edgeV, conflictEdge);
                hm.put(e, conflictEdge);
                g.addEdge(edgeU, edgeV);
            }
            DPF b = new DPF(g);

                if(b.isBipartite()){
                StdOut.println("1");
                }
                else{
                StdOut.println("0");
                }   
    
}

}

