package data;

import java.io.Serializable;
import java.util.*;
import util.MyToys;

public class FoodList implements Serializable {
    private ArrayList < Food > foodList = new ArrayList < > ();
    
    long millis = System.currentTimeMillis() - 24 * 60 * 60 * 1000;
    Date today = new java.util.Date(millis);

    public ArrayList < Food > getFoodList() {
        return foodList;
    }

    public void setFoodList(ArrayList < Food > foodList) {
        this.foodList = foodList;
    }

    //    search Food ra vị trí
    public int searchFoodById(String id) {
        for (int i = 0; i < foodList.size(); i++)
            if (foodList.get(i).getId().compareToIgnoreCase(id) == 0)
                return i;
        return -1;
    }
    //    search Food ra nguyên Food
    public Food searchObjectFoodById(String id) {
        if (foodList.isEmpty())
            return null;
        for (Food p: foodList)
            if (p.getId().compareToIgnoreCase(id) == 0)
                return p;
        return null;
    }
    //
    private ArrayList < Food > searchListFoodById(String key) {
        ArrayList < Food > res = new ArrayList < > ();
        for (Food p: foodList) {
            if (p.getId().contains(key))
                res.add(p);
        }
        return res;
    }

    public void searchFoodList() {
        if (foodList.isEmpty()) {
            System.out.println("The refrigerator is empty. Nothing to print.");
            return;
        }
        String key = MyToys.getString("Enter food's ID: ", "I can't understand you");
        key = key.toUpperCase();
        ArrayList < Food > res;
        res = searchListFoodById(key);
        if (res.isEmpty()) {
            System.err.println("Not found");
        } else {
            System.out.println("Here is the food that you wanna search");
            String header;
            header = String.format("|%-8s|%-5s|%-6s|%-11s|%-9s|%-8s|%-15s|",
                " MODEL  ", " RAM ", "CAMERA", "SCREEN SIZE", "  PRICE  ", "COLOR", "BRANCH");
            System.out.println(header);
            for (Food p: res)
                p.showDetail();
        }
    }

    public void remove() {
        if (foodList.isEmpty()) {
            System.out.println("The refrigerator is empty. Nothing to print.");
            return;
        }
        String key = MyToys.getString("Enter food's id: ", "I can't understand you");
        key = key.toUpperCase();
        ArrayList < Food > res;
        res = searchListFoodById(key);
        if (res.isEmpty()) {
            System.err.println("Not found");
        } else {
            System.out.println("Here is the food that you wanna search");
            String header;
            header = String.format("|%-8s|%-5s|%-6s|%-11s|%-9s|%-8s|%-15s|",
                " MODEL  ", " RAM ", "CAMERA", "SCREEN SIZE", "  PRICE  ", "COLOR", "BRANCH");
            System.out.println(header);
            for (Food p: res)
                p.showDetail();
            int choice = MyToys.getAnInteger("Enter number of row you wanna remove: ", "Invalid", 1, res.size());
            boolean check = MyToys.getBoolean("Are you sure removing this food (Y/N): ",
                "Invalid");
            if (check) {
                foodList.remove(res.get(choice - 1));
                System.out.println("A food's profile is sucessfully removed");
            }
        }
    }

    public void searchFoodById() {
        if (foodList.isEmpty()) {
            System.out.println("The refrigerator is empty. Nothing to print.");
            return;
        }
        String id;
        Food x;
        id = MyToys.getID("Enter food's ID (AA-DDDDD)\nA matches any alphabet\nD matches any digit: ", "Invalid", "^[A-Za-z]{2}-\\d{5}$");
        x = searchObjectFoodById(id);
        System.out.println("----------------------------------------------------------------------");
        if (x == null)
            System.err.println("Not found");
        else {
            System.out.println("Here is the food that you wanna search");
            String header;
            header = String.format("|%-8s|%-5s|%-6s|%-11s|%-9s|%-8s|%-15s|",
                " MODEL  ", " RAM ", "CAMERA", "SCREEN SIZE", "  PRICE  ", "COLOR", "BRANCH");
            System.out.println(header);
            x.showDetail();
        }
    }

    public void addNewFood() {
        String id, name, type, place;
        Date expiredDate;
        int pos, weight;
        do {
            id = MyToys.getID("Enter food's id (AA-DDDDD)\nA matches any alphabet\nD matches any digit: ", "Invalid", "^[A-Za-z]{2}-\\d{5}$");
            pos = searchFoodById(id);
            if (pos != -1)
                System.err.println("This food ID is already exist");
        } while (pos != -1);
        // private String id;
//    private String name;
//    private int weight;
//    private String type;
//    private String place;
//    private Date expiredDate;
        name = MyToys.getAName("Enter food's name: ", 
                "Food's name just contains characters and space");
        weight = MyToys.getAnInteger("Enter food's weight: "
                , "Food's weight must be an integer between 1 and 10000", 1, 10000);
        
        boolean check = MyToys.getBoolean("Are you sure adding this food (Y/N): ",
            "Invalid");
        if (check) {
            foodList.add(new Food(id, ram, primaryCamera, screenSize, price, color, branch));
            System.out.println("A food's profile is sucessfully added");
        }
    }

    public void removeFood() {
        if (foodList.isEmpty()) {
            System.out.println("The refrigerator is empty. Nothing to print.");
            return;
        }
        String id;
        int pos;
        id = MyToys.getID("Enter food's id (AA-DDDDD)\nA matches any alphabet\nD matches any digit: ", "Invalid", "^[A-Za-z]{2}-\\d{5}$");
        pos = searchFoodById(id);
        if (pos == -1) {
            System.err.println("Not found");
        } else {
            String header = String.format("|%-8s|%-5s|%-6s|%-11s|%-9s|%-8s|%-15s|",
                " MODEL  ", " RAM ", "CAMERA", "SCREEN SIZE", "  PRICE  ", "COLOR", "BRANCH");
            System.out.println(header);
            foodList.get(pos).showDetail();
            boolean check = MyToys.getBoolean("Are you sure removing this food (Y/N): ",
                "Invalid");
            if (check) {
                foodList.remove(pos);
                System.out.println("A food's profile is sucessfully removed");
            }
        }
    }

    public void printManagerListAscById() {
        if (foodList.isEmpty()) {
            System.out.println("The refrigerator is empty. Nothing to print.");
            return;
        }
        Collections.sort(foodList);
        System.out.println("Here is the food list");
        System.out.println(" ____________________________________________________________________ ");
        String header = String.format("|%-8s|%-5s|%-6s|%-11s|%-9s|%-8s|%-15s|",
            " MODEL  ", " RAM ", "CAMERA", "SCREEN SIZE", "  PRICE  ", "COLOR", "BRANCH");
        System.out.println(header);
        for (Food p: foodList) {
            p.showDetail();
        }
    }
}