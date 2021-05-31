
public class Requests extends RequestDonationList{

//prepei na vroume mesw ths RDL tin id toy entity pu zhthse o Beneficiary
// kai meta na pame mesw Organization na vroume kai na sygkrinoume posothtes



    @Override
    public void add(RequestDonation rd) {
        int rdID = rd.getID();
        double rdQu = rd.getQuantity();
        boolean allow=false;
        try {
         outer:
          for (RequestDonation currentDonation : Organization.getCurrentDonations().getRdEntities()) { //kanei diaperash ta antikeimena poy parexei h Etairia

              if (rdID == currentDonation.getID()) //Tsekarei ta id gia na vrei an einai to idio antikeimeno

                  if (rdQu > currentDonation.getQuantity()) { //Sygkrinei posothtes kai an o Benefi zhthsei perisoterh
                      throw new RuntimeException("This quantity is not currently available, we deeply apologize."); //apo oti yparxei synolika sthn etairia petaei exception
                  }


              for (Beneficiary currBenef : Organization.getBeneficiaryList()) { //diaperash toys Bene

                  if (currBenef.getPhone().equals(Menu.getCurrUserPhone()) || currBenef.getPhone().equals(Main.getCurrUserPhone())){ //sygkrinei ta thlefwna wste na vrei poios einai o trexwn Beneficiary
                      if (validRequestDonation(rd, currBenef) ) {   // Sintihikes sto validRD                                       // eite apo thn  Menu eite apo thn Main
                          allow =true;
                          break outer;
                      }
                      else
                          throw new RuntimeException("Beneficiary: " + currBenef.getName() + " is not allowed to have " + rd.getEntity().getEntityInfo()); //an den isxioyn petaei esception
                  }
              }
          }
          if(allow) { //tsekarei an isxian h synthikes kai kalh thn ADD ths mamas
              super.add(rd);
              System.out.println("Request was succesfully made.");
          }
          else System.out.println("Not Valid Request");

      }catch (RuntimeException e){
          System.err.println(e);
      }

    }

    @Override
    public void modify(RequestDonation rd) {
        int id = rd.getID();
        double quantity = rd.getQuantity();
        boolean allow=false;
        try {

            for (RequestDonation currentDona : Organization.getCurrentDonations().getRdEntities()) { //patse ta current Antikeimena poy diakinei to Company

                if (id == currentDona.getID()) //vriskei an yparxei to zhtoumeno antikeimeno

                    if (quantity > currentDona.getQuantity()) { //An o bene zhtaei parapanw posothta petaei exception
                        throw new RuntimeException("This quantity is not currently available, we deeply apologize.");
                    }


                for (var currBenef : Organization.getBeneficiaryList()) {

                    if (currBenef.getPhone().equals(Menu.getCurrUserPhone()) || currBenef.getPhone().equals(Main.getCurrUserPhone())){ //omoiws me apo panw sthn add
                        if (validRequestDonation(rd, currBenef)) {
                            allow = true;
                            break;
                        }
                        else
                            throw new RuntimeException("Beneficiary: " + currBenef.getName() + " is not allowed to have " + rd.getEntity().getEntityInfo());

                    }       //idia me thn add

                }
            }
            if(allow) {
                super.modify(rd); //kalei thn modify ths mamas klasshs
                System.out.println("Request was succesfully modified.");
            }
            else System.out.println("Not Valid modification");

        }catch (RuntimeException e){
            System.err.println(e);
        }

    }


    public boolean validRequestDonation(RequestDonation rd, Beneficiary be){
       if(rd.getEntity() instanceof Material) { //an to antikeimeno einai material //h instanceof einai boolean
           int Person = be.getNoPersorns(); //pernei ta posa atoma exei sthn familia o Beneficiary
           int rdID =  rd.getID();
           double Quant = rd.getQuantity();
           boolean check2 = false;

           if (Person == 1) {
               double Level1Q = ((Material) rd.getEntity()).getLevel1(); //pernei thn posothta level1 toy antikeimenoy

               boolean check1 = Quant <= Level1Q; //tsekarei an to POSO poy exei zhthsei o Bene einai mikrotero iso apo ayto p dikaioytai
               boolean insidecheck = false;
               if(check1) //an isxyei h prwth synthikh
               {
                   for(RequestDonation rdEntity : getRdEntities() ) //kanei diaperash ta Entities
                       if(rdID == rdEntity.getID()){ //tsekarei an einai to idio antikeimeno
                           insidecheck = true;
                           check2 = (Quant + rdEntity.getQuantity()) <= Level1Q; //Tsekarei an h posothta poy zhthse syn ayth poy exei hdh parei einai egkyrh

                           break;
                       }
                   if(!insidecheck){

                       check2 = true; //an den exei paralavei hdh posothta kanei to check2 idio me to check1 dhladh true
                   }
               }


           } else if (2 <= Person && Person <= 4) {
               double Level2Q = ((Material) rd.getEntity()).getLevel2(); //pernei thn posothta level2 toy antikeimenoy

               boolean check1 = Quant <= Level2Q; //tsekarei an to POSO poy exei zhthsei o Bene einai mikrotero iso apo ayto p dikaioytai
               boolean insidecheck = false;
               if(check1)
               {

                   for(RequestDonation rdEntity : getRdEntities() )
                       if(rdID == rdEntity.getID()){
                           insidecheck = true;
                           check2 = (Quant + rdEntity.getQuantity()) <= Level2Q; //Tsekarei an h posothta poy zhthse syn ayth poy exei hdh parei einai egkyrh

                           break;
                       }
                   if(!insidecheck){ //an den exei paralavei hdh posothta kanei to check2 idio me to check1 dhladh true

                       check2 = true;
                   }
               }

           } else {
               double Level3Q = ((Material) rd.getEntity()).getLevel3(); //pernei thn posothta level3 toy antikeimenoy
               boolean check1 = Quant <= Level3Q; //tsekarei an to POSO poy exei zhthsei o Bene einai mikrotero iso apo ayto p dikaioytai

               boolean insidecheck = false;
               if(check1)
               {
                   for(RequestDonation rdEntity : getRdEntities() )
                       if(rdID == rdEntity.getID()){
                           insidecheck = true;
                           check2 = (Quant + rdEntity.getQuantity()) <= Level3Q; //Tsekarei an h posothta poy zhthse syn ayth poy exei hdh parei einai egkyrh

                           break;
                       }
                   if(!insidecheck){ //an den exei paralavei hdh posothta kanei to check2 idio me to check1 dhladh true

                       check2 = true;
                   }
               }

           }

           return check2; //epistrefei thn deyterh synthikh gia na kathorisei an isxioyn h proypotheseis h oxi

       }else return true; //an den einai material einai service opote panta petaei true apo EKFWNHSH

    }

    public void commit() {
        boolean exist = false;
        int size = getRdEntities().size();
        int found =0;
        for (int i =0 ;i<size;i++) {
             //diaperash Ta Antikeimena
                try {
                    exist = false;
                    Beneficiary currBen = null; //kenos beneficiary
                    int currID = getRdEntities().get(i-found).getID();
                    double currQuantity = getRdEntities().get(i-found).getQuantity();



                    for (RequestDonation currentDonation : Organization.getCurrentDonations().getRdEntities()) {
                        if (currID == currentDonation.getID()) { // vriskei to antikeimeno

                            if (currQuantity > currentDonation.getQuantity()) { //an sto antikemeno poy paei na zhthsei exei megalytero amount apo oti yparxei
                                throw new RuntimeException("This quantity is not currently available, we deeply apologize."); //tote petaei exception
                            }

                            for (Beneficiary currBenef : Organization.getBeneficiaryList()) {

                                if (currBenef.getPhone().equals(Menu.getCurrUserPhone()) || currBenef.getPhone().equals(Main.getCurrUserPhone())) {
                                    //tsekarei an einai o current Beneficiary
                                    exist = true;

                                    if (validRequestDonation(getRdEntities().get(i - found), currBenef)) { //Tsekarei an einai valid to donation ksana
                                        currBen = currBenef; //afoy vrikame to beneficiary mas to vazoyme ston apo panw epeidh ayto einai temp metavlhth o currBenef
                                        break;
                                    } else
                                        throw new RuntimeException("Beneficiary: " + currBenef.getName() + " is not allowed to have entity with:\n " + getRdEntities().get(i - found).getEntity().getEntityInfo());
                                    //An den dikaioutai petaei exception


                                }
                            }


                            // poy exei o Organismos thn posothta poy zhththike
                            System.out.println("Commit Succesful of " + getRdEntities().get(i - found).getEntity().getName());
                            currBen.getRecievedList().add(getRdEntities().get(i - found)); //O Beneficiary paralambanei ayto poy zhthse sto RecievedList toy
                            currentDonation.setQuantity(currentDonation.getQuantity() - currQuantity); //afairei apo thn posothta toy antikeimenoy
                            getRdEntities().remove(getRdEntities().get(i - found)); //afairei apo ta Requests toy Beneficiary to antikemno


                            found++;
                            break;//afoy egine to commit fevgei apo to for poy pernei ta antikeimena poy dinei o Organization

                        }
                    }

                     //afoy egine to commit fevgei apo to for poy psaxnei ta antikeimena poy dinei o bene
                } catch (RuntimeException e){
                    System.err.println(e);
                }
           // System.out.println("trexw "+(i+1));


        }
            if (!exist) {
                System.out.println("There are not any Requests to commit."); // an den vrethei kapoios beneficiary me tetoia Request teleiwnei h methodos
            }



        }



}
