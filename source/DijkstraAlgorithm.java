import java.util.ArrayList;
import java.util.List;

/**
 * @author Florencia Vimberg
 */
public class DijkstraAlgorithm<T> {
    //todo preguntar alicia si le pasamos a donde queremos ir o como seria sino
    public Object[] dijkstra(GrafoDirigidoPonderado<T> graph, T end){
        return dijkstra(graph, graph.getVertexes(), end);
    }

    private Object[] dijkstra(GrafoDirigidoPonderado graph, List<T> vertex, T end){
        T w = vertex.get(0);
        List<T> s = new ArrayList<>();
        for (int i = 1; i < graph.getVertexes().size(); i++) {
            s.add((T) graph.getVertexes().get(i));
        }
        int[] d = new int[vertex.size()];
        Object[] p = new Object[vertex.size()];
        for (int i = 0; i < d.length ; i++) {
            d[i] = graph.getCost(w, i);
            p[i] =  w;
        }

        while(s.size() > 1){
            int minIndex = getMinIndex(d,s);
            w = vertex.get(minIndex);
            s.remove(w);

            for (int i = 0; i < d.length; i++) {
                if(graph.getCost(minIndex, i) + d[minIndex] < d[i] && graph.getCost(minIndex, i) + d[minIndex] > 0 ){
                    d[i] = graph.getCost(minIndex, i) + d[minIndex];
                    p[i] = w;
                }
            }
        }

        return p;
    }

    //todo esta proogna funciona mal
    private int getMinIndex(int[] d, List<T> s){
        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        int[] num = new int[s.size()];
        for (int i = 0; i < s.size(); i++) {
            num[i] = d[(Integer)s.get(i)];
        }
        for (int i = 0; i < s.size(); i++) {
            if(min > d[(Integer) s.get(i)] && d[(Integer) s.get(i)] != 0){
                min = d[(Integer) s.get(i)];
                minIndex = i;
            }
        }
        return minIndex;
    }

    public void printGraph(GrafoDirigidoPonderado<T> graph) {
        for (int i = 0; i < graph.getVertexes().size(); i++) {
            for (int j = 0; j < graph.getAdyList(i).size(); j++) {
                System.out.println(graph.getVertexes().get(i) + " --- "+graph.getAdyList(i).get(j).getTo() + " value: "+ graph.getAdyList(i).get(j).getValue());
            }
        }
    }

    public int getIndex(GrafoDirigidoPonderado grafo, T vertex) {
        return grafo.getVertexes().indexOf(vertex);
    }
}
