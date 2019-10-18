
public class Orange extends Fruit {
   
   
   
   public Orange(String name, String taste, double size){
   
       super(name,taste,size);

     }

@Override
   public String eat(){
     return name + " is " + taste;
//return name ;

}
 public static void main(String [] args){
 //System.out.println(super(name));
 Orange myOrange=new Orange("orange ","  nice",54.87);
 System.out.println(myOrange.eat());
 
      } 

}