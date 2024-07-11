import java.util.Scanner;
public class DeleteKCll {
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
                head =newnode;
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
            Node temp = head;
            while (temp.next!=null) {
                temp=temp.next;
            }
            temp.next=head;
         }
         void deleteKth(int k,int size){
            if(k>size){
                System.out.println("k greater than size");
                head=null;
                return;
            }
            if(head == null){
                return;
            }
            if(k == 1 && size == 1){
                head = null;
                return;
            }
            if(k==1){
              Node tail =  findTail();
              head=head.next;
              tail.next=head;
              return;
            }
            if(k==size){
                Node temp = head;
                while (k-1>1) {
                    temp=temp.next;
                    k--;                
                }
                temp.next=head;
                return;
            }
            Node temp =head;
          for(int i=1;i<k-1;i++){
            temp=temp.next;
          }
          temp.next=temp.next.next;

            
                

         }
         Node findTail(){
            Node temp = head;
            while(temp.next!=head){
                temp=temp.next;
            }
            return temp;
         }
         



         void traverse(){
            if(head == null){
                System.out.println("Circular Linkedlist is empty");
                return;
            }
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
        System.out.println("before deletion");
        list.traverse();
        System.out.println("enter the node position you want to delete");
        list.deleteKth(sc.nextInt(),n);
        System.out.println();
        System.out.println("after deletion of kth node");
        list.traverse();
        sc.close();
    }
    
}
