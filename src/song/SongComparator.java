package song;

import java.util.Comparator;


public class SongComparator implements Comparator<Song> {
    public int compare(Song a, Song b) {
        int albumComparison = a.Album.compareTo(b.Album);
        Integer atracknum = a.TrackNum;
        Integer btracknum = b.TrackNum;
        return albumComparison == 0 ? atracknum.compareTo(btracknum) : albumComparison;
    }
}
