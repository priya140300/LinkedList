import java.util.Scanner;

public class InsertDll {
    static class Node{
        int data;
        Node prev;
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
                while(temp.next!=null){
                    temp=temp.next;
                }
                temp.next=newnode;
                newnode.prev=temp;
            }
        }
   void insertBegin(int data){
    Node newnode=new Node(data);
    head.prev=newnode;
    newnode.next =head;
    head = newnode;
   }
        void traverse(){
            Node temp=head;
            while (temp!=null) {
                System.out.print(temp.data);
                if(temp.next!=null){
                    System.out.print("|->");
                    System.out.print("<-|");
                }
                temp=temp.next;
                
            }
        }

    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        LinkedList list =new LinkedList();
        System.out.println("enter the length of doubly ll");
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            list.insert(sc.nextInt());
        }
        System.out.println("before insertion");
        list.traverse();
        System.out.println("enter the node you want to insert beginning");
        list.insertBegin(sc.nextInt());
        System.out.println("after insertion");

        list.traverse();
        sc.close();
    }
}
