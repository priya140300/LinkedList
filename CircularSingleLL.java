import java.util.Scanner;
public class CircularSingleLL {
    static class Node{
        int data;
        Node next;
        Node(int val){
            data = val;
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
                Node temp = head;
                while(temp.next!=null){
                    temp=temp.next;
                }
                temp.next=newnode;
            }
        }
        void findTail(){
            Node temp =head;
            while(temp.next!=null){
                temp = temp.next;
            }
            temp.next=head;
        }
        void traverse(){
            Node temp = head;
           if(head == null){
            return;
           }
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
        Scanner sc =new Scanner(System.in);
        LinkedList list =new LinkedList();
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            list.insert(sc.nextInt());
        }
        list.findTail();
        
        list.traverse();
        sc.close();

    }
}
