import java.util.PriorityQueue;
import java.util.Scanner;
public class SortKDLL{
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

        void sortK(int k){
            if(head == null){
                return;
            }
            Node temp =head;
            PriorityQueue<Node>minheap =new PriorityQueue<>((a,b)->a.data-b.data);
            for(int i=0;temp!=null&&i<=k;i++){
                minheap.add(temp);
                temp=temp.next;
            }
            Node dummy = new Node(-1);
            Node curr=dummy;
            while(!minheap.isEmpty()){
                curr.next = minheap.poll();
                curr.next.prev=curr;
                curr=curr.next;
                if(temp!=null){
                    minheap.add(temp);
                    temp=temp.next;
                }

            }
            curr.next = null; // Properly terminate the list
            head = dummy.next;
            head.prev = null;
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
        System.out.println("before sorting");
        list.traverse();
        System.out.println();
        System.out.println("enter k value");
        list.sortK(sc.nextInt());
        System.out.println("after sorting");
        list.traverse();

        sc.close();
    }
}