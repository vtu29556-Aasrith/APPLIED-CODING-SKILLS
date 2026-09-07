class MyCircularDeque {
    private int[] deque;
    private int front;
    private int count;
    private int capacity;

    public MyCircularDeque(int k) {
        deque = new int[k];
        front = 0;
        count = 0;
        capacity = k;
    }
    
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        front = (front - 1 + capacity) % capacity;
        deque[front] = value;
        count++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        int rearIndex = (front + count) % capacity;
        deque[rearIndex] = value;
        count++;
        return true;
    }
    
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        front = (front + 1) % capacity;
        count--;
        return true;
    }
    
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        count--;
        return true;
    }
    
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return deque[front];
    }
    
    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        int rearIndex = (front + count - 1) % capacity;
        return deque[rearIndex];
    }
    
    public boolean isEmpty() {
        return count == 0;
    }
    
    public boolean isFull() {
        return count == capacity;
    }
}