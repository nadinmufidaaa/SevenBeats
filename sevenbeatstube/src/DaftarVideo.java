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

        System.out.printf("%-5s %-30s %-20s %-10s %-12s %-10s\n",
                "No", "Judul", "Channel", "Durasi", "View", "Genre");
        System.out.println("---------------------------------------------------------------------------------------------");

        while (temp != null) {
            System.out.printf("%-5s %-30s %-20s %-10s %-12s %-10s\n",
                    (no++) + ".",
                    temp.data.judul,
                    temp.data.channel,
                    temp.data.durasi + " mnt",
                    temp.data.view,
                    temp.data.genre
            );
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

    public Video cari(String kataKunci, String tipe) {
        Node temp = head;
        Video hasil = null;
        boolean ada = false;
        String GRAY   = "\u001B[90m";
        String RESET  = "\u001B[0m";
        System.out.println("   Hasil pencarian \"" + kataKunci + "\":");
        while (temp != null) {
            boolean cocok = false;
            if (tipe.equals("judul") && temp.data.judul.toLowerCase().contains(kataKunci.toLowerCase())) cocok = true;

            if (cocok) {
                if (hasil == null) hasil = temp.data;
                System.out.println("   ╔════════════════════════════════════════════════════════════════════════════╗");
                System.out.println("   ║                                                                            ║");
                System.out.println("   ║   ██████████████████████████████████████████████████████████████████████   ║");
                System.out.println("   ║   ██████████████████████████████████████████████████████████████████████   ║");
                System.out.println("   ║   ██████████████████████████████████████████████████████████████████████   ║");
                System.out.println("   ║   ██████████████████████████████████████████████████████████████████████   ║");
                System.out.println("   ║   ██████████████████████████████████████████████████████████████████████   ║");
                System.out.println("   ║   ██████████████████████████████████████████████████████████████████████   ║");
                System.out.println("   ║   ██████████████████████████████████████████████████████████████████████   ║");
                System.out.println("   ║   ██████████████████████████████████████████████████████████████████████   ║");
                System.out.println("   ║   ██████████████████████████████████████████████████████████████████████   ║");
                System.out.println("   ║   ██████████████████████████████████████████████████████████████████████   ║");
                System.out.println("   ║   ██████████████████████████████████████████████████████████████████████   ║");
                System.out.println("   ║   ██████████████████████████████████████████████████████████████████████   ║");
                System.out.println("   ║   ██████████████████████████████████████████████████████████████████████   ║");
                System.out.println("   ║                                                                            ║");
                System.out.printf("   ║   0:01 / %-66s", temp.data.durasi + ":00"); System.out.println("║");
                System.out.println("   ║   [██████████░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░]   ║");
                System.out.println("   ║                                                                            ║");
                System.out.println("   ╚════════════════════════════════════════════════════════════════════════════╝");

                System.out.println("   " + temp.data.judul + " • " + GRAY + temp.data.genre + RESET);
                System.out.println("   -----------------------------------------------------------------------------");
                System.out.println("   " + temp.data.channel + " •  1M subscribers");
                System.out.println("   -----------------------------------------------------------------------------");
                System.out.println("   ▶ Play    👍    👎    💬 Komentar    ↗ Bagikan    ↓ Download    ♥ Terima kasih");
                System.out.println("   -----------------------------------------------------------------------------");
                System.out.println("   Bersponsor • 1 dari 2   sevenbeats");
                System.out.println("\n   Tekan tombol apa saja untuk keluar...");
                ada = true;
            }
            temp = temp.next;
        }
        if (!ada) {
            System.out.println("   Tidak ditemukan.\n");
            return null;
        }
        System.out.println();
        return hasil;
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
