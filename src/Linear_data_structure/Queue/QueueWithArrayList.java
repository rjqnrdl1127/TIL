package Linear_data_structure.Queue;

import java.util.ArrayList;

public class QueueWithArrayList {
    ArrayList list;

    QueueWithArrayList() {
        this.list = new ArrayList();
    }

    public boolean isEmpty() {
        if (this.list.size() == 0) return true;
        else return false;
    }

    public void push(Object data) {
        this.list.add(data);
    }

    public Object pop() {
        if (this.isEmpty()) {
            System.out.println("데이터가 없습니다.");
            return null;
        }

        Object data = this.list.get(0);
        this.list.remove(0);
        return data;
    }

    public Object peek() {
        if (this.isEmpty()) {
            System.out.println("데이터가 없습니다.");
            return null;
        }

        return this.list.get(0);
    }

    public void printQueue() {
        System.out.println(this.list);
    }

    public static void main(String[] args) {
        QueueWithArrayList queue = new QueueWithArrayList();
        queue.push(1);
        queue.push(0.1);
        queue.push("가나다라");
        queue.printQueue();

        System.out.println(queue.peek());

        System.out.println(queue.pop());
        queue.printQueue();

        queue.pop();
        queue.printQueue();

    }
}
