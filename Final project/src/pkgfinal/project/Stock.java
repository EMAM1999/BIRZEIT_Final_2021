/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal.project;
import java.util.ArrayList;
import java.util.Comparator;

/**

 @author EMAM
 */
public class Stock {

      private String name;
      private ArrayList<StockItem> items;
      private Location loc;
      public Stock(String _name, Location _loc) {
            this.name = _name;
            this.items = new ArrayList<>();
            this.loc = _loc;
      }

      public ArrayList<StockItem> getItems() {
            return items;
      }

      public String getName() {
            return name;
      }

      public void addStockItem(StockItem _item) {
            items.add(_item);
      }

//      public sortItem()
      public int countElectronic() {
            int count = 0;
            for ( StockItem item: items ) {
                  if ( item instanceof Electronic ) {
                        count++;
                  }
            }
            return count;
      }

      public int countGrocery() {
            return items.size() - countElectronic();
      }

      public ArrayList<StockItem> SortItems() {
            items.sort(new Comparator<StockItem>() {
                  @Override
                  public int compare(StockItem _o1, StockItem _o2) {
                        return _o1.brand.compareTo(_o2.brand);
                  }
            });
            return items;
      }
}
