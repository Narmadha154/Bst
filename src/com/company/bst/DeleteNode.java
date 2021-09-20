package com.company.bst;

import java.util.Scanner;

public class DeleteNode {
    class Node{
        int key;
        Node left,right;
        public Node(int data){
            key=data;
            left=right=null;
        }
    }
    Node root;
    DeleteNode(){
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
            System.out.print(root.key+"\t");
            inOrderRec(root.right);
        }
    }
    public void delete(int key){
        root=deleteRec(root,key);
    }
    public Node deleteRec(Node root,int key){
        if(root==null){
            return root;
        }
        if(key<root.key){
            root.left=deleteRec(root.left,key);
        }
        else if(key>root.key){
            root.right=deleteRec(root.right,key);
        }
        else{
            if(root.left==null){
                return root.right;
            }
            if(root.right==null){
                return root.left;
            }
            root.key=minValue(root.right);
            root.right=deleteRec(root.right,key);
        }
        return root;
    }
    public int minValue(Node root){
        int minV= root.key;
        while(root.left!=null){
            minV=root.left.key;
            root=root.left;
        }
        return minV;
    }
    public void doDeletion(){
        DeleteNode tree=new DeleteNode();
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the no.of elements:");
        int num=sc.nextInt();
        System.out.println("enter the elements:");
        for(int i=0;i<num;i++){
            tree.insert(sc.nextInt());
        }
        System.out.println("before deletion");
        tree.inOrder();
        System.out.println();
        System.out.println("enter the k value:");
        int k=sc.nextInt();
        tree.delete(k);
        System.out.println("after deletion");
        tree.inOrder();
    }
}
