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
 */
class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        int [] in=Arrays.copyOf(preorder,preorder.length);
        Arrays.sort(in);
        int n=in.length;
        return build(0,n-1,0,n-1,in,preorder);
    }
    public static TreeNode build(int prelo,int prehi,int inlo,int inhi, int inorder[] , int preorder[]){
    if(prelo>prehi || inlo>inhi) return null;
    int val=preorder[prelo];

    TreeNode root=new TreeNode(val);
    int r=0;

    for(int i=inlo;i<=inhi;i++){
        if(inorder[i]==val){
            r=i;
            break;
        }

    }
    int cnt=r-inlo;
    root.left=build(prelo+1,prelo+cnt,inlo,r-1,inorder,preorder);
    root.right=build(prelo+cnt+1,prehi,r+1,inhi,inorder,preorder);
    return root;
    }
}
        

