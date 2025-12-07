public class Video {
    String judul, channel, genre;
    int durasi;
    long view;

    Video(String judul, String channel, int durasi, long view, String genre) {
        this.judul = judul;
        this.channel = channel;
        this.durasi = durasi;
        this.view = view;
        this.genre = genre;
    }
}