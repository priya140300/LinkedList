import java.util.Scanner;
public class Palindrome{
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
        Node middle(){
            Node slow=head;
            Node fast=head;
            while(fast.next!=null && fast.next.next!=null){
                slow=slow.next;
                fast=fast.next.next;
            }
            return slow;
        }
        Node reverse(Node curr){
            Node next;
            Node prev=null;
            while(curr!=null){
                next=curr.next;
                curr.next=prev;
                prev=curr;
                curr=next;
                
            }
            return prev;
        }
        boolean palin(){
            Node mid=middle();
            Node revhead=reverse(mid.next);
            mid.next=revhead;

            Node temp=head;
            while(revhead!=null)   //jb tk second half empty na ho
            {   
                if(revhead.data!=temp.data){
                    return false;
                }
                revhead=revhead.next;
                temp=temp.next;
                
            }
            return true;                   

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
        boolean res=list.palin();
        if(res){
          System.out.println("Its a palindrome");
        }
        else{
            System.out.println("Not a palindrome");
        }
        list.traverse();
        sc.close();
    }
}