package ENTITY;

import MENU.Menu;
import REQUESTS.Organization;
import USER.*;
import REQUESTS.*;
public class Main {

    public static void main(String[] args) {

        /*
        //Test Service
        Service se = new Service("NurserySupport", "nosokoma", 5);
        Service se = new Service("NurserySupport", "nosokoma", 5);
        Service se = new Service("NurserySupport", "nosokoma", 5);
        System.out.println(se.toString());

        //Test Material
        Material mat = new Material("milk", "gala",2,1,2,3);
        System.out.println(mat.toString());
         */
        Organization org = new Organization();
        Material milk = new Material("milk", "Milk", 1, 2, 3, 4);
        Material sugar = new Material("sugar", "Sugar", 2, 2, 3, 4);
        Material rice = new Material("rice", "Rice", 3, 2, 3, 4);

        Service NurserySupport = new Service("NurserySupport", "nosokoma", 4);
        Service BabySitting = new Service("BabySitting", "BabySitting", 5);
        Service MedicalSupport = new Service("MedicalSupport", "MedicalSupport", 6);

        Admin admin = new Admin("Baknis","555435123");
        Beneficiary beneficiary1 =new Beneficiary("Kostas","6975554123",2);
        Beneficiary beneficiary2 =new Beneficiary("Maria","6985554169",3);
        Donator donator = new Donator("Babis", "697666666");
{


    //Organization.getCurrentDonations().add(new RequestDonation(milk, 100));



    org.insertBeneficiary(beneficiary1);
    org.insertBeneficiary(beneficiary2);
    org.insertDonator(donator);

   donator.add(new RequestDonation(milk, 100));
    org.addEntity(milk);
    org.addEntity(BabySitting);
    org.addEntity(rice);
    Menu menu = new Menu();



}



    }
}
