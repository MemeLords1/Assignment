public class Triangle extends Shape {
   
   public Triangle()	{
      super();
   }
   @Override
   public String draw(){
      return " drawing Triangle";
   }
   
    public String erase(){
      return " Eraseing Triangle";
   }
   public static	void main (String	[]	args){
      Triangle myc= new Triangle();
      System.out.println(myc.draw());
      System.out.println(myc.erase());
   
   } 
   	
}