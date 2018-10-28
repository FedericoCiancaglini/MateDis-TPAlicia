import java.util.List;

/**
 * @author Florencia Vimberg
 */
public interface IGraph<T> {
    void addVertex(T vertex);
    void addEdge(int v, int w, int value);
    void removeEdge(int v, int w);
    void removeVertex(int v);
    boolean hasEdge(int v, int w);
    boolean hasEdge(T vertex1, T vertex2);
    int order();
    int amtEdges();
    T vertex(int v);
    List<EdgeDirigidoPonderado> getAdyList(T v);
    List<T> getAdyListElements(T vertex);
    int getIndex(T vertex);
}

