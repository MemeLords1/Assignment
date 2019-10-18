
public class Apple extends Fruit {
   
   
   
   public Apple(String name, String taste, double size){
   
       super(name,taste,size);

     }

@Override
   public String eat(){
     return name + " is " + taste;
//return name ;

}
 public static void main(String [] args){
 //System.out.println(super(name));
 Apple myA=new  Apple("APPLE "," has flavor",54.87);
 System.out.println(myA.eat());
 
 
      } 

}