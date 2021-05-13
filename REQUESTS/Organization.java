package REQUESTS;

import ENTITY.Entity;
import USER.*;

import java.util.ArrayList;


public class Organization {

    private static ArrayList<Entity> entityList= new ArrayList<>();
    private static ArrayList<Beneficiary> beneficiaryList = new ArrayList<>();
    private static ArrayList<Donator> donatorList = new ArrayList<>();
    private Admin admin;
    private static RequestDonationList currentDonations;


    public static RequestDonationList getCurrentDonations() {
        return currentDonations;
    }

    public static ArrayList<Beneficiary> getBeneficiaryList() {
        return beneficiaryList;
    }

    public static ArrayList<Entity> getEntityList() {
        return entityList;
    }


    public Admin getAdmin() {
        return admin;
    }



    public void setAdmin(Admin admin) {
        this.admin = admin;
    }


    public  void addEntity(Entity entity ){

        try {


            if (entityList.contains(entity))
            {
                System.out.println("Error");
                throw new RuntimeException("This entity already exists");

            }
            entityList.add(entity);
        }catch (RuntimeException e) {
            System.err.println(e);
        }
    }

    public   void  removeEntity(Entity entity){

        if(admin==getAdmin()){
            entityList.remove(entity);
        }


    }
    //H methodos contains se ena arraylist einai boolean
    public void  insertDonator(Donator donator){

        try {

            if (donatorList.contains(donator))
            {
                System.out.println("Error");
                throw new RuntimeException("This donator already exists");

            }
            donatorList.add(donator);
        }catch (RuntimeException e){
            System.err.println(e);
        }
    }



    void removeDonator(Donator donator){

        if(admin==getAdmin()){
            donatorList.remove(donator);}
    }

    public  void  insertBeneficiary(Beneficiary beneficiary){

        try {

            if (beneficiaryList.contains(beneficiary))
            {
                System.out.println("Error");
                throw new RuntimeException("This beneficiary already exists");

            }
            beneficiaryList.add(beneficiary);
        }catch (RuntimeException e){
            System.err.println(e);
        }


    }



    public void removeBeneficiary (Beneficiary beneficiary){
        if(admin==getAdmin()){
            beneficiaryList.remove(beneficiary);}

    }

    void listEntities(){

        System.out.println(entityList);

    }

    void listBeneficiaries(){
        System.out.println(beneficiaryList);
        System.out.println(currentDonations);
    }

    void listDonators(){
        System.out.println(donatorList);

    }



}

