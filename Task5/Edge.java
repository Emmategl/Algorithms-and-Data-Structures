import java.util.HashMap;

public class Edge {
public int start;
public int stop;
public int isConflict;
public static HashMap<Edge, Integer> b = new HashMap<Edge, Integer>();

public Edge(int start, int stop) {
this.start = start;
this.stop = stop;
}

public Edge() {
    this.start = start;
    this.stop = stop;
}

public void setVertices(int start, int stop, int isConflict) {
    this.start = start;
    this.stop = stop;
    this.isConflict = isConflict;
    Edge e = new Edge(start, stop);
    b.put(e, isConflict);
}

public int getEdgeType(Edge c) {
    int h = b.get(c);
    return h;
}


public void setB(HashMap<Edge, Integer> b) {
    this.b = b;
}

public HashMap<Edge, Integer> getB() {
    return b;
}


@Override
public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + start;
    result = prime * result + stop;
    return result;
}

@Override
public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    Edge other = (Edge) obj;
    if (start != other.start)
        return false;
    if (stop != other.stop)
        return false;
    return true;
}

}
