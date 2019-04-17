package queque;

/**
 * @author songwb
 * @date 2019/4/11 17:41
 * 自定义队列接口
 */
public interface Queue<E> {

    void enQueue(E e);

    E deDeque();

    boolean isEmpty();
}
