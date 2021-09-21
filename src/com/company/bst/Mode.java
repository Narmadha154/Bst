package com.company.bst;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Mode {
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
    int curCount=1;
    int maxCount=0;
    Node prev;
    public int [] findMode(Node root){
        if(root==null){
            return new int[0];
        }
        List<Integer> list=new ArrayList<>();
        inOrder(root,list);
        int [] res=new int[list.size()];
        for(int i=0;i<list.size();i++){
            res[i]=list.get(i);
        }
        return res;
    }
    public void inOrder(Node root,List<Integer> list){
        if(root==null){
            return;
        }
        inOrder(root.left,list);
        if(prev!=null){
            if(root.key==prev.key){
                curCount++;
            }
            else{
                curCount=1;
            }
        }
        prev=new Node(root.key);
        if(curCount>maxCount){
            maxCount=curCount;
            list.clear();
            list.add(root.key);
        }
        else if(curCount==maxCount){
            list.add(root.key);
        }
        inOrder(root.right,list);
    }
    public void findModeOfBst() {
        Scanner sc = new Scanner(System.in);
        Mode tree = new Mode();
        System.out.println("Enter the no.of elements");
        int num = sc.nextInt();
        Node root = null;
        System.out.println("Enter the elements:");
        for (int i = 0; i < num; i++) {
            root = tree.insert(root, sc.nextInt());
        }
        int [] res=findMode(root);
        for(int i=0;i<10;i++) {
                System.out.println(res);
        }
    }
}
