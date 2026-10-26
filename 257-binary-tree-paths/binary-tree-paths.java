class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans= new ArrayList<>();
        if(root==null) return ans;

        dfs(root,"",ans);
        return ans;
    }
    public void dfs(TreeNode root,String path,List<String> ans){
        if(root==null){
            return;
        }
        if(path.isEmpty()){
            path=""+root.val;
        }else{
            path+= "->"+root.val;
        }
        if(root.left==null && root.right==null){
            ans.add(path);
            return;
        }
        dfs(root.left,path,ans);
        dfs(root.right,path,ans);
    }
}