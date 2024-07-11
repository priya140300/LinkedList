import java.util.Scanner;
public class ReverseGroupDLL {
    static class Node{
        int data;
        Node prev;
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
                head = newnode;
            }
            else{
                Node temp=head;
                while(temp.next!=null){
                    temp=temp.next;
                }
                temp.next=newnode;
                newnode.prev=temp;
            }
        }

        Node reverseGroup(Node head,int k){
            Node curr=head;
            Node prev=null;
            Node next=null;
            int count =0;
            while(curr!=null && count< k){
                next=curr.next;
                curr.next=prev;
                curr.prev=next;
                prev=curr;
                curr=next;
                count++;

            }
            if(next!=null){
                head.next=reverseGroup(next, k);
                //check this without if
                if(head.next!=null){
                    head.next.prev=head;

                }
            }
            return prev;

        }

        void traverse(){
            Node temp=head;
            while (temp!=null) {
                System.out.print(temp.data);
                if(temp.next!=null){
                    System.out.print("|->");
                    System.out.print("<-|");
                }
                temp=temp.next;
                
            }
        }

    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        LinkedList list =new LinkedList();
        System.out.println("enter the length of doubly ll");
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            list.insert(sc.nextInt());
        }
        System.out.println("before reversing every group of k nodes");
        list.traverse();
        System.out.println("enter group size i.e k");
        list.head = list.reverseGroup(list.head,sc.nextInt());
        System.out.println("after reversing every group of k nodes");
        list.traverse();
        sc.close();
    }

}
