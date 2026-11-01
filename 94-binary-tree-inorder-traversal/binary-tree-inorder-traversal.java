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
 * }   //ITERATIVE APPROACH(STACK)
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList <Integer> ans=new ArrayList<>();
        Stack<TreeNode> st=new Stack<>();
        TreeNode curr=root;
        while(st.size()>0 || curr!=null)
        {
        if(curr!=null){
            if(curr.left!=null){
                st.push(curr);
                curr=curr.left;
            }
            else{
                ans.add(curr.val);
                curr=curr.right;
            }
        }else{  //curr==null
        TreeNode top=st.pop();
        ans.add(top.val);
        curr=top.right;
        }
        }
    return ans;   
    }
}