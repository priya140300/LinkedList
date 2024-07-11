import java.util.Scanner;
public class Sortzot{
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
        Node sort012(){
            Node temp=head;
            Node dummyzero=new Node(-1);
            Node temp0=dummyzero;
            Node dummyone=new Node(-1);
            Node temp1=dummyone;
            Node dummytwo=new Node(-1);
            Node temp2=dummytwo;
            while(temp!=null){
                if(temp.data == 0){
                    temp0.next=temp;
                    temp0=temp;
                }
                else if(temp.data == 1){
                    temp1.next=temp;
                    temp1=temp;
                }
                else{
                    temp2.next=temp;
                    temp2=temp;
                }
                temp=temp.next;
            }
            temp0.next=dummyone.next;
            temp1.next=dummytwo.next;
            temp2.next=null;
            return dummyzero.next;
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
        LinkedList list=new LinkedList();
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            list.insert(sc.nextInt());
        }
        list.head=list.sort012();
        list.traverse();
        sc.close();

    }
}