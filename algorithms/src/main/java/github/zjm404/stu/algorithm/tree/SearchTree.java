package github.zjm404.stu.algorithm.tree;

/**
 * @author zjm
 * @date 2020/12/24
 */
public class SearchTree<T> {

    private TreeNode<T> root;

    private int size;

    public class TreeNode<T>{
        private T val;
        private TreeNode<T> left;
        private TreeNode<T> right;
    }

    public int getSize(){
        return size;
    }


}
