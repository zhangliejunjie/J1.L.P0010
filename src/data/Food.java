package data;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Food implements Comparable<Food>{
    private String id;
    private String name;
    private int weight;
    private String type;
    private String place;
    private Date expiredDate;

    public Food(String id, String name, int weight, String type, String place, Date expiredDate) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.type = type;
        this.place = place;
        this.expiredDate = expiredDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }
    
    public void showDetail() {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        System.out.printf("|%8s|%-10s|%-5d|%-31s|%-10s|%-10s|\n",
                    id, name, weight, type, place, expiredDate);
    }
    
//    public void showInfor() {
//        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
//        System.out.printf("|%-4d|%-15s|%-10s|%-10s|%-5d|\n", 
//                id, title, df.format(beginDate), df.format(endDate), totalHours);
//    }

    @Override
    public int compareTo(Food that) {
        return id.compareToIgnoreCase(that.getId());
    }
    
}
// private String id;
//    private String name;
//    private int weight;
//    private String type;
//    private String place;
//    private Date expiredDate;