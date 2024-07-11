import java.util.Scanner;
public class DeleteLoop {
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
                last=newnode;
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

        void removeLoop(Node slow,Node fast){
           slow=head;
           while(slow.next!=fast.next){
            slow=slow.next;
            fast=fast.next;
           }
           fast.next=null;
        }

        void detect(Node slow,Node fast){
            if(head.next==head){
                head.next=null;
                return;
            }
            if(last.next==head){
              last.next=null;
              return;
            }
            while(fast!=null && fast.next!=null){
                slow=slow.next;
                fast=fast.next.next;
                if(slow== fast){
                    removeLoop(slow,fast);
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
          //list.last.next=list.head;
          list.last.next=list.head.next.next;//custom 
          System.out.println("linkedlist before"+list.last.next.data);
          list.detect(list.head,list.head);
          list.traverse();
          System.out.println();
          System.out.println("linkedlist after "+list.last.next);
          sc.close();
    }
    
}
