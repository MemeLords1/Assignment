public class Apple extends Fruit {
   public Apple(String name, String taste, double size){
      super(name,taste,size);
     }
   public String eat(){
      return name + " is " + taste;
}
 public static void main(String [] args){
 Apple myA=new  Apple("APPLE "," has flavor",54.87);
 System.out.println(myA.eat());
      } 
}
