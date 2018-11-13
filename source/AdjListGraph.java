import java.util.*;

public class AdjListGraph<V> {
    private Map<V, List<EdgeDirigidoPonderado<V>>> adjacencyList;  // [vertices] -> [edge]
    private Map<V, Vertex<V>> vertex;     // [vertex] -> [info]

    public AdjListGraph() {
        this.adjacencyList = new HashMap<V, List<EdgeDirigidoPonderado<V>>>();
        this.vertex = new HashMap<V, Vertex<V>>();
    }

    public void addVertex(V v) {
        if (v == null) {
            throw new IllegalArgumentException("null");
        }

        adjacencyList.put(v, new ArrayList<EdgeDirigidoPonderado<V>>());
        vertex.put(v, new Vertex<V>(v));
    }

    public void addEdge(V from, V to, int weight) {
        List<EdgeDirigidoPonderado<V>> edgeList = adjacencyList.get(from);
        if (edgeList == null) {
            throw new IllegalArgumentException("source vertex not in graph");
        }

        EdgeDirigidoPonderado<V> newEdge = new EdgeDirigidoPonderado<V>(from, to, weight);
        edgeList.add(newEdge);
    }

    public boolean hasEdge(V from, V to) {
        return getEdge(from, to) != null;
    }

    public EdgeDirigidoPonderado<V> getEdge(V from, V to) {
        List<EdgeDirigidoPonderado<V>> edgeList = adjacencyList.get(from);
        if (edgeList == null) {
            throw new IllegalArgumentException("source vertex not in graph");
        }

        for(EdgeDirigidoPonderado<V> e : edgeList) {
            if (e.getTo().equals(to)) {
                return e;
            }
        }

        return null;
    }

    public boolean hasPath(V v1, V v2) {
        return getDFSPath(v1, v2) != null;
    }

    public List<V> getDFSPath(V v1, V v2) {
        clearVertexInfo();

        List<V> path = new ArrayList<>();
        getDFSPath(v1, v2, path);

        if (path.isEmpty()) {
            return null;
        } else {
            return path;
        }
    }

    private List<V> getDFSPath(V v1, V v2, List<V> path) {
        path.add(v1);
        Vertex<V> vInfo = vertex.get(v1);
        vInfo.setVisited(true);

        if (v1.equals(v2)) {
            return path;
        }

        List<EdgeDirigidoPonderado<V>> edges = this.adjacencyList.get(v1);
        for (EdgeDirigidoPonderado<V> e : edges) {
            Vertex<V> vInfo2 = vertex.get(e.getTo());
            if (!vInfo2.isVisited()) {
                getDFSPath(e.getTo(), v2, path);
                if (path.get(path.size() - 1).equals(v2)) {
                    return path;
                }
            }
        }

        path.remove(v1);
        return path;
    }

/*    public List<V> getBFSPath(V v1, V v2) {
        clearVertexInfo();

        List<V> path = new ArrayList<V>();
        getBFSPath(v1, v2, path);

        if (path.isEmpty()) {
            return null;
        } else {
            return path;
        }
    }

    private List<V> getBFSPath(V v1, V v2, List<V> path) {
        path.add(v1);
        Vertex<V> vInfo = vertex.get(v1);
        vInfo.setVisited(true);

        if (v1.equals(v2)) {
            return path;
        }

        List<EdgeDirigidoPonderado<V>> edges = this.adjacencyList.get(v1);
        for (EdgeDirigidoPonderado<V> e : edges) {
            Vertex<V> vInfo2 = vertex.get(e);
            if (!vInfo2.isVisited()) {
                getBFSPath()
            }
        }
    }*/

    public String toString() {
        Set<V> keys = adjacencyList.keySet();
        String str = "";

        for (V v : keys) {
            str += v + ": ";

            List<EdgeDirigidoPonderado<V>> edgeList = adjacencyList.get(v);

            for (EdgeDirigidoPonderado<V> edge : edgeList) {
                str += edge + "  ";
            }
            str += "\n";
        }
        return str;
    }

    private void clearVertexInfo() {
        for (Vertex<V> info : this.vertex.values()) {
            info.clear();
        }
    }

    public Map<V, List<EdgeDirigidoPonderado<V>>> getAdjacencyList() {
        return adjacencyList;
    }

    public Map<V, Vertex<V>> getVertex() {
        return vertex;
    }
}