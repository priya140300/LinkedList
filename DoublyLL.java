import java.util.Scanner;
public class DoublyLL{
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
        list.traverse();
        sc.close();
    }
}