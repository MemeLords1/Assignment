public class Song implements Comparable<Song>{

public int ranks, views;
public String songN, artist;
public Song(int ranks, String songN, String artist, int views) {
    super();
    this.ranks = ranks;
    this.songN = songN;
    this.artist = artist;
    this.views = views;

}

public int getranks() {
    return ranks;
}

public String getsongN() {
    return songN;
}

public String getartist() {
    return artist;
}

public int getviews() {
    return views;
}

public int compareTo (Song s) {
 return this.songN.compareTo(s.songN);
}

public String toStringSong(){
	return (songN + " --  By: " + artist);
}
}