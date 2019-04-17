package array;



/**
 * @author songwb
 * @date 2019/4/11 11:23
 * 自定义动态数组
 */
public class Array<E> {

    /**
     * Default initial capacity.
     */
    private  static final int DEFAULT_CAPACITY = 10;



    /**
     * The array buffer into which the elements of the ArrayList are stored.
     * The capacity of the ArrayList is the length of this array buffer. Any
     * empty ArrayList with elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA
     * will be expanded to DEFAULT_CAPACITY when the first element is added.
     */
    transient private   E[] elementData;

    /**
     * The size of the ArrayList (the number of elements it contains).
     *
     * @serial
     */
    private int size;

    @SuppressWarnings("unchecked")
    public Array(int initialCapacity) {
        if (initialCapacity >= 0) {
            this.elementData = (E[]) new Object[initialCapacity];
            this.size = 0;
        }  else {
            throw new IllegalArgumentException("Illegal Capacity: "+
                    initialCapacity);
        }
    }

    public Array() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * 获取数组的长度
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 判断数组是否为空
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 指定索引插入元素
     * @param index
     * @param element
     */
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        if (size == elementData.length) {
            resize(size  + size >> 2);
        }
        System.arraycopy(elementData, index, elementData, index + 1,
                size - index);
        elementData[index] = element;
        size += 1;
    }

    /**
     * 像最后一个位置添加元素
     * @param element
     */
    public void add(E element) {
        if (size == elementData.length) {
            resize(size  * 2  );
        }
        elementData[size] = element;
        size += 1;
    }


    /**
     * 获取一个下标数据
     * @param index
     * @return
     */
    public E get(int index) {
        if (index <0 || index >= size) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }

        return elementData[index];
    }

    /**
     * 覆盖值
     * @param index
     * @param element
     * @return
     */
    public E set(int index, E element) {
        if (index <0 || index >= size) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
        E oldValue = elementData[index];
        elementData[index] = element;
        return oldValue;
    }

    /**
     * 查找元素的索引
     * @param element
     * @return
     */
    public int indexOf(E element) {
        if (element == null) {
            for (int i = 0; i < size; i ++) {
                if (null == elementData[i]) {
                    return i;
                }
            }
        }
        else {
            for (int i = 0; i < size; i ++) {
                if (element.equals(elementData[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * 根据索引删除元素
     * @param index
     * @return
     */
    public E remove(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
        E element = elementData[index];
        System.arraycopy(elementData, index+1, elementData, index, size -index -1);
        elementData[size-1] = null;//clear to let GC do its work
        size -= 1;

        //缩容
        if (size > 1 && size == elementData.length/4 && size % 2 == 0 ) {
            resize(elementData.length/2);
        }

        return element;
    }

    /**
     * 根据元素值删除元素
     * @param element
     * @return
     */
    public E removeElement(E element) {

       return  remove(indexOf(element));

    }

    /**
     * 删除第一个元素
     * @return
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 删除最后一个元素
     * @return
     */
    public E removeLast() {
        return remove(size-1);
    }

    @SuppressWarnings("unchecked")
    private void resize(int newCapacity) {
        if (newCapacity <= 0 ) {
            throw new IllegalArgumentException("illegalArgument newCapacity: " + newCapacity);
        }
        E[] newElementData = (E[]) new Object[newCapacity];
        System.arraycopy(elementData, 0, newElementData, 0,
                Math.min(elementData.length, newElementData.length));
        elementData = newElementData;

    }

    /**
     * A version of rangeCheck used by add and addAll.
     */
    private void rangeCheckForAdd(int index) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    /**
     * Constructs an IndexOutOfBoundsException detail message.
     * Of the many possible refactorings of the error handling code,
     * this "outlining" performs best with both server and client VMs.
     */
    private String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+size;
    }

    @Override
    public String toString() {
        if (elementData == null)
            return "null";

        int iMax = size - 1;
        if (iMax == -1)
            return "[]";

        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0;i <= iMax ; i++) {
            b.append(String.valueOf(elementData[i]));
            if (i == iMax)
                return b.append("]" + " size is " + size).toString();
            b.append(", ");
        }

        return b.toString();
    }
}
