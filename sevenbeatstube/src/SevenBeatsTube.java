import java.util.Scanner;

public class SevenBeatsTube {
    private static final String RED    = "\u001B[31m";
    private static final String BLUE   = "\u001B[34m";
    private static final String GRAY   = "\u001B[90m";
    private static final String YELLOW = "\u001B[33m";
    private static final String CYAN   = "\u001B[36m";
    private static final String RESET  = "\u001B[0m";
    private static final String BOLD   = "\u001B[1m";

    private static final DaftarVideo daftar = new DaftarVideo();
    private static final Queue upNext = new Queue();
    private static final Stack history = new Stack();
    private static final GenreTree genreTree = new GenreTree();
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        daftar.tambah(new Video("Belajar Java Dasar", "KodingAsik", 35, 920000, "Tutorial"));
        daftar.tambah(new Video("Kompilasi Meme 2025", "MemeLucuID", 7, 3800000, "Comedy"));
        daftar.tambah(new Video("Valorant Clutch 1v5", "ProGamerID", 18, 2100000, "Gaming"));
        daftar.tambah(new Video("Cinta di Akhir Hayat", "DramaSedih", 42, 1100000, "Drama"));
        daftar.tambah(new Video("Sial - Mahalini Live", "KonserID", 5, 6200000, "Music"));
        daftar.tambah(new Video("Excel untuk Pemula", "ExcelGue", 75, 1560000, "Tutorial"));
        daftar.tambah(new Video("Stand Up Pandji 2025", "Pandji", 70, 5200000, "Comedy"));
        daftar.tambah(new Video("Minecraft Speedrun WR", "SpeedRunID", 14, 6700000, "Gaming"));
        daftar.tambah(new Video("Dilan 1991 Nangis", "FalconPic", 8, 29800000, "Drama"));
        daftar.tambah(new Video("To The Bone - Pamungkas", "Pamungkas", 7, 56700000, "Music"));
        daftar.tambah(new Video("Python 1 Jam", "CodeZamanNow", 60, 3900000, "Tutorial"));
        daftar.tambah(new Video("Try Not To Laugh", "Dika", 15, 13400000, "Comedy"));
        daftar.tambah(new Video("GTA 6 Trailer Reaction", "Miawaug", 12, 18900000, "Gaming"));
        daftar.tambah(new Video("Pengabdi Setan 3", "JokoAnwar", 180, 31200000, "Drama"));
        daftar.tambah(new Video("Pesan Terakhir - Lyodra", "Trinity", 5, 45600000, "Music"));
        daftar.tambah(new Video("HTML CSS Website", "WebUNPAS", 80, 2400000, "Tutorial"));
        daftar.tambah(new Video("Roasting TikTokers", "Jerome", 45, 9800000, "Comedy"));
        daftar.tambah(new Video("Free Fire 1vs4", "Frontal", 18, 11200000, "Gaming"));
        daftar.tambah(new Video("KKN Desa Penari", "MDPictures", 130, 78900000, "Drama"));
        daftar.tambah(new Video("Adaptasi - Tulus", "Tulus", 4, 61200000, "Music"));
        daftar.tambah(new Video("Timnas Indonesia vs Thailand", "BolaID", 110, 8900000, "Sports"));
        daftar.tambah(new Video("Cuaca Ekstrem 2025", "KompasTV", 5, 29800000, "News"));
        daftar.tambah(new Video("Bikin Pizza Homemade", "CookingID", 20, 1800000, "Food"));
        daftar.tambah(new Video("Day in My Life: Mahasiswa", "StudentVlog", 18, 4500000, "Vlog"));

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
