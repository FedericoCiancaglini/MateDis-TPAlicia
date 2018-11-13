import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Florencia Vimberg
 */
public class Main {
    private static List<GrafoDirigidoPonderado> graphs = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       printOptions();
       int option = scanner.nextInt();

        while (option != 0) {
            switch (option){
                case 1:
                    createGraph(scanner);
                    printOptions();
                    option = scanner.nextInt();
                    break;
                case 2:
                    createRandomGraph(scanner);
                    printOptions();
                    option = scanner.nextInt();
                    break;
                case 3:
                    printGraph();
                    printOptions();
                    option = scanner.nextInt();
                    break;
                default:
                    System.out.println("Sorry! that's not an option please try again");
                    printOptions();
                    option = scanner.nextInt();
            }
        }


    }

    private static  void createGraph(Scanner scanner){
        System.out.println("ENTER THE AMOUNT OF VERTEX FOR THE GRAPH:");
        int capacity = scanner.nextInt();
        GrafoDirigidoPonderado grafo = new GrafoDirigidoPonderado();
        List<Integer> vertexValues = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            System.out.println("Add vertex value: ");
            int vertexValue = scanner.nextInt();
            vertexValues.add(vertexValue);
            grafo.addVertex(vertexValue);
        }

        System.out.println("ENTER THE AMOUNT OF EDGES FOR THE GRAPH: ");
        int amtEdges = scanner.nextInt();

        for (int i = 0; i < amtEdges; i++) {
            System.out.println("Add from where the edge starts: ");
            int from = scanner.nextInt();
            System.out.println("Add where the edge finishes: ");
            int to = scanner.nextInt();
            if (!vertexValues.contains(from) || !vertexValues.contains(to) ){
                System.out.println("Sorry you wrote a vertex that doesn't exists");
                break;
            }
            System.out.println("Add edge value: ");
            int value = scanner.nextInt();
            grafo.addEdge(from, to, value);
        }

        graphs.add(grafo);
    }

    private static void createRandomGraph(Scanner scanner) {
        System.out.println("Enter the amount of vertex for the random graph: ");
        int capacity = scanner.nextInt();

        System.out.println("Enter the amount of edges for the random graph: ");
        int amtEdges = scanner.nextInt();

        GrafoDirigidoPonderado grafo = new GrafoDirigidoPonderado();

        Random randomVertex = new Random();
        List<Integer> vertexValues = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            int vertexValue = randomVertex.nextInt(1000);
            vertexValues.add(vertexValue);
            grafo.addVertex(vertexValue);
        }

        Random randomEdge = new Random(capacity);
        for (int i = 0; i < amtEdges; i++) {
            int from = randomEdge.nextInt(vertexValues.size());
            int to = randomEdge.nextInt(vertexValues.size());
            while (from == to){
                to = randomEdge.nextInt(vertexValues.size());
            }
            int value = randomVertex.nextInt(1000);
            grafo.addEdge((int)grafo.getVertexes().get(from), (int)grafo.getVertexes().get(to), value);
        }

        graphs.add(grafo);
        System.out.println("\nGraph created");
    }


    private static void printGraph() {
        for (int k = 0; k < graphs.size(); k++) {
            System.out.println("Graph number " + k);
            GrafoDirigidoPonderado graph = graphs.get(k);

            for (int i = 0; i < graph.getVertexes().size(); i++) {
                if(graph.getAdyList(graph.getVertexes().get(i)).size() > 0){
                    for (int j = 0; j < graph.getAdyList(graph.getVertexes().get(i)).size(); j++) {
                        System.out.println(graph.getVertexes().get(i) + " ---> "+ ((EdgeDirigidoPonderado) graph.getAdyList(graph.getVertexes().get(i)).get(j)).getTo() +
                                " value {" + ((EdgeDirigidoPonderado) graph.getAdyList(graph.getVertexes().get(i)).get(j)).getValue() + "}");
                    }
                } else {
                    System.out.println(graph.getVertexes().get(i));
                }
            }
        }

    }

    private static void printOptions(){
        System.out.println("         \nCONTROL PANEL \n" +
                "0. Exit program\n" +
                "1. Create new graph\n" +
                "2. Create random graph\n" +
                "3. Print graphs\n" +
                "Please enter an option: ");
    }
}
