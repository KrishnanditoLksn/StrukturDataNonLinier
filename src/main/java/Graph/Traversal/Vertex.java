package Graph.Traversal;


public class Vertex {//buat kelas vertex
    String label;//declare variabel label
    boolean flagVisited;

    public Vertex(String value) {
        this.label = value;
    }

    public boolean getFlagVisited() {//mendapatkan nilai flag visited bernilai false
        return !flagVisited;
    }

    public void setFlagVisited(boolean flagVisited) {//mengeset flag visited
        this.flagVisited = flagVisited;
    }

    public String getLabel() {//buat method getlabel
        return label;//mereturn label
    }
}
