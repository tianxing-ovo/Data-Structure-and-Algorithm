package 链表;

import com.sun.istack.internal.NotNull;

import java.util.Iterator;

/**
 * 单向链表
 */
public class SinglyLinkedList<T> implements Iterable<T> {
    private final Node<T> head; // 头节点

    private int size; // 节点数量

    public SinglyLinkedList() {
        head = new Node<>(null, null);
    }

    /**
     * 清空链表
     */
    public void clear() {
        head.next = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 获取指定位置处的元素
     */
    public T get(int index) {
        return getNode(index).item;
    }

    /**
     * 获取指定位置处的节点
     */
    public Node<T> getNode(int index) {
        Node<T> node = head.next;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    /**
     * 添加节点
     */
    public void insert(T item) {
        Node<T> last = getLast();
        last.next = new Node<>(item, null);
        size++;
    }

    /**
     * 指定位置处添加节点
     */
    public void insert(int index, T item) {
        // 找到前一个节点和当前节点
        Node<T> pre = getNode(index - 1);
        Node<T> cur = pre.next;
        pre.next = new Node<>(item, cur);
        size++;
    }

    /**
     * 删除指定位置处的节点,并返回被删除的元素
     */
    public T remove(int index) {
        Node<T> pre = getNode(index - 1);
        Node<T> cur = pre.next;
        pre.next = cur.next;
        cur.next = null;
        size--;
        return cur.item;
    }

    /**
     * 查找元素t第一次出现的位置
     */
    public int indexOf(T item) {
        Node<T> node = head;
        for (int i = 0; node.next != null; i++) {
            node = node.next;
            if (node.item == item) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 获取最后一个节点
     */
    public Node<T> getLast() {
        Node<T> node = head;
        while (node.next != null) {
            node = node.next;
        }
        return node;
    }

    /**
     * 遍历链表
     */
    @NotNull
    @Override
    public Iterator<T> iterator() {

        return new Iterator<T>() {

            Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node.next != null;
            }

            @Override
            public T next() {
                node = node.next;
                return node.item;
            }
        };
    }
}
