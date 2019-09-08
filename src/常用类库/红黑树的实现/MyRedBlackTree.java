package 常用类库.红黑树的实现;

import java.util.Arrays;
import java.util.Random;

/**
 * @author : S K Y
 * @version :0.0.1
 */

enum Color {
    RED, BLACK
}

class BinaryTree<T extends Comparable> {
    private Node root;          //根节点
    private int count;
    private int foot;       //转化为数组时的脚标
    private Object[] array;

    private class Node {
        private T data;
        private Node parent;    //当前节点的父节点,如果未根节点,则为null
        private Node left;      //当前节点的左子节点
        private Node right;     //当前节点的右子节点
        private Color color;    //当前节点的颜色

        private Node(T data, Node parent, Node left, Node right, Color color) {
            this.data = data;
            this.parent = parent;
            this.left = left;
            this.right = right;
            this.color = color;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", color=" + color +
                    '}';
        }

        /**
         * 向数组中添加数据
         */
        private void addToArray() {
            if (this.left != null) {
                this.left.addToArray();
            }
            System.out.println(foot + " " + this.data + " " + this.color + " " + this.parent + " " + this.left + " " + this.right);
            BinaryTree.this.array[BinaryTree.this.foot++] = this.data;
            if (this.right != null) {
                this.right.addToArray();
            }
        }
    }

    /**
     * 插入新节点时获取其父节点
     *
     * @param data       当前新增的数据
     * @param parentNode 当前的暂定父节点
     * @return 最终父节点
     */
    private Node getParentNode(Comparable<T> data, Node parentNode) {
        Node preParentNode = parentNode;        //用来记录当前的父节点
        if (data.compareTo(parentNode.data) <= 0) {    //当前的节点比这个暂定的父节点小
            parentNode = parentNode.left;
        } else {
            parentNode = parentNode.right;
        }
        if (parentNode == null) return preParentNode;
        return getParentNode(data, parentNode);
    }

    /**
     * 插入数据节点
     *
     * @param data 当前所需要插入的数据
     */
    public void add(Comparable<T> data) {
        if (data == null) return;
        if (this.root == null) {      //当前不存在根节点
            //当前插入的节点为根节点,默认为红色,但是这样违反了红黑树规则,改变为黑色
            this.root = new Node((T) data, null, null, null, Color.BLACK);
        } else { //当前已经存在根节点
            Node parentNode = getParentNode(data, root);    //得到插入节点的父节点
            if (parentNode.equals(root)) {      //直接作为根节点的子节点进行插入
                if (data.compareTo(parentNode.data) <= 0) {
                    parentNode.left = new Node((T) data, parentNode, null, null, Color.RED);
                } else {
                    parentNode.right = new Node((T) data, parentNode, null, null, Color.RED);
                }
            } else {        //此时对于插入节点而言将会存在父节点和祖父节点
                Node uncleNode = null;
                if ((parentNode.data.compareTo(parentNode.parent.data) <= 0)) { //在左侧插入
                    uncleNode = parentNode.parent.right;      //当前的叔叔节点
                } else {
                    uncleNode = parentNode.parent.left;      //当前的叔叔节点
                }
                if (parentNode.color == Color.RED && (uncleNode != null && uncleNode.color == Color.RED)) {
                    //插入平衡规则1:插入节点的父节点和叔叔节点都为红
                    if (data.compareTo(parentNode.data) <= 0) {
                        parentNode.left = new Node((T) data, parentNode, null, null, Color.RED);
                    } else {
                        parentNode.right = new Node((T) data, parentNode, null, null, Color.RED);
                    }
                    if (parentNode.parent.color == Color.BLACK) parentNode.parent.color = Color.RED;
                    parentNode.color = Color.BLACK;
                    uncleNode.color = Color.BLACK;
                } else if (parentNode.color == Color.RED && (uncleNode == null || uncleNode.color == Color.BLACK)) {
                    //插入平衡规则2:插入节点的父节点为红色,叔叔节点是黑色,且插入节点是父节点的左子节点()
                    //若插入节点的父节点是祖父节点的右节点,那么插入节点是父节点的右子节点
                    //插入节点的父节点是祖父节点的左节点时左侧插入,插入节点的父节点是祖父节点的右节点时右侧插入
                    Node preParent = parentNode.parent;
                    T prePatentData = preParent.data;
                    boolean isleft = parentNode.data.compareTo(preParent.data) <= 0 ? true : false;
                    if ((parentNode.data.compareTo(preParent.data) <= 0 && data.compareTo(parentNode.data) <= 0) ||
                            (parentNode.data.compareTo(preParent.data) > 0 && data.compareTo(parentNode.data) > 0)) {
                        preParent.data = parentNode.data;
                        parentNode.data = (T) data;
                    } else {
                        //插入平衡操作规则3:插入节点的父节点是祖父节点的左节点时右侧插入,插入节点的父节点是祖父节点的右节点时左侧插入
                        preParent.data = (T) data;
                    }
                    if (isleft) {
                        preParent.right = new Node(prePatentData, preParent, null, uncleNode, Color.RED);
                        if (uncleNode != null) uncleNode.parent = preParent.right;
                    } else {
                        preParent.left = new Node(prePatentData, preParent, uncleNode, null, Color.RED);
                        if (uncleNode != null) uncleNode.parent = preParent.left;
                    }
                } else {
                    if (data.compareTo(parentNode.data) <= 0) {
                        parentNode.left = new Node((T) data, parentNode, null, null, Color.RED);
                    } else {
                        parentNode.right = new Node((T) data, parentNode, null, null, Color.RED);
                    }
                }
            }
        }
        count++;
    }

    /**
     * 获取二叉树的数量
     *
     * @return 二叉树的数量
     */
    public int getCount() {
        return count;
    }

    public Object[] toArray() {
        if (count == 0) return null;
        this.foot = 0;
        this.array = new Object[count];
        this.root.addToArray();
        return this.array;
    }
}

public class MyRedBlackTree {
    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();
        Random random = new Random();
        tree.add(96);
        tree.add(98);
        tree.add(8);
        tree.add(22);
        tree.add(76);
        tree.add(3);
//        tree.add(86);
//        tree.add(79);
//        tree.add(70);
//        tree.add(57);
        Object[] objects = tree.toArray();
        System.out.println(Arrays.toString(objects));
    }
}
