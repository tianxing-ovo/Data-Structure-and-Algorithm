package 链表;

import com.sun.istack.internal.NotNull;

import java.util.Iterator;

/**
 * 双向链表
 */
public class DoublyLinkedList<T> implements Iterable<T> {

    Node<T> head; // 头节点
    Node<T> tail; // 尾节点
    int size; // 节点个数

    public DoublyLinkedList() {
        head = new Node<>(null, null, null);
        tail = new Node<>(null, null, null);
        head.next = tail;
        tail.pre = head;
    }

    /**
     * 清空链表
     */
    public void clear() {
        head.next = null;
        tail.pre = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 获取第一个元素
     */
    public T getFirst() {
        if (isEmpty()) {
            return null;
        }
        return head.next.item;
    }

    /**
     * 获取最后一个元素
     */
    public T getLast() {
        if (isEmpty()) {
            return null;
        }
        return tail.pre.item;
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
        if (index == -1) {
            return head;
        }
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
        Node<T> pre = tail.pre;
        Node<T> node = new Node<>(item, pre, tail);
        pre.next = node;
        tail.pre = node;
        size++;
    }

    /**
     * 指定位置处添加节点
     */
    public void insert(int index, T item) {
        // 找到前一个节点和当前节点
        Node<T> pre = getNode(index - 1);
        Node<T> cur = pre.next;
        Node<T> node = new Node<>(item, pre, cur);
        pre.next = node;
        cur.pre = node;
        size++;
    }

    /**
     * 删除指定位置处的节点,并返回被删除的元素
     */
    public T remove(int index) {
        Node<T> pre = getNode(index - 1);
        Node<T> cur = pre.next;
        Node<T> next = cur.next;
        cur.pre = null;
        cur.next = null;
        pre.next = next;
        next.pre = pre;
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
            if (node.item.equals(item)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 遍历链表
     */
    @NotNull
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> node = head;
            int index;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public T next() {
                node = node.next;
                index++;
                return node.item;
            }
        };
    }

    /**
     * 节点
     */
    private static class Node<T> {
        T item; // 元素
        Node<T> pre; // 上一个节点
        Node<T> next; // 下一个节点

        public Node(T item, Node<T> pre, Node<T> next) {
            this.item = item;
            this.pre = pre;
            this.next = next;
        }
    }
}
