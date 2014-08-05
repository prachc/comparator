package song;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;


public class MusicShuffle {
	public static void main(String[] args) {
		List<Song> songList = new ArrayList<Song>();
		
		songList.add(new Song("LUNA SEA","Shine","Time Has Come",1));
		songList.add(new Song("LUNA SEA","Shine","Storm",2));
		songList.add(new Song("LUNA SEA","Shine","Shine",4));
		
		songList.add(new Song("LUNA SEA","Mother","Loveless",1));
		songList.add(new Song("LUNA SEA","Mother","Rosier",2));
		songList.add(new Song("LUNA SEA","Mother","Mother",10));
		
		songList.add(new Song("ADTR","Homesick","The Downfall of Us All",1));
		songList.add(new Song("ADTR","Homesick","NJ Legion Iced Tea",4));
		songList.add(new Song("ADTR","Homesick","Homesick",8));
		
		songList.add(new Song("ADTR","Common Courtesy","Right Back at It Again",2));
		songList.add(new Song("ADTR","Common Courtesy","I Surrender",9));
		songList.add(new Song("ADTR","Common Courtesy","City of Ocala",1));
		
		Collections.sort(songList, new SongComparator());
		
		for(Song song:songList){
			System.out.println(song.toString());
		}
		
		System.out.println("//////");
		
		/*Collections.shuffle(songList);
		
		for(Song song:songList){
			System.out.println(song.toString());
		}*/
		
		System.out.println("//////");
		
		ArrayList<Song> shuffled = shuffle(songList);
		
		System.out.println("//////");
		for(Song song:shuffled){
			System.out.println(song.toString());
		}
	}
	
	public static ArrayList<Song> shuffle(List<Song> sortedsonglist){
		LinkedHashMap<String,ArrayList<Song>> albums = new LinkedHashMap<String,ArrayList<Song>>();
		
		for(Song song:sortedsonglist){
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
			for(Song song:songlist){
				System.out.println(song.toString());
			}
			result.addAll(songlist);
			System.out.println();
		}
		
		return result;
	}
}
