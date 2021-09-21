package com.company.bst;

import java.util.Scanner;

public class SumOfLeafNode {
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
    int sum;
    public void sumOfLeafNode(Node root){
        if(root==null){
           return;
        }
        if(root.left==null&&root.right==null){
            sum+=root.key;
        }
        sumOfLeafNode(root.left);
        sumOfLeafNode(root.right);
    }
    public void findLeafSum() {
        Scanner sc = new Scanner(System.in);
        SumOfLeafNode tree = new SumOfLeafNode();
        System.out.println("Enter the no.of elements");
        int num = sc.nextInt();
        Node root = null;
        System.out.println("Enter the elements:");
        for (int i = 0; i < num; i++) {
            root = tree.insert(root, sc.nextInt());
        }
        sum=0;
        sumOfLeafNode(root);
        System.out.println(sum);
    }
}
