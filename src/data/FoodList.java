package data;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
     
    private ArrayList < Food > searchListFoodByName(String key) {
        ArrayList < Food > res = new ArrayList < > ();
        for (Food p: foodList) {
            if (p.getName().toLowerCase().contains(key))
                res.add(p);
        }
        return res;
    }
    
    private ArrayList < Food > searchListFoodByPlace(String key) {
        ArrayList < Food > res = new ArrayList < > ();
        for (Food p: foodList) {
            if (p.getPlace().compareToIgnoreCase(key) == 0)
                res.add(p);
        }
        return res;
    }
    
    private ArrayList < Food > searchListFoodByType(String key) {
        ArrayList < Food > res = new ArrayList < > ();
        for (Food p: foodList) {
            if (p.getType().compareToIgnoreCase(key) == 0)
                res.add(p);
        }
        return res;
    }
    
    private ArrayList < Food > searchListFoodByExpDate(Date key) {
        ArrayList < Food > res = new ArrayList < > ();
        for (Food p: foodList) {
            if (p.getExpiredDate().compareTo(key) == 0)
                res.add(p);
        }
        return res;
    }

    public void searchFoodList() throws ParseException {
        if (foodList.isEmpty()) {
            System.out.println("The refrigerator is empty. Nothing to print.");
            return;
        }
        ArrayList < Food > res = null;
        String key;
        Menu srchMenu = new Menu("Choosing filter");
        srchMenu.addNewOption("1. Search by ID");        
        srchMenu.addNewOption("2. Search by name");
        srchMenu.addNewOption("3. Search by type");
        srchMenu.addNewOption("4. Search by place");        
        srchMenu.addNewOption("5. Search by expired date");
        srchMenu.printMenu();
        int srchChoice = srchMenu.getChoice();
        switch(srchChoice) {
            case 1:
                key = MyToys.getString("Enter food's ID: ", "I can't understand you");
                key = key.toUpperCase();
                res = searchListFoodById(key);
                break;
            case 2:
                key = MyToys.getString("Enter food's name: ", "I can't understand you");
                key = key.toLowerCase();
                res = searchListFoodByName(key);
                break;
            case 3:
                Menu subMenu = new Menu("Choosing food type");
                for (int i = 0; i < MyToys.foodCategory.length; i++)
                    subMenu.addNewOption(i + 1 + ". " + MyToys.foodCategory[i]);
                subMenu.printMenu();
                int choice = subMenu.getChoice();
                key = MyToys.foodCategory[choice - 1];
                res = searchListFoodByType(key);
                break;
            case 4:
                Menu menu = new Menu("Choosing place");
                for (int i = 0; i < MyToys.placeList.length; i++)
                    menu.addNewOption(i + 1 + ". " + MyToys.placeList[i]);
                menu.printMenu();
                choice = menu.getChoice();
                key = MyToys.placeList[choice - 1];
                res = searchListFoodByPlace(key);
                break;
            case 5:
                SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
                Date keyDate = MyToys.getADate("Enter food's expired date: ", "Invalid", df.parse("01-01-2000"), df.parse("30-06-2030"));
                res = searchListFoodByExpDate(keyDate);
                break;           
        }
        if (res == null || res.isEmpty()) {
            System.err.println("Not found");
        } else {
            System.out.println("Here is the food that you wanna search");
            String header = "|   ID   |     NAME      |WEIGHT|         TYPE OF FOOD          |      PLACE TO PUT      | EXP-DATE |";
            System.out.println(header);
            for (Food p: res)
                p.showDetail();
        }
    }

    public void remove() throws ParseException {
        if (foodList.isEmpty()) {
            System.out.println("The refrigerator is empty. Nothing to print.");
            return;
        }
        ArrayList < Food > res = null;
        String key;
        Menu srchMenu = new Menu("Choosing filter");
        srchMenu.addNewOption("1. Search by ID");        
        srchMenu.addNewOption("2. Search by name");
        srchMenu.addNewOption("3. Search by type");
        srchMenu.addNewOption("4. Search by place");        
        srchMenu.addNewOption("5. Search by expired date");
        srchMenu.printMenu();
        int srchChoice = srchMenu.getChoice();
        switch(srchChoice) {
            case 1:
                key = MyToys.getString("Enter food's ID: ", "I can't understand you");
                key = key.toUpperCase();
                res = searchListFoodById(key);
                break;
            case 2:
                key = MyToys.getString("Enter food's name: ", "I can't understand you");
                key = key.toLowerCase();
                res = searchListFoodByName(key);
                break;
            case 3:
                Menu subMenu = new Menu("Choosing food type");
                for (int i = 0; i < MyToys.foodCategory.length; i++)
                    subMenu.addNewOption(i + 1 + ". " + MyToys.foodCategory[i]);
                subMenu.printMenu();
                int choice = subMenu.getChoice();
                key = MyToys.foodCategory[choice - 1];
                res = searchListFoodByType(key);
                break;
            case 4:
                Menu menu = new Menu("Choosing place");
                for (int i = 0; i < MyToys.placeList.length; i++)
                    menu.addNewOption(i + 1 + ". " + MyToys.placeList[i]);
                menu.printMenu();
                choice = menu.getChoice();
                key = MyToys.placeList[choice - 1];
                res = searchListFoodByPlace(key);
                break;
            case 5:
                SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
                Date keyDate = MyToys.getADate("Enter food's expired date: ", "Invalid", df.parse("01-01-2000"), df.parse("30-06-2030"));
                res = searchListFoodByExpDate(keyDate);
                break;           
        }
        if (res == null || res.isEmpty()) {
            System.err.println("Not found");
        } else {
            System.out.println("Here is the food that you wanna search");
            String header = "|   ID   |     NAME      |WEIGHT|         TYPE OF FOOD          |      PLACE TO PUT      | EXP-DATE |";
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
        System.out.println("-----------------------------------------------------------------------------------------------------");
        if (x == null)
            System.err.println("Not found");
        else {
            System.out.println("Here is the food that you wanna search");
            String header = "|   ID   |     NAME      |WEIGHT|         TYPE OF FOOD          |      PLACE TO PUT      | EXP-DATE |";
            System.out.println(header);
            x.showDetail();
        }
    }

    public void addNewFood() throws ParseException {
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
        weight = MyToys.getAnInteger("Enter food's weight: ", "Food's weight must be an integer between 1 and 10000", 1, 10000);
        Menu menu = new Menu("Choosing food type");
        for (int i = 0; i < MyToys.foodCategory.length; i++)
            menu.addNewOption(i + 1 + ". " + MyToys.foodCategory[i]);
        menu.printMenu();
        int choice = menu.getChoice();
        type = MyToys.foodCategory[choice - 1];
        menu = new Menu("Choosing place");
        for (int i = 0; i < MyToys.placeList.length; i++)
            menu.addNewOption(i + 1 + ". " + MyToys.placeList[i]);
        menu.printMenu();
        choice = menu.getChoice();
        place = MyToys.placeList[choice - 1];
        
        

        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        expiredDate = MyToys.getADate("Enter food's expired date: ", "Invalid", today, df.parse("30-06-2030"));
        boolean check = MyToys.getBoolean("Are you sure adding this food (Y/N): ",
            "Invalid");
        if (check) {
            foodList.add(new Food(id, name, weight, type, place, expiredDate));
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
            String header = "|   ID   |     NAME      |WEIGHT|         TYPE OF FOOD          |      PLACE TO PUT      | EXP-DATE |";
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

    public void printManagerListAscByExpDate() {
        if (foodList.isEmpty()) {
            System.out.println("The refrigerator is empty. Nothing to print.");
            return;
        }
        Collections.sort(foodList);
        System.out.println("Here is the food list");
        System.out.println(" ___________________________________________________________________________________________________ ");
        String header = "|   ID   |     NAME      |WEIGHT|         TYPE OF FOOD          |      PLACE TO PUT      | EXP-DATE |";
        System.out.println(header);
        for (Food p: foodList) {
            p.showDetail();
        }
    }
}