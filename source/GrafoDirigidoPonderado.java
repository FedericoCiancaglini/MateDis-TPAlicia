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

    public List<EdgeDirigidoPonderado> getAdyLists() {
        return edges;
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

    }

    @Override
    public void removeVertex(int v) {

    }

    @Override
    public boolean hasEdge(int v, int w) {
        return false;
    }

    @Override
    public boolean hasEdge(Object vertex1, Object vertex2) {
        return false;
    }

    @Override
    public int order() {
        return 0;
    }

    @Override
    public int amtEdges() {
        return 0;
    }

    @Override
    public Object vertex(int v) {
        return null;
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
}
