package REQUESTS;

import ENTITY.Material;
import ENTITY.Service;

public class Offers extends RequestDonationList {


    public void commit() {
        if (!getRdEntities().isEmpty()) {
            for(RequestDonation currDon:getRdEntities())
                Organization.getCurrentDonations().add(currDon);
                getRdEntities().clear();
        }
    }
}