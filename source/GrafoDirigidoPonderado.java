import java.util.ArrayList;
import java.util.List;

/**
 * @author Florencia Vimberg
 */
public class GrafoDirigidoPonderado<T> implements IGraph {

    private List<T> vertexes;
    private List<EdgeDirigidoPonderado> edges;
    //todo que tenga lista de adyacentes
    private int n;
    private int alpha;

    public GrafoDirigidoPonderado() {
        vertexes = new ArrayList<>();
        edges = new ArrayList<>();
        n = 0;
        alpha = 0;
    }

    public List<T> getVertexes() {
        return vertexes;
    }

    public int getCost(T from, T to){
        List<EdgeDirigidoPonderado> adyListFrom = getAdyList(from);
        if (from == to){
            return 0;
        }
        for (int i = 0; i < adyListFrom.size(); i++) {
            if(adyListFrom.get(i).getTo() == to){
                return adyListFrom.get(i).getValue();
            }
        }
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean hasEdge(int v, int w) {
        Vertex vertex = (Vertex) vertex(v);
        Vertex to = (Vertex) vertex(w);
        List<EdgeDirigidoPonderado> adyList = getAdyList(vertex);
        for (int i = 0; i < adyList.size(); i++) {
            if(adyList.get(i).getTo() == to){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean hasEdge(Object vertex1, Object vertex2) {
        return false;
    }

    @Override
    public int order() {
        return n;
    }

    @Override
    public int amtEdges() {
        return alpha;
    }

    @Override
    public Object vertex(int v) {
        return vertexes.get(v);
    }

    @Override
    public List<EdgeDirigidoPonderado> getAdyList(Object v) {
        List<EdgeDirigidoPonderado> adyList = new ArrayList<>();
        for (EdgeDirigidoPonderado adyList1 : edges) {
            if (adyList1.getFrom().equals(v)) {
                adyList.add(adyList1);
            }
        }
        return adyList;
    }

    @Override
    public List getAdyListElements(Object vertex) {
        return null;
    }

    @Override
    public int getIndex(Object vertex) {
        return vertexes.indexOf(vertex);
    }

    @Override
    public void addVertex(Object vertex) {
        vertexes.add((T) vertex);
        n++;
    }

    @Override
    public void addEdge(int v, int w, int value) {
        edges.add(new EdgeDirigidoPonderado(v,w,value));
        alpha++;
    }

    @Override
    public void removeEdge(int v, int w) {
        Vertex vertex = (Vertex) vertex(v);
        Vertex to = (Vertex) vertex(w);
        List<EdgeDirigidoPonderado> adyList = getAdyList(vertex);
        for (int i = 0; i < adyList.size(); i++) {
            if(adyList.get(i).getTo() == to){
                adyList.remove(i);
            }
        }
    }

    @Override
    public void removeVertex(int v) {
        vertexes.remove(v);
        Vertex vertex = (Vertex) vertex(v);
        List<EdgeDirigidoPonderado> adyList = getAdyList(vertex);
        for (int i = 0; i < adyList.size(); i++) {
            adyList.remove(i);
        }
    }

}
