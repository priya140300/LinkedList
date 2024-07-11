import java.util.Scanner;
public class IntersectionPoint{
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

        int length(Node temp){
            int sz=0;
            while(temp!=null){
                sz++;
                temp=temp.next;

            }
            return sz;
        }

        void intersect(Node temp1,Node temp2){
            if(head == null){
                return;
            }
            int l1=length(temp1);
            int l2=length(temp2);
            int diff;
            if(l1>l2){
                diff=l1-l2;
                while(diff>0){
                    temp1=temp1.next;
                    diff--;
                }
            }
            else{
                diff=l2-l1;
                while(diff>0){
                    temp2=temp2.next;
                    diff--;
                }
            }

            while(temp1!=null && temp2!=null){
                if(temp1==temp2){
                    System.out.println("intersection point/node is "+temp1.data);
                    return;
                }
                temp1=temp1.next;
                temp2=temp2.next;
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
        Node parallel=new Node(sc.nextInt());
        Node head2=parallel;
        head2.next=list.head.next.next.next;
        list.intersect(list.head,head2);
        list.traverse();
        sc.close();

    }
}