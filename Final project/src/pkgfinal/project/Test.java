/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal.project;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**

 @author EMAM
 */
public class Test {

      private static Scanner in = new Scanner(System.in);

      /**
       @param args the command line arguments
       @throws java.io.FileNotFoundException
       */
      public static void main(String[] args) throws FileNotFoundException, IOException {

            // 1. Create a stock
            Stock stock = new Stock("Al-Mashhadawi", new Location("Lacasa Mall ", "Arehan", "Ramallah"));
            ArrayList<StockItem> items = new ArrayList<>();

            // display menu
            display(items);
            System.out.println("Choose item: ");
            int index = in.nextInt();
            if ( items.size() < index ) {
                  System.out.println("The number is wrong");
            } else {
                  printItem(items.get(index - 1));
            }

            // 3. Read data
            items = read("data.txt");
            for ( StockItem item: items ) {
                  stock.addStockItem(item);
            }

            // 4. add items
            StockItem item;
            System.out.println("Choose item\n 1. Grocery\n 1. Electronic");
            String num = in.next();

            String[] data = getMainData();
            String brand = data[0];
            double discount = Double.parseDouble(data[1]);
            double price = Double.parseDouble(data[2]);

            switch ( num ) {
                  case "1":
                        int year = in.nextInt();
                        Date expiryDate = new Date(year);
                        double weight = in.nextDouble();

                        item = new Grocery(brand, discount, price, expiryDate, weight);

                        items.add(item);
                        write("data.txt", items);
                        break;
                  case "2":
                        String type = in.next();
                        double power = in.nextDouble();

                        item = new Electronic(brand, discount, price, type, power);

                        items.add(item);
                        write("data.txt", items);
                        break;
                  default:
                        System.err.println("wrong choise " + num);
            }

            // 5. expired Grocery items
            printExpired(items);

            // 6. print the Electronics items having discount
            print(items);

            // 7. Print all stock items sorted by brand in descending "report.txt"
            write("report.txt", stock.SortItems());
      }

      private static void display(ArrayList<StockItem> _items) {
            for ( int i = 0; i < _items.size(); i++ ) {
                  System.out.println(i + 1 +" ->  "+ _items.get(i).getBrand());
            }
      }

      private static String[] getMainData() {
            String[] data = new String[3];
            System.out.println("Enter brand: ");
            data[0] = in.next();
            System.out.println("Enter discount: ");
            data[1] = in.nextDouble() + "";
            System.out.println("Enter price: ");
            data[2] = in.nextDouble() + "";
            return data;
      }

      private static void print(ArrayList<StockItem> items) {
            for ( StockItem item: items ) {
                  if ( item instanceof Electronic ) {
                        if ( item.getDiscount() > 0 ) {
                              System.out.println(item.getBrand()
                                      + " (" + ((Electronic)item).getType() + ") "
                                      + "After the discount price is " + item.getPriceAfterDiscount());
                        }
                  }
            }
      }

      private static void printExpired(ArrayList<StockItem> items) {
            Calendar now = Calendar.getInstance();
            Calendar expiredDate = Calendar.getInstance();
            for ( StockItem item: items ) {
                  if ( item instanceof Grocery ) {
                        Date date = ((Grocery)item).getExpiryDate();
                        expiredDate.set(date.getYear(), date.getMonth(), date.getDay());
                        if ( !expiredDate.before(now) ) {
                              System.out.println(((Grocery)item).toString());
                        }
                  }
            }
      }

      private static void printItem(StockItem item) {
            if ( item instanceof Grocery ) {
                  System.out.println((Grocery)item);
            } else {
                  System.out.println((Electronic)item);
            }
      }

      private static ArrayList<StockItem> read(String filePath) throws FileNotFoundException {
            ArrayList<StockItem> items = new ArrayList<>();

            Scanner file = new Scanner(new File(filePath));
            while ( file.hasNextLine() ) {
                  String line = file.nextLine();
                  String[] data = line.split(",");

                  String brand = data[1];
                  double discount = Double.parseDouble(data[2]);
                  double price = Double.parseDouble(data[3]);

                  if ( data[0].equalsIgnoreCase("Grocery") ) {
                        Date date = new Date(Integer.parseInt(data[3]), 0, 0);
                        double weight = Double.parseDouble(data[5]);
                        Grocery item = new Grocery(brand, discount / 100., price, date, weight);
                        items.add(item);
                  } else if ( data[0].equalsIgnoreCase("Electronic") ) {
                        String type = data[3];
                        double power = Double.parseDouble(data[5]);
                        Electronic item = new Electronic(brand, discount / 100., price, type, power);
                        items.add(item);
                  }
            }
            return items;
      }

      private static void write(String filePath, ArrayList<StockItem> items) throws IOException {
            FileWriter writer = new FileWriter(new File(filePath));
            for ( StockItem item: items ) {
                  writer.write(item.toString());
                  writer.write("\n");
            }
      }

}
