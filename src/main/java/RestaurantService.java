import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class RestaurantService {
    private static List<Restaurant> restaurants = new ArrayList<>();
    private Restaurant[] restaurant;

    public Restaurant findRestaurantByName(String restaurantName){
        for (Restaurant restaurant : restaurant) {
            if (restaurant.getName().equals(restaurantName)) {
                return restaurant; // Found a restaurant with the given name
            }
        }

        return null; // Restaurant not found
    }
        //DELETE ABOVE STATEMENT AND WRITE CODE HERE


    public Restaurant addRestaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        Restaurant newRestaurant = new Restaurant(name, location, openingTime, closingTime);
        restaurants.add(newRestaurant);
        return newRestaurant;
    }

    public Restaurant removeRestaurant(String restaurantName) throws restaurantNotFoundException {
        Restaurant restaurantToBeRemoved = findRestaurantByName(restaurantName);
        restaurants.remove(restaurantToBeRemoved);
        return restaurantToBeRemoved;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }
}
