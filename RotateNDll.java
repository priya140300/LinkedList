import java.util.Scanner;
public class RotateNDll {
     static class Node{
        int data;
        Node next;
        Node prev;
        Node(int val){
            data= val;
        }
     }  

     static class LinkedList{
        Node head;
        void insert(int data){
            Node newnode =new Node(data);
            if(head == null){
                head =newnode;
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
         void rotate(int n,int size){
            if(head == null || n==size){
                System.out.println("No rotation");
                return;
            }
           
            Node temp=head;
            Node prev=null;
            while(n>0){
                prev=head;
                head=head.next;
                n--;
            }
            prev.next=null;
            head.prev=null;
            Node tail = findTail();
            tail.next=temp;
            temp.prev=tail;
            

         }
         Node findTail(){
            Node temp =head;
            while(temp.next!=null){
                temp=temp.next;
            }
            return temp;
         }
        void traverse(){
            Node temp =head;
            while(temp!=null){
                System.out.print(temp.data);
                if(temp.next!=null){
                    System.out.print("<->");
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
        System.out.println("before rotation");
        list.traverse();
        System.out.println();
        System.out.println("enter by how many nodes you want to rotate it");
        list.rotate(sc.nextInt(),n);
        System.out.println();
        System.out.println("after rotation");
        list.traverse();
        sc.close();
     }
}
