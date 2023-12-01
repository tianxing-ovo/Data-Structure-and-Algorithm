package 链表;

/**
 * 节点
 */
public class Node<T> {

    public T item; // 元素

    public Node<T> next; // 下一个节点

    public Node(T item, Node<T> next) {
        this.item = item;
        this.next = next;
    }
}