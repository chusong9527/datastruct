package queque;

import array.Array;

/**
 * @author songwb
 * @date 2019/4/11 17:45
 */
public class ArrayQueue<E> implements Queue<E> {

    private Array<E> data;

    public ArrayQueue() {
        this.data = new Array<>();
    }

    @Override
    public void enQueue(E e) {
        data.add(e);
    }

    @Override
    public E deDeque() {
        return data.removeFirst();
    }

    public E peek() {
        return data.get(0);
    }
    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        if (data == null || data.getSize() == 0) {
            return "[]";
        } else {
            s.append("head [");
            for (int i = 0; i < data.getSize(); i ++) {
                s.append(String.valueOf(data.get(i)));
                if (i == data.getSize()-1) {
                    s.append("] tail" );
                }
                s.append(",");
            }
        }
        return s.toString();

    }

}
