package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*
    class chứa các hàm đồ chơi cho việc nhập dữ liệu
*/
public class MyToys {
    private static Scanner sc = new Scanner(System.in);
    
    public static String foodCategory[] = {"Vegetables",
                                    "Fruits",
                                    "Grains, legumes, nuts and seeds",
                                    "Meat and poultry",
                                    "Fish and seafood",
                                    "Dairy food",
                                    "Eggs"};
    
    public static String placeList[] = {"Freezer compartment",
                                    "Ice cube tray",
                                    "Meat keeper",
                                    "Refrigerator compartment",
                                    "Glass cover",
                                    "Crisper",
                                    "Egg tray",
                                    "Butter compartment",
                                    "Dairy compartment",
                                    "Door shelf",
                                    "Guard rail"};
    
    public static int getAnInteger(String inputMsg, String erroMsg) {
        int n;
        while (true) {
            try {
                System.out.print(inputMsg);
                n = Integer.parseInt(sc.nextLine());
                return n;
            } catch (Exception e) {
                System.err.println(erroMsg);
            }
        }
    }
    /*
    xây dựng hàm lấy số nguyên nguyên từ lowerBound dến upperBound
    */
    public static int getAnInteger(String inputMsg, String errorMsg, int lowerBound, int upperBound) {
        if (upperBound < lowerBound) {
            int tmp = upperBound;
            upperBound = lowerBound;
            lowerBound = tmp;
        }
        int n;
        while (true) {
            try {
                System.out.print(inputMsg);
                n = Integer.parseInt(sc.nextLine());
                if (n < lowerBound || n > upperBound) {
                    throw new Exception();
                }
                return n;
            } catch (Exception e) {
                System.err.println(errorMsg);
            }
        }
    }
    public static long getAnLong(String inputMsg, String errorMsg, long lowerBound, long upperBound) {
        if (upperBound < lowerBound) {
            long tmp = upperBound;
            upperBound = lowerBound;
            lowerBound = tmp;
        }
        long n;
        while (true) {
            try {
                System.out.print(inputMsg);
                n = Integer.parseInt(sc.nextLine());
                if (n < lowerBound || n > upperBound) {
                    throw new Exception();
                }
                return n;
            } catch (Exception e) {
                System.err.println(errorMsg);
            }
        }
    }


    public static double getADouble(String inputMsg, String erroMsg) {
        double n;
        while (true) {
            try {
                System.out.print(inputMsg);
                n = Double.parseDouble(sc.nextLine());
                return n;
            } catch (Exception e) {
                System.err.println(erroMsg);
            }
        }
    }

    public static double getADouble(String inputMsg, String erroMsg, double lowerBound, double upperBound) {
        if (upperBound < lowerBound) {
            double tmp = upperBound;
            upperBound = lowerBound;
            lowerBound = tmp;
        }
        double n;
        while (true) {
            try {
                System.out.print(inputMsg);
                n = Double.parseDouble(sc.nextLine());
                if (n < lowerBound || n > upperBound) {
                    throw new Exception();
                }
                return n;
            } catch (Exception e) {
                System.err.println(erroMsg);
            }
        }
    }

    public static String getID(String inputMsg, String errorMsg, String format) {
        String id;
        boolean match;
        while (true) {
            System.out.print(inputMsg);
            id = sc.nextLine().trim().toUpperCase();
            match = id.matches(format);
            if (id.length() == 0 || id.isEmpty() || !match) {
                System.err.println(errorMsg);
            } else {
                return id;
            }
        }
    }

    public static String getString(String inputMsg, String errorMsg) {
        String string;
        while (true) {
            System.out.print(inputMsg);
            string = sc.nextLine().trim();
            string = string.replaceAll("\\s+", " ");
            if (string.length() == 0 || string.isEmpty()) {
                System.err.println(errorMsg);
            } else {
                String temp[] = string.split(" ");
                string = ""; // ? ^-^
                for (int i = 0; i < temp.length; i++) {
                    string += String.valueOf(temp[i].charAt(0)) + temp[i].substring(1);
                    if (i < temp.length - 1) // ? ^-^
                        string += " ";
                }
                return string;
            }
        }
    }

    public static boolean getBoolean(String inputMsg, String errorMsg) {
        String str;
        while (true) {
            System.out.print(inputMsg);
            str = sc.nextLine().trim().toUpperCase();
            if (str.compareToIgnoreCase("Y") == 0)
                return true;
            else if (str.compareToIgnoreCase("N") == 0)
                return false;
            else
                System.err.println(errorMsg);
        }
    }

    public static Date getADate(String inputMsg, String errorMsg, Date lowerBound, Date upperDate) {
        Date d;
        while (true) {
            try {
                System.out.print(inputMsg);
                SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
                d = df.parse(sc.nextLine());
                if (d.compareTo(lowerBound) < 0 || d.compareTo(upperDate) > 0) {
                    throw new Exception();
                }
                return d;
            } catch (ParseException pe) {
                System.err.println("Wrong format");
            } catch (Exception e) {
                System.err.println(errorMsg);
            }
        }
    }

    public static String getAName(String inputMsg, String errorMsg) {
        String name;
        boolean match;
        while (true) {
            System.out.print(inputMsg);
            name = sc.nextLine().trim().toLowerCase();
            name = name.replaceAll("\\s+", " ");
            match = name.matches("^[a-zA-Z\\s]*$");
            if (name.length() == 0 || name.isEmpty() || !match)
                System.err.println(errorMsg);
            else {
                String temp[] = name.split(" ");
                name = ""; // ? ^-^
                for (int i = 0; i < temp.length; i++) {
                    name += String.valueOf(temp[i].charAt(0)).toUpperCase() + temp[i].substring(1);
                    if (i < temp.length - 1) // ? ^-^
                        name += " ";
                }
                return name;
            }
        }
    }

    public static String getGender(String inputMsg, String errorMsg, String pattern) {
        String str;
        while (true) {
            System.out.print(inputMsg);
            str = sc.nextLine().trim().toUpperCase();
            String[] option = pattern.split(" ");
            if (str.compareToIgnoreCase(option[0]) == 0)
                return "FEMALE";
            else if (str.compareToIgnoreCase(option[1]) == 0)
                return "MALE";
            else if (option[2].compareToIgnoreCase(str) == 0)
                return "OTHER";
            else
                System.err.println(errorMsg);
        }
    }
}