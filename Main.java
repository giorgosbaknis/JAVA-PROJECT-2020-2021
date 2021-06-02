
public class Main {

    public static void main(String[] args) {

        Organization org = new Organization();

        Material milk = new Material("milk", "Milk", 1, 10, 20, 40);
        Material sugar = new Material("sugar", "Sugar", 2, 2, 3, 4);
        Material rice = new Material("rice", "Rice", 3, 2, 3, 4);

        Service NurserySupport = new Service("NurserySupport", "nosokoma", 4);
        Service BabySitting = new Service("BabySitting", "BabySitting", 5);
        Service MedicalSupport = new Service("MedicalSupport", "MedicalSupport", 6);

        Admin admin = new Admin("Baknis","5554351231");
        org.setAdmin(admin);

        Beneficiary beneficiary1 =new Beneficiary("Kostas","6975554123",2);
        Beneficiary beneficiary2 =new Beneficiary("Maria","6985554169",3);
        Donator donator = new Donator("Babis", "6976666661");


        org.addEntity(milk);
        org.addEntity(BabySitting);
        org.addEntity(rice);
        org.addEntity(sugar);
        
        Organization.insertBeneficiary(beneficiary1);
        Organization.insertBeneficiary(beneficiary2);
        Organization.insertDonator(donator);

        donator.add(new RequestDonation(milk,100));
        donator.add(new RequestDonation(rice,4));
        donator.add(new RequestDonation(sugar,5));
        donator.add(new RequestDonation(BabySitting,10));

        donator.commit();


        currStringPhone = beneficiary1.getPhone();
        beneficiary1.addRequest(new RequestDonation(milk,1));
        beneficiary1.addRequest(new RequestDonation(rice,1));

        beneficiary1.commitRequests();
        currStringPhone = "";


        Menu menu = new Menu();
        menu.check();

    }

    private static String currStringPhone;

    public static String getCurrUserPhone() {
        return currStringPhone;
    }
}
