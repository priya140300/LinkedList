





                  //ASSUMPTION:IN THE PROBLEM STATEMENT WE ARE ASSUMIG THAT ONLY UNIQUE ELEMENTS ARE PROVIDED NO DUPLICATES

// //this approach takes O(n^2) time complexity ;check the other method for optimization
// import java.util.Scanner;
// public class PairSumDll {

//     static class Node{
//         int data;
//         Node prev;
//         Node next;
//         Node(int val){
//             data=val;
//         }
//     }

//     static class LinkedList{
//         Node head;
//         void insert(int data){
//             Node newnode=new Node(data);
//             if(head == null){
//                 head = newnode;
//             }
//             else{
//                 Node temp=head;
//                 while(temp.next!=null){
//                     temp=temp.next;
//                 }
//                 temp.next=newnode;
//                 newnode.prev=temp;
//             }
//         }
//         void findPairs(int x){

//             if(head.data >= x){
//                 return;
//             }
//             Node temp=head;
//             int diff =x-temp.data;
//             Node temp1=temp.next;
//             while(temp1 !=null && temp1.data<=diff){
//                 if(temp1.data == diff){
//                     System.out.println(temp.data+","+temp1.data);
//                     temp=temp.next;
//                     diff=x-temp.data;
//                     temp1=temp.next;
//                 }
//                 else{
//                     temp1=temp1.next;
//                 }

//             }
//             if(temp1 == null || temp1.data>diff){
//                 System.out.println("No more  pairs found");
//             }

            

//         }

//         void traverse(){
//             Node temp=head;
//             while (temp!=null) {
//                 System.out.print(temp.data);
//                 if(temp.next!=null){
//                     System.out.print("|->");
//                     System.out.print("<-|");
//                 }
//                 temp=temp.next;
                
//             }
//         }

//     }
//     public static void main(String[] args){
//         Scanner sc=new Scanner(System.in);
//         LinkedList list =new LinkedList();
//         System.out.println("enter the length of doubly ll");
//         int n=sc.nextInt();
//         for(int i=0;i<n;i++){
//             list.insert(sc.nextInt());
//         }

//         list.traverse();
//         System.out.println("enter the sum");
//         list.findPairs(sc.nextInt());
//         sc.close();
//     }
    
// }


import java.util.Scanner;
public class PairSumDll{
    static class Node{
        int data;
        Node next;
        Node prev;
        Node(int val){
            data =val;
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
                while(temp.next!=null){
                    temp = temp.next;
                }
                temp.next =newnode;
                newnode.prev = temp;
            }
        }

        void findPairs(int sum){
            Node left =head;
            Node right = findTail();
            while(left.data <right.data){
                if(left.data+right.data == sum){
                    System.out.println("("+left.data+","+right.data+")");
                    left=left.next;
                    right =right.prev;
                }
                else if(left.data +right.data <sum){
                    left=left.next;
                }
                else{
                    right=right.prev;
                }
            }
        }
        Node findTail(){
            Node temp =head;
            while(temp.next!=null){
                temp=temp.next;
            }
            return temp;
        }

        void traverse(){
            Node temp =head;
            while(temp!=null){
                System.out.print(temp.data);
                if(temp.next!=null){
                    System.out.print("<->");
                }
                temp=temp.next;
            }
        }

    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        LinkedList list =new LinkedList();
        System.out.println("enter the length of linked list");
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            list.insert(sc.nextInt());
        }
        list.traverse();
        System.out.println("enter sum");
        list.findPairs(sc.nextInt());
        sc.close();

    }
}