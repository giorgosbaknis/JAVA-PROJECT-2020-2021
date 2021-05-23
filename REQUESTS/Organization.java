package REQUESTS;

import ENTITY.*;
import USER.*;

import java.util.ArrayList;


public class Organization {

    private static ArrayList<Entity> entityList= new ArrayList<>();
    private static ArrayList<Beneficiary> beneficiaryList = new ArrayList<>();
    private static ArrayList<Donator> donatorList = new ArrayList<>();
    private static Admin admin ;
    private static RequestDonationList currentDonations = new RequestDonationList();

    public static ArrayList<Donator> getDonatorList() {
        return donatorList;
    }

    public static RequestDonationList getCurrentDonations() {
        return currentDonations;
    }

    public static ArrayList<Beneficiary> getBeneficiaryList() {
        return beneficiaryList;
    }

    public static ArrayList<Entity> getEntityList() {
        return entityList;
    }


    public static Admin getAdmin() {
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

    public  void  removeEntity(Entity entity,String phones){

        if(phones.equals(admin.getPhone())){
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



    public  static void removeDonator(Donator donator, String phones){

        if(phones.equals(admin.getPhone())){
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



    public static void removeBeneficiary (Beneficiary beneficiary,String phones){
        if(phones.equals(admin.getPhone())){
            beneficiaryList.remove(beneficiary);}

    }

   public static void listEntities(){


        int cout=0;


        for(int i=0;i<entityList.size();i++){
            if (entityList.get(i) instanceof Service){
                cout++;
                if (cout==1){
                    System.out.println("Service");
                }

                System.out.println( cout+". "+entityList.get(i).getName() );
            }
        }

       cout=0;
       for(int i=0;i<entityList.size();i++){
           if (entityList.get(i) instanceof Material){
               cout++;
               if (cout==1){
                   System.out.println("Material");
               }
               System.out.println( cout+". "+entityList.get(i).getName() );
           }

       }


    }

   public static void listBeneficiaries() {

       for (int i=0;i<beneficiaryList.size();i++) {

           System.out.println((i+1) + ". " + beneficiaryList.get(i).getName());
           beneficiaryList.get(i).getRecievedList().monitor();
       }

    }

   public static void listDonators(){

       for (int i=0;i<donatorList.size();i++) {
           System.out.println((i+1) + ". " + donatorList.get(i).getName());
       }
    }



}

