public class Stack {
    Node top;

    public void push(Video v) {
        Node baru = new Node(v);
        baru.next = top;
        top = baru;
    }

    public Video pop() {
        if (top == null) return null;
        Video v = top.data;
        top = top.next;
        return v;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void tampilkanHistory() {
        if (top == null) {
            System.out.println("Riwayat kosong!\n");
            return;
        }
        System.out.println("Riwayat tontonan (terbaru di atas, max 5):");
        Node temp = top;
        int count = 0;
        while (temp != null && count < 5) {
            System.out.println((count + 1) + ". " + temp.data.judul);
            temp = temp.next;
            count++;
        }
        System.out.println();
    }
}