import java.util.Scanner;
import java.util.HashMap;
public class LRU {
    static class Node{
        int data;
        int key;
        Node prev;
        Node next;
        Node(int keyvalue,int val){
            key=keyvalue;
            data=val;
        }
    }
    int capacity;
    HashMap<Integer,Node> cache = new HashMap<>();
    Node head=null;
    Node tail=null;
    LRU(int c){
        capacity=c;
    }
    int get(int key){
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            moveToHead(node);
            return node.data;
        }
        else{
            return -1;
        }
    }
    void put(int key,int data){
        if(cache.containsKey(key)){
            //node is a reference
          Node node= cache.get(key);
          moveToHead(node);

        }
        else{
             Node newnode =new Node(key,data);
             cache.put(key,newnode);
              addToHead(newnode);
        }
        if(cache.size()>capacity){
            removeTail();
        }
    }
    void moveToHead(Node node){
        removeNode(node);
        addToHead(node);
        node.prev=null;
    }
    void removeNode(Node node){
        if(node.prev!=null){
            node.prev.next=node.next;
        }
        else{
            //moving head node to head 
            head=node.next;
        }
        if(node.next!=null){
            node.next.prev=node.prev;

        }
        else{
            // node.prev.next=null;
            tail=node.prev;
        }
    }
    void addToHead(Node newnode){
        if(head == null){
            head=newnode;
            tail=newnode;
        }
        else{
            newnode.next=head;
            head.prev=newnode;
            head=newnode;
        }
    }
    void removeTail(){
        cache.remove(tail.key);
        if(tail.prev!=null){
            tail.prev.next=null;
            tail=tail.prev;
        }
        else{
            head = null;
            tail=null;
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the capacity of cache");
        LRU lru= new LRU(sc.nextInt());
        while (true) {
            System.out.println("ENTER OPERATION 1:PUT ,2:GET ,3:EXIT");
            int operation = sc.nextInt();

            if(operation == 1){
                System.out.println("Enter key and value to put:");
                int key =sc.nextInt();
                int data=sc.nextInt();
                lru.put(key,data);
                System.out.println("Inserted (" + key + ", " + data + ") into the cache.");

            }
            else if(operation == 2){
                System.out.println("enter key for which you want data");
                int key =sc.nextInt();
                int res = lru.get(key);
                if(res ==-1){
                    System.out.println("Key not found!");
                }
                else{
                    System.out.println(res);
                }
                
            }
            else if(operation == 3){
                break;
            }
            else{
                System.out.println("Invalid operation. Please enter 1, 2, or 3.");
            }
              
        }
        sc.close();
    }
   
    
}
