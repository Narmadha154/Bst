package com.company.bst;

import java.util.Scanner;

public class MinAbsoluteDiff {
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
    Node prev;
    int ans;
    public void inOrder(Node curr){
        if(curr==null){
            return;
        }
        inOrder(curr.left);
        if(prev!=null){
            ans=Math.min(curr.key-prev.key,ans);
        }
        prev=curr;
        inOrder(curr.right);
    }
    public int minDiff(Node root){
        prev=null;
        ans=Integer.MAX_VALUE;
        inOrder(root);
        return ans;
    }
    public void findMinDiff() {
        Scanner sc = new Scanner(System.in);
        MinAbsoluteDiff tree = new MinAbsoluteDiff();
        System.out.println("Enter the no.of elements");
        int num = sc.nextInt();
        Node root = null;
        System.out.println("Enter the elements:");
        for (int i = 0; i < num; i++) {
            root = tree.insert(root, sc.nextInt());
        }
        System.out.println(minDiff(root));
    }
}
