package Graph.Traversal;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {

    Vertex[] verticesList;//membuat array of vertex
    int[][] adjacencyMatrix;//membuat array 2 dimensi matrix ketetanggaan
    int count;//membuat variabel count
    int amountVertices;//membuat variabel jumlah vertex

    public Graph(int vertex) {//membuat konstruktor
        this.verticesList = new Vertex[vertex];//membuat objek vertex
        this.amountVertices = vertex;
        this.adjacencyMatrix = new int[vertex][vertex];//membuat array 2 d
        this.count = 0;//meinisialisasi count 0

        for (int i = 0; i < vertex; i++) {//melakukan perulangan untuk matrix awal 0
            for (int j = 0; j < vertex; j++) {
                adjacencyMatrix[i][j] = 0;
            }
        }
    }

    void addVertex(String amountVertex) {//membuat method menambah vertex
        if (count < amountVertices) {
            verticesList[count++] = new Vertex(amountVertex);
        } else {
            System.out.println("Vertex full ");
        }
    }

    void addEdges(int row, int column, int weight) {//membuat method untuk menambah edges setiap vertex yang terhubung
        if (row < amountVertices && column < amountVertices) {
            adjacencyMatrix[row][column] = weight;
            adjacencyMatrix[column][row] = weight;
        } else {
            System.out.println("Full of edges");
        }
    }

    void displayMatrix() {//membuat method untuk menampilkan matrix
        for (int i = 0; i < amountVertices; i++) {
            System.out.println();
            System.out.print(" " + verticesList[i].getLabel() + " ");
            for (int j = 0; j < amountVertices; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
        }
    }

    void displayVertex(int index) {//membuat method untuk menampilkan vertex
        if (index < amountVertices) {
            System.out.println("Vertex  dengan label " + verticesList[index].getLabel());
        }
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
}