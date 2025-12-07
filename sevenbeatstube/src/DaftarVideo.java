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
    public void sortByJudul() {
        if (head == null) return;
        boolean swapped;
        do {
            swapped = false;
            Node temp = head;
            while (temp.next != null) {
                if (temp.data.judul.compareToIgnoreCase(temp.next.data.judul) > 0) {
                    Video swap = temp.data;
                    temp.data = temp.next.data;
                    temp.next.data = swap;
                    swapped = true;
                }
                temp = temp.next;
            }
        } while (swapped);
    }

    public void sortByDurasi() {
        if (head == null) return;
        boolean swapped;
        do {
            swapped = false;
            Node temp = head;
            while (temp.next != null) {
                if (temp.data.durasi > temp.next.data.durasi) {
                    Video swap = temp.data;
                    temp.data = temp.next.data;
                    temp.next.data = swap;
                    swapped = true;
                }
                temp = temp.next;
            }
        } while (swapped);
    }

    public void cari(String kataKunci, String tipe) {
        Node temp = head;
        boolean ada = false;
        System.out.println("Hasil pencarian \"" + kataKunci + "\":");
        while (temp != null) {
            boolean cocok = false;
            if (tipe.equals("judul") && temp.data.judul.toLowerCase().contains(kataKunci.toLowerCase())) cocok = true;
            if (tipe.equals("channel") && temp.data.channel.toLowerCase().contains(kataKunci.toLowerCase())) cocok = true;
            if (tipe.equals("genre") && temp.data.genre.equalsIgnoreCase(kataKunci)) cocok = true;

            if (cocok) {
                System.out.println("   " + temp.data.judul + " | " + temp.data.channel + " | " + temp.data.genre);
                ada = true;
            }
            temp = temp.next;
        }
        if (!ada) System.out.println("   Tidak ditemukan.\n");
        else System.out.println();
    }

    public Video cariJudul(String judul) {
        Node temp = head;
        while (temp != null) {
            if (temp.data.judul.equalsIgnoreCase(judul)) return temp.data;
            temp = temp.next;
        }
        return null;
    }

    
}
