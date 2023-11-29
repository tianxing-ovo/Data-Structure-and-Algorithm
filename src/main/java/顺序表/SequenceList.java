package 顺序表;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("unchecked")
public class SequenceList<T> {
    // 存储元素的数组
    T[] elementData;
    // 数组中元素的个数
    int size;

    public SequenceList(int capacity) {
        elementData = (T[]) new Object[capacity];
        size = 0;
    }

    @SneakyThrows
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
    }

    public boolean add(T t) {
        if (size == elementData.length) {
            int newLength = size + size / 2;
            elementData = Arrays.copyOf(elementData, newLength);
        }
        elementData[size++] = t;
        return true;
    }
}
