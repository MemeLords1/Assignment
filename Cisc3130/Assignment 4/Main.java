//Thomas Chen
//Assignment #4
//Cisc. 3130
//Movie Genres

//Note
//The console print the report for people who are just trying to see the information or result as quickly as possible by 
//just running the program but for people who are trying to store the data and trying to look at it without having 
//to run the program all over again I had the data printed onto different CSV file so it could be quickly accessed 
//and stored for later use.


import java.io.*;
import java.io.FileReader;
import java.util.*;

//Creating  Main Class

public class Main {

	public static void main(String[]args)throws IOException{

//Read in the file called movies.csv with BufferReader

	File file= new File("movies.csv");
	BufferedReader reader= new BufferedReader(new FileReader(file));
	reader.readLine();	

//Creating HashMap

	HashMap<String,Integer> mapYear = new HashMap<>();
	HashMap<String,Integer> map = new HashMap<>();
	HashMap<Integer,Integer> howMany = new HashMap<>();

//Creating an Array

	String[] array;
	String line = reader.readLine();

//Reading the file by lines while setting up boundarys (setting values)

	while(line !=null) {
		array = line.split(",");
		line = reader.readLine();
	
	try {
		int comma = line.lastIndexOf(',');
		String sub = line.substring(0,comma);
		int open = sub.lastIndexOf('(')+1;
		int close = sub.lastIndexOf(')');
		int year = Integer.parseInt(sub.substring(open,close));

	if (year>=2015){
		String[] genres = array[array.length-1].split("\\|");

//Setting a key for Genre

	for (String genre:genres){
		if(mapYear.containsKey(genre)){
			mapYear.put(genre,mapYear.get(genre)+1);

	}
	else{
	mapYear.put(genre,1);	
		}
	}
}

//Setting a Key for Year

	if (howMany.containsKey(year)){
		howMany.put(year,howMany.get(year)+1);
	}
	else{
		howMany.put(year,1);
	}
}
catch (Exception e){
}

//Putting genres into an Array
	
	String[] genres = array[array.length-1].split("\\|");
		for(String genre:genres){
			if(map.containsKey(genre)){
				map.put(genre,map.get(genre)+1);
			}
		else{
			map.put(genre,1);
		}
	}
}

//Making an ArrayList to help sort the list and the sortByYears help sort the list by Years

	ArrayList<Map.Entry<String, Integer>> sorted = new ArrayList<>();
	ArrayList<Map.Entry<String,Integer>> sortByYears = new ArrayList<>();
		
//Adding the sorted entry		

		for(Map.Entry<String, Integer> entry : map.entrySet()){
			sorted.add(entry);
		}

//Adding the sorted Years

		for (Map.Entry<String, Integer> entry : mapYear.entrySet()){
		sortByYears.add(entry);
		}

//Comparing the value so it can be sorted from the information provided above ^ 

	sorted.sort((a,b) -> b.getValue().compareTo(a.getValue()));
	sortByYears.sort((a,b) -> b.getValue().compareTo(a.getValue()));


//Printing out the values into the console so you can see the Printed out value when you run the program
//Also print the value into a .csv file so it can be stored and view later

	System.out.println("\nMovies Sorted by Genre:");
	PrintStream g = new PrintStream(new File("Movies Sorted by Genre.csv"));
	PrintStream gp = System.out;
		for (Map.Entry<String, Integer> entry : sorted) {
		System.setOut(g);
		System.out.println(entry.getValue() + " Movies That Are " + entry.getKey());
		System.setOut(gp); 
		System.out.println(entry.getValue() + " Movies That Are " + entry.getKey());
	}
	System.out.println("\nNumber of Genre of Movies Created within the last five Years: ");
	PrintStream y = new PrintStream(new File("Number of Genre of Movies Created within the last five Years.csv"));
	PrintStream yp = System.out;
		for (Map.Entry<String, Integer> entry : sortByYears) {
	System.setOut(y);
	System.out.println(entry.getValue() + " " + entry.getKey() );
	System.setOut(yp); 
	System.out.println(entry.getValue() + " " + entry.getKey() );
	}
	ArrayList<Map.Entry<Integer, Integer>> sort = new ArrayList<>();
		for(Map.Entry<Integer, Integer> entry : howMany.entrySet()){
		sort.add(entry);
	}
	
	sort.sort((a,b) -> a.getKey().compareTo(b.getKey()));
	System.out.println("\nNumber of Movies created by Years: ");
	PrintStream o = new PrintStream(new File("Number of Movies created by Years.csv"));
	PrintStream console = System.out;
	for (Map.Entry<Integer, Integer> entry : sort) { 
		System.setOut(o);
		System.out.println(entry.getValue() + " Movies in Years " + entry.getKey());
		System.setOut(console); 
		System.out.println(entry.getValue() + " Movies in Years " + entry.getKey());
		}
	}
}
