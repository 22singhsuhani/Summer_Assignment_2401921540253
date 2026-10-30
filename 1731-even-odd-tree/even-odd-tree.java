/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */ // pre order dfs
class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);

        int level=0;
        while(!q.isEmpty()){
            int size=q.size();
            int prev;


            if(level%2==0){
                prev=Integer.MIN_VALUE;
            }else{
                prev=Integer.MAX_VALUE;
            }
            for(int i=0;i<size;i++){
                TreeNode curr=q.poll();
                int val=curr.val;

                if(level%2==0){
                    if(val%2==0 || val<=prev ){
                        return false;
                    }
                }else{
                    if(val%2!=0 || val>=prev){
                        return false;
                    }
                }
                prev=val;

                if(curr.left!=null){
                    q.offer(curr.left);
                }
                if(curr.right!=null){
                    q.offer(curr.right);
                }
            }
            level++;
        }
        return true;

    }
}