//Thomas Chen
//Didnt understand what you mean by making a song Queue.. 
//Since cant you just remove the Song you just listen from the song list "csv file"???
//So all i did was combine multiple CSV File to create a New one with all of them combine. 

import java.io.BufferedReader;
import java.io.FileReader; 
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.io.*;
import java.util.Scanner;

public class Main
{

//Created  CSV Path which is the new file you created once you combine week1,week2,week3,weekn

public static final String CSV_PATH = "SpotifyQuarterList.csv";
public static boolean append = true;
public static ArrayList<String> aList = new ArrayList<String>();

//Read in the CSV File of week1,week2,week3,weekn and store them in order from week1 then week2 then week3 then weekn under each other in that order
 
       public static void main(String[] args) throws IOException
       {      
       ArrayList<String> list = new ArrayList<String>();
       try
       {
       BufferedReader r1 = new BufferedReader(new FileReader( "Week1.csv"));
       BufferedReader r2 = new BufferedReader(new FileReader( "Week2.csv"));
       BufferedReader r3 = new BufferedReader(new FileReader( "Week3.csv"));
       BufferedReader rn = new BufferedReader(new FileReader( "Weekn.csv"));
            String s1 = null;
            String s2 = null;
	    String s3 = null;
            String sn = null;

                         while ((s1 = r1.readLine()) != null)
                         {                         
                                        list.add(s1);        
                         }
                         while((s2 = r2.readLine()) != null)
                         {    
                                        list.add(s2);    
                         } 
                         while ((s3 = r3.readLine()) != null)
                         {                         
                                        list.add(s3);        
                         }
                         while((sn = rn.readLine()) != null)
                         {    
                                        list.add(sn);    
                         } 
       }
        catch (IOException e)
          {
            e.printStackTrace();
          }

// Write or copy the information of week1,week2,week3,weekn into a new csv file Callled SportifyQuarterList

           BufferedWriter writer=null;
           writer = new BufferedWriter(new FileWriter("SpotifyQuarterList.csv"));
            String listWord;              
                   for (int i = 0; i< list.size(); i++)
                  {
                        listWord = list.get(i);
                       writer.write(listWord);
                       writer.write("\n");
                  }
		       System.out.print("\n");
                   System.out.println("This Is Your Spotify Quarter List\n");
                        writer.close();   
// Give the user Option to sort the information

int choice = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 1 To Show The Songs.");
                System.out.println("Enter 2 To Sort Alphabetical By Artist Names While Also Seeing the Position - Song Name - Artist - And Play Time");
		System.out.println("Enter 3 To See Only The Artist Names Alphabetical");
	 	System.out.println("Enter 4 To See Song Name Alphabetical");
                System.out.println("Enter 0 to exit."+"\n");
                System.out.print("Your choice: ");
		choice = sc.nextInt(); 
// Display the full combine List in total

if (choice == 1) {
    readAllLinesFromFile(CSV_PATH);
    System.out.println("\n" + "Your Top 200 In Order By Ranks\n");
    System.out.println("The Data Is Shown By " + "\n");
    System.out.println("Position - Song Name - Artist - # Of Plays");
	for(String aChartString: aList){
        System.out.println(aChartString +"\n");
    }
}
// Sort Alphabetical By Artist Names While still containing the Position - Song Name - Artist - And Play Time

else { if (choice == 2) {	
    readAllLinesFromFile(CSV_PATH);
    ArrayList<Chart> charts = convertToCharts(aList);
    System.out.println("\n" + "Your Top 200 Sorted Alphabetical By Artist Names:\n");
    System.out.println("The Data Is Shown By " + "\n");
    System.out.println("Position - Song Name - Artist - # Of Plays");
        for(Chart chart : charts){
        System.out.println(chart.toString());
    }
} 
//Sort the songs only by Artist names Alphabetical

else if (choice == 3) { 
    readAllLinesFromFile(CSV_PATH);
    ArrayList<Chart> charts = convertToCharts(aList);
   for(Chart chart : charts){
   System.out.println(chart.toStringName());
} 
}

//Sort by song name Aplhabetical

else if (choice == 4) { 
    readAllLinesFromFile(CSV_PATH);
    ArrayList<Song> songs = convertToSongs(aList);
   for(Song song : songs){
   System.out.println(song.toStringSong());
} 
}

//Exit the Prompt

else if (choice == 0) {
	System.out.println("\n" + "Good Bye!");
}
}
}

//BufferedReader

public static ArrayList<String> readAllLinesFromFile(String path) throws IOException{

    FileReader fileReader = new FileReader(path);
    BufferedReader bufferedReader = new BufferedReader(fileReader);
    String line = null;
    while( (line = bufferedReader.readLine()) != null){
        aList.add(line);
    }
    bufferedReader.close();

    return aList;

}

//Pass information and call Chart.java file while passing,getting information between them

public static ArrayList<Chart> convertToCharts(ArrayList<String> chartsStrings) {
    ArrayList<Chart> charts = new ArrayList<>();
    chartsStrings.remove(0);
    for(String chartString : chartsStrings) {
         String[] parts = chartString.split(",");
        int ranks = Integer.valueOf(parts[0]);
        String songN = parts[1];
        String artist = parts[2];
        int views = Integer.valueOf(parts[3]);
        charts.add(new Chart(ranks, songN, artist, views));
    }

//Sorting the Artist names

    Collections.sort(charts, new Comparator<Chart>() {
        @Override
        public int compare(Chart o1, Chart o2) {
            return o1.compareTo(o2);
        } 
    });
    return charts;
}

// Pass information to Song.java File Same as Above

public static ArrayList<Song> convertToSongs(ArrayList<String> songsStrings) {
    ArrayList<Song> songs = new ArrayList<>();
    songsStrings.remove(0);
    for(String songString : songsStrings) {
         String[] parts = songString.split(",");
        int ranks = Integer.valueOf(parts[0]);
        String songN = parts[1];
        String artist = parts[2];
        int views = Integer.valueOf(parts[3]);
        songs.add(new Song(ranks, songN, artist, views));
    }

//Sorting Song names

    Collections.sort(songs, new Comparator<Song>() {
        @Override
        public int compare(Song o1, Song o2) {
            return o1.compareTo(o2);
        } 
    });
    return songs;
}
}
