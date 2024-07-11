import java.util.Scanner;
public class PairWiseSwap {
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

        void pairSwap(){
            if(head == null || head.next==null){
                return;
            }
            Node curr=head.next.next;
            Node prev=head;
            head=head.next;
            head.next=prev;
            Node next;
            while(curr!=null && curr.next!=null){
                    prev.next=curr.next;
                    prev=curr;
                    next=curr.next.next;
                    curr.next.next=curr;//prev                   
                    curr=next;
            }
            prev.next=curr;
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
        list.pairSwap();
        list.traverse();
        sc.close();
    }
}
