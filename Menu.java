

import java.util.*;


public class Menu {
    private static String currUserPhone;

    public static String getCurrUserPhone() {
        return currUserPhone;
    }

    public void check(){

        try (Scanner sc = new Scanner(System.in)) {
            while(true) {
                big:
                while (true) {


                        String currPhone = "";

                        System.out.println("Give your phone number: "); //mas leipei h eggrafh

                        boolean found = false;

                        currUserPhone = currPhone = sc.nextLine().strip();

                        while (currPhone.length() == 0) {

                            System.out.println("Give a valid phone number: "); //mas leipei h eggrafh

                            currUserPhone = currPhone = sc.nextLine().strip();

                        }


                    for (Beneficiary currBen : Organization.getBeneficiaryList()) {
                        if (currPhone.equals(currBen.getPhone())) {
                            found = true;
                            printMenuBene(currBen);
                            break big;

                        }
                    }

                    for (Donator currDon : Organization.getDonatorList()) {
                        if (currPhone.equals(currDon.getPhone())) {
                            found = true;
                            printMenuDon(currDon);
                            break big;
                        }
                    }
                    if (currPhone.equals(Organization.getAdmin().getPhone())) {
                        printMenuAdmin(Organization.getAdmin());
                        found = true;
                        break big;
                    }
                    outer:
                    while (true) {
                        if (!found ) {
                            System.out.println("You are not registred in the system. Do you want to be a 1.Donator or a 2.Beneficiary");
                            if (sc.hasNextInt()) {
                                int choise = sc.nextInt();
                                sc.nextLine();

                                switch (choise) {
                                    case 1:
                                        System.out.println("What is your name? ");
                                        Organization.insertDonator(new Donator(sc.nextLine(), currPhone));
                                        System.out.println("Registration Successful. ");
                                        found = true;
                                        break outer;


                                    case 2:
                                        System.out.println("What's your name? ");
                                        String name = sc.nextLine();

                                        while (true) {
                                            System.out.println("How many members do you have in your family? ");
                                            if (sc.hasNextInt()) {
                                                int choi = Math.abs(sc.nextInt());
                                                choi = Math.abs(choi);

                                                if (choi > 0) {
                                                    Organization.insertBeneficiary(new Beneficiary(sc.nextLine(), currPhone, choi));
                                                    System.out.println("Registration Successful. ");
                                                    found = true;
                                                    break outer;
                                                } else {
                                                    System.out.println("Your family has to have at least 1 person (that is including you) .");

                                                }

                                            } else {
                                                sc.nextLine();
                                                System.out.println("Not a number.");
                                            }
                                        }


                                    default:
                                        System.out.println("Not a valid choice . Please choose again. ");
                                        break;


                                }


                            } else {
                                sc.nextLine();
                                System.out.println("Not a valid choice.");
                            }

                        }
                    }
                }
                }

            } catch (Exception E) {
                System.err.println(E);
            }



    }

    public void printMenuBene(Beneficiary be){
        System.out.println("Hello "+be.getName() +'\n'+"Your phone is :"+be.getPhone()); //ONOMA ORGANAT?????
        Scanner sc = new Scanner(System.in);

        outerb:
        while (true){

            int epil;

                while (true) {
                    System.out.println("1.Add Request");
                    System.out.println("2.Show Requests");
                    System.out.println("3.Commit");
                    System.out.println("4.Back");
                    System.out.println("5.Logout");
                    System.out.println("6.Exit");
                    if (sc.hasNextInt()) {
                        epil = sc.nextInt();
                        sc.nextLine();
                        break;
                    }else
                        sc.nextLine();
                }

                switch(epil){
                    case 1:
                        innerd1:
                        while (true) {
                                int counter = 0;
                                System.out.print("1.Material");
                                for (int i = 0; i < Organization.getEntityList().size(); i++) {
                                    if (Organization.getEntityList().get(i) instanceof Material)
                                        counter++;
                                }
                                System.out.println("(" + counter + ")");
                                System.out.println("2.Serivce " + '(' + (Organization.getEntityList().size() - counter) + ')');
                                int epild1;

                            System.out.println("Which Category do you want?");
                            System.out.println("Press 4 to go back");
                            if (sc.hasNextInt()) {
                                epild1 = sc.nextInt();
                                sc.nextLine();
                                switch (epild1) {
                                    case 1:

                                        ArrayList<Entity> materials = new ArrayList<>();
                                        boolean keno = false;
                                        for (int i = 0; i < Organization.getEntityList().size(); i++) {
                                            keno = false;
                                            if (Organization.getEntityList().get(i) instanceof Material) {
                                                materials.add(Organization.getEntityList().get(i));
                                                System.out.print(materials.size() + "." + Organization.getEntityList().get(i).getName());


                                                if (Organization.getCurrentDonations().getRdEntities().size() != 0) // dn eixame kanei elegxo an einai null
                                                    for (RequestDonation currDon : Organization.getCurrentDonations().getRdEntities()) {

                                                        if (currDon.getID() == Organization.getEntityList().get(i).getId()) {
                                                            System.out.println(" (" + currDon.getQuantity() + ')');
                                                            keno=true;
                                                        }
                                                    }
                                                if(!keno)
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
                                                        System.out.println("Do you want to Request this item? Press y or n for yes or no.");
                                                        System.out.println("Press 4 to go back");


                                                        String ok;
                                                        ok = sc.nextLine().strip().toLowerCase();

                                                        if (ok.length() == 1) {

                                                            switch (ok.charAt(0)) {
                                                                case 'y':
                                                                    System.out.println("What amount do you want to get?");
                                                                    double amount;
                                                                   boolean yparxei = false;
                                                                    if (sc.hasNextDouble()) {
                                                                        amount = Math.abs(sc.nextDouble());
                                                                        sc.nextLine();

                                                                        if (Organization.getCurrentDonations().getRdEntities().size() != 0)
                                                                            for (RequestDonation DonSearch : Organization.getCurrentDonations().getRdEntities()) { //tsekarei an yparxei hdh donation apo ayto to object
                                                                                if (materials.get(antikd1 - 1).getId() == DonSearch.getID()) {

                                                                                    RequestDonation temp1 = new RequestDonation(materials.get(antikd1-1),amount);

                                                                                    yparxei=true;
                                                                                    be.addRequest(temp1);


                                                                                    break while2;
                                                                                }

                                                                            }

                                                                        else
                                                                            System.out.println("There are no Donations currently");

                                                                        if(!yparxei){
                                                                            System.out.println("Donations of this item at this time do not exist.");
                                                                        }

                                                                    } else
                                                                        sc.nextLine();

                                                                    break;


                                                                case 'n':
                                                                    System.out.println(" You chose to not Request anything.");
                                                                    break while2;

                                                                case '4':
                                                                    break while2;
                                                                default:
                                                                    break;
                                                            }
                                                        }

                                                        break;
                                                    }
                                                } catch (IndexOutOfBoundsException e) {
                                                    System.err.println(e + "Material with that Number does not exist.");
                                                }
                                            } else
                                                sc.nextLine();
                                        }
                                        break;

                                    case 2:
                                        ArrayList<Entity> services = new ArrayList<>();

                                        for (int i = 0; i < Organization.getEntityList().size(); i++) {
                                            keno = false;
                                            if (Organization.getEntityList().get(i) instanceof Service) {
                                                services.add(Organization.getEntityList().get(i));
                                                // System.out.println();
                                                System.out.print(services.size() + "." + Organization.getEntityList().get(i).getName());

                                                if (Organization.getCurrentDonations().getRdEntities().size() != 0)
                                                    for (RequestDonation currDon : Organization.getCurrentDonations().getRdEntities()) {

                                                        if (currDon.getID() == Organization.getEntityList().get(i).getId()) {
                                                            System.out.println(" (" + currDon.getQuantity() + ')');
                                                            keno=true;
                                                        }
                                                    }
                                                if(!keno)
                                                    System.out.println();

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
                                                        System.out.println("Do you want to Request this service? Press y or n for yes or no.");
                                                        System.out.println("Press 4 to go back");
                                                        {
                                                            String ok;
                                                            ok = sc.nextLine().strip().toLowerCase();
                                                            if (ok.length() == 1) {

                                                                switch (ok.charAt(0)) {
                                                                    case 'y':
                                                                        System.out.println("How many hours do you want to request?");
                                                                        double hours;
                                                                        boolean yparxei = false;
                                                                        if (sc.hasNextDouble()) {
                                                                            hours = Math.abs(sc.nextDouble());
                                                                            sc.nextLine();
                                                                            if (Organization.getCurrentDonations().getRdEntities().size() != 0)
                                                                                for (RequestDonation DonSearch : Organization.getCurrentDonations().getRdEntities()) { //tsekarei an yparxei hdh donation apo ayto to object
                                                                                    if (services.get(antik - 1).getId() == DonSearch.getID()) {

                                                                                        RequestDonation temp3 = new RequestDonation(services.get(antik-1),hours);


                                                                                        be.addRequest(temp3);
                                                                                        yparxei=true;
                                                                                        break while3;
                                                                                    }

                                                                                }

                                                                            else
                                                                                System.out.println("Donations at this time do not exist.");
                                                                            if(!yparxei){
                                                                                System.out.println("Donations of this item at this time do not exist.");
                                                                            }
                                                                            break while3;

                                                                        } else
                                                                            sc.nextLine();
                                                                        break;

                                                                    case 'n':
                                                                        System.out.println(" You chose to not Request.");
                                                                        break while3;

                                                                    case '4':
                                                                        break while3;
                                                                    default:
                                                                        break;
                                                                }
                                                            }
                                                        }

                                                        break;

                                                    } catch (ArrayIndexOutOfBoundsException e) {
                                                        System.err.println(e);
                                                    }
                                                } else
                                                    sc.nextLine();
                                            }
                                        }
                                        break;

                                    case 4:
                                        break innerd1;

                                    default:
                                        System.out.println("Number doesnt match any category");
                                        break;
                                }
                            } else
                                sc.nextLine();
                        }
                        break;




                    case 2:
                        if (be.getRequestsList().getRdEntities().size() != 0)
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
                        return;
                    case 6:
                        System.out.println("Exitting...");
                        sc.close();
                        System.exit(0);

                }


            }


    }
    public void printMenuDon(Donator don) {
        System.out.println("Hello " + don.getName() + '\n' + "Your phone is :" + don.getPhone()); //ONOMA ORGANAT?????
        Scanner sc = new Scanner(System.in);

            outerd:
            while (true) {

                int epil;

                while (true) {
                    System.out.println("1.Add Offer");
                    System.out.println("2.Show Offers");
                    System.out.println("3.Commit");
                    System.out.println("4.Back");
                    System.out.println("5.Logout");
                    System.out.println("6.Exit");

                    if (sc.hasNextInt()) {
                        epil = sc.nextInt();
                        sc.nextLine();
                        break;
                    } else
                        sc.nextLine();
                }

                switch (epil) {
                    case 1:

                        innerd1:
                        while (true) {

                                int counter = 0;
                                System.out.print("1.Material");
                                for (int i = 0; i < Organization.getEntityList().size(); i++) {
                                    if (Organization.getEntityList().get(i) instanceof Material)
                                        counter++;
                                }
                                System.out.println("(" + counter + ")");
                                System.out.println("2.Serivce " + '(' + (Organization.getEntityList().size() - counter) + ')');
                                int epild1;

                            System.out.println("Which Category do you want?");
                            System.out.println("Press 4 to go back");
                            if (sc.hasNextInt()) {
                                epild1 = sc.nextInt();
                                sc.nextLine();
                                switch (epild1) {
                                    case 1:

                                        ArrayList<Entity> materials = new ArrayList<>();
                                        boolean keno = false;
                                        for (int i = 0; i < Organization.getEntityList().size(); i++) {
                                        keno=false;
                                            if (Organization.getEntityList().get(i) instanceof Material) {
                                                materials.add(Organization.getEntityList().get(i));
                                                System.out.print(materials.size() + "." + Organization.getEntityList().get(i).getName());
                                            

                                                if (Organization.getCurrentDonations().getRdEntities().size() != 0) // dn eixame kanei elegxo an einai null
                                                    
                                                    for (RequestDonation currDon : Organization.getCurrentDonations().getRdEntities()) {

                                                        if (currDon.getID() == Organization.getEntityList().get(i).getId()) {
                                                            System.out.println(" (" + currDon.getQuantity() + ')');
                                                            keno = true;
                                                        }
                                                    }

                                                if(!keno)
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
                                                        System.out.println("Press 4 to go back");


                                                        String ok;
                                                        ok = sc.nextLine().strip().toLowerCase();

                                                        if (ok.length() == 1) {

                                                            switch (ok.charAt(0)) {
                                                                case 'y':
                                                                    System.out.println("What amount do you want to offer?");
                                                                    double amount;
                                                                    if (sc.hasNextDouble()) {
                                                                        amount = Math.abs(sc.nextDouble());
                                                                        sc.nextLine();

                                                                        if (Organization.getCurrentDonations().getRdEntities().size() != 0)
                                                                            for (RequestDonation DonSearch : Organization.getCurrentDonations().getRdEntities()) { //tsekarei an yparxei hdh donation apo ayto to object
                                                                                if (materials.get(antikd1 - 1).getId() == DonSearch.getID()) {

                                                                                    RequestDonation temp1 = new RequestDonation(DonSearch.getEntity(), amount);
                                                                                    don.add(temp1);
                                                                                    System.out.println("Donation was succesful");

                                                                                    break while2;
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


                                                                    } else
                                                                        sc.nextLine();

                                                                    break;


                                                                case 'n':
                                                                    System.out.println(" You chose to not donate.");
                                                                    break while2;

                                                                case '4':
                                                                    break while2;
                                                                default:
                                                                    break;
                                                            }
                                                        }

                                                        break;
                                                    }
                                                } catch (ArrayIndexOutOfBoundsException e) {
                                                    System.err.println(e + "Material with that Number does not exist.");
                                                }
                                            } else
                                                sc.nextLine();
                                        }
                                        break;

                                    case 2:
                                        ArrayList<Entity> services = new ArrayList<>();

                                        for (int i = 0; i < Organization.getEntityList().size(); i++) {
                                            keno = false;
                                            if (Organization.getEntityList().get(i) instanceof Service) {
                                                services.add(Organization.getEntityList().get(i));
                                                // System.out.println();
                                                System.out.print(services.size() + "." + Organization.getEntityList().get(i).getName());

                                                if (Organization.getCurrentDonations().getRdEntities().size() != 0)
                                                    for (RequestDonation currDon : Organization.getCurrentDonations().getRdEntities()) {

                                                        if (currDon.getID() == Organization.getEntityList().get(i).getId()) {
                                                            System.out.println(" (" + currDon.getQuantity() + ')');
                                                            keno = true;
                                                        }
                                                    }

                                                if(!keno)
                                                    System.out.println();
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
                                                        System.out.println("Press 4 to go back");
                                                        {
                                                            String ok;
                                                            ok = sc.nextLine().strip().toLowerCase();
                                                            if (ok.length() == 1) {

                                                                switch (ok.charAt(0)) {
                                                                    case 'y':
                                                                        System.out.println("How many hours do you want to offer?");
                                                                        double hours;
                                                                        if (sc.hasNextDouble()) {
                                                                            hours = Math.abs(sc.nextDouble());
                                                                            sc.nextLine();
                                                                            if (Organization.getCurrentDonations().getRdEntities().size() != 0)
                                                                                for (RequestDonation DonSearch : Organization.getCurrentDonations().getRdEntities()) { //tsekarei an yparxei hdh donation apo ayto to object
                                                                                    if (services.get(antik - 1).getId() == DonSearch.getID()) {

                                                                                        RequestDonation temp3 = new RequestDonation(DonSearch.getEntity(), hours);

                                                                                        don.add(temp3);
                                                                                        break while3;
                                                                                    }

                                                                                }
                                                                            RequestDonation temp4 = new RequestDonation(services.get(antik - 1), hours);

                                                                            temp4.setQuantity(hours);

                                                                            don.add(temp4);
                                                                            System.out.println("Donation was succesful");
                                                                            break while3;

                                                                        } else
                                                                            sc.nextLine();
                                                                        break;

                                                                    case 'n':
                                                                        System.out.println(" You chose to not donate.");
                                                                        break while3;

                                                                    case '4':
                                                                        break while3;
                                                                    default:
                                                                        break;
                                                                }
                                                            }
                                                        }

                                                        break;

                                                    } catch (ArrayIndexOutOfBoundsException e) {
                                                        System.err.println(e);
                                                    }
                                                } else
                                                    sc.nextLine();
                                            }
                                        }
                                        break;

                                    case 4:
                                        break innerd1;

                                    default:
                                        System.out.println("Number doesnt match any category");
                                        break;
                                }
                            } else
                                sc.nextLine();
                        }
                        break;


                    case 2:
                        if (don.getOfferList().getRdEntities().size() != 0) {
                            outerw:
                            while (true) {
                                don.getOfferList().monitor();

                                System.out.println("a.Modify you Offer list");
                                System.out.println("b.Reset Your Offer List");
                                System.out.println("c.Commit");
                                System.out.println("Press 4 to go back.");
                                char epil2;
                                String st;
                                st = sc.nextLine().strip();


                                if (st.length() == 1) {
                                    epil2 = st.charAt(0);

                                    switch (epil2) {

                                        case 'a':
                                               innerw:
                                            while (true) {
                                                System.out.println("Choose an Entity.");
                                                if (sc.hasNextInt()) {
                                                    int choice;
                                                    choice = sc.nextInt();
                                                    sc.nextLine();


                                                    System.out.println("What do you want to do?");
                                                    System.out.println("1.Delete Offer");
                                                    System.out.println("2.Change an offer's quantity.");
                                                    System.out.println("Press 4 to go back");

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



                                                                } catch (IndexOutOfBoundsException e) {
                                                                    System.err.println(e + "You entity choice is not valid." );
                                                                    break;
                                                                }

                                                            case 2:

                                                                System.out.println("Give quantity");
                                                                if (sc.hasNextDouble()) {

                                                                    double quantity;
                                                                    quantity = Math.abs(sc.nextDouble());
                                                                    sc.nextLine();
                                                                    try {


                                                                        don.getOfferList().getRdEntities().get(choice - 1).setQuantity(quantity);
                                                                        System.out.println("Quantity was changed to given one.");
                                                                        break;
                                                                    } catch (IndexOutOfBoundsException e) {
                                                                        System.err.println(e + "\n" + "Choice of entity is not available");
                                                                        break;
                                                                    }
                                                                } else
                                                                    sc.nextLine();


                                                                break;

                                                            case 4:
                                                                break innerw;

                                                            default:
                                                                System.out.println("You option choice is not valid");
                                                                break;
                                                        }

                                                    } else
                                                        sc.nextLine();


                                                } else sc.nextLine();
                                                break;
                                            }
                                            break;
                                        case 'b':
                                            System.out.println("Deleting all offers...");
                                            don.getOfferList().reset();
                                            System.out.println("Success.");
                                            break;


                                        case 'c':

                                            don.commit();
                                            System.out.println("Commit successful.");
                                            break;


                                        case '4':
                                            break outerw;
                                        default:
                                            break;


                                    }
                                }


                            }
                            break;

                        } else {
                            System.out.println("You do not have any offers at this moment.");
                        }
                        break;


                    case 3:
                        don.commit();
                        System.out.println("Commit succesful");
                        break;
                    case 4:
                        break;

                    case 5:
                        System.out.println("Logging off...");
                        return;

                    case 6:
                        System.out.println("Exitting...");
                        sc.close();
                        System.exit(0);

                }


            }

    }

    public void printMenuAdmin(Admin ad){
        System.out.println("Welcome "+ad.getName()+ " Your Phone is: "+ad.getPhone());

        outer:
        while (true){
            System.out.println("1.View");
            System.out.println("2.Monitor Organization");
            System.out.println("3.Back");
            System.out.println("4.Logout");
            System.out.println("5.Exit");
            int epil;
            Scanner sc = new Scanner(System.in);

                while (true) {
                    if (sc.hasNextInt()) {
                        epil = sc.nextInt();
                        sc.nextLine();
                        break;
                    }else
                        sc.nextLine();
                }
                switch(epil) {
                    case 1:
                        inner1:
                        while (true) {
                                int counter=0;
                                System.out.print("1.Material" );
                                for(int i=0;i<Organization.getEntityList().size();i++){
                                    if (Organization.getEntityList().get(i) instanceof Material)
                                        counter++;
                                }
                                System.out.println("("+counter+")");
                                System.out.println("2.Serivce "+ '(' + (Organization.getEntityList().size()-counter) +')' );
                                int epil1;
                            System.out.println("Which Category do you want?");
                            System.out.println("Press 3 to go back");
                            if(sc.hasNextInt()) {
                                epil1 = sc.nextInt();
                                sc.nextLine();
                                switch (epil1) {
                                    case 1:
                                        ArrayList<Entity> materials = new ArrayList<>();
                                        boolean keno = false;
                                        for (int i = 0; i < Organization.getEntityList().size(); i++) {
                                            keno = false;
                                            if (Organization.getEntityList().get(i) instanceof Material) {
                                                materials.add(Organization.getEntityList().get(i));
                                                System.out.print( materials.size() + "." + Organization.getEntityList().get(i).getName());


                                                for (RequestDonation currDon : Organization.getCurrentDonations().getRdEntities()) {

                                                    if (currDon.getID() == Organization.getEntityList().get(i).getId()) {
                                                        keno=true;
                                                        System.out.println(" (" + currDon.getQuantity() + ')');
                                                    }
                                                }if(!keno){
                                                    System.out.println();
                                                }
                                            }
                                        }


                                        while (true) {
                                            int antik;
                                            System.out.println("Type the number of your desired Material: ");
                                            if (sc.hasNextInt()) {
                                                antik = sc.nextInt();
                                                sc.nextLine();
                                                try {
                                                    System.out.println(materials.get(antik - 1).toString() ) ;
                                                    break;
                                                }catch (ArrayIndexOutOfBoundsException e){
                                                    System.err.println(e);
                                                }
                                            }else
                                            sc.nextLine();
                                        }
                                    break;


                                    case 2:
                                        ArrayList<Entity> services = new ArrayList<>();

                                        for(int i=0;i<Organization.getEntityList().size();i++){
                                            keno=false;
                                            if (Organization.getEntityList().get(i) instanceof Service){
                                                services.add(Organization.getEntityList().get(i));
                                                System.out.print( services.size()+ "."+Organization.getEntityList().get(i).getName());

                                                for(RequestDonation currDon: Organization.getCurrentDonations().getRdEntities()){

                                                    if (currDon.getID()==Organization.getEntityList().get(i).getId()){
                                                        keno=true;
                                                        System.out.println(" ("+currDon.getQuantity()+')');
                                                    }
                                                }
                                                if(!keno){
                                                    System.out.println();
                                                }

                                            }
                                        }

                                        while (true) {
                                            int antik;
                                            System.out.println("Type the number of your desired Service: ");
                                            if (sc.hasNextInt()) {
                                                antik = sc.nextInt();
                                                sc.nextLine();
                                                try {
                                                    System.out.println( services.get(antik - 1).toString() );
                                                    break;
                                                }catch (IndexOutOfBoundsException e){
                                                    System.err.println(e);
                                                }
                                            }else
                                                sc.nextLine();
                                        }
                                        break;

                                    case 3:
                                        break inner1;

                                    default:
                                        System.out.println("Number doesnt match any category");
                                        break;
                                }
                            }else
                                sc.nextLine();

                        }
                        break;


                    case 2:

                        inner2:
                        while (true) {
                            char epil2;
                            System.out.println("a. List Beneficiaries");
                            System.out.println("b. List Donators");
                            System.out.println("c. Reset Beneficiaries Lists");
                            System.out.println("Press 3 to go back.");

                                String st;
                                st = sc.nextLine().strip();

                                if (st.length() == 1) {
                                    epil2 = st.charAt(0);

                                    switch (epil2) {
                                        case 'a':
                                            Organization.listBeneficiaries();
                                            int inp=0;
                                            boolean notNull = false;
                                            while (true) {
                                                if (Organization.getBeneficiaryList().size() != 0) {
                                                    System.out.println("Type the number of the Beneficiary you want.");
                                                    if (sc.hasNextInt()) {
                                                        inp = sc.nextInt();
                                                        sc.nextLine();
                                                        try {
                                                            Organization.getBeneficiaryList().get(inp - 1).getRecievedList().monitor();
                                                            break;

                                                        } catch (IndexOutOfBoundsException e) {
                                                            System.out.println(e);
                                                        }

                                                    } else
                                                        sc.nextLine();
                                                }
                                                else{
                                                    notNull=true;
                                                    break;
                                                }
                                            }
                                             if(notNull){
                                            System.out.println("There are not any Beneficiaries at this moment.");
                                             break inner2;
                                            }

                                            int inp2;
                                            inner3:
                                            while (true) {
                                                System.out.println("1.Clear Recieved List");
                                                System.out.println("2.Delete Beneficiary");
                                                System.out.println("Press 3 to go back.");

                                                System.out.println("Give one of the 3 numbers: ");
                                                if (sc.hasNextInt()) {
                                                    inp2 = sc.nextInt();
                                                    sc.nextLine();
                                                    switch (inp2){
                                                        case 1:
                                                            Organization.getBeneficiaryList().get(inp-1).getRecievedList().reset();
                                                            System.out.println("Benefiaciary's recieved list cleared.");
                                                            break inner3;
                                                        case 2:
                                                            Organization.removeBeneficiary(Organization.getBeneficiaryList().get(inp-1),currUserPhone);
                                                            System.out.println("Beneficiary deleted.");
                                                            break inner3;
                                                        case 3:
                                                            break inner3;

                                                        default:
                                                            System.out.println("Invalid Choice.Please Try again");
                                                            break;
                                                    }
                                                }else
                                                    sc.nextLine();
                                            }
                                            break;

                                        case 'b':

                                            int inpd;
                                            inner3:
                                            while (true) {
                                                Organization.listDonators();
                                                if(Organization.getDonatorList().size()!=0) {
                                                    System.out.println("Type the number of the Donator you want.");
                                                    if (sc.hasNextInt()) {
                                                        inpd = sc.nextInt();
                                                        sc.nextLine();
                                                        try {
                                                            Organization.getDonatorList().get(inpd - 1).getOfferList().monitor();

                                                            while (true) {
                                                                System.out.println("Do you want to delete the donator? Type yes to proceed.");
                                                                System.out.println("Press 3 to go back. ");
                                                                String checked;
                                                                {
                                                                    checked = sc.nextLine().toLowerCase();

                                                                    if (checked.equals("yes")) {
                                                                        Organization.removeDonator(Organization.getDonatorList().get(inpd - 1));
                                                                        System.out.println("Donator deleted. ");
                                                                        break inner3;

                                                                    } else if (checked.equals("3")) {
                                                                        break inner3;
                                                                    }

                                                                    break;
                                                                }

                                                            }
                                                        } catch (IndexOutOfBoundsException e) {
                                                            System.out.println(e);
                                                        }

                                                    } else
                                                        sc.nextLine();
                                                }else {
                                                    System.out.println("There are not donators currently.");
                                                    break inner3;
                                                }
                                            }

                                            break;


                                        case 'c':
                                            for (Beneficiary currBen : Organization.getBeneficiaryList()){
                                                currBen.getRecievedList().reset();
                                            }
                                            System.out.println("All Beneficiaries lists were Reset.");
                                            break;

                                        case '3':
                                            break inner2;
                                    }
                                }

                        }
                        break;

                    case 3:
                        break;
                    case 4:
                        System.out.println("Logging off...");
                        break outer;

                    case 5:
                        System.out.println("Exitting...");
                        sc.close();
                        System.exit(0);


                }

        }


    }


}