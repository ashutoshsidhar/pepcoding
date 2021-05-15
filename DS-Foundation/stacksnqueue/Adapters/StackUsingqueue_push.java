import java.util.Queue;
import java.util.LinkedList;

public class StackUsingqueue_push {
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

    // O(1)
    public void push(int data) {
        que.add(data);
    }

    // O(1)
    public int peek() {
        return this.que.peek();

    }

    // O(n)
    public int pop() {
        int Rem = this.que.remove();
        transferToAnotherQueue();
        this.que = this.temp;
        return Rem;
    }
}