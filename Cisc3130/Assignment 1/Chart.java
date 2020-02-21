//Thomas Chen

public class Chart implements Comparable<Chart>{

public int ranks, views;
public String songN, artist;
public Chart(int ranks, String songN, String artist, int views) {
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



public int compareTo (Chart c) {
 return this.artist.compareTo(c.artist);
}

public String toString() {
    return (ranks + " - " + songN + " -  " + artist + " -  " + views);
}
public String toStringName(){
	return artist;
}
}
