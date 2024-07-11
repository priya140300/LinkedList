import java.util.Scanner;
public class FlattenLL {
    static class Node{
        int data;
        Node next=null;
        Node child=null;
        Node(int val){
            data=val;
        }
    }

    static class LinkedList{
        Scanner sc=new Scanner(System.in);
        Node head;
        void insert(int data){
            Node newnode=new Node(data);
            if(head == null){
                head = newnode;
              
            }
            else{
                Node temp=head;
                while(temp.next!=null){
                    temp=temp.next;
                }
                temp.next=newnode;

            }
            System.out.println("enter how many child nodes you want to have for this particular head node");
            int size=sc.nextInt();
            childInsert(size,newnode);
            newnode.next=null;

        }
        void childInsert(int size,Node newnode){
            Node temp=newnode;
            for(int i=0;i<size;i++){
                System.out.println("enter value for child node");
                Node childNode=new Node(sc.nextInt());
                temp.child=childNode;
                temp=childNode;
            }
            temp.child=null;

        }

        Node flat(Node head){
            if(head == null || head.next == null){
                return head;
            }
           Node mergeHead=flat(head.next);
           return merge(head, mergeHead);

        }

        Node merge(Node temp1,Node temp2){
            Node dummy=new Node(-1);
            Node res=dummy;
            while(temp1!=null && temp2!=null){
                if(temp1.data<temp2.data){
                    res.child=temp1;
                    res=temp1;
                    temp1=temp1.child;
                }
                else{
                    res.child=temp2;
                    res=temp2;
                    temp2=temp2.child;
                }
                res.next=null;
            }
            if(temp1 !=null){
                res.child=temp1;
            }
            else{
                res.child=temp2;
            }
            return dummy.child;

        }

        void traverse(Node head){
            Node temp=head;
            while(temp!=null){
                System.out.print(temp.data);
                
                if(temp.child!=null){
                    System.out.print("->");
                }
                temp=temp.child;
            }

        }


        // void traverseChild(Node temp){
        //     while(temp!=null){
        //         System.out.print("|"+temp.data);
        //         if(temp.child.child!=null){
        //             System.out.print("||");

        //         }
        //         temp=temp.child;
                
        //     }
        // }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        LinkedList list=new LinkedList();
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            System.out.println("enter horizontal node value");
            list.insert(sc.nextInt());
        }
        list.head=list.flat(list.head);
        list.traverse(list.head);
       //list.traverseChild(list.head);
        sc.close();

    }

}
