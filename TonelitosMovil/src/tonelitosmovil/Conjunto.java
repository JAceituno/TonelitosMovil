/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tonelitosmovil;

/**
 *
 * @author rick
 */
///////////////////////NO USAR TODAVIA
public class Conjunto {

    private Node head;

    public Conjunto(Node head) {
        this.head = head;
    }

    public Conjunto() {
        head = null;
    }

    public Conjunto(Object value) {
       this.head = new Node(value);
    }
    
    public Conjunto(Conjunto nuevo){
        head = new Node(nuevo.memberAt(0));
        Node temp = head;
        
        if(nuevo.size()>1){
            for (int i = 1; i < nuevo.size(); i++) {
                temp = temp.getNext();
                temp.setNext(new Node(nuevo.memberAt(i))); 
                
            }
        }
            
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }
    
    public Conjunto union(Conjunto B){ //union de dos conjuntos
        Conjunto nuevo = new Conjunto(this);
        List hasNumbers = new List(false);
        Node tempNumbers = hasNumbers.elementAt(0);
        
        if (B.size()>1){
            for (int i = 0; i < B.size(); i++) {
                tempNumbers.setNext(new Node (false));
                tempNumbers = tempNumbers.getNext();
                
            }
            
        }
        
        for (int i = 0; i < B.size(); i++) {
            for (int j = 0; j < size(); j++) {
                if (B.memberAt(i) == this.memberAt(j)){
                    hasNumbers.elementAt(i).setValue(true);
                    break;
                }
            }
        }
        
        for (int i = 0; i < B.size(); i++) {
            if ((boolean)hasNumbers.elementAt(i).getValue()){
                tempNumbers.setNext(new Node(B.memberAt(i)));
                tempNumbers = tempNumbers.getNext();
            }
        }
        return nuevo;
        
    }
    
    public Conjunto intersection(Conjunto B){ //elementos en comun de los conjuntos
        Conjunto nuevo = new Conjunto();
        List hasNumbers = new List(false);
        Node temp = hasNumbers.elementAt(0);
        
        if (size()<B.size()){
            
            for (int i = 1; i < B.size(); i++) {
                temp.setNext(new Node(false));
                temp = temp.getNext();
            }
            
            for (int i = 0; i < B.size(); i++) {
                for (int j = 0; j < size(); j++) {
                    if (B.memberAt(i) == this.memberAt(j)){
                        hasNumbers.elementAt(i).setValue(true);
                        break;
                    }
                }
            }
            
            for (int i = 0; i < B.size(); i++) {
                if ((boolean)hasNumbers.elementAt(i).getValue()){
                    nuevo.insert(size()-1,B.memberAt(i));
                }
            }
        }else{
            
            for (int i = 1; i < size(); i++) {
                temp.setNext(new Node (false));
                temp = temp.getNext();
            }
            
            
            for (int i = 0; i < size(); i++) {
                for (int j = 0; j < B.size(); j++) {
                    if (B.memberAt(i) == this.memberAt(j)){
                        hasNumbers.elementAt(i).setValue(true);
                        break;
                    }
                }
            }
            
            for (int i = 0; i < size(); i++) {
                if ((boolean)hasNumbers.elementAt(i).getValue()){
                    nuevo.insert(size()-1,memberAt(i));
                }
            }
        }
        
        return nuevo;
        
    }
    
    public Conjunto difference(Conjunto B){ //elementos diferentes de os conjuntos
        Conjunto nuevo = new Conjunto();
        List hasNumbers = new List(false);
        Node temp = hasNumbers.elementAt(0);
        
        if (size()<B.size()){
            
            for (int i = 1; i < B.size(); i++) {
                temp.setNext(new Node(false));
                temp = temp.getNext();
            }
            
            for (int i = 0; i < B.size(); i++) {
                for (int j = 0; j < size(); j++) {
                    if (B.memberAt(i) == this.memberAt(j)){
                        hasNumbers.elementAt(i).setValue(true);
                        break;
                    }
                }
            }
            
            for (int i = 0; i < B.size(); i++) {
                if (!(boolean)hasNumbers.elementAt(i).getValue()){
                    nuevo.insert(size()-1,B.memberAt(i));
                }
            }
        }else{
            
            for (int i = 1; i < size(); i++) {
                temp.setNext(new Node (false));
                temp = temp.getNext();
            }
            
            
            for (int i = 0; i < size(); i++) {
                for (int j = 0; j < B.size(); j++) {
                    if (B.memberAt(i) == this.memberAt(j)){
                        hasNumbers.elementAt(i).setValue(true);
                        break;
                    }
                }
            }
            
            for (int i = 0; i < size(); i++) {
                if (!(boolean)hasNumbers.elementAt(i).getValue()){
                    nuevo.insert(size()-1,memberAt(i));
                }
            }
        }
        
        return nuevo;
    }
    
    public Node memberAt(int pos){
        Node member= null;
        
        if (size()-1<pos || pos < size()-1){
            System.err.println("Index out of bounds");
        }else{
            Node temp = head;
            for (int i = 0; i < pos; i++) {
                temp = temp.getNext();
                member =  temp;
            }
        }
        
        
        return member;
        
    }
    
    public void insert(int posicion,Node valor) {
        
        if(posicion > 0){
            if(!head.hasNext()){
                if(posicion == 1){
                    head.setNext(new Node(valor));
                }
                else if(posicion > 1){
                    System.err.println("Index out of bounds");
                }
                else{
                    Node temp = head;
                    head.setValue(valor);
                    head.setNext(temp);
                }
            }
            else{
                Node temp = head;
                int cont = 0;
                if(size() >= posicion){
                    while(cont < posicion-1){
                        temp = temp.getNext();
                        cont++;
                    }
                    Node nuevo = new Node(valor);
                    if(temp.hasNext()){
                        Node temp2 = temp.getNext();
                        nuevo.setNext(temp2);                        
                    }
                    temp.setNext(nuevo);
                }
            }
        }
        else if(posicion == 0){
            if(head != null){
                Node temp = head;
                setHead(new Node(valor));
                head.setNext(temp);
            }
            else{
                setHead(new Node(valor));
            }
        }
        else{
            System.err.println("Invalid position");
        }
        
        sort();
        
        
    }
    
    public void remove(int x){
        
        Node temp = head;
        
        if (x==0){
         head = head.getNext();
        }
        if (x> size()-1 || x<size()-1){
            System.err.println("Index out of Bounds");
        }else{
            for (int i = 0; i < x; i++) {
                temp = temp.getNext();
            }
            temp.setNext(temp.getNext().getNext());
            
        }
        
    }
    
    public int min(){
        int minValue=(int)head.getValue();
        Node temp = head;
        
        for (int i = 0; i < size(); i++) {
            if (minValue > (int)temp.getValue()){
                minValue = (int)temp.getValue();
            }
            if(temp.hasNext()){
                temp = temp.getNext();
            }else{
                break;
            }
        }
        
        return minValue;
    }
    
    public int max(){
        Node temp = head;
        int maxValue = (int)temp.getValue();
        
        for (int i = 0; i < size(); i++) {
            if (maxValue < (int)temp.getValue()){
                maxValue = (int)temp.getValue();
            }
            if(temp.hasNext()){
                temp = temp.getNext();
            }else{
                break;
            }
        }
        
        return maxValue;
    }
    
    public int size(){
        
        int contador=0;
        if (head == null){
            return 0;
        }else{
            contador++;
        }
        Node temp = head;
        while(temp.hasNext()){
            contador++;
            temp = temp.getNext();
        }
        return contador;
        
    }
    
    public boolean equal(Conjunto B){
        if (B.size()!= size()){
            return false;
        }else{
            int numTemp;
            List hasNumbers = new List();
        
            for (int i = 0; i < size(); i++) {
                numTemp = (int)this.memberAt(i).getValue();
                hasNumbers.insert(i, false);
                for (int j = 0; j < B.size(); j++) {
                    if(numTemp == (int)B.memberAt(j).getValue()){
                        hasNumbers.elementAt(i).setValue(true);
                        break;
                    }
                }
            }
            
            for (int i = 0; i < hasNumbers.size(); i++) {
                if (!(boolean)hasNumbers.elementAt(i).getValue()){
                    return false;
                }
            }
            
            return true;
    
        }
        
       
    }
    
    public Node elementAt(int posicion){
        int contador = 0;
	Node temp = head;
        if(size() > posicion){
            if(posicion == 0){
                return head;
            }
            while(contador < posicion){
                temp = temp.getNext();
                contador++;
            }
            return temp;
        }
	return new Node();
    }
    
    public void sort (){
        List temp = new List();
        temp.push_back(head);
        int min;
        String TempJ;
        String TempI;
        
        if (size()>1){
            for (int i = 0; i < temp.size(); i++) {
                min = i;
                for (int j = 0; j < temp.size(); j++) {
                    TempJ = temp.elementAt(j).getValue().toString();
                    TempI = temp.elementAt(i).getValue().toString();
                    if ((Integer.parseInt(TempJ)< (Integer.parseInt(TempI))) && (i<j)){
                        min = j;
                    }

                }
            Node nodeTemp = temp.elementAt(i);
            temp.insert(i, temp.elementAt(min));
            temp.remove(i+1);
            temp.insert(min,nodeTemp);
            temp.remove(min+1);
            
            

            }
        }
        
            
        
    }    
    
    
    
    
    
    
    
    
    
    
    
}
