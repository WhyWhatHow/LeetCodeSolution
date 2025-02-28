package leetcode.algorithm.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2353 {

    public static void main(String[] args) {
        Solution_2353 sol = new Solution_2353();
        System.out.println("abc".compareTo("de"));
        System.out.println("==================");
        FoodRatings foodRatings = new FoodRatings(new String[]{"kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"},

                new String[]{"korean", "japanese", "japanese", "greek", "japanese", "korean"},
                new int[]{9, 12, 8, 15, 14, 7});
        foodRatings.highestRated("korean"); // 返回 "kimchi"
        // "kimchi" 是分数最高的韩式料理，评分为 9 。
        foodRatings.highestRated("japanese"); // 返回 "ramen"
        // "ramen" 是分数最高的日式料理，评分为 14 。
        foodRatings.changeRating("sushi", 16); // "sushi" 现在评分变更为 16 。
        foodRatings.highestRated("japanese"); // 返回 "sushi"
        // "sushi" 是分数最高的日式料理，评分为 16 。
        foodRatings.changeRating("ramen", 16); // "ramen" 现在评分变更为 16 。
        foodRatings.highestRated("japanese"); // 返回 "ramen"
        // "sushi" 和 "ramen" 的评分都是 16 。
        // 但是，"ramen" 的字典序比 "sushi" 更小。

    }


}

class Food {
    String name;
    int rating;

    public Food(String name, int rating) {
        this.name = name;
        this.rating = rating;
    }
}

class FoodRatings {
    // food, i_rating
    HashMap<String, Integer> fmap = new HashMap<>(); // food, idx. 
    HashMap<String, ArrayList<Integer>> cmap = new HashMap<>();
    String[] foods;
    String[] cuisines;
    int[] ratings;

    // cuisine , rate_idxs.
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        this.foods = foods;
        this.cuisines = cuisines;
        this.ratings = ratings;
        for (int i = 0; i < ratings.length; i++) {
            fmap.put(foods[i], i);
            int finalI = i;
            cmap.compute(cuisines[i], (k, v) -> {
                if (v == null) {
                    v = new ArrayList<Integer>();
                }
                v.add(finalI);
                return v;
            });
        }
    }

    public void changeRating(String food, int newRating) {
        Integer i = fmap.get(food);
        ratings[i] = newRating;
    }

    PriorityQueue<Food> pq = new PriorityQueue<>((a, b) -> {
        if (a.rating != b.rating) return b.rating - a.rating;
        else return a.name.compareTo(b.name);
    });

    public String highestRated(String cuisine) {
        ArrayList<Integer> list = cmap.get(cuisine);
//        pq.clear();
//        for (Integer i : list) {
//            pq.add(new Food(foods[i], ratings[i]));
//        }
//        return pq.peek().name;
        int maxRating = ratings[list.get(0)];
        String maxName = foods[list.get(0)];
        for (int i = 1; i < list.size(); i++) {
            int idx = list.get(i);
            if (maxRating < ratings[idx]) {
                maxRating = ratings[idx];
                maxName = foods[idx];
            } else if (maxRating == ratings[idx] && maxName.compareTo(foods[idx]) > 0) {
                maxName = foods[idx];
            }
        }
        return maxName;
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */