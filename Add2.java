import java.util.Scanner;
public class Add2 {
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
      Node add2(Node head1,Node head2){
        Node temp1=head1;
        Node temp2=head2;
        Node dummy=new Node(-1);
        Node curr=dummy;
        int carry=0;
        while(temp1!=null || temp2!=null){
            int sum=carry;
            if(temp1!=null){
                sum+=temp1.data;
            }
            if(temp2!=null){
                sum+=temp2.data;
            }
            Node newnode=new Node(sum%10);
            carry=sum/10;
            curr.next=newnode;
            curr=curr.next;
            
            if(temp1!=null){
                temp1=temp1.next;
            }
            if(temp2!=null){
                temp2=temp2.next;
            }

        }
        if(carry!=0){
             Node newnode=new Node(carry);
             curr.next=newnode;
        }
        return dummy.next;

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
        //we will create two instances of the LinkedList in order to create two different linkedlists.
        LinkedList list1=new LinkedList();
        LinkedList list2=new LinkedList();
        

        System.out.println("enter the length of first linkedlist");
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            list1.insert(sc.nextInt());
        }
        System.out.println("enter the length of second linkedlist");
        int m=sc.nextInt();
        for(int i=0;i<m;i++){
            list2.insert(sc.nextInt());
        }

        list1.head=list1.add2(list1.head,list2.head);
        list1.traverse();
        sc.close();


    }
}
