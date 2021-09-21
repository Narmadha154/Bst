package com.company.bst;

import java.util.Scanner;

public class Search {
    class Node {
        int key;
        Node left, right;

        public Node(int data) {
            key = data;
            left = right = null;
        }
    }
    Node root;
    public Node insert(Node root,int key){
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
    public Node search(Node root,int key){
        if(root==null||root.key==key){
            return root;
        }
        else if(key<root.key){
            return search(root.left,key);
        }
        return search(root.right, key);
    }
    public void preOrder(Node node){
        if(node==null){
            return;
        }
        System.out.print(node.key+" ");
        preOrder(node.left);
        preOrder(node.right);
    }
    public void doSearch(){
        Scanner sc = new Scanner(System.in);
        Search tree = new Search();
        System.out.println("Enter the no.of elements");
        int num = sc.nextInt();
        Node root=null;
        System.out.println("Enter the elements:");
        for(int i=0;i<num;i++){
            root=tree.insert(root,sc.nextInt());
        }
        System.out.println("Enter the key to be checked");
        int keyVal = sc.nextInt();
        root=search(root,keyVal);
        preOrder(root);

    }
}
