package REQUESTS;

import ENTITY.Material;
import ENTITY.Service;

public class Offers extends RequestDonationList {


    public void commit() {
        if (!getRdEntities().isEmpty()) {
            Organization.getCurrentDonations().getRdEntities().addAll(getRdEntities());
            getRdEntities().clear();
        }
    }
}