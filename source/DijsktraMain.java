import java.util.List;

/**
 * @author Florencia Vimberg
 */
public class DijsktraMain {
    public static void main(String[] args) {
        GrafoDirigidoPonderado grafo =  new GrafoDirigidoPonderado();
        grafo.addVertex(0);
        grafo.addVertex(1);
        grafo.addVertex(2);
        grafo.addVertex(3);
        grafo.addVertex(4);

        grafo.addEdge(0,4,100);
        grafo.addEdge(0,3,10);
        grafo.addEdge(0,1,10);
        grafo.addEdge(1,2,50);
        grafo.addEdge(3,2,20);
        grafo.addEdge(3,4,60);
        grafo.addEdge(4,2,30);

        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm();

        dijkstra.printGraph(grafo);

        List<List<Integer>> dijkstraArray = dijkstra.dijkstra(grafo, 0);

        System.out.println("\nLess expensive paths:");
        for (int i = 0; i < dijkstraArray.size(); i++) {
            System.out.println(print(dijkstraArray.get(i)));
        }
    }

    private static String print(List<Integer> list) {
        String result = "";
        for (int i = 0; i < list.size() ; i++) {
            if(i == list.size()-1){
                result += list.get(i);
            } else {
                result += list.get(i) + " -> \t";
            }
        }
        return result;
    }
}
