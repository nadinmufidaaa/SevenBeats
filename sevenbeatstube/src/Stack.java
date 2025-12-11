public class Stack {
    Node top;
    public void push(Video v) {
        Node baru = new Node(v);
        baru.next = top;
        top = baru;
    }
    
    public void tampilkanHistory() {
        if (top == null) {
            System.out.println("Riwayat kosong!\n");
            return;
        }
        System.out.println("Riwayat tontonan");
        Node temp = top;
        int count = 0;
        while (temp != null) {
            System.out.println((count + 1) + ". " + temp.data.judul);
            temp = temp.next;
            count++;
        }
        System.out.println();
    }
}
