package queue;

import java.util.ArrayList;
import java.util.List;

public class QueueWithLL<T> {
    private List<T> queue_list;
    private int queue_size;

    public QueueWithLL() {
        queue_list = new ArrayList<>();
        queue_size = 0;
    }


    public boolean isEmpty() {
        return queue_size == 0;
    }

    public T front() {
        if (isEmpty()) {
            return null; // or throw an exception
        }
        return queue_list.get(0);
    }

    public T rear() {
        if (isEmpty()) {
            return null; // or throw an exception
        }
        return queue_list.get(queue_size - 1);
    }

    public int size() {
        return queue_size;
    }

    public void enqueue(T value) {
        queue_list.add(value);
        queue_size++;
    }

    public T dequeue() {
        if (isEmpty()) {
            return null; // or throw an exception
        }
        T front = queue_list.remove(0);
        queue_size--;
        return front;
    }
}
