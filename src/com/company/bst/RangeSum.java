package com.company.bst;

import java.util.Scanner;

public class RangeSum {
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
    int sum=0;
    public int rangeSumBst(Node root,int low,int high){
        if(root==null){
            return 0;
        }
        if(root.key<low){
            return rangeSumBst(root.right,low,high);
        }
        if(root.key>high){
            return rangeSumBst(root.left,low,high);
        }
        return root.key+rangeSumBst(root.right,low,high)+rangeSumBst(root.left,low,high);
    }
    public void findRangeSum() {
        Scanner sc = new Scanner(System.in);
        RangeSum tree = new RangeSum();
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
        System.out.println(rangeSumBst(root,low,high));
    }
}
