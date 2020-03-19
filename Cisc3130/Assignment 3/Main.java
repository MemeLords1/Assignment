//Thomas Chen
//Assignment #3
//Cisc. 3130
//Movie Titles

//Notes/Problem
//I Couldnt add or sort the full 9743 Movies on the list becuase the Binary tree isnt balanced because of how I created
//The insert function but I didnt have time to fix the insert function to balanced out the binary tree to accept more then 1000
//Because the tree insert and recurse ran too deep so I decided to just keep it at a maxmium of 1000. 
//I did try to fix this problem by creating a loop which should solve the balancing issue
//But when I did it would just break the program and I didnt know how to fix it within the amount of time I left.
//So I ended up not tryin to fix my Binary Tree Balancing issue which means that the the full 9743 movies listed
//arent printed or present on the outcome file. Since it is restricted to 1000.

import java.util.Scanner;
import java.io.*;
import java.io.PrintWriter;

//THIS IS THE MAIN CLASS
//--------------------------------------------------------------------------------------------------------------------------------
public class Main {
	public static void main(String[] args) throws IOException {
		
	//Creating Binary Search Tree
	MovieBST movieTree = new MovieBST(1000);

	//Creating SubLists
	List subList1 = new List();
	List subList2 = new List();	
	List subList3 = new List();

	//For the report you're generating: provide some examples of choosing a subset of 
 	//movie titles. Since the movie titles are sorted in the binary search tree, 
	//the subset function would act like a filter.

	//Using the example you provided

	subList1 = movieTree.subList("Bug's Life", "Harry Potter");
	subList2 = movieTree.subList("Back to the Future", "Hulk");
	subList3 = movieTree.subList("Toy Story", "WALL-E");

	
	//Print out the subLists on 3 different files called MovieList1,Movielist2,Movielist3

	subList1.print("MovieList1.csv");
	subList2.print("MovieList2.csv");
	subList3.print("MovieList3.csv");

	//Tell the user that the program ran perfectly and is finished.

        System.out.println("File Have Been Printed into MovieList1, MovieList2, MovieList3");
	}
}

//--------------------------------------------------------------------------------------------------------------------------------
//This is a class that returns data.

class Return {
	Movie data;
	Return next;
	Return() { data = null; }
	Return(Movie m) { data = m; next = null; }
	public String getTitle() { return data.title; }
	public String getYear() { return data.releaseYear; }
}


//--------------------------------------------------------------------------------------------------------------------------------
//This is the class that deal with listing the movies.

class List {

// Assigning First and Last

	public Return first;
	public Return last;

//Setting Null Pointers

	List() { first = null; last = null; }

//If the Method is Empty Return

	public boolean isEmpty() {
	return first == null;
	}

//Size of the list 

	public int size() {
	Return curr = first;
	int i = 0;
	while(curr != null) {
		curr = curr.next;
		i++;
	}
		return i;
	}

//Creating and inserting movies to the end of the list
	
	public void insertLast(Movie m) {
	Return newReturn = new Return(m);
	if(isEmpty()) {
		first = newReturn;
	}
	else
		last.next = newReturn;
		last = newReturn;
	}


//This return First
	public Return RMovie() {
		return first;
	}
	



//Print the List
	public void print(String s) throws IOException {
	File myFile = new File(s);
	PrintWriter output = new PrintWriter(myFile);
	output.println("Movie Subset :");
	Return current = first;
	while(current != null) {
		output.printf("%-5s%-50s%s", current.getYear(), current.getTitle(),"\n");
		current = current.next;
		}
		output.flush();
		output.close();
	}
}
//--------------------------------------------------------------------------------------------------------------------------------
//This class assign object to a value. (Example: string, Movie ) 
class Movie { 
	String title;
	String releaseYear;
	Movie(String t, String y) { title = t; releaseYear = y;
	left = right = null; }
	Movie() { title = ""; releaseYear = ""; left = right = null; }
	Movie left;
	Movie right;
}

//--------------------------------------------------------------------------------------------------------------------------------
//This class deals with Storing the movies data so it can be listed and sorted from the classes above ^

class MovieBST {
	private Movie root;
	MovieBST() {
		root = null;
	}
//Storing Our Information (1000 Movies and the two columes of information)
 
	MovieBST(int numLines) throws IOException {
		int row = 1000, col = 2, counter = 0;
		String[][] arr = new String[row][col];
		for(int i = 0; i < 1000; i++)
			for(int j = 0; j < 2; j++)
				arr[i][j] = " ";
   
//Open the file called movies.csv and read in the data that is contain in that CSV FILE
//Using UTF-8 which is (8-bit Unicode Transformation Format) which is used for encoding. 

		File myFile = new File("movies.csv");
		Scanner input = new Scanner(myFile, "UTF-8");

//Storing movies titles and release year into an array.

		String temp = "";
		temp = input.nextLine();
		while(counter < 1000) {
			temp = input.nextLine();
			int x = temp.indexOf(',');
			int z = temp.lastIndexOf(')');
			int y = temp.lastIndexOf('(', z - 1);
			if(temp.charAt(x + 1) == '"')
				arr[counter][0] = temp.substring(x + 2, y);
			else
				arr[counter][0] = temp.substring(x + 1, y);
			arr[counter][1] = temp.substring(y + 1, z);
			counter++;
		}
		input.close();

		for(int i = 0; i < numLines; i++) {
			insert(arr[i][0], arr[i][1]);
		}
		
	}

//Method that calls the insertImplem which is method is below this code.
 
	public void insert(String title, String year) {
		root = insertImplem(root, title, year);
	}


//This method is used to insert the Movies into the right place on the tree

	public Movie insertImplem(Movie root, String title, String year) {
		if(root == null) {
			root = new Movie(title, year);
			return root;
		}
		if(root.title.compareTo(title) > 0)
			root.left = insertImplem(root.left, title, year);
		else if(root.title.compareTo(title) < 0)
			root.right = insertImplem(root.right, title, year);
		
		return root;
	}	

//Used to called the subListMake while passing it data

	public List subList(String begin, String end) {
		List subList = new List();
		subListMake(root, begin, end, subList);
		return subList;
	}

//subListMake like the name implys makes the subList in their desire range and order

	public void subListMake(Movie root, String begin, String end, List sub) {
		if(root != null) {
			subListMake(root.left, begin, end, sub);
			if(root.title.compareToIgnoreCase(end) <= 0 && 
					root.title.compareToIgnoreCase(begin) >= 0)
						sub.insertLast(root);
			subListMake(root.right, begin, end, sub);
		}
	}
	
//Used to call inorder while passing it data(the list)

	public List inorderList() {
		List subList = new List();
		inorder(root, subList);
		
		return subList;
	}
	
//used to put the list(information) given by inorderList in order

	public void inorder(Movie root, List sub)
	{
		if(root != null) {
			inorder(root.left, sub);
			sub.insertLast(root);
			inorder(root.right, sub);
		}	
	}
	
//Everything is done now and you just need to Print the root which the Print method handle

	public void done() {
		Print(root);
	}
	
//Print the end result and everything.

	public void Print(Movie root) {
		if(root != null) {
			Print(root.left);
			System.out.println(root.title);
			Print(root.right);
		}
	}
}






