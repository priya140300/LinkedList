import java.util.Scanner;
public class Nthnode{
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

        void nthNode(int n){

               if(head == null){
                return;
            }
           
            Node slow=head;
            Node fast=head;
            //fast ko n nodes ahead move kra rhe
            while(n>0){
                if(fast == null){
                    return;
                }
                fast=fast.next;
                n--;
            }
            while(fast!=null){
                fast=fast.next;
                slow=slow.next;
            }
            System.out.println("the nth node from end is "+slow.data);
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
        list.nthNode(sc.nextInt());
       // list.traverse();
        sc.close();
    }
}