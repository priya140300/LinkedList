import java.util.Scanner;
public class ReverseRec{
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

       Node reverse(Node prev,Node curr){
                   if(curr == null){
                    return prev;
                   }
                   Node next=curr.next;
                   curr.next=prev;
                   return reverse(curr,next);

          
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
        Node prev=null;
        Node curr=list.head;
        list.head=list.reverse(prev,curr);
        list.traverse();
        sc.close();

    }
}

