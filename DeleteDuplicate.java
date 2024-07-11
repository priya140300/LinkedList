import java.util.*;
public class DeleteDuplicate{
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
            if(head== null){
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

        
        void duplicate(){
            Node temp=head;
            if(head == null){
                return;
            }
            while(temp!=null && temp.next!=null){
                if(temp.data ==temp.next.data){
                    temp.next=temp.next.next;
                }
                else{
                    temp=temp.next;
                }
            }
        }
        void traverse(){
            Node temp=head;
            while(temp!=null){
                System.out.print(temp.data);
                if(temp.next!=null){
                    System.out.print("->");
                }
                temp=temp.next;
            }
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        LinkedList list =new LinkedList();
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            list.insert(sc.nextInt());
        }
        list.duplicate();
        list.traverse();
        sc.close();

    }
}