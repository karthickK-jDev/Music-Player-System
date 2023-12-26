package musicPlayer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	
	private static ArrayList<Album> albums = new ArrayList<>();
	 
	public static void main(String[] args) {
		Album album = new Album("Non-Stop","Reggae & Jamaica");
		album.addSong("Heaven In Her Eyes",4.41);
		album.addSong("A Dub Tribulation",4.53);
		album.addSong("Longing For",4.60);
		album.addSong("One Woman",4.23);
		album.addSong("Reggae Vibes",4.16);
		album.addSong("No Love Allowed",4.26);
		albums.add(album);
		
		album = new Album("Starzinger","Ola Englund");
		album.addSong("Stars & Ponies",4.43);
		album.addSong("Cringy AF",4.35);
		album.addSong("Space Invaders",4.46);
		album.addSong("Demon",4.34);
		album.addSong("Balengmah",4.54);
		album.addSong("Sun & the Moon",4.16);
		albums.add(album);
		
		LinkedList<Song> playList_1 = new LinkedList<>();
		
		albums.get(0).addToPlaylist("Heaven In Her Eyes", playList_1);
		albums.get(0).addToPlaylist("A Dub Tribulation", playList_1);
		albums.get(0).addToPlaylist("Reggae Vibes", playList_1);
		albums.get(1).addToPlaylist("Stars & Ponies", playList_1);
		albums.get(1).addToPlaylist("Sun & the Moon", playList_1);
		albums.get(1).addToPlaylist("Demon", playList_1);
		
		play(playList_1);
	}
	
	private static void play(LinkedList<Song> playList) {
		Scanner sc = new Scanner(System.in);
		boolean quit = false;
		boolean forward = true;
		ListIterator<Song> listIterator = playList.listIterator();
		
		if(playList.size()==0) {
			System.out.println("This Playlist have no song");
		}
		else {
			System.out.println("Now Playing : "+listIterator.next().toString());
			printMenu();
		}
		
		while(!quit) {
			int action = sc.nextInt();
			sc.nextLine();
			
			switch(action) {
			case 0:
				System.out.println("Playlist completed.");
				quit = true;
				break;
			case 1:
				if(!forward) {
					if(listIterator.hasNext()) {
						listIterator.next();
					}
					forward = true;
				}
					if(listIterator.hasNext()) {
						System.out.println("Now Playing : " + listIterator.next().toString());
					}
					else {
						System.out.println("no song available.Reached to the end of list");
						forward = false;
					}
				break;
			case 2:
				if(forward) {
					if(listIterator.hasPrevious()) {
						listIterator.previous();
					}
					forward = false;
				}
					if(listIterator.hasPrevious()) {
						System.out.println("Now Playing : " + listIterator.previous().toString());
					}
					else {
						System.out.println("It is the First song");
						forward = false;
					}
				break;
			case 3:
				if(forward) {
					if(listIterator.hasPrevious()) {
						System.out.println("Now Playing : " + listIterator.previous().toString());
						forward = false;
					}
					else {
						System.out.println("You are at start of the list");
					}
				}
				else {
					if(listIterator.hasNext()) {
						System.out.println("Now Playing : " + listIterator.next().toString());
						forward = true;
					}
					else {
						System.out.println("You are at end of the list");
					}
				}
				break;
			case 4:
				printList(playList);
				break;
			case 5:
				printMenu();
				break;
			case 6:
				if(playList.size()>0) {
					listIterator.remove();
					if(listIterator.hasNext()) {
						System.out.println("Now Playing : " + listIterator.next().toString());
						forward = true;
					}
					else {
						if(listIterator.hasPrevious()) {
							System.out.println("Now Playing : " + listIterator.previous().toString());
						}
					}
				}
				break;
		}	
	}
}
	
	private static void printMenu() {
		System.out.println("Select anyone of below\n"+
				"0 - to Quit\n"+
				"1 - to Play Next Song\n"+
				"2 - to Play Previous Song\n"+
				"3 - to Replay Current Song\n"+
				"4 - List of All Songs\n"+
				"5 - Print all available options\n"+
				"6 - to Delete Current Song\n");
	}
	
	private static void printList(LinkedList<Song> playList) {
		Iterator iterator = playList.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
