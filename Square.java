public class Square extends Shape {
   public Square()	{
      super();
   }
   public String draw(){
      return " drawing Square";
   }
    public String erase(){
      return " Eraseing Square";
   }
   public static	void main (String	[]	args){
      Square myc= new Square();
      System.out.println(myc.draw());
      System.out.println(myc.erase());
   } 	
}