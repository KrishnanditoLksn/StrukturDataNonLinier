package Graph.MST_Path;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');
        graph.addVertex('F');

        for (int i = 0; i < graph.verticesList.length; i++) {
            graph.displayVertex(i);
        }


        graph.addEdges('E', 'F', 15);
        graph.addEdges('E', 'D', 15);
        graph.addEdges('F', 'D', 10);
        graph.addEdges('A', 'F', 10);
        graph.addEdges('A', 'D', 100);
        graph.addEdges('A', 'C', 30);
        graph.addEdges('A', 'B', 50);
        graph.addEdges('D', 'B', 20);
        graph.addEdges('D', 'C', 50);
        graph.addEdges('C', 'B', 5);


        graph.dijkstraShortestPath("A","F");
    }

}
