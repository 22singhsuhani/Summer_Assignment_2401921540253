
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        return ismirror(root.left,root.right);
    }
    public boolean ismirror(TreeNode n1,TreeNode n2){
        if(n1==null && n2==null){
            return true;
        }
        if(n1==null || n2==null){
            return false;
        }
        return n1.val==n2.val 
        && ismirror(n1.left,n2.right)
        && ismirror(n1.right,n2.left);

    }
}