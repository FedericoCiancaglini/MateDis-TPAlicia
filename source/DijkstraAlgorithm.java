import java.util.ArrayList;
import java.util.List;

/**
 * @author Florencia Vimberg
 */
public class DijkstraAlgorithm<T> {
    public List<List<T>> dijkstra(GrafoDirigidoPonderado<T> graph, T begin){
        return dijkstra(graph, graph.getVertexes(), begin);
    }

    private List<List<T>> dijkstra(GrafoDirigidoPonderado graph, List<T> vertex, T begin){
        int index = graph.getIndex(begin);
        T w = vertex.get(index);
        T[] s = (T[]) new Object[vertex.size()];
        for (int i = 0; i < graph.getVertexes().size(); i++) {
            s[i] = (T) graph.getVertexes().get(i);
        }
        s = remove(s, index);
        int[] d = new int[vertex.size()];
        T[] p = (T[]) new Object[vertex.size()];
        for (int i = 0; i < d.length ; i++) {
            d[i] = graph.getCost(w, i);
            p[i] =  w;
        }

        while(s.length > 1){
            int minIndex = getMinIndex(d,s);
            w = vertex.get(minIndex);
            s = remove(s, minIndex);

            for (int i = 0; i < d.length; i++) {
                if(graph.getCost(minIndex, i) + d[minIndex] < d[i] && graph.getCost(minIndex, i) + d[minIndex] > 0 ){
                    d[i] = graph.getCost(minIndex, i) + d[minIndex];
                    p[i] = w;
                }
            }
        }

        return redoPaths(p, graph.getVertexes(), begin);
    }

    private int getMinIndex(int[] d, T[] s){
        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        for (int i = 0; i < s.length; i++) {
            if(min > d[(Integer) s[i]] && d[(Integer) s[i]] != 0){
                min = d[(Integer) s[i]];
                minIndex = (Integer) s[i];
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

    public T[] remove(T[] s, int minIndex){
        T[] result = (T[]) new Object[s.length-1];
        for(int i = 0; i < s.length; i++){
            if(s[i].equals(minIndex)){
                for(int j = i; j < s.length - 1; j++){
                    result[j] = s[j+1];
                }
                return result;
            } else {
                result[i] = s[i];
            }
        }
        return result;
    }

    public List<List<T>> redoPaths(T[] p, List<T> vertex, T begin){
        List<List<T>> result = new ArrayList<>(p.length);
        for (int j = 0; j < p.length; j++) {
            int i = j;
            List<T> list = new ArrayList<>();
            list.add(vertex.get(i));
            while (p[i] != begin){
                list.add(p[i]);
                i = (Integer) p[i];
            }
            list.add(p[i]);
            result.add(list);
        }
        return result;
    }
}
