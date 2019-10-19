public class Orange extends Fruit {
   public Orange(String name, String taste, double size){
       super(name,taste,size);
     }
   public String eat(){
     return name + " is " + taste;
}
 public static void main(String [] args){
 Orange orangeEat = new Orange("orange ","orange Taste ",1);
 System.out.println(orangeEat.eat());
      } 

}