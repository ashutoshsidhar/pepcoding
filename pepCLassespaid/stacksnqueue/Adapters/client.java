public class client {
    public static void main(String[] args) {
        StackUsingqueue_push st = new StackUsingqueue_push();
        for (int i = 1; i <= 10; i++) {
            st.push(i * 10);
        }

        while (st.size() != 0) {
            System.out.println(st.pop());
        }
    }
}