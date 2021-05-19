package MENU;
import REQUESTS.Organization;
import USER.*;

import java.util.*;

public class Menu {
    private String currUserPhone;



    public void check(){
        String currPhone="";
        System.out.println("Give your phone number: ");
        try (Scanner sc = new Scanner(System.in)) {
            if(sc.hasNext()){
                currPhone = sc.nextLine().strip();
            }
            for(Beneficiary currBen : Organization.getBeneficiaryList()){
                if (currPhone.equals(currBen.getPhone())){

                }
            }

            for(Donator currDon : Organization.getDonatorList()){
                if (currPhone.equals(currDon.getPhone())){

                }
            }



        }catch (Exception E){
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
        while (true){
            int epil;
            try(Scanner sc = new Scanner(System.in))
            {
                while (true) {
                    if (sc.hasNextInt()) {
                        epil = sc.nextInt();
                        break;
                    }
                }
                switch(epil){
                    case 1:



                    case 2:
                        be.getRequestsList().monitor();
                        break;

                    case 3:
                        be.getRequestsList().commit();
                        break;

                    case 4:

                    case 5:

                    case 6:
                        System.exit(0);

                }


            }
        }

    }
    public void printMenuDon(Donator don){

        System.out.println("1.Add Offer");
        System.out.println("2.Show Offers");
        System.out.println("3.Commit");
        System.out.println("4.Back");
        System.out.println("5.Logout");
        System.out.println("6.Exit");
        while (true){
            int epil;
            try(Scanner sc = new Scanner(System.in))
            {
                while (true) {
                    if (sc.hasNextInt()) {
                        epil = sc.nextInt();
                        break;
                    }
                }
                switch(epil){
                    case 1:


                    case 2:
                        don.getOfferList().monitor();
                        break;
                    case 3:
                        don.getOfferList().commit();
                        break;
                    case 4:

                    case 5:

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
        while (true){
            int epil;
            try(Scanner sc = new Scanner(System.in))
            {
                while (true) {
                    if (sc.hasNextInt()) {
                        epil = sc.nextInt();
                        break;
                    }
                }
                switch(epil) {
                    case 1:
                        char epil1;
                        while (true) {

                        }

                        // na vroume pws typwnoume tis pososthtes

                        break;
                    case 2:
                        char epil2;
                        while (true) {
                            if (sc.hasNext()) {
                                String st;
                                st = sc.next().strip(); //thelw char gtpm
                                if (st.length() == 1) {
                                    epil2 = st.charAt(0);
                                    switch (epil2) {
                                        case 'a':
                                            Organization.listBeneficiaries();
                                            int inp;
                                            while (true) {

                                                System.out.println("Type the number of the Beneficiary you want.");
                                                if (sc.hasNextInt()) {
                                                    inp = sc.nextInt();
                                                    try {
                                                        Organization.getBeneficiaryList().get(inp-1).getRecievedList().monitor();
                                                        break;

                                                    } catch (ArrayIndexOutOfBoundsException e) {
                                                        System.out.println(e);
                                                    }

                                                }
                                            }
                                            System.out.println("1.Clear Recieved List");
                                            System.out.println("2.Delete Beneficiary");
                                            int inp2;
                                            while (true) {
                                                 System.out.println("Give one of the 2 numbers: ");
                                                if (sc.hasNextInt()) {
                                                    inp2 = sc.nextInt();
                                                    switch (inp2){
                                                        case 1:
                                                            Organization.getBeneficiaryList().get(inp-1).getRecievedList().reset();
                                                            break;
                                                        case 2:
                                                            Organization.removeBeneficiary(Organization.getBeneficiaryList().get(inp-1),currUserPhone);
                                                            break;
                                                        default:
                                                            break;
                                                    }
                                                }
                                            }

                                        case 'b':
                                            Organization.listDonators();
                                            int inpd;
                                            while (true) {

                                                System.out.println("Type the number of the Donator you want.");
                                                if (sc.hasNextInt()) {
                                                    inpd = sc.nextInt();
                                                    try {
                                                        Organization.getDonatorList().get(inpd-1).getOfferList().monitor();
                                                        break;

                                                    } catch (ArrayIndexOutOfBoundsException e) {
                                                        System.out.println(e);
                                                    }

                                                }
                                            }
                                            System.out.println("Do you want to delete the donator? Type yes to proceed.");
                                            String checked;
                                            if(sc.hasNext()){
                                                checked =sc.nextLine().toLowerCase();
                                                if(checked.equals("yes")){
                                                    Organization.removeDonator(Organization.getDonatorList().get(inpd-1),currUserPhone);
                                                }

                                            }
                                            break;

                                        case 'c':
                                            for (Beneficiary currBen : Organization.getBeneficiaryList()){
                                               currBen.getRecievedList().reset();
                                            }
                                            break;

                                    }
                                }


                            }
                        }
                        break;


                    case 3:

                    case 4:

                    case 5:
                        System.exit(0);


                }
            }
        }


    }




}
