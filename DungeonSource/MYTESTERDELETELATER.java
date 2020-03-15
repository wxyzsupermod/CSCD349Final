import java.util.Random;

public class MYTESTERDELETELATER {

	public static void main(String[] args) {
   
      Room[][] rooms = new Room[5][5];
      
      System.out.print("**********************");
      for(int i =0; i < rooms.length; i++){
         System.out.println();  
         System.out.print("*");   
         
         for(int j = 0; j < rooms.length; j++){         
            rooms[i][j] = new Room();
            System.out.print(rooms[i][j] + " ");
            System.out.print("|");
         }
         System.out.print("*");
      }
      System.out.println();
      System.out.println("**********************");
   }
}