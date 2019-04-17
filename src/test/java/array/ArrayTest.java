//package array;

import array.Array;
import org.junit.Test;

import java.util.Arrays;


/**
 * @author songwb
 * @date 2019/4/11 11:40
 */
public class ArrayTest {
    @Test
    public void test1() {
       Integer[] number = new Integer[0];
//       number[0] = 1;
        System.out.println(Arrays.toString(number));
    }
    @Test
    public void test2() {
        Array<Integer> arr = new Array<>();
       for (int i =0; i < 10; i ++) {
           arr.add(i);
           System.out.println(arr);
       }
       arr.add(10, 99);
        System.out.println(arr);


    }
    @Test
    public void test3() {
        Array<Integer> arr = new Array<>();
        for (int i =0; i < 10; i ++) {
            arr.add(i);
            System.out.println(arr);
        }
        arr.add(6, 99);
        System.out.println(arr);
        System.out.println(arr.indexOf(99));
        arr.add(null);
        System.out.println(arr.indexOf(null));

    }
    @Test
    public void testRemove() {
        Array<Integer> arr = new Array<>();
        for (int i =0; i < 10; i ++) {
            arr.add(i);
            System.out.println(arr);
        }
        arr.remove(2);
        System.out.println(arr);
        arr.removeElement(9);
        System.out.println(arr);
//        System.out.println(0%2);

    }
}
