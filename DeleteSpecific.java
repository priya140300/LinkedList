import java.util.Scanner;
public class DeleteSpecific {
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
            Node newnode =new Node(data);
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
        void deleteSpec(int n,int position){
            if(head == null){
                return;
            }
            if(position>n){
                return;
            }
            if(head.next == null){
                head=null;
                return;
            }
            if(position ==0){
                return;
            }
            if(position==1){
                head=head.next;
                return;
            }
            int count=1;
            Node temp=head;
            while(count!=position-1){
                count++;
                temp=temp.next;
            }
            temp.next=temp.next.next;
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
        list.deleteSpec(n,sc.nextInt());
        list.traverse();
        sc.close();
    }
}
