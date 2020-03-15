public class DungeonEntity{
   private String name;
   private int changeInHealth;
   
   public String getName(){
      return this.name;
   }
   
   public void setName(String name){
      this.name = name;
   }
   
   public int getChangeInHealth(){
      return this.changeInHealth;
   }
   
   public void setChangeInHealth(int changeInHealth){
      this.changeInHealth = changeInHealth;
   }
   
   public String toString(){
      return this.name;
   }
}