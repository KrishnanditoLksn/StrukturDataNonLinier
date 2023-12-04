package Graph.MST_Path;

public class Vertex {
    char label;

    boolean flagVisited;
    String labels;

    public Vertex(char label) {
        this.label = label;
    }

    public Vertex(String label) {
        this.labels = label;
    }

    public String getLabels() {
        return labels;
    }

    public void setLabels(String labels) {
        this.labels = labels;
    }

    public char getLabel() {
        return label;
    }

    public boolean isVisited() {
        return this.flagVisited;
    }

    public boolean getFlagVisited() {
        return !flagVisited;
    }

    public void setFlagVisited(boolean flagVisited) {
        this.flagVisited = flagVisited;
    }
}
