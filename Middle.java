import java.util.Scanner;
public class Middle{ 
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

        void middle(){
            Node slow=head;
            Node fast=head;
            if(head == null){
                return;
            }
            if(head.next == null){
                System.out.println(head.data);
                return;
            }
            while(fast!=null && fast.next!=null){
                fast=fast.next.next;
                slow=slow.next;
            }
            System.out.println(slow.data);
            
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
        System.out.println("middle node is ");
        list.middle();
        list.traverse();
        sc.close();
    }

}
//in case of even ->take second middle element;in even ll ;fast pointer /refernce variable points to null
//in case of odd -> fast pointer points to last node