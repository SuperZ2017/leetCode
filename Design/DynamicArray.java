package Design;

import java.util.Arrays;

/**
 * 动态数组
 * @param <E>
 */
public class DynamicArray<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    private Object[] elementData;
    public DynamicArray(){
        this.elementData = new Object[DEFAULT_CAPACITY];
    }

    private void ensureCapacity(int minCapacity) {
        int oldCapacity = elementData.length;
        if (oldCapacity >= minCapacity) {
            return;
        }

        int newCapacity = oldCapacity * 2;
        if (newCapacity < minCapacity)
            newCapacity = minCapacity;
        // Arrays.copyOf 方法的返回值是新的数组对象，改变传回数组中的元素值，不会影响原来的数组，第二个值是要建立的新数组长度
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    public void add(E e) {
        ensureCapacity(size + 1);
        elementData[size++] = e;
    }

    public E get(int index) {
        return (E)elementData[index];
    }

    public int size(){
        return size;
    }

    public E set(int index, E element) {
        E oldValue = get(index);
        elementData[index] = element;
        return oldValue;
    }

    public E remove(int index) {
        E oldValue = (E) elementData[index];
        // 计算要移动元素的个数
        int numMoved = size - index - 1;
        // 将 index 前面的元素向前移动一位
        if (numMoved > 0)
            System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        elementData[--size] = null;
        return oldValue;
    }

}
