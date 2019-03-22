import java.util.ArrayList;

public class ArrayQueue<T> implements Queue<T> {

    int head;
    T[] arr;
    int size = 0;
    int tail;


    public ArrayQueue() {
        arr = (T[]) new Object[10];
        head = 0;
        tail = 0;
    }


    @Override
    public T dequeue() {
       T temp = arr[head];
       head = (head+1)% arr.length;
       size--;
       return temp;
    }

    @Override
    public void enqueue(T t) {
        if((head+1) % arr.length == tail){
            grow_array();
        }
        arr[tail++] = t;
        tail = tail % arr.length;
        size++;
    }

    public void grow_array() {
        T[] temp = (T[]) new Object[arr.length*2];
        for(int i = head, j = 0; i < arr.length;i++, j++)
            temp[j] = arr[i%temp.length];
        arr = temp;
        head = 0;
        tail = size;
    }

    @Override
    public boolean empty() {
        if(head == tail)
            return true;
        return false;
    }
}
