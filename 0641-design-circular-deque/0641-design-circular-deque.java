class MyCircularDeque {
    private int front, rear, size, cap;
    private int[] arr;

    public MyCircularDeque(int k) {
        arr = new int[k];
        this.cap = k;
        front = -1;
        rear = -1;
        size = 0;
    }
    
    public boolean insertFront(int value) {
        if (isFull()) return false;
        
        if (isEmpty()) {
            front = rear = 0; 
        } else if (front == 0) {
            front = cap - 1; 
        } else {
            front--;       
        }
        
        arr[front] = value;
        size++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if (isFull()) return false;
        
        if (isEmpty()) {
            front = rear = 0; 
        } else if (rear == cap - 1) {
            rear = 0;         
        } else {
            rear++;      
        }
        
        arr[rear] = value;
        size++;
        return true;
    }
    
    public boolean deleteFront() {
        if (isEmpty()) return false;
        
        if (size == 1) {
            front = rear = -1; 
        } else if (front == cap - 1) {
            front = 0;         
        } else {
            front++;          
        }
        
        size--;
        return true;
    }
    
    public boolean deleteLast() {
        if (isEmpty()) return false;
        
        if (size == 1) {
            front = rear = -1;
        } else if (rear == 0) {
            rear = cap - 1;    
        } else {
            rear--;            
        }
        
        size--;
        return true;
    }
    
    public int getFront() {
        if (isEmpty()) return -1;
        return arr[front];
    }
    
    public int getRear() {
        if (isEmpty()) return -1;
        return arr[rear];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == cap;
    }
}