public class Vertex<V> {

    private V v;
    private boolean visited;

    public Vertex(V v) {
        this.v = v;
        this.clear();
    }

    public void clear() {
        this.visited = false;
    }

    public V getV() {
        return v;
    }

    public void setV(V v) {
        this.v = v;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
}
