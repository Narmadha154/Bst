package com.company.bst;

import java.util.Scanner;

public class LowestCommonAncestor {
    class Node{
        int key;
        Node left,right;
        public Node(int data){
            key=data;
            left=right=null;
        }
    }
    Node root;
    LowestCommonAncestor(){
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
            System.out.println(root.key+" ");
            inOrderRec(root.right);
        }
    }
    public Node lca(Node root,int node1,int node2){
        if(root==null){
            return null;
        }
        System.out.println("*"+root.key);
        if(root.key>node1&&root.key>node2){
            return lca(root.left,node1,node2);
        }
        if(root.key<node1&&root.key<node2){
            return lca(root.right,node1,node2);
        }
        return root;
    }
    public void findAncestor(){
        Scanner sc=new Scanner(System.in);
        LowestCommonAncestor tree= new LowestCommonAncestor();
        System.out.println("Enter the no.of elements");
        int num=sc.nextInt();
        System.out.println("Enter the elements:");
        for(int i=0;i<num;i++){
            tree.insert(sc.nextInt());
        }
        System.out.println("Enter the node 1:");
        int node1=sc.nextInt();
        System.out.println("Enter the node 2:");
        int node2=sc.nextInt();
        tree.inOrder();
        Node lcAncestor=tree.lca(tree.root,node1,node2);
        System.out.println("lowest common ancestor is :"+lcAncestor.key);
    }
}
