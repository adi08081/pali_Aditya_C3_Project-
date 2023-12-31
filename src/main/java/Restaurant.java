import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private String name;
    private String location;
    public LocalTime openingTime;
    public LocalTime closingTime;
    private List<Item> menu = new ArrayList<Item>();

    public Restaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        this.name = name;
        this.location = location;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }

    public Restaurant(LocalTime of, LocalTime of1) {

    }

    public boolean isRestaurantOpen(LocalTime currentTime) {
        LocalTime currentTime1 = LocalTime.now();
        return !currentTime.isBefore(openingTime) && !currentTime.isAfter(closingTime);

    }
    Restaurant restaurant = new Restaurant(LocalTime.of(10, 0), LocalTime.of(20, 0));

    private LocalTime currentTime1;
    boolean isOpen = restaurant.isRestaurantOpen(currentTime1);{

        if (isOpen) {
        System.out.println("The restaurant is open.");
    } else {
        System.out.println("The restaurant is closed.");
    }
}

 //public LocalTime getCurrentTime(){ return  LocalTime.now(); }

    public List<Item> getMenu() {
        List<Item> menuItems = new ArrayList<>();

        menuItems.add(new Item("Masala Dosa", (int) 10.99));
        menuItems.add(new Item("Idli sambhar", (int) 8.49));
        menuItems.add(new Item("Medu vada", (int) 12.99));


        return menuItems;
        //DELETE ABOVE RETURN STATEMENT AND WRITE CODE HERE
    }

    private Item findItemByName(String itemName){
        for(Item item: menu) {
            if(item.getName().equals(itemName))
                return item;
        }
        return null;
    }

    public void addToMenu(String name, int price) {
        Item newItem = new Item(name,price);
        menu.add(newItem);
    }
    
    public void removeFromMenu(String itemName) throws itemNotFoundException {

        Item itemToBeRemoved = findItemByName(itemName);
        if (itemToBeRemoved == null)
            throw new itemNotFoundException(itemName);

        menu.remove(itemToBeRemoved);
    }
    public void displayDetails(){
        System.out.println("Restaurant:"+ name + "\n"
                +"Location:"+ location + "\n"
                +"Opening time:"+ openingTime +"\n"
                +"Closing time:"+ closingTime +"\n"
                +"Menu:"+"\n"+getMenu());

    }

    public String getName() {
        return name;
    }

}
