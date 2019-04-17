//package array;
//
///**
// * @author songwb
// * @date 2019/4/11 11:23
// * 自定义动态数组
// */
//public class Array<E> {
//
//    /**
//     * Default initial capacity.
//     */
//    private static final int DEFAULT_CAPACITY = 10;
//
//    /**
//     * Shared empty array instance used for empty instances.
//     */
////    private static final E[] EMPTY_ELEMENTDATA = {};
//
//    /**
//     * The array buffer into which the elements of the ArrayList are stored.
//     * The capacity of the ArrayList is the length of this array buffer. Any
//     * empty ArrayList with elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA
//     * will be expanded to DEFAULT_CAPACITY when the first element is added.
//     */
//    transient private  E[] elementData;
//
//    /**
//     * The size of the ArrayList (the number of elements it contains).
//     *
//     * @serial
//     */
//    private int size;
//
//    @SuppressWarnings("unchecked")
//    public Array(int initialCapacity) {
//        if (initialCapacity > 0) {
//            this.elementData = (E[]) new Object[initialCapacity];
//        }  else {
//            throw new IllegalArgumentException("Illegal Capacity: "+
//                    initialCapacity);
//        }
//    }
//
//    public Array() {
//        this(DEFAULT_CAPACITY);
//    }
//
//    /**
//     * 获取数组的长度
//     * @return
//     */
//    public int getSize() {
//        return size;
//    }
//
//    /**
//     * 判断数组是否为空
//     * @return
//     */
//    public boolean isEmpty() {
//        return size == 0;
//    }
//}
