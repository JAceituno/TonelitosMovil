package tonelitosmovil;

public class Node {
    
    private Object value;
    private Node next;
    private int ID;
    private List aristas = new List();
    private long DijkstraNum = Integer.MAX_VALUE;
    private List DijkstraPath = new List();

    public Node(Object value) {
        this.value = value;
    }

    public Node() {
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return ""+value;
    }
    public boolean hasNext(){
        if(next != null)
            return true;
        return false;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public List getAristas() {
        return aristas;
    }

    public void setAristas(List relations) {
        this.aristas = relations;
    }    
    
    public long getDijkstraNum() {
        return DijkstraNum;
    }

    public void setDijkstraNum(long DijkstraNum) {
        this.DijkstraNum = DijkstraNum;
    }
    
    public List getDijkstraPath(){
        return DijkstraPath;
    }
    
    public void setDijkstraPath(List DijkstraPath){
        this.DijkstraPath = DijkstraPath;
    }
    
    public void addToPath(Arista edge){
        DijkstraPath.push_back(edge);
    }
    
    
    
}
