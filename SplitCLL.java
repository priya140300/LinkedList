import java.util.Scanner;
public  class SplitCLL {
    static class Node{
        int data;
        Node next;
        Node(int val){
            data=val;
        }
    }

    static class LinkedList{
        Node head ;
        void insert(int data){
            Node newnode=new Node(data);
            if(head == null){
                head=newnode;
            }
            else{
                Node temp =head;
                while(temp.next!=null){
                    temp=temp.next;
                }
                temp.next=newnode;
            }
        }
        void findLast(){
            Node temp=head;
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=head;
        }
        void split(){
            Node slow =head;
            Node fast=head;
            while(fast.next!=head && fast.next.next!=head){
                   slow=slow.next;
                   fast=fast.next.next;
            }
            Node sechead =slow.next;
            slow.next=head;
            Node curr=sechead;
            while (curr.next!=head){
                curr=curr.next; 
            }
            curr.next=sechead;
            traverse(head);
            System.out.println();
            traverse(sechead);
        }
        void traverse(Node head){
            Node temp =head;
            do{
                System.out.print(temp.data);
                if(temp.next!=head){
                    System.out.print("->");
                }
                temp=temp.next;
            }
            while(temp!=head);
        }

    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        LinkedList list =new LinkedList();
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            list.insert(sc.nextInt());
        }
        list.findLast();
        System.out.println("before splitting");
        list.traverse(list.head);
        System.out.println();
        System.out.println("after splitting");
        list.split();
        
        sc.close();
    }
}
