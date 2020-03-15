import java.util.Random;

public class HealingPotion extends Potion{
   
   public HealingPotion(){
      this.setChangeInHealth(new Random().nextInt(15 - 5) + 1);
      this.setName("Healing Potion");
   }
   
   public String toString(){
      return super.toString();
   }

}