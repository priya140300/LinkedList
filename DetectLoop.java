import java.util.Scanner;
public class DetectLoop{
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
        boolean detect(){
            if(head.next==head){
                return true;
            }
            Node slow=head;
            Node fast=head;
            if(head== null){
                return false;
            }
            while(fast!=null && fast.next!=null){
                slow=slow.next;
                fast=fast.next.next;
                if(slow==fast){
                  
                    return true;
                }
            }
            return false;

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
        list.last.next=list.head.next;
        
       boolean res=list.detect();
       if(res){
        System.out.println("its a loop");
       }
       else{
        System.out.println("its not a loop");
       }
       // list.traverse();
        sc.close();
    }
}