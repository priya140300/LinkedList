import java.util.HashSet;
import java.util.Scanner;
public class DeleteDuplicateUnsorted{
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

        void remove(){
            Node curr=head;
            Node prev=null;
            HashSet<Integer> seen=new HashSet<>();
            while(curr!=null){
                if(seen.contains(curr.data)){
                       prev.next=curr.next;
                     
                }
                else{
                    seen.add(curr.data);
                    prev=curr;
                }
                curr=curr.next;
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
     list.remove();
     list.traverse();
     sc.close();
    }
}