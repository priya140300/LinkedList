//If we dont want to add through the method of reversing again n again;we can do it Recursively
import java.util.Scanner;
public class Add1Recursively{
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
          
        int helper(Node temp){
            if(temp == null){
                return 1;
            }
            int carry=helper(temp.next);
            temp.data=temp.data+carry;
            if(temp.data<10){
               return 0;
            }
           temp.data=0;
           return 1;
        }
        void add(){
            Node temp=head;
           int carry=helper(temp);
           if(carry==1){
            Node newnode=new Node(1);
            newnode.next=head;
            head=newnode;
           }
          traverse();

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
        list.add();
        //list.traverse();
        sc.close();

       }
} 