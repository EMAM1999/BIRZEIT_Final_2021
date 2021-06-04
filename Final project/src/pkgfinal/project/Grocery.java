/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal.project;
import java.util.Date;

/**

 @author EMAM
 */
public class Grocery extends StockItem {

      private Date expiryDate;
      public double weight;

      public Grocery(String _brand, double _discount, double _price, Date _expiryDate, double _weight) {
            super(_brand, _discount, _price);
            this.expiryDate = _expiryDate;
            this.weight = _weight;
      }

      public Date getExpiryDate() {
            return expiryDate;
      }

      public void setExpiryDate(Date _expiryDate) {
            this.expiryDate = _expiryDate;
      }

      public double getWeight() {
            return weight;
      }

      public void setWeight(double _weight) {
            this.weight = _weight;
      }

      @Override
      public double taxCal() {
            double taxRatio = 0.0575;
            return this.price * taxRatio;
      }

      @Override
      public String toString() {
            return super.toString() + ", expiry Year = " + this.expiryDate.getYear() + ", Weight (" + this.weight + "Kg)"
                    + (this.discount > 0 ? "\nafter discount price is ($" + this.getPriceAfterDiscount() + ") " : "")
                    + ", after tax included ($" + this.price * (1 + this.taxCal()) + ")";
      }

}
