package REQUESTS;

import ENTITY.Entity;
import USER.Beneficiary;

import java.util.ArrayList;

public class Organization {
    private static ArrayList<Entity> entitylist = new ArrayList<>();
    private static ArrayList<Beneficiary> beneficiaryList = new ArrayList<>();
    private static RequestDonationList currentDonations;


    public static RequestDonationList getCurrentDonations() {
        return currentDonations;
    }

    public static ArrayList<Beneficiary> getBeneficiaryList() {
        return beneficiaryList;
    }

    public static ArrayList<Entity> getEntitylist() {
        return entitylist;
    }
}
