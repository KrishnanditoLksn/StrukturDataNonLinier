package Graph;

public class Graph {
    Vertex[] vertexList;//membuat variabel bertipe array of Vertex
    int[][] adjacencyMatrix;//membuat variabel bertipe array 2D of vertex
    int count;//membuat variable count
    int amountVertex;//membuat variabel jumlah vertex

    public Graph(int amountVertex) {//membuat konstruktor graph
        this.vertexList = new Vertex[amountVertex];//membuat array of objek vertex sebanyak jumlah vertex
        this.count = 0;//membuat variable count  untuk menghitung seberapa banyak index
        this.adjacencyMatrix = new int[amountVertex][amountVertex];//membuat array 2d dengan jumlah banyak element sesuai param
        this.amountVertex = amountVertex;//menunjuk variabel ke konstruktor
    }


    public void addVertex(String vertex) {
        if (count < amountVertex) {
            vertexList[count++] = new Vertex(vertex);
        } else {
            throw new ArrayIndexOutOfBoundsException("Out of bound of array");
        }
    }

    public void addEdge(int startIndex, int finishIndex) {
        if (startIndex < amountVertex && finishIndex < amountVertex) { // Periksa apakah indeks dalam rentang yang benar
            adjacencyMatrix[startIndex][finishIndex] = 1;
            adjacencyMatrix[finishIndex][startIndex] = 1;
        } else {
            throw new ArrayIndexOutOfBoundsException("Out of bounds of array ");
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