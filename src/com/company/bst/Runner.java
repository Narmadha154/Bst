package com.company.bst;

import java.util.Scanner;

public class Runner{
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the program number:");
            int number=sc.nextInt();
            switch(number) {
                case 1:
                    InsertNode insert = new InsertNode();
                    insert.doInsertion();
                    break;
                case 2:
                    DeleteNode delete = new DeleteNode();
                    delete.doDeletion();
                    break;
                case 3:
                    ArrayToBst change = new ArrayToBst();
                    change.doChange();
                    break;
                case 4:
                    MinimumElement min = new MinimumElement();
                    min.findMin();
                    break;
                case 5:
                    LowestCommonAncestor lca = new LowestCommonAncestor();
                    lca.findAncestor();
                    break;
                case 6:
                    CheckForBst check = new CheckForBst();
                    check.check();
                    break;
                case 7:
                    LevelOrderTraversal level = new LevelOrderTraversal();
                    level.levelOrder();
                    break;
                case 8:
                    KthSmallest small = new KthSmallest();
                    small.findCount();
                    break;
                case 9:
                    Search searchKey = new Search();
                    searchKey.doSearch();
                    break;
                case 10:
                    MinDistance dist = new MinDistance();
                    dist.findMinDis();
                    break;
                case 11:
                    MinAbsoluteDiff diff = new MinAbsoluteDiff();
                    diff.findMinDiff();
                    break;
                case 12:
                    RangeSum sum = new RangeSum();
                    sum.findRangeSum();
                    break;
                case 13:
                    SumOfLeafNode leaf = new SumOfLeafNode();
                    leaf.findLeafSum();
                    break;
                case 14:
                    TrimBst trim = new TrimBst();
                    trim.doTrim();
                    break;
                case 15:
                    Mode mod = new Mode();
                    mod.findModeOfBst();
                    break;
                default:
                    System.out.println("no program");
            }
    }
}
