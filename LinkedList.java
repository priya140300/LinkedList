import java.util.Scanner;;
public class LinkedList{
    static Node head;
    static class Node{
        int data;
        Node next;
        Node(int val){
            data=val;

        }
    }
    public static LinkedList insert(LinkedList list,int data){
        Node newnode=new Node(data);
        if(head==null){
            head=newnode;
        }
        else{
            Node last =head;
            while(last.next!=null){
                last=last.next;
            }
            last.next=newnode;
        }
        return list;
    }
    public static void traverse(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data +"->");
            temp=temp.next;
        }
    }
    public static void main(String[] args){
        LinkedList list=new LinkedList();
        Scanner sc=new Scanner(System.in);
        list=insert(list,sc.nextInt());
        list=insert(list,sc.nextInt());
        list=insert(list,sc.nextInt());
        list=insert(list,sc.nextInt());
        traverse();
        sc.close();

    }
}