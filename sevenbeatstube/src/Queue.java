public class Queue{
    Node front, rear;

    public void enqueue(Video v) {
        Node baru = new Node(v);
        if (rear == null) {
            front = rear = baru;
        } else {
            rear.next = baru;
            rear = baru;
        }
    }

    public Video dequeue() {
        if (front == null) return null;
        Video v = front.data;
        front = front.next;
        if (front == null) rear = null;
        return v;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void tampilkan() {
        if (front == null) {
            System.out.println("Up Next kosong!\n");
            return;
        }
        System.out.println("Up Next:");
        Node temp = front;
        int i = 1;
        while (temp != null) {
            System.out.println(i++ + ". " + temp.data.judul);
            temp = temp.next;
        }
        System.out.println();
    }
}