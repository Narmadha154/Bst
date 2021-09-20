package com.company.bst;

import java.util.Scanner;

public class LevelOrderTraversal {
    class Node{
        int key;
        Node left,right;
        public Node(int data){
            key=data;
            left=right=null;
        }
    }
    Node root;
    public void preOrder(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.key+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public Node getNode(int data){
        Node node=new Node(data);
        return node;
    }
    public Node levelOrder(Node root,int key){
        if(root==null){
            root=new Node(key);
            return root;
        }
        else {
            if (key <= root.key) {
                root.left = levelOrder(root.left, key);
            } else {
                root.right = levelOrder(root.right, key);
            }
        }
        return root;
     }
     public Node constructBst(int [] arr,int n){
        if(n==0){
            return null;
        }
        root=null;
        for(int i=0;i<n;i++){
            root=levelOrder(root,arr[i]);
        }
        return root;
     }
    public void levelOrder() {
        Scanner sc = new Scanner(System.in);
        LevelOrderTraversal tree = new LevelOrderTraversal();
        System.out.println("enter the size:");
        int size=sc.nextInt();
        System.out.println("Enter the elements:");
        int [] arr=new int[size];
        for(int i=0;i<size;i++) {
            arr[i] = sc.nextInt();
        }
        root = constructBst(arr, size);
        preOrder(root);
    }
}
