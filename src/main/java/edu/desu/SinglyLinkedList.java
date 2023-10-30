package edu.desu;

public class SinglyLinkedList<T> {

    private Node<T> headNode;

    public SinglyLinkedList(){
    }

    public void insertAtHead(T data){
        Node<T> previousNode = headNode;
        Node<T> node = new Node<>(data);
        node.setNextNode(previousNode);
        this.headNode = node;
    }

    public Boolean isEmpty(){
        return (headNode == null);
    }

    public Boolean insertAfter(T previous, T data){
        Node<T> currentNode = headNode;
        while(currentNode  != null){
            // Compare the two values of current node and previous
            T currentValue = currentNode.getData();
            // if the values are equal
            if(currentValue.equals(previous)) {

                // create a new node and place data in it
                Node<T> newNode = new Node<>(data);
                // new nodes next node equal to current nodes next node
                newNode.setNextNode(currentNode.getNextNode());
                // current nodes next node equal to new node
                currentNode.setNextNode(newNode);
                return true;
            }
            Node<T> nextNode = currentNode.getNextNode();
            currentNode = nextNode;
        }
        return false;
    }


    public void insertAtEnd(T data){
        if(headNode == null){
           insertAtHead(data);
           return;
        }
        Node<T> currentNode = headNode;
        while(currentNode.hasNext()){
            Node<T> nextNode = currentNode.getNextNode();
            currentNode = nextNode;
        }
        currentNode.setNextNode(new Node<>(data));
    }

    public String toString(){
        String data = "";
        Node<T> node = headNode;
        while(node != null){
            data += node.getData().toString();
            if(node.hasNext()){
                data += ",";
            }
            node = node.getNextNode();
        }
        return data;
    }
}
