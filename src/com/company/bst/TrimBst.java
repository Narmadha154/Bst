package com.company.bst;

import java.util.Scanner;

public class TrimBst {
    class Node {
        int key;
        Node left, right;
        public Node(int data) {
            key = data;
            left = right = null;
        }
    }
    Node root;
    public Node insert(Node root, int key){
        if(root==null){
            root=new Node(key);
            return root;
        }
        else{
            if(key<=root.key){
                root.left=insert(root.left,key);
            }
            else{
                root.right=insert(root.right,key);
            }
        }
        return root;
    }
    public Node removeOutsideRange(Node root,int min,int max){
        if(root==null){
            return null;
        }
        root.left=removeOutsideRange(root.left,min,max);
        root.right=removeOutsideRange(root.right,min,max);
        if(root.key<min){
            Node rChild=root.right;
            root=null;
            return rChild;
        }
        if(root.key>max){
            Node rChild=root.left;
            root=null;
            return rChild;
        }
        return root;
    }
    public void inOrderRec(Node root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.println(root.key);
            inOrderRec(root.right);
        }
    }
    public void doTrim() {
        Scanner sc = new Scanner(System.in);
        TrimBst tree = new TrimBst();
        System.out.println("Enter the no.of elements");
        int num = sc.nextInt();
        Node root = null;
        System.out.println("Enter the elements:");
        for (int i = 0; i < num; i++) {
            root = tree.insert(root, sc.nextInt());
        }
        System.out.println("Enter the lower range");
        int low = sc.nextInt();
        System.out.println("Enter the higher range");
        int high = sc.nextInt();
        System.out.println("before trim:");
        tree.inOrderRec(root);
        root=removeOutsideRange(root,low,high);
        System.out.println("after trim:");
        tree.inOrderRec(root);
    }
}
