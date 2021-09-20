package com.company.bst;

import java.util.Scanner;

public class CheckForBst {
    class Node{
        int key;
        Node left,right;
        public Node(int data){
            key=data;
            left=right=null;
        }
    }
    Node root;
    public Node insert(Node root, int key){
        if(root==null){
            root=new Node(key);
            return root;
        }
        else {
            if (key <= root.key) {
                root.left = insert(root.left, key);
            } else {
                root.right = insert(root.right, key);
            }
        }
        return root;
    }
    public boolean isBst(Node root,Node left,Node right){
        if(root==null){
            return true;
        }
        if(left!=null&&root.key<=left.key){
            return false;
        }
        if(right!=null&&root.key<=right.key){
            return false;
        }
        return isBst(root.left,left,root)&& isBst(root.right,root,right);
    }
    public void check(){
        Scanner sc=new Scanner(System.in);
        CheckForBst tree= new CheckForBst();
        System.out.println("Enter the no.of elements");
        int num=sc.nextInt();
        Node root=null;
        System.out.println("Enter the elements:");
        for(int i=0;i<num;i++){
            root=tree.insert(root,sc.nextInt());
        }
       if(isBst(root,null,null)){
           System.out.println("BST");
       }
        else{
           System.out.println("Not BST");
       }
    }
}
