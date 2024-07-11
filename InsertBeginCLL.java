import java.util.Scanner;
public class InsertBeginCLL {
    static class Node{
        int data;
        Node next;
        Node(int val){
            data = val;
        }
    }

    static class LinkedList{
        Node head;
        void insert(int data){
            Node newnode=new Node(data);
            if(head == null){
                head = newnode;
            }
            else{
                Node temp = head;
                while(temp.next!=null){
                    temp=temp.next;
                }
                temp.next=newnode;
            }
        }
        Node findTail(){
            Node temp =head;
            while(temp.next!=null){
                temp = temp.next;
            }
            return temp;
        }
        void insertBegin(int data){
            Node newnode =new Node(data);
           
            newnode.next=head;
            head=newnode;
            
        }
        void traverse(){
            Node temp = head;
           if(head == null){
            return;
           }
           do{
            System.out.print(temp.data);
            if(temp.next!=head){
                System.out.print("->");
            }
            temp=temp.next;
           }
           while(temp!=head);

           
        }
    }
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        LinkedList list =new LinkedList();
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            list.insert(sc.nextInt());
        }
        Node tail =list.findTail();
        tail.next=list.head;
        System.out.println("before insertion");
        list.traverse();
        System.out.println("enter data to be inserted");
        list.insertBegin(sc.nextInt());
        tail.next=list.head;
        System.out.println("after insertion");
        list.traverse();
        
        sc.close();

    }
}
