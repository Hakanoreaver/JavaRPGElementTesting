/**
 * Created by Hakanoreaver on 20/6/18.
 */
public class ItemDetails {

    public static void itemRightClick(String item, Player player) {
        switch (item) {
            case "Sword" :
                player.swingSword();
                break;
            case "ManaPotion":
                System.out.println(item);
                break;
            case "HealthPotion" :
                System.out.println(item);
        }
    }

    public static void itemLeftClick(String item) {
        switch (item) {
            case "Sword" :
                System.out.println(item);
                break;
            case "ManaPotion":
                System.out.println(item);
                break;
            case "HealthPotion" :
                System.out.println(item);
        }
    }

}

