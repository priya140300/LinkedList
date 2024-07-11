import java.util.Scanner;
public class InsertEndCll {
    static class Node{
        int data;
        Node next;
        Node(int val){
            data=val;
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
                Node temp=head;
                while (temp.next!=null) {
                    temp=temp.next;
                    
                }
                temp.next=newnode;
            }
        }
        Node findTail(){
            Node temp = head;
           
            while(temp.next!=head){
                temp=temp.next;
            }
            return temp;


        }
        void insertEnd(int data){
            Node newnode =new Node(data);
            Node tail = findTail();
            tail.next=newnode;
            newnode.next=head;
        }
        void traverse(){
            Node temp =head;
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
        Scanner sc=new Scanner(System.in);
        LinkedList list = new LinkedList();
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            list.insert(sc.nextInt());
        }
        Node curr =list.head;
        while(curr.next!=null){
            curr=curr.next;
        }
        curr.next=list.head;

       
        System.out.println("before insertion");
        list.traverse();
        System.out.println("enter the data you need to add");
        list.insertEnd(sc.nextInt());
        System.out.println("after insertion");
        list.traverse();
        sc.close();

    }
}
