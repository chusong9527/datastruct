package stack;

import array.Array;

/**
 * @author songwb
 * @date 2019/4/11 17:01
 */
public class Stack<E> {

    private Array<E> data;

    public Stack() {
        data = new Array<>();
    }

    public boolean empty() {
        return data.isEmpty();
    }

    public void push(E e) {
         data.add(e);
    }

    public E pop() {
        return data.removeLast();
    }

    public E peek() {
        return data.get(data.getSize()-1);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        if (data == null || data.getSize() == 0) {
            return "[]";
        } else {
            s.append("[");
            for (int i = 0; i < data.getSize(); i ++) {
                s.append(String.valueOf(data.get(i)));
                if (i == data.getSize()-1) {
                    s.append("] top" );
                }
                s.append(",");
            }
        }
        return s.toString();
    }
}
