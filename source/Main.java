/**
 * @author Florencia Vimberg
 */
public class Main {
    public static void main(String[] args) {
        GrafoDirigidoPonderado grafo =  new GrafoDirigidoPonderado();
        grafo.addVertex(0);
        grafo.addVertex(1);
        grafo.addVertex(2);
        grafo.addVertex(3);
        grafo.addVertex(4);

        grafo.addEdge(0,1,10);
        grafo.addEdge(0,3,30);
        grafo.addEdge(0,4,100);
        grafo.addEdge(1,2,50);
        grafo.addEdge(2,4,10);
        grafo.addEdge(3,2,20);
        grafo.addEdge(3,4,60);

        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm();

        dijkstra.printGraph(grafo);

        Object[] dijkstraArray = dijkstra.dijkstra(grafo, 4);

        for (int i = 0; i < dijkstraArray.length; i++) {
            System.out.println(dijkstraArray[i]);
        }
    }
}
