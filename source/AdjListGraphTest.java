public class AdjListGraphTest {
    public static void main(String[] args) {
        AdjListGraph<String> airlineGraph = new AdjListGraph<String>();

        buildGraph(airlineGraph);
        System.out.println(airlineGraph);

        testEdges(airlineGraph);
        System.out.println();

        testDFS(airlineGraph);

        System.out.println("Adjacency List:");
        System.out.println(airlineGraph.getAdjacencyList().values());

        System.out.println("DFS");
        System.out.println(airlineGraph.getDFSPath("DFW", "MIA"));
    }

    public static void testEdges(AdjListGraph<String> g) {
        System.out.println("Edge between JFK and SFO? " + g.hasEdge("JFK", "SFO"));
        System.out.println("Edge between JFK and SFO: " + g.getEdge("JFK", "SFO"));

        System.out.println("Edge between MIA and LAX? " + g.hasEdge("MIA", "LAX"));
        System.out.println("Edge between MIA and LAX: " + g.getEdge("MIA", "LAX"));

        System.out.println("Edge between MIA and ORD? " + g.hasEdge("MIA", "ORD"));
        System.out.println("Edge between MIA and ORD: " + g.getEdge("MIA", "ORD"));

        System.out.println("Edge between SFO and DFW? " + g.hasEdge("SFO", "DFW"));
        System.out.println("Edge between SFO and DFW: " + g.getEdge("SFO", "DFW"));
    }

    public static void testDFS(AdjListGraph<String> g) {
        System.out.println("Path between BOS and LAX? " + g.hasPath("BOS", "LAX"));
        System.out.println("Edge between BOS and LAX: " + g.getDFSPath("BOS", "LAX"));

        System.out.println("Path between ORD and LAX? " + g.hasPath("ORD", "LAX"));
        System.out.println("Edge between ORD and LAX: " + g.getDFSPath("ORD", "LAX"));

        System.out.println("Path between SFO and LAX? " + g.hasPath("SFO", "LAX"));
        System.out.println("Edge between SFO and LAX: " + g.getDFSPath("SFO", "LAX"));
    }

    public static void buildGraph(AdjListGraph<String> g) {
        g.addVertex("LAX");
        g.addVertex("SFO");
        g.addVertex("DFW");
        g.addVertex("ORD");
        g.addVertex("MIA");
        g.addVertex("JFK");
        g.addVertex("BOS");

        g.addEdge("LAX", "ORD", 1500);
        g.addEdge("DFW", "LAX", 800);
        g.addEdge("DFW", "ORD", 600);
        g.addEdge("DFW", "SFO", 1100);
        g.addEdge("DFW", "JFK", 950);
        g.addEdge("ORD", "MIA", 700);
        g.addEdge("MIA", "DFW", 1200);
        g.addEdge("MIA", "LAX", 2800);
        g.addEdge("JFK", "MIA", 1300);
        g.addEdge("JFK", "SFO", 3600);
        g.addEdge("JFK", "BOS", 300);
        g.addEdge("BOS", "JFK", 300);
        g.addEdge("BOS", "MIA", 1500);
    }
}