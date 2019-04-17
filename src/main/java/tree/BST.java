package tree;

import queque.ArrayQueue;
import stack.Stack;

/**
 * @author songwb
 * @date 2019/4/12 10:55
 * 自定义二分搜索树:
 * 1.每个节点的左子树的值都小于本节点的值
 * 2.每个节点的右子树的值都大于本节点的值
 * 本BST不包含重复元素的值
 */
public class BST<E extends Comparable<E>> {

    /**
     * 树的节点
     */
    private class Node {

        E e;
        //左孩子
        Node left;
        //右孩子
        Node right;

        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
        }

        public Node(E e, Node left, Node right) {
            this.e = e;
            this.left = left;
            this.right = right;
        }

        public E getE() {
            return e;
        }


    }

    //根节点
    private Node root;

    //节点个数
    private int size;

    public BST() {

    }

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return  this.size == 0;
    }

    public Node getRoot() {
        return root;
    }

    /**
     * 添加节点
     * @param e
     */
    public void add(E e) {
       root = add(root, e);
    }

    /**
     * 递归插入元素：
     * 1. 最后一个步骤
     * 2. 拆解成一个小步骤
     * @param node
     * @param e
     */
    private void addElement(Node node, E e) {
        if (null == e) {
            return;
        }
        if (e.compareTo(node.e) == 0 ) {
            return;
        } else if (e.compareTo(node.e) < 0 && node.left == null) {
            node.left = new Node(e);
        } else if (e.compareTo(node.e) > 0 && node.right == null) {
            node.right = new Node(e);
        }

        if (e.compareTo(node.e) < 0) {
            addElement(node.left, e);
        } else {
            addElement(node.right, e);
        }
    }

    /**
     * 向以node为根的二分搜索树中插入元素e,优化的递归算法
     * 返回插入新节点后二分搜索树的根
     * @param node
     * @return
     */
    private Node add(Node node, E e) {
        if (node == null) {
            node = new Node(e);
            size += 1;
            return node;
        }
        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }
        return node;
    }

    /**
     * 是否包含元素
     * @param e
     * @return
     */
    public boolean contains(E e) {
       return contains(root, e);
    }

    private boolean contains(Node node, E e) {

        if (node == null) {
            return false;
        }

        if (e.compareTo(node.e) == 0) {
            return true;
        } else if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 非递归实现前序遍历：
     * 用栈来实现
     */
    public void preOrderNR() {
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.empty()) {
            Node node = stack.pop();
            System.out.println(node.e);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.right != null) {
                stack.push(node.left);
            }
        }
    }

    /**
     * 中序遍历
     */
    public void middOrder() {
        middOrder(root);
    }

    private void middOrder(Node node) {
        if (node == null) {
            return;
        }
        middOrder(node.left);
        System.out.println(node.e);
        middOrder(node.right);
    }

    /**
     * 中序遍历（非递归操作）
     *
     *
     */
    public void middOrderNR() {
        Stack<Node> stack = new Stack<>();
        Node nod = root;
        while (!stack.empty() || nod != null) {
            while (nod != null) {
                stack.push(nod);
                nod = nod.left;
            }
            Node sNode = stack.pop();
            System.out.println(sNode.getE());
            nod = sNode.right;
        }
    }


    /**
     * 后序遍历
     * 可以用于释放内存
     */
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }
    /**
     * 后序遍历（非递归操作）
     *
     *
     */
    private void postOrderOne() {
        Stack<Node> stack = new Stack<>();
        Node nod = root;
        Node pre = null;
        while (!stack.empty() || nod != null) {
            while (nod != null) {
                stack.push(nod);
                nod = nod.left;
            }
            Node sNode = stack.peek();
            if (sNode.right == null || pre == sNode.right) {
                stack.pop();
                pre = sNode;
                System.out.print(sNode.getE() + " ");
            } else {
                nod = sNode.right;
            }
        }
    }

    /**
     * 层次遍历
     * 广度优先遍历
     * 常用于算法设计中求最短路径
     */
    public void levelOrder() {
        ArrayQueue<Node> queue = new ArrayQueue<>();
        queue.enQueue(root);
        while (!queue.isEmpty()) {
            Node cur = queue.deDeque();
            System.out.println(cur.getE());
            if (cur.left != null) {
                queue.enQueue(cur.left);
            }
            if (cur.right != null) {
                queue.enQueue(cur.right);
            }
        }
    }

    /**
     * 寻找二分搜索树中最小的元素
     * @return
     */
    public E miniItem() {
        if (isEmpty()) {
            throw new IllegalArgumentException("BST is empty!");
        }
        return miniItem(root);
    }

    public E miniItem(Node node) {
        if (node.left == null) {
            return node.e;
        }
        return miniItem(node.left);
    }

    /**
     * 寻找二分搜索树中最大的元素
     * @return
     */
    public E maxItem() {
        if (isEmpty()) {
            throw new IllegalArgumentException("BST is empty!");
        }
        return maxItem(root);
    }

    public E maxItem(Node node) {
        if (node.right == null) {
            return node.e;
        }
        return maxItem(node.right);
    }

    /**
     * 删除最小元素
     * @return
     */
    public E romveMini() {
       E mini = miniItem();
       root = removeMini(root);
       return mini;
    }

    /**
     * 删除掉以node为根的二分搜索树中最小节点
     * 返回新二分搜索树的根
     * @param node
     * @return
     */
    private Node removeMini(Node node) {
        //处理递归到底的情况
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size -= 1;
            return rightNode;
        }
        node.left = removeMini(node.left);
        return node;
    }

    /**
     * 删除最大节点
     * @return
     */
    public E romveMax() {
        E max = maxItem();
        root = removeMax(root);
        return max;
    }

    /**
     * 删除掉以node为根的二分搜索树中最大节点
     * 返回新二分搜索树的根
     * @param node
     * @return
     */
    private Node removeMax(Node node) {
        //处理递归到底的情况
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size -= 1;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }


    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        int [] arrs = {28, 16, 30, 13, 22, 29, 42};
        for (Integer value: arrs) {
            bst.add(value);
        }
        System.out.println("前序遍历==================");
        bst.preOrder();
        System.out.println("前序遍历==================");

        System.out.println("非递归前序遍历==================");
        bst.preOrderNR();
        System.out.println("非递归前序遍历==================");

        System.out.println("中序遍历==================");
        bst.middOrder();
        System.out.println("中序遍历==================");

        System.out.println("非递归中序遍历==================");
        bst.middOrderNR();
        System.out.println("非递归中序遍历==================");

        System.out.println("后序遍历==================");
        bst.postOrder();
        System.out.println("后序遍历==================");

        System.out.println("is contained 30 ==     " + bst.contains(30));
        System.out.println("is contained 14 ==     " + bst.contains(14));

        System.out.println("层次遍历==================");
        bst.levelOrder();
        System.out.println("层次遍历==================");

        System.out.println("bst mini value  " + bst.miniItem());
        System.out.println("bst max value  " + bst.maxItem());
    }

}
