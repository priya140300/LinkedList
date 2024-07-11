import java.util.Scanner;
    public class Merge2Sortedll{
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

        Node merge(Node head1,Node head2){
            Node temp1=head1;
            Node temp2=head2;
            Node dummy=new Node(-1);
            Node curr=dummy;

           //boundary conditions
            if (head1 == null) return head2;
            if (head2 == null) return head1;
            while(temp1!=null && temp2!=null){
                if(temp1.data<temp2.data){
                     curr.next=temp1;
                     temp1=temp1.next;
                }
                else{
                  curr.next=temp2;
                  temp2=temp2.next;
                }
                curr=curr.next;
            }
            if(temp1== null){
                curr.next=temp2;
            }
            else{
                curr.next=temp1;
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
     public static void main(String[]  args){
        Scanner sc=new Scanner(System.in);
        LinkedList list1=new LinkedList();
        LinkedList list2=new LinkedList();

        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            list1.insert(sc.nextInt());
        }
        int m=sc.nextInt();
        for(int i=0;i<m;i++){
            list2.insert(sc.nextInt());
        }
        
       list1.head= list1.merge(list1.head,list2.head);
       list1.traverse();
       sc.close();


     }
    }

    //TC:since we are traversing in both linkedlist for changing the links of size m and n ,in worst case tc will beO(m+n);
    //SC:O(1);we are not crreating new linkedlist instead we are changing the links (next pointer) in the existing linked lists.