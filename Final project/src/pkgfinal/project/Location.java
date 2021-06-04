/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal.project;

/**

 @author EMAM
 */
public class Location {
      public String loc ;
      public String district;
      public String city;

      public Location(String _loc, String _district, String _city) {
            this.loc = _loc;
            this.district = _district;
            this.city = _city;
      }

      public String getCity() {
            return city;
      }

      public void setCity(String _city) {
            this.city = _city;
      }

      public String getDistrict() {
            return district;
      }

      public void setDistrict(String _district) {
            this.district = _district;
      }

      public String getLoc() {
            return loc;
      }

      public void setLoc(String _loc) {
            this.loc = _loc;
      }

      @Override
      public String toString() {
            return super.toString(); //To change body of generated methods, choose Tools | Templates.
      }
      
}
