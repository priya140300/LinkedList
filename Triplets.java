import java.util.Scanner;
public class Triplets{
    static class Node{
        int data;
        Node next;
        Node prev;
        Node(int val){
            data =val;
        }
    }

    static class LinkedList{
        Node head;
        void insert(int data){
            Node newnode =new Node(data);
            if(head == null){
                head = newnode;
            }
            else{
                Node temp = head;
                while(temp.next!=null){
                    temp = temp.next;
                }
                temp.next =newnode;
                newnode.prev = temp;
            }
        }

        void findTriplePair(int sum,int size){
          if(head == null){
            return;
          }
          Node temp = head;
          for(int i=1;i<=size-2;i++){
            if(temp.data >=sum){
                System.out.println("No more pairs");
                return;
            }
            Node left =temp.next;
            Node right = findTail();
            int updated_sum=sum-temp.data;
            while(left.data<right.data){
                 if(left.data+right.data == updated_sum){
                    System.out.println("("+temp.data+","+left.data+","+right.data+")");
                    left=left.next;
                    right=right.prev;
                 }
                 else if(left.data +right.data <updated_sum){
                    left=left.next;
                 }
                 else{
                    right=right.prev;
                 }
            }
            temp=temp.next;
          }

        }
        Node findTail(){
            Node temp =head;
            while(temp.next!=null){
                temp=temp.next;
            }
            return temp;
        }

        void traverse(){
            Node temp =head;
            while(temp!=null){
                System.out.print(temp.data);
                if(temp.next!=null){
                    System.out.print("<->");
                }
                temp=temp.next;
            }
        }

    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        LinkedList list =new LinkedList();
        System.out.println("enter the length of linked list");
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            list.insert(sc.nextInt());
        }
        list.traverse();
        System.out.println("enter sum");
        list.findTriplePair(sc.nextInt(),n);
        sc.close();

    }
}