import java.util.Scanner;
public class LengthOfLoop{
    static class Node{
        int data;
        Node next;
        Node(int val){
            data=val;

        }
    }
    static class LinkedList{
        Node head;
        Node last;
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
                last=newnode;
             }
            
        }
        void length(Node slow,Node fast){
            int count=1;
            slow=slow.next;
            while(slow!=fast){
                count++;
                slow=slow.next;
            }
            System.out.println("length is"+count);
        }
         void detect(){
            if(head.next==head){
                System.out.println("length is 1");
                return;
            }
            Node slow=head;
            Node fast=head;
            if(head== null){
                System.out.println("length is 0");
                return;
            }
            while(fast!=null && fast.next!=null){
                slow=slow.next;
                fast=fast.next.next;
                if(slow==fast){
                    
                    length(slow,fast);
                    return;
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
        LinkedList list=new LinkedList();
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            list.insert(sc.nextInt());
        }
        list.last.next=list.head;
        //list.last.next=list.head.next.next;
        
        list.detect();
        //list.traverse();
        sc.close();
    }
}