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
      String[] menuUtama = {
                "ADD", "DELETE", "LIST",
                "SEARCH", "SORT", "ADD_Q",
                "NEXT", "HISTORY", "GENRE"
        };

        // Konstanta lebar kolom untuk kerapian
        final int LEBAR_KOLOM = 10;
        final String GARIS_PEMBATAS = "------------------------------------------";

        int p;
        tampilkanHomePage();
        do {
            System.out.println("   " + "═".repeat(66));
            int kolom = 5;
            int jumlahMenu = menuUtama.length;

            for (int i = 0; i < jumlahMenu; i += kolom) {
                System.out.print("   │ ");
                for (int j = 0; j < kolom; j++) {
                    int index = i + j;
                    if (index < jumlahMenu)
                        System.out.printf("%-" + LEBAR_KOLOM + "s │ ", index + 1);
                    else
                        System.out.printf("%-" + LEBAR_KOLOM + "s │ ", "0"); // kolom kosong
                }
                System.out.println(" ");
                System.out.print("   │ ");
                for (int j = 0; j < kolom; j++) {
                    int index = i + j;
                    if (index < jumlahMenu)
                        System.out.printf("%-" + LEBAR_KOLOM + "s │ ", menuUtama[index]);
                    else
                        System.out.printf("%-" + LEBAR_KOLOM + "s │ ", "OUT"); // kolom kosong
                }
                System.out.println(" ");

                System.out.println("   " + "═".repeat(66));
            }
            System.out.print("   Pilih: ");
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

                case 3: 
                    daftar.tampilkanSemua(); 
                    break;
                    
                case 4:
                    System.out.print("   Masukkan judul Video: "); String key = sc.nextLine();
                    Video dicari = daftar.cari(key, "judul");
                    history.push(dicari);
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
                        puterVideo(play);
                        history.push(play);
                    }
                    break;

                case 8: 
                    history.tampilkanHistory(); 
                    break;
                case 9: 
                    genreTree.inorder(); 
                    break;
                case 0: 
                    System.out.println("Terima kasih!"); 
                    break;
                default: 
                    System.out.println("Pilihan salah!\n");
            }
        } while (p != 0);
    }
    public static void tampilkanHomePage() {
        System.out.println(RED + BOLD +
                "    ███████╗ ███████╗ ██╗   ██╗ ███████╗ ███╗   ██╗ ████████╗ ██╗   ██╗ ██████╗  ███████╗\n" +
                "    ██╔════╝ ██╔════╝ ██║   ██║ ██╔════╝ ████╗  ██║ ╚══██╔══╝ ██║   ██║ ██╔══██╗ ██╔════╝\n" +
                "    ████████╗█████╗   ██║   ██║ █████╗   ██╔██╗ ██║    ██║    ██║   ██║ ██████╔╝ █████╗  \n" +
                "    ╚════██║ ██╔══╝   ╚██╗ ██╔╝ ██╔══╝   ██║╚██╗██║    ██║    ██║   ██║ ██╔══██╗ ██╔══╝  \n" +
                "    ███████║ ███████╗  ╚████╔╝  ███████╗ ██║ ╚████║    ██║    ╚██████╔╝ ██████╔╝ ███████╗\n" +
                "    ╚══════╝ ╚══════╝   ╚═══╝   ╚══════╝ ╚═╝  ╚═══╝    ╚═╝     ╚═════╝  ╚═════╝  ╚══════╝\n" +
                RESET);
        System.out.println(YELLOW + BOLD +
                "                                 YouTube Clone • SevenTubes 2025                              \n" +
                RESET);

        System.out.println(GRAY + "        Untuk Anda  •  Trending  •  Musik  •  Gaming  •  Komedi  •  Drama  •  Tutorial" + RESET);
        System.out.println("   " + "═".repeat(88));

        daftar.sortByView();
        tampilkanGridVideo(daftar.head, 6);
    }

    private static void tampilkanGridVideo(Node start, int jumlah) {
        if (start == null) {
            System.out.println("   Belum ada video.");
            return;
        }

        Node current = start;
        int count = 0;

        while (current != null && count < jumlah) {
            // Kumpulkan video untuk satu baris (maksimal 3 kolom)
            Video[] row = new Video[3];
            int colsInRow = 0;
            for (int i = 0; i < 3 && current != null && count < jumlah; i++) {
                row[i] = current.data;
                current = current.next;
                count++;
                colsInRow++;
            }

            // Cetak 5 baris thumbnail secara horizontal
            for (int line = 0; line < 5; line++) {
                for (int c = 0; c < colsInRow; c++) {
                    String[] thumb = {
                            YELLOW + "    ┌────────────────────┐    " + RESET,
                            YELLOW + "    │                    │    " + RESET,
                            YELLOW + "    │   ▄▀█ █▀▄  VIDEO   │    " + RESET,
                            YELLOW + "    │                    │    " + RESET,
                            YELLOW + "    └────────────────────┘    " + RESET
                    };
                    System.out.print(thumb[line]);
                }
                System.out.println(); // pindah baris setelah satu baris thumbnail selesai
            }

            // Cetak judul
            for (int c = 0; c < colsInRow; c++) {
                String judul   = truncate(row[c].judul, 22);
                System.out.printf("    %s%-22s%s    ", BOLD, judul, RESET);
            }
            System.out.println();
            // Chanel, views, durasi
            for (int c = 0; c < colsInRow; c++) {
                String channel = truncate(row[c].channel, 18);
                String views   = formatViews(row[c].view);
                int m  = row[c].durasi;
                String durasi = (m>=60)? (m/60) + " jam" : m + " menit";
                String gabung = channel + " • " + views +" • "+ durasi;
                System.out.printf("    %s%-26s%s", CYAN, gabung, RESET);
            }
            System.out.println();
            for (int c = 0; c < colsInRow; c++) {
                String genre   = row[c].genre;
                System.out.printf("    %s%-22s%s    ", GRAY, genre, RESET);
            }
            System.out.println();
            // Garis pemisah antar baris video (kecuali baris terakhir)
            if (current != null && count < jumlah) {
                System.out.println("   " + "─".repeat(88));
            }
        }

        System.out.println();
    }

    
    private static void puterVideo (Video puter){
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
        System.out.printf("   ║   0:01 / %-66s", puter.durasi + ":00"); System.out.println("║");
        System.out.println("   ║   [██████████░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░]   ║");
        System.out.println("   ║                                                                            ║");
        System.out.println("   ╚════════════════════════════════════════════════════════════════════════════╝");
        System.out.println("   " + puter.judul + " • " + GRAY + puter.genre + RESET);
        System.out.println("   -----------------------------------------------------------------------------");
        System.out.println("   " + puter.channel + " •  1M subscribers");
        System.out.println("   -----------------------------------------------------------------------------");
        System.out.println("   ▶ Play    👍    👎    💬 Komentar    ↗ Bagikan    ↓ Download    ♥ Terima kasih");
        System.out.println("   -----------------------------------------------------------------------------");
        System.out.println("   Bersponsor • 1 dari 2   sevenbeats");
        System.out.println("\n   Tekan tombol apa saja untuk keluar...");
    }


    // Helper: batasi panjang teks
    private static String truncate(String s, int max) {
        return s.length() > max ? s.substring(0, max - 3) + "..." : s;
    }


    private static String truncate(String s, int max) {
        return s.length() > max ? s.substring(0, max - 3) + "..." : s;
    }

}
