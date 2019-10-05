package com.general.arithmetic.tree;

import java.util.LinkedList;

/****
 *
 *获取二叉树的深度
 *  **/
public class GetHWithTree {
    public static void main(String[] args){
        GetHWithTree test_tree=new GetHWithTree();
       int max_h= test_tree.getH(test_tree.generateTree(),0);
       System.out.println("digui max_h is "+max_h);

       int h=test_tree.getH1(test_tree.generateTree());

       System.out.println("fei di gui h is "+h);
    }

    TreeNode generateTree(){
        TreeNode root=new TreeNode(0);
        root.left_child=new TreeNode(1);
        root.right_child=new TreeNode(2);
        root.left_child.left_child=new TreeNode(3);
        root.left_child.right_child=new TreeNode(4);
        root.left_child.right_child.right_child=new TreeNode(10);
        root.left_child.right_child.right_child.left_child=new TreeNode(11);
        root.left_child.right_child.right_child.left_child.right_child=new TreeNode(12);
        return root;
    }
    /****递归求解树的高度***/
    int getH(TreeNode root,int h)
    {
        if(root==null && h==0){
            System.out.println("node is null and h is 0,input is error");
            return -1;
        }
        if (root==null&&h!=0){
            return h;
        }

        TreeNode left=root.left_child;
        TreeNode right=root.right_child;
        int l_h=0,r_h=0;
        if(root!=null && left==null && right==null){//左右子树为空，本节点非空
            h++;
            return h;
        }else{
            int c_h=++h;
            if(left!=null){
                l_h=getH(left,c_h);//递归左子树

            }else{
                l_h=h;
            }
            if(right!=null){
                r_h=getH(right,c_h);//递归右子树
            }else{
                r_h=h;
            }
        }



        int max_h=(l_h>r_h)?l_h:r_h;
        return max_h;



    }
    /****非递归求出树的高度，利用队列辅助****/
    int getH1(TreeNode root){


        if(root==null){
            return 0;
        }
        //使用层次遍历的方式，遍历整棵树 求解树的深度
        int treeHigh=0;//树高
        int nextCount=1;//还未进行遍历的下一层的节点数
        int count=0;//当前层中已经遍历的节点数
        LinkedList<TreeNode> queue=new LinkedList<>();//LinkedList实现了Queue接口，可以当做队列使用
        queue.add(root);
        while (!queue.isEmpty()){//队列非空未遍历完成
            count++;
            TreeNode node=queue.poll();
            if (node.left_child!=null){
                queue.add(node.left_child);
            }
            if (node.right_child!=null){
                queue.add(node.right_child);
            }
            //当前遍历的节点数和当前层的节点数相等时，即一层的节点遍历完成
            if(count==nextCount){
                nextCount=queue.size();//此时队列中节点数量即为下一层中的节点数量
                count=0;//置下一层中已经遍历的节点数量为0
                treeHigh++;//遍历完一层 树高加1
            }
        }

        return treeHigh;

    }
}
class TreeNode{
    TreeNode left_child;
    TreeNode right_child;
    int data=-1;
    TreeNode(int data){
        this.data=data;
    }
}