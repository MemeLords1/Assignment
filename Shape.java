public class Shape {
//   private String draw, erasing;
                  
   public Shape(){
//      draw = "drawing shape";
//      erasing = "erasing shape";   
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