import java.util.Scanner;
public class StartOfLoop {
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

        void startLoop(Node slow,Node fast){
          slow=head;
          while(slow.next!=fast.next){
            slow=slow.next;
            fast=fast.next;
          }
          System.out.println("this is starting node "+slow.next.data);
    
        }

        void detectLoop(Node slow,Node fast){
            if(head.next == head){
                System.out.println(head.data);
                return;
            }
          if(last.next==head){
            last.next=null;
          }
            
            while(fast!=null && fast.next!=null){
                slow=slow.next;
                fast=fast.next.next;
                if(slow == fast){
                   startLoop(slow,fast);
                   return;
                }
            }

         System.out.println("There is no loop");
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
        list.last.next=list.head.next.next.next;
        System.out.println("last node is "+list.last.data);
        System.out.println("this is"+list.head.next.next.next.data);

       list.detectLoop(list.head,list.head);
        //list.traverse();
        sc.close();

    }
}
