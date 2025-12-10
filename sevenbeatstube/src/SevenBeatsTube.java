import java.util.Scanner;

public class SevenBeatsTube {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DaftarVideo daftar = new DaftarVideo();
        Queue upNext = new Queue();
        Stack history = new Stack();
        GenreTree genreTree = new GenreTree();

        // Data awal (tanpa array)
        daftar.tambah(new Video("Belajar Java Dasar", "KodingAsik", 35, 920000, "Tutorial"));
        daftar.tambah(new Video("Kompilasi Meme 2025", "MemeLucuID", 7, 3800000, "Comedy"));
        daftar.tambah(new Video("Valorant Clutch 1v5", "ProGamerID", 18, 2100000, "Gaming"));
        daftar.tambah(new Video("Cinta di Akhir Hayat", "DramaSedih", 42, 1100000, "Drama"));
        daftar.tambah(new Video("Sial - Mahalini Live", "KonserID", 5, 6200000, "Music"));

        Node temp = daftar.head;
        while (temp != null) {
            genreTree.tambahGenre(temp.data.genre);
            temp = temp.next;
        }

        int p;
        do {
            System.out.println("=== SevenBeatsTube ===");
            System.out.println("1. Tambah Video");
            System.out.println("2. Hapus Video");
            System.out.println("3. Tampilkan Semua Video");
            System.out.println("4. Cari Video");
            System.out.println("5. Sorting Video");
            System.out.println("6. Tambah ke Up Next");
            System.out.println("7. Putar Video Berikutnya");
            System.out.println("8. Tampilkan Riwayat");
            System.out.println("9. Tampilkan Genre Tree");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            p = sc.nextInt();
            sc.nextLine();
            System.out.println();

            switch (p) {
                case 1:
                    System.out.print("Judul   : "); String j = sc.nextLine();
                    System.out.print("Channel : "); String c = sc.nextLine();
                    System.out.print("Durasi  : "); int d = sc.nextInt();
                    System.out.print("View    : "); long v = sc.nextLong(); sc.nextLine();
                    System.out.print("Genre   : "); String g = sc.nextLine();
                    daftar.tambah(new Video(j, c, d, v, g));
                    genreTree.tambahGenre(g);
                    System.out.println("Video ditambahkan!\n");
                    break;

                case 2:
                    System.out.print("Judul yang dihapus: ");
                    daftar.hapus(sc.nextLine());
                    System.out.println("Video dihapus jika ada.\n");
                    break;

                case 3: daftar.tampilkanSemua(); break;
                case 4:
                    System.out.println("1.Judul  2.Channel  3.Genre");
                    int ct = sc.nextInt(); sc.nextLine();
                    System.out.print("Kata kunci: "); String key = sc.nextLine();
                    String tipe = (ct == 1) ? "judul" : (ct == 2) ? "channel" : "genre";
                    daftar.cari(key, tipe);
                    break;

                case 5:
                    System.out.println("Sort: 1.View  2.Judul  3.Durasi");
                    int s = sc.nextInt();
                    if (s == 1) daftar.sortByView();
                    else if (s == 2) daftar.sortByJudul();
                    else if (s == 3) daftar.sortByDurasi();
                    System.out.println("Berhasil diurutkan!\n");
                    daftar.tampilkanSemua();
                    break;

                case 6:
                    System.out.print("Judul untuk Up Next: ");
                    Video vid = daftar.cariJudul(sc.nextLine());
                    if (vid != null) {
                        upNext.enqueue(vid);
                        System.out.println("Ditambahkan ke Up Next!\n");
                    } else System.out.println("Video tidak ditemukan!\n");
                    break;

                case 7:
                    Video play = upNext.dequeue();
                    if (play == null) {
                        System.out.println("Up Next kosong!\n");
                    } else {
                        System.out.println("Memutar: " + play.judul + "\n");
                        history.push(play);
                    }
                    break;

                case 8: history.tampilkanHistory(); break;
                case 9: genreTree.inorder(); break;
                case 0: System.out.println("Terima kasih!"); break;
                default: System.out.println("Pilihan salah!\n");
            }
        } while (p != 0);
    }
    public static void tampilkanHomePage() {
        System.out.println(RED + BOLD +
                "    ███████╗ ███████╗ ██╗   ██╗ ███████╗ ███╗   ██╗ ████████╗ ██╗   ██╗ ██████╗  ███████╗\n" +
                "    ██╔════╝ ██╔════╝ ██║   ██║ ██╔════╝ ████╗  ██║ ╚══██╔══╝ ██║   ██║ ██╔══██╗ ██╔════╝\n" +
                "    ████████╗█████╗   ██║   ██║ █████╗   ██╔██╗ ██║    ██║    ██║   ██║ ██████╔╝ █████╗  \n" +
                "    ╚════██║ ██╔══╝   ╚██╗ ██╔╝ ██╔══╝   ██║╚██╗██║    ██║    ██║   ██║ ██╔══██╗ ██╔══╝  \n" +
                "    ███████║ ███████╗  ╚████╔╝  ███████╗ ██║ ╚████║    ██║    ╚██████╔╝ ██║  ██║ ███████╗\n" +
                "    ╚══════╝ ╚══════╝   ╚═══╝   ╚══════╝ ╚═╝  ╚═══╝    ╚═╝    ╚═════╝   ╚═╝  ╚═╝ ╚══════╝\n" +
                RESET);
        System.out.println(YELLOW + BOLD +
                "                                 YouTube Clone • SevenTubes 2025                              \n" +
                RESET);

        System.out.println(GRAY + "        Untuk Anda  •  Trending  •  Musik  •  Gaming  •  Komedi  •  Drama  •  Tutorial" + RESET);
        System.out.println("   " + "═".repeat(88));

        daftar.sortByView();
        tampilkanGridVideo(daftar.head, 6);
    }
}
