/**
 * Author:   80303990
 * Date:     2020/11/17 9:30
 * Description: 手写实现LRU
 */
package exercise.penghao;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LRU<T> {

    public static void main(String args[]){
        LRU<Integer> lruCache= new LRU<>(3);

        lruCache.set("key1",1);
        lruCache.set("key2",2);
        lruCache.set("key3",3);
        lruCache.set("key4",4);
        lruCache.get("key2");
        lruCache.set("key2",5);
        System.out.println(lruCache.get("key2"));
        System.out.println(lruCache.table);
    }


    public T get(String key){
        ListNode<String,T> node=table.get(key);
        //如果缓存中有，则要将节点移动到头部（设定头部时使用最频繁的）
        if(node!=null){
            //截断链表
            node.pre.post=node.post;
            node.post.pre=node.pre;
            //移动该节点到头部
            head.post.pre=node;
            node.post=head.post;
            head.post=node;
            node.pre=head;
        }
        return node.value;
    }

    public void set(String key,T value){
        ListNode<String,T> node=table.get(key);
        if(node!=null){
            //如果缓存中已经有了，直接赋新值
            node.value=value;
            //截断链表
            node.pre.post=node.post;
            node.post.pre=node.pre;
        }else {
            //缓存中没有
            //如果容量超了,删掉最后一个节点
            if(table.size()==capacity){
                ListNode<String, T> lastNode = tail.pre;
                lastNode.pre.post=lastNode.post;
                lastNode.post.pre=lastNode.pre;
                table.remove(lastNode.key);
            }
            node=new ListNode<>(key,value);
            table.put(key,node);
        }
        //将node移到头部
        head.post.pre=node;
        node.post=head.post;
        head.post=node;
        node.pre=head;

    }

    //默认容量
    private int capacity = 1024;
    //存放数据的哈希表
    private Map<String, ListNode<String, T>> table = new ConcurrentHashMap<>();
    //双向链表的头结点
    private ListNode<String, T> head;
    //双向链表的尾节点
    private ListNode<String, T> tail;

    //初始化头结点和尾节点的指向
    public LRU() {
        head = new ListNode<>();
        tail = new ListNode<>();
        head.post = tail;
        head.pre = null;
        tail.post = null;
        tail.pre = head;
    }

    public LRU(int capacity) {
        this();
        this.capacity = capacity;
    }


    //双向链表节点类
    public static class ListNode<K, V> {
        private K key;
        private V value;
        private ListNode<K, V> pre;
        private ListNode<K, V> post;

        public ListNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public ListNode() {

        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }
}