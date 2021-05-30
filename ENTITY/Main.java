package ENTITY;

import MENU.Menu;
import REQUESTS.Organization;
import USER.*;
import REQUESTS.*;
public class Main {
    private static String currStringPhone;

    public static String getCurrUserPhone() {
        return currStringPhone;
    }

    public static void main(String[] args) {


        Organization org = new Organization();
        Material milk = new Material("milk", "Milk", 1, 10, 20, 40);
        Material sugar = new Material("sugar", "Sugar", 2, 2, 3, 4);
        Material rice = new Material("rice", "Rice", 3, 2, 3, 4);

        Service NurserySupport = new Service("NurserySupport", "nosokoma", 4);
        Service BabySitting = new Service("BabySitting", "BabySitting", 5);
        Service MedicalSupport = new Service("MedicalSupport", "MedicalSupport", 6);

        Admin admin = new Admin("Baknis","555435123");
        org.setAdmin(admin);
        Beneficiary beneficiary1 =new Beneficiary("Kostas","6975554123",2);
        Beneficiary beneficiary2 =new Beneficiary("Maria","6985554169",3);
        Donator donator = new Donator("Babis", "697666666");
        Donator donator1 = new Donator("Danah","1234");
        org.addEntity(milk);
        org.addEntity(BabySitting);
        org.addEntity(rice);

        Organization.insertBeneficiary(beneficiary1);
        Organization.insertBeneficiary(beneficiary2);
        Organization.insertDonator(donator);
        Organization.insertDonator(donator1);


       // donator.add(new RequestDonation(milk,1000));
       // donator.add(new RequestDonation(rice,40));
       // donator.commit();
        //System.out.println(Organization.getCurrentDonations().getRdEntities());

        //currStringPhone = beneficiary1.getPhone();
        //beneficiary1.addRequest(new RequestDonation(milk,1));
        //beneficiary1.addRequest(new RequestDonation(rice,1));




    Menu menu = new Menu();
   menu.check();


    }
}
