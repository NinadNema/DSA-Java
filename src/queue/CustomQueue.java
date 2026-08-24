package queue;

public class CustomQueue {
    protected int[] data;

    private static final int DEFAULT_SIZE = 10;

    public CustomQueue() {
        this(DEFAULT_SIZE);
    }

    public CustomQueue(int size){
        this.data = new int[size];
    }

    public int end = -1;
    private boolean isFull() {
        return end == data.length - 1;
    }

    private boolean isEmpty(){
        return end == -1;
    }

    public boolean push(int item){
        if(isFull()){
            System.out.println("Queue Is Full.");
            return false;
        }
        end++;
        data[end] = item;

        return true;
    }

    public int remove() throws Exception{
        if(isEmpty()){
            throw new Exception("Queue is Empty. ");
        }

        int removed = data[0];
        for (int i = 1; i < end; i++) {
            data[i - 1] = data[i];
        }
        end--;
        return removed;
    }

    public int front() throws Exception{
        if(isEmpty()){
            throw new Exception("Queue is Empty.");
        }
        return data[0];
    }
}
