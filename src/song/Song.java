package song;

public class Song{
	public String Artist;
	public String Album;
	public String Title;
	public int TrackNum;
	
	public Song(String artist, String album, String title, int tracknum){
		Artist = artist;
		Album = album;
		Title = title;
		TrackNum = tracknum;
	}
	
	public String toString(){
		return Artist+" "+Album+" "+Title+" "+TrackNum;	
	}
	
	public String generateKey(){
		return Artist+Album;
	}
}