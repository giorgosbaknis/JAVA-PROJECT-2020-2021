package REQUESTS;

import ENTITY.Material;
import ENTITY.Service;

public class Offers extends RequestDonationList {


    public void commit() {
        if (!getRdEntities().isEmpty()) { //an yparxei kapoio antikeimneo poy thelei an dwrisei o Donator
            for(RequestDonation currDon:getRdEntities()) //pernei ena ena ta entity poy thelei na kanei Donate
                Organization.getCurrentDonations().add(currDon); //to vazei sthn currentDonations toy Organization
                getRdEntities().clear(); //To afairei apo thn lista toy Donator
        }
    }
}