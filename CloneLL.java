import java.util.Scanner;
public class CloneLL{
    static class Node{
    int data;
    Node next;
    Node random;
    Node(int val){
        data=val;
    }
 }

    static class LinkedList{
        Node head;
        void insert(int data){
            Node newnode =new Node(data);
            if(head == null){
                head=newnode;
               
            }
            else{
                Node temp=head;
                while(temp.next!=null){
                    temp=temp.next;
                }
                temp.next=newnode;
            }
        }
         
        //Method to insert copies of the nodes
        void insertCopy(){
            Node temp=head;
            while(temp!=null){
                Node copyNode=new Node(temp.data);
                copyNode.next=temp.next;
                temp.next=copyNode;
                temp=temp.next.next;
            }
        }
        // Method to connect the random pointers in the copied nodes
        void randomConnect(){
            Node temp=head;
            while(temp!=null){
                Node copyNode=temp.next;
                if(temp.random!=null){
                    copyNode.random=temp.random.next;
                }
                else{
                    copyNode.random=null;
                }
                temp=temp.next.next;
            }
        }
        // Method to extract the deep copy of the list
        Node deepCopy(){
            Node dummy=new Node(-1);
            Node curr=dummy;
            Node temp=head;
            while(temp!=null){
                curr.next=temp.next;
                temp.next=temp.next.next;
                curr=curr.next;
                temp=temp.next;
            }
            return dummy.next;
            
        }
          // Method to clone the linked list
         void cloneLL(){
             insertCopy();
             randomConnect();
             Node head2=deepCopy();
             traverse(head2);
         }

        void traverse(Node head){
            Node temp=head;
            while(temp!=null){
                System.out.print(temp.data);
                if(temp.random !=null){
                    System.out.print(":"+temp.random.data);
                }
                if(temp.next!=null){
                    System.out.print("->");
                }
                temp=temp.next;
            }
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        LinkedList list=new LinkedList();
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            list.insert(sc.nextInt());
        }
        Node temp=list.head;
        Node temp2=list.head;
        
         // Manually setting up the random pointers for 5 sized linkedlist
        temp.random=null;
        temp.next.random=temp;
        temp.next.next.random=temp.next.next.next.next;
        temp.next.next.next.random=temp2.next.next;
        temp.next.next.next.next.random=temp2;

        System.out.println("this is Cloned Linked List");
        list.cloneLL();
        System.out.println();
        System.out.println("this is Original Linked List");
        list.traverse(list.head);
        sc.close();


    }
}
//SC:O(N)->REQUIREMENT OF PROBLEM