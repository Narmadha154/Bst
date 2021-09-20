package com.company.bst;

import java.util.Scanner;

public class InsertNode {
     class Node{
        int key;
        Node left,right;
        public Node(int data){
            key=data;
            left=right=null;
        }
    }
    Node root;
    InsertNode(){
        root=null;
    }
    public void insert(int key){
        root=insertRec(root,key);
    }
   public Node insertRec(Node root,int key){
        if(root==null){
            root=new Node(key);
            return root;
        }
        if(key<root.key){
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
            System.out.println(root.key);
            inOrderRec(root.right);
        }
    }
    public static void doInsertion(){
        InsertNode tree=new InsertNode();
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the no.of elements:");
        int num=sc.nextInt();
        System.out.println("enter the elements:");
        for(int i=0;i<num;i++){
            tree.insert(sc.nextInt());
        }
        System.out.println("enter the k value:");
        int k=sc.nextInt();
        tree.insert(k);
        tree.inOrder();
    }
}
