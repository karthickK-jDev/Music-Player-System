package musicPlayer;

public class Song {
	String title;
	double duration;
	
	public Song(String title,double duration){
		this.title = title;
		this.duration = duration;
	}
	
	public Song(){
		
	}
	public String getTitle() {
		return title;
	}

	public String toString() {
		return "Song Name:\""+title+"\"\n"+"Duration: "+duration+"mins";
	}
}
