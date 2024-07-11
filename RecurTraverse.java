import java.util.Scanner;
public class RecurTraverse {

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
            if(head==null){
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
        void rec(Node temp){
            if(temp==null){
                return;
            }
            System.out.print(temp.data);
            if(temp.next!=null){
                System.out.print("->");
            }
            rec(temp.next);
        }

    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        LinkedList list=new LinkedList();
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
           list.insert(sc.nextInt());     
        }
        Node temp=list.head;
        list.rec(temp);
        System.out.println(list.head);
        System.out.println(list.head.next);

        sc.close();

        

    }

}