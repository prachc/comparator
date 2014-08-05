package song;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class MusicShuffle {
	public static void main(String[] args) {
		List<Song> songList = new ArrayList<Song>();
		
		songList.add(new Song("LUNA SEA","Shine","Storm",2));
		songList.add(new Song("LUNA SEA","Shine","Time Has Come",1));
		songList.add(new Song("LUNA SEA","Shine","Shine",4));
		
		songList.add(new Song("LUNA SEA","Mother","Rosier",2));
		songList.add(new Song("LUNA SEA","Mother","Loveless",1));
		songList.add(new Song("LUNA SEA","Mother","Mother",10));
		
		songList.add(new Song("ADTR","Homesick","NJ Legion Iced Tea",4));
		songList.add(new Song("ADTR","Homesick","The Downfall of Us All",1));
		songList.add(new Song("ADTR","Homesick","Homesick",8));
		
		songList.add(new Song("ADTR","Common Courtesy","Right Back at It Again",2));
		songList.add(new Song("ADTR","Common Courtesy","I Surrender",9));
		songList.add(new Song("ADTR","Common Courtesy","City of Ocala",1));
		
		for(Song song:songList){
			System.out.println(song.toString());
		}
		
		ArrayList<Song> shuffled = shuffle(songList);
		
		System.out.println("//////");
		for(Song song:shuffled){
			System.out.println(song.toString());
		}
	}
	
	//O(n)
	public static ArrayList<Song> shuffle(List<Song> anysonglist){
		HashMap<String,ArrayList<Song>> albums = new HashMap<String,ArrayList<Song>>();
		
		for(Song song:anysonglist){
			String key = song.generateKey();
			if(albums.get(key)==null){
				ArrayList<Song> temp = new ArrayList<Song>();
				temp.add(song);
				albums.put(key, temp);
			}else{
				ArrayList<Song> temp = albums.get(key);
				temp.add(song);
			}
		}
		
		ArrayList<ArrayList<Song>> albums2 = new ArrayList<ArrayList<Song>>(albums.values());
		
		Collections.shuffle(albums2);
		
		ArrayList<Song> result = new ArrayList<Song>();
		
		for(ArrayList<Song> songlist:albums2){
			Collections.sort(songlist, new SongComparator());
			result.addAll(songlist);
		}
		
		return result;
	}
	
	//Test
	
	//each album is in track order --> assert increment of each album
	//album are really in random order --> compare key set
}
