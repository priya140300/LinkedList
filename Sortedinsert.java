import java.util.Scanner;

public class Sortedinsert{
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
            if(head ==null){
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
        void sortedInsert(int data){
            Node newnode=new Node(data);
            if(head == null){
                  head=newnode;
                  return;
            }
            Node prev=head;
            if(prev.data >newnode.data){
                newnode.next=prev;
                head=newnode;
                return;
            }
            while(prev.next!=null && prev.next.data<newnode.data){
                prev=prev.next;

            }
            Node curr=prev.next;
            prev.next=newnode;
            newnode.next=curr;
           

        }
        void traverse(){
            Node temp=head;
            System.out.println("linked list looks like ");
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
        list.sortedInsert(sc.nextInt());
        list.traverse();
        sc.close();

    }
}