package main.queue;

/**
 * @author jitendra.kumar01
 * 01/02/20
 */
public class FixedSizeCircularArrayQueue<T> {
    private T[] queue;
    private int size, rear, front;
    private int capacity;

    public FixedSizeCircularArrayQueue(int capacity, T[] queue) {
        this.queue = queue;
        this.capacity = capacity;
    }

    public boolean isFull() {
        return (size == capacity);
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public void enQueue(T data) {
        if (isFull())
            throw new IllegalStateException("Queue is Full : Overflow");
        queue[rear] = data;
        rear = (rear + 1) % capacity;

    }

    public T deQueue() {
        if (isEmpty())
            throw new IllegalStateException("Queue is Empty : Underflow");
        T data = queue[front % capacity];
        front = (front + 1) % capacity;
        return data;
    }
}

