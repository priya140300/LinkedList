import java.util.Scanner;
public class QuickSort{
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
            Node newnode =new Node(data);
            if(head == null){
                head = newnode;
            }
            else{
                Node temp = head;
                while (temp.next!=null) {
                    temp =temp.next;
                }
                temp.next=newnode;
            }
        }
        Node getTail(Node node){
            while (node.next!=null){
                node=node.next;
            }
            return node;

        }

        Node partition(Node head ,Node end,Node[] newHead ,Node[] newEnd){
            Node curr=head;
            Node prev =null;
            Node pivot= end;
            Node tail=pivot;
         

            while (curr!=pivot){
                if(curr.data < pivot.data){
                    if(newHead[0] == null){
                        newHead[0]=curr;
                    }
                    prev=curr;
                    curr=curr.next;
                }
                else{
                    if(prev!=null){
                        prev.next=curr.next;
                    }
                    Node temp =curr.next;
                    curr.next=null;
                    tail.next=curr;
                    tail=tail.next;
                    curr=temp;
                }
                
            }
            if(newHead[0] == null){
                newHead[0]=pivot;
            }
            newEnd[0]=tail;
            return pivot;
        }
        Node quickSortRecur(Node head ,Node end){
            if(head == null || head == end){
                return head;
            }
            Node[] newHead =new Node[1];
            Node[] newEnd =new Node[1];

            Node pivot = partition(head,end,newHead,newEnd);
            //ie.left sublist exist
            if(newHead[0]!=pivot){
                Node temp = newHead[0];
                while(temp.next!=pivot){
                    temp=temp.next;
                }
                temp.next=null;
               newHead[0]= quickSortRecur(newHead[0],temp);

                 temp = getTail(newHead[0]);
                 temp.next=pivot;
            }
           //right side recursivley sort
            pivot.next=quickSortRecur(pivot.next,newEnd[0]);
            return newHead[0];

        }

       void quickSorting(){
        head= quickSortRecur(head,getTail(head));

        }
        void traverse(){
            Node temp=head;
            while (temp!=null) {
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
        LinkedList list =new LinkedList();
        System.out.println("enter the length of the linkedlist");
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            list.insert(sc.nextInt());
        }
        System.out.println("before sorting");
        list.traverse();
        list.quickSorting();
        System.out.println();
        System.out.println("after sorting");
        list.traverse();
        sc.close();
    }
}