import java.util.PriorityQueue;
import java.util.Scanner;
public class MergKSortedLLs{
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
         Node newnode = new Node(data);
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
    
     Node mergeK(Node[] heads,int k){

        if(heads.length == 0 ){
            return null;
        }
        PriorityQueue<Node> minHeap =new PriorityQueue<>(heads.length,(a,b)->a.data-b.data);
        for(Node h:heads){
            if(h!=null){
                minHeap.add(h);
            }
        }
        Node dummy = new Node(-1);
        Node curr=dummy;
        while(!minHeap.isEmpty()){
            Node minNode=minHeap.poll();
            curr.next= minNode;
            curr=curr.next;

            if(minNode.next!=null){
                minHeap.add(minNode.next);
            }
        }
        return dummy.next;
     }

     void traverse(Node head){
        Node temp=head;
        while(temp !=null){
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
    System.out.println("enter the number of linked lists you want to merge in one");
    int k=sc.nextInt();
    LinkedList[] lists =new LinkedList[k];//k references ;each reference pointing to a different linkedlists
    Node[] heads=new Node[k];
    for(int i=0;i<k;i++){
        lists[i] =new LinkedList();
        System.out.println("enter the size of Linked List "+(i+1));
        int n=sc.nextInt();
        for(int j=0;j<n;j++){
            lists[i].insert(sc.nextInt());
        }
        heads[i]=lists[i].head;
    }
    LinkedList result =new LinkedList();
    result.head=result.mergeK(heads, k);
    System.out.println("The Merged linked list is here ");
    result.traverse(result.head);

    sc.close();
    
   } 
}



