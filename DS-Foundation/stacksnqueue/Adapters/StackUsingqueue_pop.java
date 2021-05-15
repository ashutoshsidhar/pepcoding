import java.util.Queue;
import java.util.LinkedList;

public class StackUsingqueue_pop {
    Queue<Integer> que = new LinkedList<>();
    Queue<Integer> temp = new LinkedList<>();

    public int size() {
        return que.size();
    }

    public boolean isEmpty() {
        return que.isEmpty();
    }

    private void transferToAnotherQueue() {
        while(que.size() != 0){
            temp.add(que.remove());
        }
    }

    // O(n)
    public void push(int data) {
        transferToAnotherQueue();
        this.que = this.temp;
        que.add(data);
        
    }

    // O(1)
    public int peek() {
        return this.que.peek();
    }

    // O(1)
    public int pop() {
        return this.que.remove();   
    }
}