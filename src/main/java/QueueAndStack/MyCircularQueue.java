package QueueAndStack;

public class MyCircularQueue {
    int[] arr;
    int front = 0;      //队头
    int rear = 0;       //队尾
    int maxsize;        //容量
    public MyCircularQueue(int k) {
        arr = new int[k + 1];
        maxsize = k + 1;
    }

    public boolean enQueue(int value) {
        if ((rear + 1) % maxsize != front) {
            arr[rear] = value;
            rear = (rear + 1) % maxsize;
            return true;
        }
        return false;

    }

    public boolean deQueue() {
        if (front != rear) {
            front = (front + 1) % maxsize;
            return true;
        }
        return false;
    }

    public int Front() {
        if (rear == front) return -1;
        return arr[front];
    }

    public int Rear() {
        if (rear == front) return -1;
        if (rear == 0) return arr[maxsize - 1];
        return arr[rear - 1];
    }

    public boolean isEmpty() {
        if (rear == front) return true;
        return false;
    }

    public boolean isFull() {
        if ((rear + 1) % maxsize == front) return true;
        return false;
    }
}
