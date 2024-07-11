import java.util.Scanner;
public class CommonNodes{
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
            if(head== null){
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
        void common(Node head1,Node head2){
            Node temp1=head1;
            Node temp2=head2;
            Node dummy=new Node(-1);
            Node curr=dummy;
            while(temp1!=null && temp2!=null){

                if(temp1.data<temp2.data){
                    temp1=temp1.next;
                }
                else if(temp1.data>temp2.data){
                    temp2=temp2.next;
                }
                else if(temp1.data == temp2.data){
                    curr.next=temp1;
                    curr=curr.next;
                    temp1=temp1.next;
                    temp2=temp2.next;
                }
            }
            curr.next=null;
            traverse(dummy.next);

        }
        void traverse(Node head){
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
        LinkedList list1=new LinkedList();
        LinkedList list2=new LinkedList();
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            list1.insert(sc.nextInt());
        }
        int m=sc.nextInt();
        for(int i=0;i<m;i++){
            list2.insert(sc.nextInt());
        }
        list1.common(list1.head,list2.head);
        sc.close();

    }
}