import  java.util.Scanner;
public class CDLL{
    static class Node{
        int data;
        Node next;
        Node prev;
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
                Node temp =head;
                while(temp.next!=null){
                    temp=temp.next;
                }
                temp.next=newnode;
                newnode.prev=temp;
            }
        }
        void findTail(){
            Node temp =head;
            while (temp.next!=null) {
                temp=temp.next;
            }
            temp.next=head;
            head.prev=temp;
        }
        void traverse(){
            Node temp =head;
            do{
                System.out.print(temp.data);
                if(temp.next!=head){
                    System.out.print("<->");
                }
                temp=temp.next;
            }
            while(temp!=head);
        }
    }
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        LinkedList list =new LinkedList();
        System.out.println("enter the length of linkedlist");
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            list.insert(sc.nextInt());
        }
        list.findTail();
        list.traverse();
        sc.close();
    }
}