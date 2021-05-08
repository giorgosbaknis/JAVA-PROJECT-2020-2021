package REQUESTS;

import ENTITY.Material;
import USER.Beneficiary;

public class Requests extends RequestDonationList{

    //prepei na vroume mesw ths RDL tin id toy entity pu zhthse o Bene , kai meta na pame mesw Organa na vroume kai na sygkrinoume posothtes



    @Override
    public void add(RequestDonation rd) {
        int rdID = rd.getID();
        double rdQu = rd.getQuantity();

        try {

          for (RequestDonation rdEntity : getRdEntities()) {

              if (rdID == rdEntity.getID())

                  if (rdQu <= rdEntity.getQuantity()) {

                      break;
                  } else
                      throw new RuntimeException("This quantity is not currently available, we deeply apologize.");


            for(var Beneficiaries: Organization.getBeneficiaryList()){

                if(Beneficiaries.getRequestsList().get(rdID) != null ){
                    if(!validRequestDonation(rd , Beneficiaries) )
                        break;
                    else
                        throw new RuntimeException("Beneficiary: "+Beneficiaries.getName() +" is not allowed to have "+rd.getEntity().getEntityInfo());


                }

            }
            super.add(rd);
            System.out.println("Request was succesfully made.");
          }
      }catch (RuntimeException e){
          System.err.println(e);
      }

    }

    @Override
    public void modify(int id, int quantity) {
        try {
            RequestDonation bot = null;
            for (RequestDonation rdEntity : getRdEntities()) {

                if (id == rdEntity.getID())

                    if (quantity <= rdEntity.getQuantity()) {
                        bot=rdEntity;
                        break;
                    } else
                        throw new RuntimeException("This quantity is not currently available, we deeply apologize.");


                for(var Beneficiaries: Organization.getBeneficiaryList()){

                    if(Beneficiaries.getRequestsList().get(id) != null ){
                        if(validRequestDonation(bot , Beneficiaries) )
                            break;
                        else
                            throw new RuntimeException("Beneficiary: "+Beneficiaries.getName() +" is not allowed to have "+bot.getEntity().getEntityInfo());


                    }

                }
                super.modify(id, quantity);
                System.out.println("Request was succesfully made.");
            }
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
               if(check1)
               {
                   for(RequestDonation rdEntity : be.getRecievedList().getRdEntities() )
                       if(rdID == rdEntity.getID()){
                           check2 = (Quant + rdEntity.getQuantity()) <= Level1Q;
                           break;
                       }
               }


           } else if (2 <= Person && Person <= 4) {
               double Level2Q = ((Material) rd.getEntity()).getLevel2();
               boolean check1 = Quant <= Level2Q;
               if(check1)
               {
                   for(RequestDonation rdEntity : be.getRecievedList().getRdEntities() )
                       if(rdID == rdEntity.getID()){
                           check2 = (Quant + rdEntity.getQuantity()) <= Level2Q;
                           break;
                       }
               }

           } else {
               double Level3Q = ((Material) rd.getEntity()).getLevel3();
               boolean check1 = Quant <= Level3Q;
               if(check1)
               {
                   for(RequestDonation rdEntity : be.getRecievedList().getRdEntities() )
                       if(rdID == rdEntity.getID()){
                           check2 = (Quant + rdEntity.getQuantity()) <= Level3Q;
                           break;
                       }
               }

           }

           return check2;


       }else return true;


    }





}
