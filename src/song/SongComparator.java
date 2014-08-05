package song;

import java.util.Comparator;


public class SongComparator implements Comparator<Song> {
    public int compare(Song a, Song b) {
        Integer atracknum = a.TrackNum;
        Integer btracknum = b.TrackNum;
        return  atracknum.compareTo(btracknum);
    }
}
