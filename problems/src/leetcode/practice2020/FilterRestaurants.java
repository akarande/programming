package leetcode.practice2020;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author akarande
 * 1333. Filter Restaurants by Vegan-Friendly, Price and Distance
 * https://leetcode.com/problems/filter-restaurants-by-vegan-friendly-price-and-distance/submissions/
 **/
public class FilterRestaurants {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        List<Restaurant>list = new ArrayList<>();
        for(int[] r : restaurants) list.add(new Restaurant(r[0], r[1], r[2], r[3], r[4]));
        List<Integer> sortedIds = list.stream()
            .filter(r -> (veganFriendly == 0 || r.isVegan == veganFriendly && veganFriendly == 1) && r.price <= maxPrice && r.distance <= maxDistance)
            .sorted((a, b) -> {
                if (a.rating == b.rating) return b.id - a.id;
                return b.rating - a.rating;
            })
            .map(r -> r.id)
            .collect(Collectors.toList());
        return sortedIds;
    }

    class Restaurant {
        int id, rating, isVegan, price, distance;
        public Restaurant(int id, int rating, int isVegan, int price, int distance) {
            this.id = id;
            this.rating = rating;
            this.isVegan = isVegan;
            this.price = price;
            this.distance = distance;
        }
    }

    public static void main(String[] args) {
        FilterRestaurants restaurants = new FilterRestaurants();
        int[][] res = {{1,4,1,40,10},{2,8,0,50,5},{3,8,1,30,4},{4,10,0,10,3},{5,1,1,15,1}};
        int isVegan = 1, maxPrice = 50, maxDistance = 10;
        List<Integer> list = restaurants.filterRestaurants(res, isVegan, maxPrice, maxDistance);
        System.out.println("list.to = " + list.toString());
    }
}
