package Graph;

public class Graph {

    Vertex[] vertexList;
    int[][] adjacencyMatrix;
    int count;
    int amountVertex;

    public Graph(int amountVertex) {
        this.vertexList = new Vertex[amountVertex];
        this.count = 0;
        this.adjacencyMatrix = new int[amountVertex][amountVertex];
        this.amountVertex = amountVertex;
    }


    public void addVertex(String vertex) {
        if (count < amountVertex) {
            vertexList[count++] = new Vertex(vertex);

        } else {
            System.out.println("This vertex is full" + amountVertex);
        }
    }

    public void addEdge(int startIndex, int finishIndex) {
        if (startIndex < amountVertex && finishIndex < amountVertex) { // Periksa apakah indeks dalam rentang yang benar
            adjacencyMatrix[startIndex][finishIndex] = 1;
            adjacencyMatrix[finishIndex][startIndex] = 1;
        } else {
            System.out.println("Invalid vertex index");
        }
    }

    public int getCount() {
        return count;
    }

    public void displayVertex(int index) {
        if (index < amountVertex) {
            System.out.println("Vertex  dengan label " + vertexList[index].getLabel());
        } else {
            System.out.println("Invalid vertex index");
        }
    }

    public void showMatrix() {
        for (int i = 0; i < amountVertex; i++) {
            System.out.println();
            for (int j = 0; j < amountVertex; j++) {
                System.out.print(adjacencyMatrix[i][j] + "  ");
            }
        }
    }
}