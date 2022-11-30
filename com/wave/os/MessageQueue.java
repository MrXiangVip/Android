
/*
 源码路径
 frameworks/base/core/java/android/os/MessageQueue.java
 */
package com.wave.os;

import java.util.*;

public class MessageQueue implements Queue {


    Queue<Message>  queue;

    MessageQueue(){
         System.out.println("MessageQueue 构造函数");
         queue = new LinkedList();
    }
    @Override
    public int size() {
        return  queue.size();
    }

    @Override
    public boolean isEmpty() {
        if( queue.size()==0){
            return  true;
        }else{
            return false;
        }
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public Object[] toArray(Object[] objects) {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        System.out.println("add ");
        if( Message.class.isInstance(o)){
            queue.add((Message) o);
            System.out.println("current size "+queue.size());
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean remove(Object o) {
        if( Message.class.isInstance(o)){
            queue.remove(o);
        }else{
            return false;
        }
        return true;
    }

    @Override
    public boolean addAll(Collection collection) {
        return false;
    }

    @Override
    public void clear() {
        queue.clear();
    }

    @Override
    public boolean retainAll(Collection collection) {
        return false;
    }

    @Override
    public boolean removeAll(Collection collection) {
        return false;
    }

    @Override
    public boolean containsAll(Collection collection) {
        return false;
    }

    @Override
    public boolean offer(Object o) {
        System.out.println("off ");
        if( Message.class.isInstance(o)){
            queue.offer((Message) o);

        }else{
            return  false;
        }
        return true;
    }

    @Override
    public Message remove() {
        Message msg = queue.remove();
        return msg;
    }

    @Override
    public Message poll() {
        System.out.println("poll ");
        Message msg = queue.poll();
        return msg;
    }

    @Override
    public Message element() {
        Message msg = queue.element();
        return msg;
    }

    @Override
    public Message peek() {
        System.out.println("peek ");
        Message msg = queue.peek();
        return msg;
    }
}
