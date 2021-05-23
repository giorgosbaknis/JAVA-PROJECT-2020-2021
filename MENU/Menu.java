package MENU;
import ENTITY.Entity;
import ENTITY.Material;
import ENTITY.Service;
import REQUESTS.*;
import USER.*;

import java.util.*;

public class Menu {
    private String currUserPhone;



    public void check(){


            String currPhone = "";

            System.out.println("Give your phone number: ");
            try (Scanner sc = new Scanner(System.in)) {


                    currUserPhone = currPhone = sc.nextLine().strip();


                for (Beneficiary currBen : Organization.getBeneficiaryList()) {
                    if (currPhone.equals(currBen.getPhone())) {
                        printMenuBene(currBen);
                    }
                }

                for (Donator currDon : Organization.getDonatorList()) {
                    if (currPhone.equals(currDon.getPhone())) {
                        printMenuDon(currDon);
                    }
                }
                if (currPhone.equals(Organization.getAdmin().getPhone())){
                    printMenuAdmin(Organization.getAdmin());
                }


            } catch (Exception E) {
                System.err.println(E);
            }



    }

    public void printMenuBene(Beneficiary be){
        System.out.println("Hello "+be.getName() +'\n'+"Your phone is :"+be.getPhone()); //ONOMA ORGANAT?????
        System.out.println("1.Add Request");
        System.out.println("2.Show Requests");
        System.out.println("3.Commit");
        System.out.println("4.Back");
        System.out.println("5.Logout");
        System.out.println("6.Exit");
       outerb:
      while (true){
            int epil;
            try(Scanner sc = new Scanner(System.in))
            {
                while (true) {
                    if (sc.hasNextInt()) {
                        epil = sc.nextInt();
                        sc.nextLine();
                        break;
                    }sc.nextLine();
                }
               switch1:
                switch(epil){
                    case 1:
                        int chois;
                     Organization.listEntities();
                     System.out.println("Which entity do you want?");
                        if (sc.hasNextInt()) {
                            chois = sc.nextInt();
                            sc.nextLine();

                            if (Organization.getCurrentDonations().get(Organization.getCurrentDonations().getRdEntities().get(0).getID()) != null) {
                                try {

                                    for (RequestDonation currItem : Organization.getCurrentDonations().getRdEntities()) {
                                        if (currItem.getID() == Organization.getEntityList().get(chois - 1).getId()) {
                                            double quantity;
                                            System.out.println("How much of :" + currItem.getEntity().getName() + " do you want?");
                                            if (sc.hasNextDouble()) {
                                                quantity = sc.nextDouble();
                                                sc.nextLine();


                                                if (quantity <= currItem.getQuantity()) {
                                                    RequestDonation requested = currItem;

                                                    requested.setQuantity(quantity);
                                                    be.addRequest(requested);

                                                    System.out.println("Item Request: SUCCESS");
                                                } else
                                                    System.out.println("Quantity of " + currItem.getEntity().getName() + " is not available to Organization, please choose less or other item");

                                                break switch1;
                                            }
                                            sc.nextLine();
                                        }
                                    }
                                    System.out.println("Quantity of that items is not available to Organization, please choose other item");


                                } catch (ArrayIndexOutOfBoundsException e) {
                                    System.err.println(e);
                                }
                            }
                        } else
                            System.out.println("Currently there are not any Donations in the system.");
                        sc.nextLine();
                        break;




                    case 2:
                        if (be.getRequestsList()!=null)
                        be.showRequests();
                        else
                            System.out.println("There are not any requests at this time.");
                        break;

                    case 3:
                        be.commitRequests();
                        break;

                    case 4:
                        break;

                    case 5:
                        System.out.println("Logging off...");
                        break outerb;
                    case 6:
                        System.exit(0);

                }


            }
        }

    }
    public void printMenuDon(Donator don){
        System.out.println("Hello "+don.getName() +'\n'+"Your phone is :"+don.getPhone()); //ONOMA ORGANAT?????
        System.out.println("1.Add Offer");
        System.out.println("2.Show Offers");
        System.out.println("3.Commit");
        System.out.println("4.Back");
        System.out.println("5.Logout");
        System.out.println("6.Exit");
       outerd:
       while (true){
            int epil;
            try(Scanner sc = new Scanner(System.in))
            {
                while (true) {
                    if (sc.hasNextInt()) {
                        epil = sc.nextInt();
                        sc.nextLine();
                        break;
                    }
                    sc.nextLine();
                }
                switch(epil){
                    case 1:
                        int counter=0;
                        System.out.print("1.Material" );
                        for(int i=0;i<Organization.getEntityList().size();i++){
                            if (Organization.getEntityList().get(i) instanceof Material)
                                counter++;
                        }
                        System.out.println("("+counter+")");
                        System.out.println("2.Serivce "+ '(' + (Organization.getEntityList().size()-counter) +')' );
                        int epild1;
                        innerd1:
                        while (true) {
                            System.out.println("Which Category do you want?");
                            System.out.println("Press 3 to go back");
                            if (sc.hasNextInt()) {
                                epild1 = sc.nextInt();
                                sc.nextLine();
                                switch (epild1) {
                                    case 1:

                                        ArrayList<Entity> materials = new ArrayList<>();

                                        for (int i = 0; i < Organization.getEntityList().size(); i++) {

                                            if (Organization.getEntityList().get(i) instanceof Material) {
                                                materials.add(Organization.getEntityList().get(i));
                                                System.out.print( materials.size() + "." + Organization.getEntityList().get(i).getName());


                                                if (Organization.getCurrentDonations() != null) // dn eixame kanei elegxo an einai null
                                                for (RequestDonation currDon : Organization.getCurrentDonations().getRdEntities()) {

                                                    if (currDon.getID() == Organization.getEntityList().get(i).getId()) {
                                                        System.out.println(" (" + currDon.getQuantity() + ')');
                                                    }
                                                }
                                                else
                                                    System.out.println();


                                            }
                                        }

                                       while2:
                                       while (true) {
                                           int antikd1;
                                           System.out.println("Type the number of your desired Material.");
                                           if (sc.hasNextInt()) {
                                               antikd1 = sc.nextInt();
                                               sc.nextLine();
                                               try {
                                                   while2_1:
                                                   while (true) {
                                                   System.out.println(materials.get(antikd1 - 1).toString());
                                                   System.out.println("Do you want to offer this item? Press y or n for yes or no.");
                                                   System.out.println("Press 3 to go back");


                                                           String ok;
                                                           ok = sc.nextLine().strip().toLowerCase();

                                                           if (ok.length() == 1) {
                                                               switch2:
                                                               switch (ok.charAt(0)) {
                                                                   case 'y':
                                                                           System.out.println("What amount do you want to offer?");
                                                                           double amount;
                                                                           if (sc.hasNextDouble()) {
                                                                               amount = sc.nextDouble();
                                                                               sc.nextLine();

                                                                               if (Organization.getCurrentDonations() != null)
                                                                                   for (RequestDonation DonSearch : Organization.getCurrentDonations().getRdEntities()) { //tsekarei an yparxei hdh donation apo ayto to object
                                                                                       if (materials.get(antikd1 - 1).getId() == DonSearch.getID()) {

                                                                                           RequestDonation temp1 = DonSearch;
                                                                                           temp1.setQuantity(amount);

                                                                                           don.add(temp1);
                                                                                           break switch2;
                                                                                       }

                                                                                   }
                                                                               RequestDonation temp2 = new RequestDonation(materials.get(antikd1 - 1), amount);

                                                                               temp2.setQuantity(amount);
                                                                               try {


                                                                                   don.add(temp2);
                                                                                   System.out.println("Donation was succesful");
                                                                                   break while2;
                                                                               } catch (NullPointerException e) {
                                                                                   System.err.println(e);
                                                                               }

                                                                           }
                                                                           else
                                                                           sc.nextLine();

                                                                           break ;


                                                                   case 'n':
                                                                       System.out.println(" You chose to not donate.");
                                                                       break while2;

                                                                   case '3':
                                                                       break while2_1;
                                                                   default:
                                                                       break ;
                                                               }
                                                           }

                                                       break;
                                                   }
                                               } catch (ArrayIndexOutOfBoundsException e) {
                                                   System.err.println(e+ "Material with that Number does not exist.");
                                               }
                                           }sc.nextLine();
                                       }
                                       break ;

                                    case 2:
                                        ArrayList<Entity> services = new ArrayList<>();
                                        for(int i=0;i<Organization.getEntityList().size();i++){

                                            if (Organization.getEntityList().get(i) instanceof Service){
                                                services.add(Organization.getEntityList().get(i));
                                                System.out.print((i+1)+ '.'+Organization.getEntityList().get(i).getName());

                                                if (Organization.getCurrentDonations() != null)
                                                for(RequestDonation currDon: Organization.getCurrentDonations().getRdEntities()){

                                                    if (currDon.getID()==Organization.getEntityList().get(i).getId()){
                                                        System.out.println(" ("+currDon.getQuantity()+')');
                                                    }
                                                }

                                            }
                                        }
                                      while3:
                                      while (true) {
                                          int antik;
                                         while4:
                                         while (true) {
                                             System.out.println("Type the number of your desired Service");
                                              if (sc.hasNextInt()) {
                                                  antik = sc.nextInt();
                                                  sc.nextLine();
                                                  try {
                                                      System.out.println(services.get(antik - 1).toString());
                                                      System.out.println("Do you want to offer this service? Press y or n for yes or no.");
                                                      System.out.println("Press 3 to go back");
                                                     {
                                                          String ok;
                                                          ok = sc.nextLine().strip().toLowerCase();
                                                          if (ok.length() == 1) {
                                                              switch3:
                                                              switch (ok.charAt(0)) {
                                                                  case 'y':
                                                                      System.out.println("How many hours do you want to offer?");
                                                                      double hours;
                                                                      if (sc.hasNextDouble()) {
                                                                          hours = sc.nextDouble();
                                                                          sc.nextLine();
                                                                          if (Organization.getCurrentDonations()!= null)
                                                                          for (RequestDonation DonSearch : Organization.getCurrentDonations().getRdEntities()) { //tsekarei an yparxei hdh donation apo ayto to object
                                                                              if (services.get(antik - 1).getId() == DonSearch.getID()) {

                                                                                  RequestDonation temp3 = DonSearch;
                                                                                  temp3.setQuantity(hours);

                                                                                  don.add(temp3);
                                                                                  break while3;
                                                                              }

                                                                          }
                                                                          RequestDonation temp4 = new RequestDonation(services.get(antik - 1), hours);

                                                                          temp4.setQuantity(hours);

                                                                          don.add(temp4);
                                                                          System.out.println("Donation was succesful");
                                                                          break while3;

                                                                      }sc.nextLine();
                                                                      break;

                                                                  case 'n':
                                                                      System.out.println(" You chose to not donate.");
                                                                      break while3;

                                                                  case '3':
                                                                      break while4;
                                                                  default:
                                                                      break ;
                                                              }
                                                          }
                                                      }

                                                      break ;

                                                  } catch (ArrayIndexOutOfBoundsException e) {
                                                      System.err.println(e);
                                                  }
                                              }sc.nextLine();
                                          }
                                      }
                                      break ;

                                    case 3:
                                        break innerd1;

                                    default:
                                        System.out.println("Number doesnt match any category");
                                        break;
                                }
                            }sc.nextLine();
                        }



                    case 2:
                        if( don.getOfferList().get(don.getOfferList().getRdEntities().get(0).getID()) != null ) {
                            outerw:
                            while (true){
                                don.getOfferList().monitor();
                                System.out.println("Choose an Entity.");
                                    if (sc.hasNextInt()) {
                                        int choice;
                                        choice = sc.nextInt();
                                        sc.nextLine();

                                        {
                                            char epil2;
                                            String st;
                                            st = sc.nextLine().strip();

                                            if (st.length() == 1) {
                                                epil2 = st.charAt(0);
                                               switchouter:
                                                switch (epil2) {

                                                    case 'a':
                                                        innerw:
                                                        while (true) {

                                                            System.out.println("What do you want to do?");
                                                            System.out.println("1.Delete Offer");
                                                            System.out.println("2.Change an offer's quantity.");
                                                            System.out.println("Press 3 to go back");

                                                            if (sc.hasNextInt()) {
                                                                int chos;
                                                                chos = sc.nextInt();
                                                                sc.nextLine();

                                                                switch (chos) {
                                                                    case 1:
                                                                        try {
                                                                            don.getOfferList().remove(don.getOfferList().getRdEntities().get(choice - 1));
                                                                            System.out.println("Offer was successfully removed");
                                                                            break;
                                                                        } catch (ArrayIndexOutOfBoundsException e) {
                                                                            System.out.println("You entity choice is not valid.");
                                                                            System.err.println(e);
                                                                            break innerw;
                                                                        }

                                                                    case 2:

                                                                        System.out.println("Give quantity");
                                                                        if (sc.hasNextInt()) {

                                                                            double quantity;
                                                                            quantity = sc.nextInt();
                                                                            sc.nextLine();
                                                                            try {


                                                                                don.getOfferList().getRdEntities().get(choice - 1).setQuantity(quantity);
                                                                                System.out.println("Quantity was changed to given one.");
                                                                                break;
                                                                            } catch (ArrayIndexOutOfBoundsException e) {
                                                                                System.err.println(e + "\n" + "Choice of entity is not available");
                                                                                break;
                                                                            }
                                                                        }sc.nextLine();


                                                                        break;

                                                                    case 3:
                                                                        break switchouter;

                                                                    default:
                                                                        System.out.println("You option choice is not valid");
                                                                        break;
                                                                }


                                                            }sc.nextLine();
                                                            break ;
                                                        }
                                                    case 'b':
                                                        System.out.println("Deleting all offers...");
                                                        don.getOfferList().reset();
                                                        System.out.println("Success.");
                                                        break;


                                                    case 'c':
                                                        don.commit();
                                                        break;


                                                    case '3':
                                                        break switchouter;
                                                    default:
                                                        break;




                                                }
                                            }

                                         }
                                    }sc.nextLine();

                            }

                        }
                        else {
                            System.out.println("You do not have any offers at this moment.");
                        }
                        break;
                    case 3:
                        don.commit();
                        break;
                    case 4:
                        break;

                    case 5:
                        System.out.println("Logging off...");
                        break outerd;

                    case 6:
                        System.exit(0);

                }


            }
        }


    }
    public void printMenuAdmin(Admin ad){
        System.out.println("1.View");
        System.out.println("2.Monitor Organization");
        System.out.println("3.Back");
        System.out.println("4.Logout");
        System.out.println("5.Exit");
       outer:
        while (true){
            int epil;
            try(Scanner sc = new Scanner(System.in))
            {
                while (true) {
                    if (sc.hasNextInt()) {
                        epil = sc.nextInt();
                        sc.nextLine();
                        break;
                    }sc.nextLine();
                }
                switch(epil) {
                    case 1:
                        int counter=0;
                        System.out.print("1.Material" );
                        for(int i=0;i<Organization.getEntityList().size();i++){
                            if (Organization.getEntityList().get(i) instanceof Material)
                                counter++;
                        }
                        System.out.println("("+counter+")");
                        System.out.print("2.Serivce "+ '(' + (Organization.getEntityList().size()-counter) +')' );
                         int epil1;
                        inner1:
                         while (true) {
                            System.out.println("Which Category do you want?");
                            System.out.println("Press 3 to go back");
                            if(sc.hasNextInt()) {
                                epil1 = sc.nextInt();
                                sc.nextLine();
                                switch (epil1) {
                                    case 1:
                                        ArrayList<Entity> materials = new ArrayList<>();
                                        for (int i = 0; i < Organization.getEntityList().size(); i++) {

                                            if (Organization.getEntityList().get(i) instanceof Material) {
                                                System.out.print((i + 1) + '.' + Organization.getEntityList().get(i).getName());
                                                materials.add(Organization.getEntityList().get(i));

                                                for (RequestDonation currDon : Organization.getCurrentDonations().getRdEntities()) {

                                                    if (currDon.getID() == Organization.getEntityList().get(i).getId()) {
                                                        System.out.println(" (" + currDon.getQuantity() + ')');
                                                    }
                                                }
                                            }
                                        }

                                        while (true) {
                                            int antik;
                                            System.out.println("Type the number of your desired Material");
                                            if (sc.hasNextInt()) {
                                                antik = sc.nextInt();
                                                sc.nextLine();
                                                try {
                                                    System.out.println(materials.get(antik - 1).toString() ) ;
                                                    break;
                                                }catch (ArrayIndexOutOfBoundsException e){
                                                    System.err.println(e);
                                                }
                                            }
                                            sc.nextLine();
                                        }



                                    case 2:
                                        ArrayList<Entity> services = new ArrayList<>();
                                        for(int i=0;i<Organization.getEntityList().size();i++){

                                            if (Organization.getEntityList().get(i) instanceof Service){
                                                services.add(Organization.getEntityList().get(i));
                                                System.out.print((i+1)+ '.'+Organization.getEntityList().get(i).getName());

                                                for(RequestDonation currDon: Organization.getCurrentDonations().getRdEntities()){

                                                    if (currDon.getID()==Organization.getEntityList().get(i).getId()){
                                                        System.out.println(" ("+currDon.getQuantity()+')');
                                                    }
                                                }

                                            }
                                        }
                                        while (true) {
                                            int antik;
                                            System.out.println("Type the number of your desired Service");
                                            if (sc.hasNextInt()) {
                                                antik = sc.nextInt();
                                                sc.nextLine();
                                                try {
                                                    System.out.println( services.get(antik - 1).toString() );
                                                    break;
                                                }catch (ArrayIndexOutOfBoundsException e){
                                                    System.err.println(e);
                                                }
                                            }sc.nextLine();
                                        }

                                    case 3:
                                        break inner1;

                                    default:
                                        System.out.println("Number doesnt match any category");
                                        break;
                                }
                            }sc.nextLine();

                        }


                    case 2:
                        char epil2;
                       inner2:
                       while (true) {
                             {
                                String st;
                                st = sc.nextLine().strip();

                                if (st.length() == 1) {
                                    epil2 = st.charAt(0);
                                   switch2:
                                    switch (epil2) {
                                        case 'a':
                                            Organization.listBeneficiaries();
                                            int inp;
                                            while (true) {

                                                System.out.println("Type the number of the Beneficiary you want.");
                                                if (sc.hasNextInt()) {
                                                    inp = sc.nextInt();
                                                    sc.nextLine();
                                                    try {
                                                        Organization.getBeneficiaryList().get(inp-1).getRecievedList().monitor();
                                                        break;

                                                    } catch (ArrayIndexOutOfBoundsException e) {
                                                        System.out.println(e);
                                                    }

                                                }sc.nextLine();
                                            }
                                            System.out.println("1.Clear Recieved List");
                                            System.out.println("2.Delete Beneficiary");
                                            int inp2;
                                            while (true) {
                                                 System.out.println("Give one of the 2 numbers: ");
                                                if (sc.hasNextInt()) {
                                                    inp2 = sc.nextInt();
                                                    sc.nextLine();
                                                    switch (inp2){
                                                        case 1:
                                                            Organization.getBeneficiaryList().get(inp-1).getRecievedList().reset();
                                                            break;
                                                        case 2:
                                                            Organization.removeBeneficiary(Organization.getBeneficiaryList().get(inp-1),currUserPhone);
                                                            break;
                                                        case 3:
                                                            break switch2;

                                                        default:
                                                            break;
                                                    }
                                                }sc.nextLine();
                                            }

                                        case 'b':
                                            Organization.listDonators();
                                            int inpd;
                                           inner3:
                                            while (true) {

                                                System.out.println("Type the number of the Donator you want.");
                                                if (sc.hasNextInt()) {
                                                    inpd = sc.nextInt();
                                                    sc.nextLine();
                                                    try {
                                                        Organization.getDonatorList().get(inpd-1).getOfferList().monitor();

                                                        while (true) {
                                                            System.out.println("Do you want to delete the donator? Type yes to proceed.");
                                                            String checked;
                                                          {
                                                                checked = sc.nextLine().toLowerCase();

                                                                if (checked.equals("yes")) {
                                                                    Organization.removeDonator(Organization.getDonatorList().get(inpd - 1), currUserPhone);

                                                                }
                                                                else if(checked.equals("3")){
                                                                    break ;
                                                                }

                                                                break inner3;
                                                            }

                                                        }
                                                    }catch (ArrayIndexOutOfBoundsException e) {
                                                        System.out.println(e);
                                                    }

                                                }sc.nextLine();
                                            }




                                        case 'c':
                                            for (Beneficiary currBen : Organization.getBeneficiaryList()){
                                               currBen.getRecievedList().reset();
                                            }
                                            break;

                                        case '3':
                                            break inner2;
                                    }
                                }


                            }
                        }



                    case 3:
                        break;
                    case 4:
                        System.out.println("Logging off...");
                        break outer;

                    case 5:
                        System.exit(0);


                }
            }
        }


    }




}
