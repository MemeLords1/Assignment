//Thomas Chen 
//Cisc 3115 
//Assignment #3

public class Shape {              
   public Shape(){
   }
   public String draw() {
      return "drawing shape";
   } 
   public String erase(){
      return "erasing shape";
   }
   public static void main(String [] args){
      Shape mys= new Shape();
      System.out.println(mys.draw());
   }  
}
