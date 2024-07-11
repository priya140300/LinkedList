import java.util.Scanner;
public class SegregateEO{
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
        void segregate(){
            if(head == null){
                return;
            }
            Node es=null;
            Node ee=null;
            Node os=null;
            Node oe=null;
            Node curr=head;
            while(curr!=null){
                if(curr.data%2==0){
                    if(es==null){
                        es=curr;
                        ee=curr;
                    }
                    else{
                        ee.next=curr;
                        ee=curr;
                    }
                }
                else{
                    if(os==null){
                        os=curr;
                        oe=curr;
                    }
                    else{
                        oe.next=curr;
                        oe=curr;
                    }
                }
            curr=curr.next;
            }
            if(es==null || os==null){
                return;
            }
            else{
                ee.next=os;
                oe.next=null;
                head=es;
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
        list.segregate();
        list.traverse();
        sc.close();

    }
}