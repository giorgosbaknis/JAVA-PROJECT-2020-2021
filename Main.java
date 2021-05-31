
public class Main {

    public static void main(String[] args) {

        Organization org = new Organization();
        Material milk = new Material("milk", "Milk", 1, 10, 20, 40);
        Material sugar = new Material("sugar", "Sugar", 2, 2, 3, 4);
        Material rice = new Material("rice", "Rice", 3, 2, 3, 4);
        Material cocaine = new Material("cocaine", "Cocaine", 7, 25, 35, 45);
        Material peppers = new Material("Pepper", "Red or Green", 8, 29, 39, 49);


        Service NurserySupport = new Service("NurserySupport", "nosokoma", 4);
        Service BabySitting = new Service("BabySitting", "BabySitting", 5);
        Service MedicalSupport = new Service("MedicalSupport", "MedicalSupport", 6);

        Admin admin = new Admin("Baknis","555435123");
        org.setAdmin(admin);
        Beneficiary beneficiary1 =new Beneficiary("Kostas","6975554123",2);
        Beneficiary beneficiary2 =new Beneficiary("Maria","6985554169",3);
        Donator donator = new Donator("Babis", "697666666");


        org.addEntity(milk);
        org.addEntity(BabySitting);
        org.addEntity(rice);
        org.addEntity(sugar);
        org.addEntity(peppers);
        org.addEntity(cocaine);


        Organization.insertBeneficiary(beneficiary1);
        Organization.insertBeneficiary(beneficiary2);
        Organization.insertDonator(donator);

        donator.add(new RequestDonation(milk,100));
        donator.add(new RequestDonation(rice,4));
        donator.add(new RequestDonation(sugar,5));
        donator.add(new RequestDonation(peppers,5));
        donator.add(new RequestDonation(cocaine,10));

        donator.commit();
beneficiary1.getRecievedList().reset();
beneficiary1.getRequestsList().reset();

       currStringPhone = beneficiary1.getPhone();
        beneficiary1.addRequest(new RequestDonation(milk,1));
        beneficiary1.addRequest(new RequestDonation(rice,1));
        beneficiary1.addRequest(new RequestDonation(sugar,1));
        beneficiary1.addRequest(new RequestDonation(peppers,5));
        beneficiary1.addRequest(new RequestDonation(cocaine,4));

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
