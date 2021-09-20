package com.company.bst;

import java.util.Scanner;

public class MinimumElement {
    class Node{
        int key;
        Node left,right;
        public Node(int data){
            key=data;
            left=right=null;
        }
    }
    Node root;
   public void insert(int key){
       root=insertRec(root,key);
   }
   public Node insertRec(Node root,int key){
       if(root==null){
           root=new Node(key);
           return root;
       }
       if(key< root.key){
           root.left=insertRec(root.left,key);
       }
       else if(key>root.key){
           root.right=insertRec(root.right,key);
       }
       return root;
   }
   public void inOrder(){
       inOrderRec(root);
   }
   public void inOrderRec(Node root){
       if(root!=null){
           inOrderRec(root.left);
           System.out.println(root.key+" ");
           inOrderRec(root.right);
       }
   }
   public int findMinimum(Node root){
       if(root==null){
           return Integer.MAX_VALUE;
       }
       int res=root.key;
       int lRes=findMinimum(root.left);
       int rRes=findMinimum(root.right);
       if(lRes<res){
           res=lRes;
       }
       if(rRes<res){
           res=rRes;
       }
       return res;
   }
   public void findMin(){
       Scanner sc=new Scanner(System.in);
       MinimumElement tree=new MinimumElement();
       System.out.println("Enter the no.of elements");
       int num=sc.nextInt();
       System.out.println("Enter the elements:");
       for(int i=0;i<num;i++){
           tree.insert(sc.nextInt());
       }
       tree.inOrder();
       int minimum=findMinimum(tree.root);
       System.out.println("min element is:"+minimum);
   }
}
