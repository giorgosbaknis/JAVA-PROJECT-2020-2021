package REQUESTS;

import ENTITY.Material;
import ENTITY.Service;
import MENU.Menu;
import USER.Beneficiary;

import java.util.ConcurrentModificationException;

public class Requests extends RequestDonationList{

    //prepei na vroume mesw ths RDL tin id toy entity pu zhthse o Bene , kai meta na pame mesw Organa na vroume kai na sygkrinoume posothtes



    @Override
    public void add(RequestDonation rd) {
        int rdID = rd.getID();
        double rdQu = rd.getQuantity();

        try {
         outer:
          for (RequestDonation currentDonation : Organization.getCurrentDonations().getRdEntities()) {

              if (rdID == currentDonation.getID())

                  if (rdQu > currentDonation.getQuantity()) {
                      throw new RuntimeException("This quantity is not currently available, we deeply apologize.");
                  }


              for (Beneficiary currBenef : Organization.getBeneficiaryList()) {

                  if (currBenef.getPhone().equals(Menu.getCurrUserPhone())) {
                      if (validRequestDonation(rd, currBenef) )
                          break outer;
                      else
                          throw new RuntimeException("Beneficiary: " + currBenef.getName() + " is not allowed to have " + rd.getEntity().getEntityInfo());
                  }
              }
          }
            super.add(rd);
            System.out.println("Request was succesfully made.");

      }catch (RuntimeException e){
          System.err.println(e);
      }

    }

    @Override
    public void modify(RequestDonation rd) {
        int id = rd.getID();
        double quantity = rd.getQuantity();
        try {

            for (RequestDonation currentDona : Organization.getCurrentDonations().getRdEntities()) {

                if (id == currentDona.getID())

                    if (quantity > currentDona.getQuantity()) {
                        throw new RuntimeException("This quantity is not currently available, we deeply apologize.");
                    }


                for (var currBenef : Organization.getBeneficiaryList()) {

                    if (currBenef.getRequestsList().get(id) != null) {
                        if (validRequestDonation(rd, currBenef))
                            break;
                        else
                            throw new RuntimeException("Beneficiary: " + currBenef.getName() + " is not allowed to have " + rd.getEntity().getEntityInfo());


                    }

                }
            }
                super.modify(rd);
                System.out.println("Request was succesfully made.");

        }catch (RuntimeException e){
            System.err.println(e);
        }

    }


    public boolean validRequestDonation(RequestDonation rd, Beneficiary be){
       if(rd.getEntity() instanceof Material) {
           int Person = be.getNoPersorns();
           int rdID =  rd.getID();
           double Quant = rd.getQuantity();
           boolean check2 = false;

           if (Person == 1) {
               double Level1Q = ((Material) rd.getEntity()).getLevel1();

               boolean check1 = Quant <= Level1Q;
               boolean insidecheck = false;
               if(check1)
               {
                   for(RequestDonation rdEntity : getRdEntities() )
                       if(rdID == rdEntity.getID()){
                           insidecheck = true;
                           check2 = (Quant + rdEntity.getQuantity()) <= Level1Q;

                           break;
                       }
                   if(!insidecheck){

                       check2 = Quant <= Level1Q;
                   }
               }


           } else if (2 <= Person && Person <= 4) {
               double Level2Q = ((Material) rd.getEntity()).getLevel2();

               boolean check1 = Quant <= Level2Q;
               boolean insidecheck = false;
               if(check1)
               {

                   for(RequestDonation rdEntity : getRdEntities() )
                       if(rdID == rdEntity.getID()){
                           insidecheck = true;
                           check2 = (Quant + rdEntity.getQuantity()) <= Level2Q;

                           break;
                       }
                   if(!insidecheck){

                       check2 = Quant <= Level2Q;
                   }
               }

           } else {
               double Level3Q = ((Material) rd.getEntity()).getLevel3();
               boolean check1 = Quant <= Level3Q;

               boolean insidecheck = false;
               if(check1)
               {
                   for(RequestDonation rdEntity : getRdEntities() )
                       if(rdID == rdEntity.getID()){
                           insidecheck = true;
                           check2 = (Quant + rdEntity.getQuantity()) <= Level3Q;

                           break;
                       }
                   if(!insidecheck){

                       check2 = Quant <= Level3Q;
                   }
               }

           }

           return check2;


       }else return true;


    }

    public void commit(){
        boolean exist = false;
        for(RequestDonation requestedDon: getRdEntities()){
            try {
                Beneficiary currBen = null;
                int currID = requestedDon.getID();
                double currQuantity = requestedDon.getQuantity();

                for (RequestDonation currentDonation : Organization.getCurrentDonations().getRdEntities()) {

                    if (currID == currentDonation.getID())

                        if (currQuantity > currentDonation.getQuantity()) {
                            throw new RuntimeException("This quantity is not currently available, we deeply apologize.");
                        }

                    for(Beneficiary currBenef: Organization.getBeneficiaryList()){

                        if(currBenef.getPhone().equals(Menu.getCurrUserPhone())) {

                            exist = true;
                            if (validRequestDonation(requestedDon, currBenef)) {
                                currBen = currBenef;
                                break;
                            } else
                                throw new RuntimeException("Beneficiary: " + currBenef.getName() + " is not allowed to have entity with:\n " + requestedDon.getEntity().getEntityInfo());



                        }
                    }


                    currentDonation.setQuantity(currentDonation.getQuantity()-currQuantity);
                    getRdEntities().remove(requestedDon);
                    currBen.getRecievedList().add(requestedDon);
                    break;

                }
                System.out.println("Commit Succesful");
                break;
            }catch (RuntimeException e ){
                System.err.println(e);
            }

        }  if(!exist){
            System.out.println("There are not any Requests to commit.");
        }
    }






}
