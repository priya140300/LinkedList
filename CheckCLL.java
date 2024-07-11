import java.util.Scanner;
public class CheckCLL{
    static class Node{
        int data;
        Node next;
        Node(int val){
            data =val;
        }
    }

    static class LinkedList{
        Node head;
        void insert(int data){
            Node newnode=new Node(data);
            if(head == null){
                head =newnode;
            }
            else{
                Node temp =head;
                while(temp.next!=null){
                    temp=temp.next;
                }
                temp.next=newnode;
            }
        }
        void findLast(){
            Node temp =head;
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=head;
        }
        void check(){
            Node temp =head;
            //empty list is also a circular linked list
            if(head == null){
                System.out.println("ITs a CLL");
                return;
            }
            while(temp!=null && temp.next!=head){
                temp=temp.next;
            }
            if(temp==null){
                System.out.println("ITs not a CLL");
            }
            else{
                System.out.println("ITs a CLL");
            }
        }
        void traverse(){
            Node temp= head;
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
        LinkedList list =new LinkedList();
        int n =sc.nextInt();
        for(int i=0;i<n;i++){
            list.insert(sc.nextInt());
        }
        //list.findLast();//remove comment to see its a cll
        list.check();
        list.traverse();
        sc.close();
    }
}