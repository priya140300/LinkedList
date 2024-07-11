import java.util.Scanner;
public class Multiply2ll {
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

        long multi2(Node head1,Node head2){
            long num1=0,num2=0;
            Node temp1=head1;
            Node temp2=head2;
            long mod=1000000007;
            //Extracting digits
            while(temp1!=null){
                num1=((num1*10)+temp1.data)%mod;
                temp1=temp1.next;
            }
            while(temp2!=null){
                num2=((num2*10)+temp2.data)%mod;
                temp2=temp2.next;
            }
            return (num1*num2)%mod;


        }
        //to see the result in form of linked list
        void convert(long res){
            Node dummy=new Node(-1);
            Node curr=dummy;
            while(res>0){
                Node newnode=new Node((int)res%10);
                curr.next=newnode;
                curr=curr.next;
                res=res/10;
                
            }
            head=dummy.next;
            reverse();
            
        }
        void reverse(){
            Node curr=head;
            Node prev=null;
            Node next=null;
            while(curr!=null){
                next=curr.next;
                curr.next=prev;
                prev=curr;
                curr=next;
            }
            head=prev;
        }
        //till here
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
        LinkedList list1=new LinkedList();
        LinkedList list2=new LinkedList();
        System.out.println("enter size of first ll");
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            list1.insert(sc.nextInt());
        }
        System.out.println("enter the size of second linked list");
        int m=sc.nextInt();
        for(int i=0;i<m;i++){
            list2.insert(sc.nextInt());
        }
        long res=list1.multi2(list1.head, list2.head);
        list1.traverse();
        System.out.println();
        list2.traverse();
        System.out.println();
        System.out.println("multiplication of the above two linked list is "+res);
        list1.convert(res);
        System.out.println("Happy coding!");
        System.out.println();
        list1.traverse();
        sc.close();


    }
}
//Space is constant i.e it is not dependent on input size