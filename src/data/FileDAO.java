package data;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class FileDAO {
    public static void writeTextFile(String fileName, ArrayList<Food> data) throws FileNotFoundException {
        PrintWriter w = new PrintWriter(fileName);
        for (Food d : data) {
            w.println(d);
        }
        w.close();
    }
    //cuối file văn bản có byte đặc biệt gọi là EOF
    public static ArrayList<Food> readTextFile(String fileName) throws FileNotFoundException, IOException, ParseException {
        FileReader f = new FileReader(fileName);
        BufferedReader bf = new BufferedReader(f);
        ArrayList<Food> list = new ArrayList<>();
        while (bf.ready()) { //con chốt chặn EOF            
            String s = bf.readLine();
            String[] tmp = s.split(",");
            SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
            if (tmp.length == 6) {
                Food d = new Food(tmp[0], tmp[1], 
                        Integer.parseInt(tmp[2]), tmp[3], tmp[4], df.parse(tmp[5]));   
//            Food(id, name, weight, type, place, expiredDate);
                list.add(d);
            }
        }
        return list;
    } 
}
