

public class Offers extends RequestDonationList {


    public void commit() {
        if (!getRdEntities().isEmpty()) { //an yparxei kapoio antikeimneo poy thelei an dwrisei o Donator
            for(RequestDonation currDon:getRdEntities()) { //pernei ena ena ta entity poy thelei na kanei Donate
                Organization.getCurrentDonations().add(currDon); //to vazei sthn currentDonations toy Organization
                System.out.println("Donation committed Successfully of "+currDon.getEntity().getName());
            }
                getRdEntities().clear(); //To afairei apo thn lista toy Donator
                System.out.println("Commit Successful.\n");
        }
        else System.out.println("\nYou have no offers at this moment.");
    }
}