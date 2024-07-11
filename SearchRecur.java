import java.util.Scanner;

public class SearchRecur 
{ 
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
            if(head==null){
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
        int searchRec(int data,Node temp,int position){
            if(temp == null){
                return -1;
               }

           if(temp.data == data){
            return position;//got that targeted data
           }
           
           return searchRec(data, temp.next,position+1);

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
        Node temp=list.head;
        int result= list.searchRec(sc.nextInt(),temp,1);
        System.out.println("position of targeted data is "+result);
        list.traverse();
        sc.close();
    }
    
}
