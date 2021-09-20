package com.company.bst;

import java.util.Scanner;

class Node{
    int data;
    Node left,right;
    Node(int key){
        data=key;
        left=right=null;
    }
}
public class ArrayToBst {
     Node root;
     public Node arrToBst(int [] arr,int start,int end){
         if(start>end){
             return null;
         }
         int mid=(start+end)/2;
         Node node=new Node(arr[mid]);
         node.left=arrToBst(arr,start,mid-1);
         node.right=arrToBst(arr,mid+1,end);
         return node;
     }
     public void preOrder(Node node){
         if(node==null){
             return;
         }
         System.out.print(node.data+" ");
         preOrder(node.left);
         preOrder(node.right);
     }
     public void doChange(){
         ArrayToBst tree=new ArrayToBst();
         Scanner sc=new Scanner(System.in);
         System.out.println("enter the size:");
         int size=sc.nextInt();
         System.out.println("Enter the elements:");
         int [] arr=new int[size];
         for(int i=0;i<size;i++){
             arr[i]=sc.nextInt();
         }
         root=arrToBst(arr,0,size-1);
         System.out.println("preorder traversal of bst:");
         tree.preOrder(root);
     }
}
