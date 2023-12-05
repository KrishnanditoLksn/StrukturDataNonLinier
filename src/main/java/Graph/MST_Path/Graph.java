package Graph.MST_Path;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Stack;

public class Graph {
    Vertex[] verticesList;
    int[][] adjacencyMatrix;
    int count;
    int amountVertex;


    public Graph(int amountVertex) {
        this.amountVertex = amountVertex;
        this.count = 0;
        this.verticesList = new Vertex[amountVertex];
        this.adjacencyMatrix = new int[amountVertex][amountVertex];

        for (int i = 0; i < amountVertex; i++) {
            for (int j = 0; j < amountVertex; j++) {
                adjacencyMatrix[i][j] = 0;
            }
        }
    }

    void addVertex(char vertex) {
        if (count < amountVertex) {
            verticesList[count++] = new Vertex(vertex);
        } else {
            System.out.println("Vertex is full !!!");
        }
    }

    void addVertex(String vertex) {
        if (count < amountVertex) {
            verticesList[count++] = new Vertex(vertex);
        } else {
            System.out.println("Vertex is full !!!");
        }
    }

    void addEdges(char row, char column, int weight) {
        int rows = getVertexByIndex(row);
        int columns = getVertexByIndex(column);

        if (rows < amountVertex && columns < amountVertex) {
            adjacencyMatrix[rows][columns] = weight;
        } else {
            System.out.println("Full of edges !! ");
        }
    }

    void addEdges(String source, String destination) {
        int start = getVertexByIndex(source);
        int finish = getVertexByIndex(destination);

        if (start < amountVertex && finish < amountVertex) {
            adjacencyMatrix[start][finish] = 1;
        } else {
            System.out.println("Full of edges");
        }
    }

    int getVertexByIndex(char value) {
        for (int i = 0; i < verticesList.length; i++) {
            //jika salah satu vertex  vertexlist  sama dengan param vertex
            if (verticesList[i].getLabel() == value) {
                return i;
            }
        }
        return -1;
    }

    int getVertexByIndex(String values) {
        for (int i = 0; i < verticesList.length; i++) {
            //jika salah satu vertex  vertexlist  sama dengan param vertex
            if (Objects.equals(verticesList[i].getLabels(), values)) {
                return i;
            }
        }
        return -1;
    }

    void dfsTraversalGraph() {//membuat method untuk traversal dfs
        int visited = 0;
        int helper;

        Stack<Integer> graphStack = new Stack<>();//membuat objek stack
        graphStack.push(visited);//menambah stack awal 0

        while (!graphStack.isEmpty()) {//selama stack tidak kosng
            helper = graphStack.pop();
            if (!verticesList[helper].flagVisited) {//jika flag visited false
                System.out.println(verticesList[helper].getLabel() + " ");//cetak vertex
                verticesList[helper].setFlagVisited(true);//mengeset daftar vertex  ke true jika sudah dilewati
            }
            for (int i = count - 1; i >= 0; i--) {//melakukan iterasi menurun
                if (adjacencyMatrix[helper][i] >= 1 && verticesList[i].getFlagVisited()) {//mereset jika sudah melewati setiap vertex dengan edges yang saling terhubung
                    graphStack.push(i);
                }
            }
        }
    }


    void bfsTraversalGraph() {
        int visited = 0;
        int helper;

        Queue<Integer> graphQueue = new LinkedList<>();
        graphQueue.add(visited);

        while (!graphQueue.isEmpty()) {
            helper = graphQueue.poll();

            if (!verticesList[helper].flagVisited) {
                System.out.println(verticesList[helper].getLabel() + " ");
                verticesList[helper].setFlagVisited(true);
            }

            for (int i = count - 1; i >= 0; i--) {
                if (adjacencyMatrix[helper][i] >= 1 && verticesList[i].getFlagVisited()) {
                    graphQueue.add(i);
                }
            }
        }
    }

    void displayVertex(int index) {//membuat method untuk menampilkan vertex
        if (index < amountVertex) {
            System.out.println("Vertex  dengan label " + verticesList[index].getLabel());
        } else {
            System.out.println("No more vertex ");
        }
    }


    int disjointFindOperation(int[] parent, int vertex) {
        if (parent[vertex] != vertex) {
            return disjointFindOperation(parent, parent[vertex]);
        }
        return vertex;
    }

    void primMinSpanTree() {
        int amountVertices = adjacencyMatrix.length;
        boolean[] visited = new boolean[adjacencyMatrix.length];
        int[] key = new int[adjacencyMatrix.length];
        int[] parent = new int[adjacencyMatrix.length];

        for (int i = 0; i < adjacencyMatrix.length; i++) {
            key[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }//inisiasi vertex 0

        key[0] = 0;
        parent[0] = -1;

        //melakukan perjalanan ke seluruh vertex
        for (int i = 0; i < amountVertices - 1; i++) {
            //tentukan minimum vertex
            int minVertex = getMinimumKey(visited, key);
            //menandari sudah dilewati
            visited[minVertex] = true;

            for (int j = 0; j < amountVertex; j++) {
                if (!visited[j] && adjacencyMatrix[minVertex][j] != 0 && adjacencyMatrix[minVertex][j] < key[j]) {
                    parent[j] = minVertex;
                    key[j] = adjacencyMatrix[minVertex][j];
                }
            }
        }
        printMST(parent);

    }

    private void printMST(int[] parent) {
        int totalWeightCost = 0;

        // Print edges of the MST
        for (int i = 1; i < adjacencyMatrix.length; i++) {
            System.out.println("Bobot terpendek: " + verticesList[parent[i]].getLabel() + " " + verticesList[i].getLabel() + " Adalah: " + adjacencyMatrix[i][parent[i]]);
            totalWeightCost += adjacencyMatrix[i][parent[i]];
        }

        System.out.println("Total Weight Cost: " + totalWeightCost);
    }

    //mendapatkan nilai minimum suatu vertex
    int getMinimumKey(boolean[] vertices, int[] key) {
        int minimumKey = Integer.MAX_VALUE;
        int vertex = -1;
        for (int i = 0; i < key.length; i++) {
            if (!vertices[i] && minimumKey > key[i]) {
                minimumKey = key[i];
                vertex = i;
            }
        }
        return vertex;
    }


    void displayMatrix() {//membuat method untuk menampilkan matrix
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            System.out.printf("%-3s", verticesList[i].getLabel() + " ");
        }

        for (int i = 0; i < adjacencyMatrix.length; i++) {
            System.out.println();
            System.out.print(" " + verticesList[i].getLabel() + " ");
            for (int j = 0; j < amountVertex; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
        }
    }

    public void topologicalSorting() {
        boolean[] visited = new boolean[amountVertex];
        Stack<Integer> stack = new Stack<>();

        // Visit from each node if not already visited
        for (int i = 0; i < amountVertex; i++) {
            if (!visited[i]) {
                topologicalSortUtil(i, visited, stack);
            }
        }

        System.out.println("Topological Sort: ");
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            System.out.print(verticesList[stack.pop()].getLabel() + " ");
        }
    }

    public void topologicalSortUtil(int start, boolean[] visited, Stack<Integer> stack) {
        visited[start] = true;

        for (int i = 0; i < amountVertex; i++) {
            if (adjacencyMatrix[start][i] != 0 && !visited[i]) {
                topologicalSortUtil(i, visited, stack);
            }
        }
        stack.push(start);
    }


    public void dijkstraShortestPath(int startDistance) {
        int[] distance = new int[amountVertex];
        boolean[] visited = new boolean[amountVertex];

        for (int i = 0; i < verticesList.length; i++) {
            distance[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }

        distance[startDistance] = 0;

        for (int i = 0; i < amountVertex - 1; i++) {
            int min = minIndexByDijkstra(distance, visited);
            visited[min] = true;
            for (int j = 0; j < amountVertex; j++) {
                if (!visited[j] && adjacencyMatrix[min][j] != 0 && distance[min] != Integer.MAX_VALUE && distance[min] + adjacencyMatrix[min][j] < distance[j]) {
                    distance[j] = distance[min] + adjacencyMatrix[min][j];
                }
            }
        }
        System.out.println("Rute terpendek  dari  " + verticesList[startDistance].getLabel() + " ");
        System.out.println();
        for (int i = 0; i < amountVertex; i++) {
            System.out.println("Ke Vertex  " + verticesList[i].getLabel() + " dengan indeks " + i + " " + " mempunyai bobot " + distance[i]);
        }
    }

    public int minIndexByDijkstra(int[] distance, boolean[] shortestPath) {
        int min = Integer.MAX_VALUE, minIndex = -1;

        for (int i = 0; i < amountVertex; i++) {
            if (!shortestPath[i] && distance[i] < min) {
                min = distance[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
}
