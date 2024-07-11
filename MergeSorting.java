import java.util.Scanner;
public class MergeSorting {
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

            Node mergeSorting(Node head){
                if(head == null || head.next == null){
                     return head;
                }
                Node mid=findMiddle(head);
                Node lefthead=head;
                Node righthead=mid.next;
                mid.next=null;
                lefthead=mergeSorting(lefthead);
                righthead=mergeSorting(righthead);
                return merge2ll(lefthead,righthead);

            }
            Node findMiddle(Node head){
                Node slow=head;
                Node fast=head;
                while(fast.next!=null && fast.next.next!=null){
                    fast=fast.next.next;
                    slow=slow.next;
                }
                return slow;
            }

            Node merge2ll(Node temp1,Node temp2){
                Node dummy=new Node(-1);
                Node curr=dummy;
                while(temp1!=null && temp2!=null){
                    if(temp1.data<temp2.data){
                        curr.next=temp1;
                        temp1=temp1.next;
                    }
                    else{
                        curr.next=temp2;
                        temp2=temp2.next;
                    }
                    curr=curr.next;
                }
                if(temp1!=null){
                    curr.next=temp1;
                }
                else{
                    curr.next=temp2;
                }
                return dummy.next;
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
        list.traverse();
        list.head=list.mergeSorting(list.head);
        System.out.println();
        list.traverse();
        sc.close();

    }
}
//we are reaching to individual element as individual element is sorted in itself and therefore suitable for merge2ll algorithm
