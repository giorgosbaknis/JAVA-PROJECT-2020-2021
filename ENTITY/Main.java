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
        Material milk = new Material("milk", "Milk", 1, 10, 20, 40);
        Material sugar = new Material("sugar", "Sugar", 2, 2, 3, 4);
        Material rice = new Material("rice", "Rice", 3, 2, 3, 4);

        Service NurserySupport = new Service("NurserySupport", "nosokoma", 4);
        Service BabySitting = new Service("BabySitting", "BabySitting", 5);
        Service MedicalSupport = new Service("MedicalSupport", "MedicalSupport", 6);

        Admin admin = new Admin("Baknis","555435123");
        org.setAdmin(admin);
        //Beneficiary beneficiary1 =new Beneficiary("Kostas","6975554123",2);
        Beneficiary beneficiary2 =new Beneficiary("Maria","6985554169",3);
        Donator donator = new Donator("Babis", "697666666");
        Donator donator3 = new Donator("Bs", "6976632");
        Donator donator1 = new Donator("Bas", "69766663266"); Donator donator4 = new Donator("Babi", "69766632131666");
        Donator donator2 = new Donator("Bab", "6976666612316");
        Beneficiary beneficiary5 =new Beneficiary("DOT","6985534534",2);



Organization.getCurrentDonations().add(new RequestDonation(milk,100));


    //org.insertBeneficiary(beneficiary1);
    org.insertBeneficiary(beneficiary5);
    org.insertDonator(donator);

        org.insertDonator(donator1);org.insertDonator(donator2);org.insertDonator(donator3);org.insertDonator(donator4);
    org.addEntity(milk);
    org.addEntity(BabySitting);
    org.addEntity(rice);
    Menu menu = new Menu();
    menu.check();







    }
}
