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

public class Main {

public static final String CSV_PATH = "SpotifyList.csv";
public static boolean append = true;
public static ArrayList<String> aList = new ArrayList<String>();

public static void main(String[] args) throws IOException {
	int choice = 0;
    System.out.println("");
                System.out.println("This is Spotify Top 200 Chart what would you like to do"+"\n");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 1 To Show the Top 200 Chart By Ranking.");
                System.out.println("Enter 2 To Sort Alphabetical By Artist Names");
		System.out.println("Enter 3 To See Only The Artist Names Alphabetical");
                System.out.println("Enter 0 to exit."+"\n");
                System.out.print("Your choice: ");
		choice = sc.nextInt(); 
if (choice == 1) {
    readAllLinesFromFile(CSV_PATH);
    System.out.println("\n" + "Your Top 200 In Order By Ranks\n");
    System.out.println("The Data Is Shown By " + "\n");
    System.out.println("Position - Song Name - Artist - # Of Plays");
	for(String aChartString: aList){
        System.out.println(aChartString +"\n");
    }
}
else { if (choice == 2) {	
    readAllLinesFromFile(CSV_PATH);
    ArrayList<Chart> charts = convertToCharts(aList);
    System.out.println("\n" + "Your Top 200 Sorted Alphabetical By Artist Names:\n");
    System.out.println("The Data Is Shown By " + "\n");
    System.out.println("Position - Song Name - Artist - # Of Plays");
        for(Chart chart : charts){
        System.out.println(chart.toString());
    }
} else if (choice == 3) { 
    readAllLinesFromFile(CSV_PATH);
    ArrayList<Chart> charts = convertToCharts(aList);
   for(Chart chart : charts){
   System.out.println(chart.toStringName());
} 
}else if (choice == 0) {
	System.out.println("\n" + "Good Bye!");
}
}
}

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

    Collections.sort(charts, new Comparator<Chart>() {
        @Override
        public int compare(Chart o1, Chart o2) {
            return o1.compareTo(o2);
        } 
    });
    return charts;
}
}