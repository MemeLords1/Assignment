//Thomas Chen
//Exception Handling with Custom Exceptions Lab

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.io.*;

public class CustomerPrint{
  public static void main(String []args)throws Exception{
    File sourceFile = new File(args[0]);
    Scanner sc = new Scanner(System.in);
    Scanner input = new Scanner(sourceFile);
    ArrayList<Customer> people = new ArrayList<Customer>();
    if (!sourceFile.exists()) {
     System.out.println("Source file " + args[0] + " does not exist");
  }
  String info;
  String[] infos = new String[100];

  while(input.hasNext()){
    info = input.nextLine();
    infos = info.split("/");
    people.add(createObject(infos));
  }
 System.out.println("Welcome to the Customer Application");
  while(true){
    System.out.println("Display another customer? (y/n) : ");
    String x = sc.next();
    if (x.equals("n")){
      System.exit(0);
    }
    else if (x.equals("y")){
      findCustomer(people);

    }
    else{
      System.out.println("That is not a command please put y or n");
    }
  }
  }
  public static void findCustomer(ArrayList<Customer> people){
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the Customer ID:");
    String customerid = sc.nextLine();
    int matches =0;
    for (Customer customer:people){
      if (customer.getcustomernumber().equalsIgnoreCase(customerid)){
        System.out.println(customer.toString());
        matches++;
      }
    }
    if (matches <=0)
      System.out.println("The Customer " + customerid + " does not Not Exist");

  }
 
public static Customer createObject(String [] infos){
    Customer customer = new Customer();
 if(infos[4].equalsIgnoreCase("filler"))
      customer = new Customer(infos[0],infos[1],infos[2],infos[3],infos[4]);
    return customer;
  }


  
}