public class Music {

    private String singer;
    private String songTitle;

    public String getsongTitle() {
        return songTitle;
    }

    public Music(String songTitle, String singer) {
        this.songTitle = songTitle;
        this.singer = singer;
    }

    @Override
    public String toString() {
        return songTitle + " - " + singer;
    }
}