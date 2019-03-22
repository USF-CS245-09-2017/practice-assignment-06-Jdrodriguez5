public class ArrayStack<T> implements Stack<T> {

    int size = 10;
    T[] arr;
    int top;

    public ArrayStack() {
        arr = (T[]) new Object[size];
        top = -1;
    }

    @Override
    public void push(T t) {
        if(top == arr.length-1)
            grow_array();
        arr[++top] = t;
    }

    public void grow_array() {
        T[] temp = (T[]) new Object[arr.length*2];
        for(int i = 0; i < arr.length;i++) {
            temp[i] = arr[i]; //O(1)
        }
        arr = temp;
    }

    @Override
    public T pop() {
        return arr[top--]; // because youre taking away from the pop after you return it.
    }

    @Override
    public T peek() {
         return arr[top]; // no '--' because youre just giving them a copy.
    }

    @Override
    public boolean empty() {
        if (top == -1)
            return true;
        return false;
    }
}
