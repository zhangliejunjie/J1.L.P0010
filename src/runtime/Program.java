package runtime;

import data.FileDAO;
import data.Menu;
import data.FoodList;
import java.io.IOException;
import java.text.ParseException;

public class Program {
    public static void main(String[] args) throws ParseException {
        Menu mainMenu = new Menu("HKT Store - @ 2021 by <SE161289 - Trương Lê Tuấn Kiệt> \nSelect the options below:");
        FoodList fL = new FoodList();
        try {
            fL.setFoodList(FileDAO.readTextFile("database.csv"));
        } catch (IOException ex) {
            System.err.println("File error");
        }
        mainMenu.addNewOption("1. Add a new food");
        mainMenu.addNewOption("2. Search a food by name");
        mainMenu.addNewOption("3. Remove the food by ID");
        mainMenu.addNewOption("4. Print the food list in the descending order of expired date");
        mainMenu.addNewOption("5. Quit");
        int choice = 0;
        do {
            mainMenu.printMenu();
            choice = mainMenu.getChoice();
            switch (choice) {
                case 1:
                    fL.addNewFood();
                    break;
                case 2:
                    fL.searchFoodList();
                    break;
                case 3:
                    fL.remove();
                    break;
                case 4:
                    fL.printManagerListAscByExpDate();
                    break;
                case 5:
                    try {
                        FileDAO.writeTextFile("database.csv", fL.getFoodList());
                    } catch (IOException ex) {
                        System.err.println("File error");
                    }
                    break;
            }
        } while (choice != 5);
    }
}