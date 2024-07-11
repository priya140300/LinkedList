import java.util.Scanner;
public class ReverseK{
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

        void Kreverse(int k){
             Node curr=head;
             boolean isFirstPass=true;
             Node prevFirst=null;
             while(curr!=null){
                 Node first=curr;
                 Node prev=null;
                int count=0;
                while(curr!=null && count<k){
                    Node next=curr.next;
                    curr.next=prev;
                    prev=curr;
                    curr=next;
                    count++;
                }
                if(isFirstPass){
                    head=prev;
                    isFirstPass=false;
                }
                else{
                        prevFirst.next=prev;
                    }
                    prevFirst=first;
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
        list.Kreverse(sc.nextInt());
        list.traverse();
        sc.close();

    }
}

//TIME COMPLEXITY
/*
The outer loop will run n / k times and inner loop will run k times ;so
n/k * k =n =>O(N)
 */