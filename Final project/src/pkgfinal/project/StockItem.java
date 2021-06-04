/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal.project;

/**

 @author EMAM
 */
public abstract class StockItem implements Comparable<StockItem> {

      protected String brand;
      protected double discount;
      protected double price;

      public StockItem(String _brand, double _discount, double _price) {
            this.brand = _brand;
            this.discount = _discount;
            this.price = _price;
      }

      @Override
      public int compareTo(StockItem _o) {
            return brand.compareTo(_o.brand);
      }

      @Override
      public boolean equals(Object _obj) {
            return super.equals(_obj); //To change body of generated methods, choose Tools | Templates.
      }

      public String getBrand() {
            return brand;
      }

      public void setBrand(String _brand) {
            this.brand = _brand;
      }

      public double getDiscount() {
            return discount;
      }

      public void setDiscount(double _discount) {
            this.discount = _discount;
      }

      public double getPrice() {
            return price;
      }

      public void setPrice(double _price) {
            this.price = _price;
      }

      @Override
      public String toString() {
            return this.brand + " ($" + this.price + ") " + (discount > 0 ? ("has discount =" + this.discount * 100 + "%") : "");
      }

      public abstract double taxCal();

      public double getPriceAfterDiscount() {
            return this.price * (1 - this.discount);
      }

}
