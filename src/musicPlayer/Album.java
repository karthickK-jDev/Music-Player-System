package musicPlayer;
import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
	String name;
	String artist;
	private ArrayList<Song> songs =new ArrayList<Song>();
	
	public Album(String name,String artist) {
		this.name = name;
		this.artist = artist;
	}
	
	public Album() {
		
	}
	
	public Song findSong(String title) {
		for(Song checkedSong : songs) {
			if(checkedSong.getTitle().equals(title)) {
				return checkedSong;
			}
		}
		return null;
	}
	
	public boolean addSong(String title,double duration) {
		if(findSong(title)==null) {
			songs.add(new Song(title,duration));
			System.out.println(title + "\nSuccessfully added to the list.");
			return true;
		}
		else {
			System.out.println(title + "\nThe Song already exist in the list.");
			return false;
		}
	}

	public boolean addToPlaylist(String title,LinkedList<Song> Playlist) {
		for(Song checkedSong : songs) {
			if(checkedSong.getTitle().equals(title)) {
				Playlist.add(checkedSong);
				return true;
			}
		}
		
		System.out.println(title + "there is no such song in album");
		return false;
	}
}
