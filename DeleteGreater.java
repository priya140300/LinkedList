import java.util.Scanner;
public class DeleteGreater{
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
        void delete(){
            Node curr=head;
            Node next=curr.next;
            Node dummy=new Node(-1);
            Node prev=dummy;
            while(next!=null){
                if(next.data > curr.data){
                    prev.next=next;
                    curr=next;
                }
                else{
                    prev=curr;
                    curr=curr.next;
                }
                next=next.next;
            }
            head=dummy.next;

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
        System.out.println();
        list.delete();
        list.traverse();

        sc.close();

    }
}