package queue;

import org.junit.Test;
import queque.ArrayQueue;

/**
 * @author songwb
 * @date 2019/4/11 17:51
 * 测试循环队列
 */
public class TestQueue {
    @Test
    public void test1() {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        for (int i =10; i < 20; i++) {
            queue.enQueue(i);
            System.out.println(queue);
        }
        System.out.println(queue.deDeque());
        System.out.println(queue.deDeque());
        System.out.println(queue);
        System.out.println(queue.peek());
    }
}
