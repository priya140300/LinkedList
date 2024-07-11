import java.util.Scanner;

public class InsertPosition{
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
            if(head ==null){
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
        void insertSpec(int data,int position){
            Node newnode=new Node(data);
            int count=1;
            Node temp=head;
            
            while(count!=position-1){
                count++;
                temp=temp.next;
            }
            Node right=temp.next;
            temp.next=newnode;
            newnode.next=right;
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
        System.out.println("enter position");
        int position=sc.nextInt();
        System.out.println("enter the data to be inserted");
        list.insertSpec(sc.nextInt(),position);
        list.traverse();
        sc.close();
    }
}