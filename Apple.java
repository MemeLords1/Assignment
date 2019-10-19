public class Apple extends Fruit {
   public Apple(String name, String taste, double size){
      super(name,taste,size);
     }
   public String eat(){
      return name + " is " + taste;
}
 public static void main(String [] args){
 Apple AppleEat = new  Apple("APPLE "," taste like apple",1);
 System.out.println(AppleEat.eat());
      } 
}
