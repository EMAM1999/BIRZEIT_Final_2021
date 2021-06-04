/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal.project;

/**

 @author EMAM
 */
public class Electronic extends StockItem {

      private String type;
      private double power;

      public Electronic(String _brand, double _discount, double _price, String _type, double _power) {
            super(_brand, _discount, _price);
            this.type = _type;
            this.power = _power;
      }

      public double getPower() {
            return power;
      }

      public void setPower(double _power) {
            this.power = _power;
      }

      public String getType() {
            return type;
      }

      public void setType(String _type) {
            this.type = _type;
      }

      @Override
      public double taxCal() {
            double taxRatio = 0.165;
            return this.price * taxRatio;
      }

      @Override
      public String toString() {
            return super.toString()
                    + "\n(" + this.type + ") " + this.power + "Watt\n"
                    + (this.discount > 0 ? "\nafter discount price is ($" + this.getPriceAfterDiscount() + ") " : "")
                    + ", after tax included ($" + this.price * (1 + this.taxCal()) + ")";
      }

}
