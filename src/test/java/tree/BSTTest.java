package tree;

import org.junit.Test;

/**
 * @author songwb
 * @date 2019/4/12 11:34
 */
public class BSTTest {

    @Test
    public void test1() {
        BST<Integer> bst = new BST<>();
        bst.add(1);
        bst.add(10);
        bst.add(-2);

        System.out.println(bst.getRoot());


    }
}
