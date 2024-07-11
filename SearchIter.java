import java.util.Scanner;
public class SearchIter {
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
        int searchData(int data){
          
            if(head == null){
                return -1;
            }
             int position=1;
            
             Node temp=head;
             while(temp!=null && temp.data != data){
                temp=temp.next;
                position++;
             }
           if(temp == null){
            return -1;
           }
           return position;

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
       int result =list.searchData(sc.nextInt());
       System.out.println("this is the position "+result);
       list.traverse();
       sc.close();

    }
}
