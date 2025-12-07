public class DaftarVideo {
    Node head;

    public void tambah(Video v) {
        Node baru = new Node(v);
        if (head == null) {
            head = baru;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = baru;
        }
    }

    public void hapus(String judul) {
        if (head == null) return;
        if (head.data.judul.equalsIgnoreCase(judul)) {
            head = head.next;
            return;
        }
        Node temp = head;
        while (temp.next != null && !temp.next.data.judul.equalsIgnoreCase(judul)) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    public void tampilkanSemua() {
        if (head == null) {
            System.out.println("Daftar video kosong!\n");
            return;
        }
        Node temp = head;
        int no = 1;
        while (temp != null) {
            System.out.println(no++ + ". " + temp.data.judul + " | " + temp.data.channel +
                    " | " + temp.data.durasi + " menit | " + temp.data.view + " views | " + temp.data.genre);
            temp = temp.next;
        }
        System.out.println();
    }

    public void sortByView() {
        if (head == null) return;
        boolean swapped;
        do {
            swapped = false;
            Node temp = head;
            while (temp.next != null) {
                if (temp.data.view < temp.next.data.view) {
                    Video swap = temp.data;
                    temp.data = temp.next.data;
                    temp.next.data = swap;
                    swapped = true;
                }
                temp = temp.next;
            }
        } while (swapped);
    }

    
}