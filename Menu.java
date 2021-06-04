
import java.util.*;


public class Menu {
    private static String currUserPhone;//metavlhth sthn opoia apothikevoyme to thl tou current User

    //epistrefei to thlefwno tou User                   //
    public static String getCurrUserPhone() {
        return currUserPhone;
    }

    public void check() {

        try (Scanner sc = new Scanner(System.in)) { // anoigoyme thn scanner wste na paroyme input
            while (true) {
                big:
                while (true) {


                    String currPhone = "";

                    System.out.println("Give your phone number: "); //mas leipei h eggrafh

                    boolean found = false;

                    currUserPhone = currPhone = sc.nextLine().strip(); //.strip wste na mhn parei ta kena toy input aptin arxi kai telos
                    checking:
                    while (true) { //an aplws o xrhsths pathsei enter synexizei na zhtaei thlefwno
                        boolean trexw = true;

                        for (int i = 0; i < currPhone.length(); i++) { //tsekarei an exei dwsei arithmous
                            if (currPhone.charAt(i) > '9' || currPhone.charAt(i) < '0') {
                                trexw=false;
                                break;
                            } else if (i == currPhone.length() - 1) {
                               break;
                            }
                        }
                        if (currPhone.length() != 10 && trexw) { //an exei dwsei mono arithmous tsekarei an edwse 10 opws exei ena thlefwno
                            System.out.println("Put phone number with 10 digits!!!");
                            trexw=false;
                        }
                        else if(trexw) //an perasei tous elegxous synexzei
                            break checking;

                        if(!trexw) { //alliws zhtaei apo ton xrhsth na dwsei ena egkyro thlefwno
                            System.out.println("Give a valid phone number: ");

                            currUserPhone = currPhone = sc.nextLine().strip();
                        }

                    }

                        for (Beneficiary currBen : Organization.getBeneficiaryList()) {
                            if (currPhone.equals(currBen.getPhone())) { //vriskoyme an to curr Thlefwno antistoixei se kapoio Beneficiary
                                found = true;
                                printMenuBene(currBen); //kalei to Menu gia beneficiary
                                break big; //break to big gia na ksansazhthsei thlefwno

                            }
                        }

                        for (Donator currDon : Organization.getDonatorList()) {
                            if (currPhone.equals(currDon.getPhone())) { //vriskoyme an to curr Thlefwno antistoixei se kapoio Donator
                                found = true;
                                printMenuDon(currDon);
                                break big; //break to big gia na ksansazhthsei thlefwno
                            }
                        }
                        if (currPhone.equals(Organization.getAdmin().getPhone())) { //vriskoyme an to curr Thlefwno antistoixei ston Admin
                            printMenuAdmin(Organization.getAdmin());
                            found = true;
                            break big; //break to big gia na ksansazhthsei thlefwno
                        }
                        outer:
                        while (true) {
                            if (!found) {
                                System.out.println("You are not registred in the system. Do you want to be a 1.Donator or a 2.Beneficiary");
                                if (sc.hasNextInt()) {
                                    int choise = sc.nextInt();
                                    sc.nextLine(); //ta nextLine ypoxretwtika opoy xrhsimopoieitai scanner
                                    //an den einai eggegramenos ton rwtaei an thelei na einai Bene h Dona
                                    switch (choise) {
                                        case 1:
                                            System.out.println("What is your name? ");
                                            Organization.insertDonator(new Donator(sc.nextLine(), currPhone)); // ton eisagei ston Organismo
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
                                                    choi = Math.abs(choi); //pernei apolyth timh gia to posa atoma exei

                                                    if (choi > 0) { //exei toyl ena 1 atomo sta Persons ton eayto toy dld
                                                        Organization.insertBeneficiary(new Beneficiary(sc.nextLine(), currPhone, choi)); // ton eisagei ston Organismo
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
        }catch(Exception E)
    {
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
                        sc.nextLine(); //ta nextLine ypoxretwtika opoy xrhsimopoieitai scanner
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
                                for (int i = 0; i < Organization.getEntityList().size(); i++) { //metrame posa einai ta material sto organismo gia ta typwsei meta
                                    if (Organization.getEntityList().get(i) instanceof Material)
                                        counter++;
                                }
                                System.out.println("(" + counter + ")");
                                System.out.println("2.Serivce " + '(' + (Organization.getEntityList().size() - counter) + ')');
                                int epild1; //ta synolika- ta material einai osa einai ta service

                            System.out.println("Which Category do you want?");
                            System.out.println("Press 4 to go back");
                            if (sc.hasNextInt()) { //epilegei mia apo tis 2 kathgories
                                epild1 = sc.nextInt();
                                sc.nextLine(); //ta nextLine ypoxretwtika opoy xrhsimopoieitai scanner
                                switch (epild1) {
                                    case 1: //an epileksei material




                                        while2:
                                        while (true) {
                                            ArrayList<Entity> materials = new ArrayList<>();
                                            boolean keno = false;
                                            for (int i = 0; i < Organization.getEntityList().size(); i++) { //diaperash ta entities toy organismoy
                                                keno = false;
                                                if (Organization.getEntityList().get(i) instanceof Material) { //an vrei to antikeimeno san material
                                                    materials.add(Organization.getEntityList().get(i)); //to prosthetei se mia arraylist
                                                    System.out.print(materials.size() + "." + Organization.getEntityList().get(i).getName());
                                                    //to material.size dhlwnei th thesi toy antikeimenoy poy typwnoume
                                                    //kai sthn epomenh typwnoyme to onoma toy material mas

                                                    if (Organization.getCurrentDonations().getRdEntities().size() != 0) // dn eixame kanei elegxo an einai kenh
                                                        for (RequestDonation currDon : Organization.getCurrentDonations().getRdEntities()) {

                                                            if (currDon.getID() == Organization.getEntityList().get(i).getId()) { //an vrei to antikeimeno oti prosforetai posothta
                                                                System.out.println(" (" + currDon.getQuantity() + ')'); //thn typwnei apo dipla
                                                                keno=true;
                                                            }
                                                        }
                                                    if(!keno)
                                                        System.out.println(); //morfopoihsh twn prints


                                                }
                                            }

                                            int antikd1;

                                            System.out.println("Type the number of your desired Material.");
                                            if (sc.hasNextInt()) { //zhtame apto xrhsth poio entity thelei
                                                antikd1 = sc.nextInt();
                                                sc.nextLine();//ta nextLine ypoxretwtika opoy xrhsimopoieitai scanner
                                                try {
                                                    while2_1:
                                                    while (true) {
                                                        System.out.println(materials.get(antikd1 - 1).toString()); //typwnoyme oles tis leptomeries toy
                                                        System.out.println("Do you want to Request this item? Press y or n for yes or no.");
                                                        System.out.println("Press 4 to go back");


                                                        String ok;
                                                        ok = sc.nextLine().strip().toLowerCase();
                                                        //.strip gia na fygoyn ta kena apo mpros pisw kai toLowerCase gia na metatrepetai to input panta se mikra
                                                        if (ok.length() == 1) {
                                                        //eksetazoume an edwse 1 mono xarakthra opws zhthsame
                                                            switch (ok.charAt(0)) {
                                                                case 'y': //an thelei na kanei request
                                                                    System.out.println("What amount do you want to get?");
                                                                    double amount;
                                                                   boolean yparxei = false; // me ayta eksetazoume an prosferetai ayto p zhtaei
                                                                    if (sc.hasNextDouble()) { //zhtame posothta
                                                                        amount = Math.abs(sc.nextDouble());
                                                                        sc.nextLine();

                                                                        if (Organization.getCurrentDonations().getRdEntities().size() != 0)//an den einai adeia h lista
                                                                            for (RequestDonation DonSearch : Organization.getCurrentDonations().getRdEntities()) { //tsekarei an yparxei hdh donation apo ayto to object
                                                                                if (materials.get(antikd1 - 1).getId() == DonSearch.getID()) { //kai vroyme oti yparxei ayto to entity

                                                                                    RequestDonation temp1 = new RequestDonation(materials.get(antikd1-1),amount);
                                                                                    //dinoyme san orisma to entity kai to poso poy thelei kai kaloume thn antisoixh methodo
                                                                                    yparxei=true;
                                                                                    be.addRequest(temp1);


                                                                                    break while2;
                                                                                }

                                                                            }

                                                                        else
                                                                            System.out.println("There are no Donations currently");

                                                                        if(!yparxei){ //an dn yparxei tetoio donation katallhlh ektypwsh
                                                                            System.out.println("Donations of this item at this time do not exist.");
                                                                        }

                                                                    } else
                                                                        sc.nextLine();  //ta nextLine ypoxretwtika opoy xrhsimopoieitai scanner

                                                                    break;


                                                                case 'n':
                                                                    System.out.println(" You chose to not Request anything.");
                                                                    break while2;

                                                                case '4': //to back
                                                                    break while2;
                                                                default: //an dwsei asxeto character
                                                                    break;
                                                            }
                                                        }

                                                        break;
                                                    }
                                                } catch (EntityOutOfBoundsException e) { //an dwsei asxeto aithmo entity
                                                    System.err.println(e + "Material with that Number does not exist.");
                                                }
                                            } else
                                                sc.nextLine(); //ta nextLine ypoxretwtika opoy xrhsimopoieitai scanner
                                        }
                                        break;

                                    case 2:



                                        while3:
                                        while (true) {

                                            ArrayList<Entity> services = new ArrayList<>();

                                            for (int i = 0; i < Organization.getEntityList().size(); i++) { //omoiws me thn material
                                                boolean keno = false;
                                                if (Organization.getEntityList().get(i) instanceof Service) {
                                                    services.add(Organization.getEntityList().get(i)); //apothikevoume ta services se arraylist
                                                    // System.out.println();
                                                    System.out.print(services.size() + "." + Organization.getEntityList().get(i).getName());
                                                    //to megethos toy arraylist dhlwnei kai th thesi toy antikemenou poy kanoume print
                                                    if (Organization.getCurrentDonations().getRdEntities().size() != 0) // an dn einai kenh
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


                                            int antik;

                                            while4:
                                            while (true) {
                                                System.out.println("Type the number of your desired Service");
                                                if (sc.hasNextInt()) { //poio service thelei
                                                    antik = sc.nextInt();
                                                    sc.nextLine();
                                                    try {
                                                        System.out.println(services.get(antik - 1).toString());
                                                        System.out.println("Do you want to Request this service? Press y or n for yes or no."); //omoiws me material
                                                        System.out.println("Press 4 to go back");
                                                        {
                                                            String ok;
                                                            ok = sc.nextLine().strip().toLowerCase();
                                                            if (ok.length() == 1) {

                                                                switch (ok.charAt(0)) {
                                                                    case 'y':
                                                                        System.out.println("How many hours do you want to request?");
                                                                        double hours; //wres yphresias anti gia pososthta
                                                                        boolean yparxei = false;
                                                                        if (sc.hasNextDouble()) {
                                                                            hours = Math.abs(sc.nextDouble());
                                                                            sc.nextLine();
                                                                            if (Organization.getCurrentDonations().getRdEntities().size() != 0)
                                                                                for (RequestDonation DonSearch : Organization.getCurrentDonations().getRdEntities()) { //tsekarei an yparxei hdh donation apo ayto to object
                                                                                    if (services.get(antik - 1).getId() == DonSearch.getID()) { //an vrei to antikeimeno

                                                                                        RequestDonation temp3 = new RequestDonation(services.get(antik-1),hours); //san orisma dexontai ola RD


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
                                                                        break while3; // to back
                                                                    default:
                                                                        break; //an dwsei axrhsto xarakthra
                                                                }
                                                            }
                                                        }

                                                        break;

                                                    } catch (EntityOutOfBoundsException e) {
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
                                sc.nextLine();//ta nextLine aparaitha an xrhsimopoioyme scanner
                        }
                        break;




                    case 2:
                        if (be.getRequestsList().getRdEntities().size() != 0) //an den einai adeia
                            be.showRequests(); //deixnei mono ta Request
                        else
                            System.out.println("There are not any requests at this time.");
                        break;

                    case 3:
                            be.commitRequests(); //h diaxeirish exception kai print ginetai sthn commit
                        break;

                    case 4:
                        break;

                    case 5:
                        System.out.println("Logging off..."); //den epistrefei tipota alla termatizei thn methodo kai synexizei kanonika h CHECK
                        return;
                    case 6:
                        System.out.println("Exitting...");
                        sc.close(); //Kleinoyme to scanner
                        System.exit(0); //kai termatizei teleiws to programma

                }


            }


    }
    public void printMenuDon(Donator don) {
        System.out.println("Hello " + don.getName() + '\n' + "Your phone is :" + don.getPhone()); //ektypwsh plhroforiwn tou donator
        Scanner sc = new Scanner(System.in);

        outerd:
        while (true) {

            int epil;
            //ektypwsi epologwn xrhsth
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
            //eleghos ths epiloghw tou xrhsth
            switch (epil) {
                //perisptosh Add Offer
                case 1:

                    innerd1:
                    while (true) {

                        int counter = 0;//metrhths
                        //ektypwsh twn material kai twn services kai twn posotitwn twn stoixeiwn tous
                        System.out.print("1.Material");
                        for (int i = 0; i < Organization.getEntityList().size(); i++) {
                            if (Organization.getEntityList().get(i) instanceof Material)
                                counter++;
                        }
                        System.out.println("(" + counter + ")");
                        System.out.println("2.Serivce " + '(' + (Organization.getEntityList().size() - counter) + ')');
                        int epild1;

                        System.out.println("Which Category do you want?");//o xrhsths epilegei 1 apo tis 2 kathgories.
                        System.out.println("Press 4 to go back");//me to 4 ginetai back
                        if (sc.hasNextInt()) {
                            epild1 = sc.nextInt();
                            sc.nextLine();
                            //eleghos ths epiloghs tou xrhsth
                            switch (epild1) {
                                //perisptwsh epiloghs tou Material
                                case 1:

                                    while2:
                                    while (true) {

                                        ArrayList<Entity> materials = new ArrayList<>();
                                        boolean keno = false;
                                        for (int i = 0; i < Organization.getEntityList().size(); i++) {
                                            keno=false;
                                            //eleghos an to entity einai material h oxi
                                            if (Organization.getEntityList().get(i) instanceof Material) {
                                                materials.add(Organization.getEntityList().get(i));//prosthetei to entity sthn materials
                                                System.out.print(materials.size() + "." + Organization.getEntityList().get(i).getName());

                                                //an o arithmos twn entities pou mporoun na dvrhthoun einai != 0
                                                if (Organization.getCurrentDonations().getRdEntities().size() != 0)
                                                    //gia kathe entity
                                                    for (RequestDonation currDon : Organization.getCurrentDonations().getRdEntities()) {
                                                        //an to entity pou diakinei o organismos exei prosfores ekeinh thn stigmh
                                                        if (currDon.getID() == Organization.getEntityList().get(i).getId()) {
                                                            System.out.println(" (" + currDon.getQuantity() + ')');
                                                            keno = true;
                                                        }
                                                    }
                                                //morfopoihsh
                                                if(!keno)
                                                    System.out.println();

                                            }
                                        }

                                        int antikd1;
                                        //epilogi katallhlou material poy thelei o xrhsths
                                        System.out.println("Type the number of your desired Material.");
                                        if (sc.hasNextInt()) {
                                            antikd1 = sc.nextInt();
                                            sc.nextLine();
                                            try {
                                                while2_1:
                                                while (true) {
                                                    System.out.println(materials.get(antikd1 - 1).toString());//ektypwsh plhrofoiwn tou material.
                                                    //epilogh gia to an thelei o xrhsthe na prosferei to antikeimeno h oxi
                                                    System.out.println("Do you want to offer this item? Press y or n for yes or no.");
                                                    System.out.println("Press 4 to go back");


                                                    String ok;
                                                    ok = sc.nextLine().strip().toLowerCase();//metatroph character se low
                                                    //an o xrhsths exei dwsei epitrepto character
                                                    if (ok.length() == 1) {

                                                        switch (ok.charAt(0)) {
                                                            case 'y':
                                                                System.out.println("What amount do you want to offer?");//posotita pou thelei na dwsei o xrhsths
                                                                double amount;
                                                                //eisagwgh posothtas
                                                                if (sc.hasNextDouble()) {
                                                                    amount = Math.abs(sc.nextDouble());//apolyth timh posothtas xrhsth
                                                                    sc.nextLine();
                                                                    //an o arithmos twn entities pou exoun prosferthei einai != 0
                                                                    if (Organization.getCurrentDonations().getRdEntities().size() != 0)
                                                                        for (RequestDonation DonSearch : Organization.getCurrentDonations().getRdEntities()) { //elegxei an yparxei hdh donation apo ayto to object

                                                                            if (materials.get(antikd1 - 1).getId() == DonSearch.getID()) {

                                                                                RequestDonation temp1 = new RequestDonation(DonSearch.getEntity(), amount);//dhmiourgia neou antikeimenou
                                                                                don.add(temp1);//prosthetei to entity
                                                                                System.out.println("Donation was succesful");

                                                                                break while2;
                                                                            }

                                                                        }

                                                                    RequestDonation temp2 = new RequestDonation(materials.get(antikd1 - 1), amount);

                                                                    temp2.setQuantity(amount);//allagh ths posothtas toy antikeimenou

                                                                    don.add(temp2);
                                                                    System.out.println("Donation was succesful");
                                                                    break while2;


                                                                } else
                                                                    sc.nextLine();

                                                                break;
                                                            //o xrhsths den thelei na kanei donate
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
                                            } catch (EntityOutOfBoundsException e) {
                                                System.err.println(e + "Material with that Number does not exist.");
                                            }
                                        } else
                                            sc.nextLine();
                                    }
                                    break;

                                case 2:


                                        while3:
                                        while (true) {

                                            ArrayList<Entity> services = new ArrayList<>();//dhmiourgia neas listas
                                            //
                                            for (int i = 0; i < Organization.getEntityList().size(); i++) {
                                                boolean keno = false;
                                                //an to entity einai service
                                                if (Organization.getEntityList().get(i) instanceof Service) {
                                                    //ta entities typou services entasontai sthn lista services
                                                    services.add(Organization.getEntityList().get(i));
                                                    //ektypwsh tou size you arraylist kai tou onomatos
                                                    System.out.print(services.size() + "." + Organization.getEntityList().get(i).getName());
                                                    //an o arithmos twn entities pou exoun prosferthei einai != 0
                                                    if (Organization.getCurrentDonations().getRdEntities().size() != 0)
                                                        for (RequestDonation currDon : Organization.getCurrentDonations().getRdEntities()) {

                                                            if (currDon.getID() == Organization.getEntityList().get(i).getId()) {
                                                                //ektypwsh tou quantity
                                                                System.out.println(" (" + currDon.getQuantity() + ')');
                                                                keno = true;
                                                            }
                                                        }

                                                    if(!keno)
                                                        System.out.println();
                                                }
                                            }

                                            int antik;
                                            while4:
                                            while (true) {
                                                System.out.println("Type the number of your desired Service");
                                                if (sc.hasNextInt()) {
                                                    antik = sc.nextInt(); //dinoyme sto xrhsth na epileksei service
                                                    sc.nextLine();
                                                    try {
                                                        System.out.println(services.get(antik - 1).toString()); //print details apto service p dialekse
                                                        System.out.println("Do you want to offer this service? Press y or n for yes or no.");
                                                        System.out.println("Press 4 to go back");
                                                        {
                                                            String ok;
                                                            ok = sc.nextLine().strip().toLowerCase(); //input ama thelei to prosferei
                                                            if (ok.length() == 1) { //an edwse ena char opws toy eipame

                                                                switch (ok.charAt(0)) { //diavazei ton character sthn thesi 0 afou h java diavazei string
                                                                    case 'y':
                                                                        System.out.println("How many hours do you want to offer?");
                                                                        double hours; //poses wres thelei an prosferei
                                                                        if (sc.hasNextDouble()) {
                                                                            hours = Math.abs(sc.nextDouble());//se apolyth timh
                                                                            sc.nextLine(); // aparaithto afoy yparxei scanner
                                                                            if (Organization.getCurrentDonations().getRdEntities().size() != 0) //an den einai kenh
                                                                                for (RequestDonation DonSearch : Organization.getCurrentDonations().getRdEntities()) { //tsekarei an yparxei hdh donation apo ayto to object
                                                                                    if (services.get(antik - 1).getId() == DonSearch.getID()) { //an sysxetistoyn ta dio ID oti einai to idio entity

                                                                                        RequestDonation temp3 = new RequestDonation(DonSearch.getEntity(), hours);
                                                                                        //ftiaxnoume ena neo request Donation kai kaloyme thn katallhlh add
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
                                                                        System.out.println(" You chose to not donate."); //an pathsei den ginetai to donate
                                                                        break while3;

                                                                    case '4': // to back
                                                                        break while3;
                                                                    default: // an pathsei kati akyro poy exei perasei toys prohgoumenos elegxous paei ekei gia na ton ksanarwthsei
                                                                        break;
                                                                }
                                                            }
                                                        }

                                                        break;

                                                    } catch (EntityOutOfBoundsException e) {
                                                        System.err.println(e);
                                                    }
                                                } else
                                                    sc.nextLine();
                                            }
                                        }
                                        break;

                                    case 4://to back
                                        break innerd1;

                                    default://akyro input
                                        System.out.println("Number doesnt match any category");
                                        break;
                                }
                            } else
                                sc.nextLine();
                        }
                        break;


                    case 2:
                        if (don.getOfferList().getRdEntities().size() != 0) { //an den einai kenh h lista prosforwn
                            outerw:
                            while (true) {
                                don.getOfferList().monitor(); //typwnei tis prosfores toy

                                System.out.println("a.Modify you Offer list");
                                System.out.println("b.Reset Your Offer List");
                                System.out.println("c.Commit");
                                System.out.println("Press 4 to go back.");
                                char epil2;
                                String st;
                                st = sc.nextLine().strip(); //zhtame na dwsei epilogh ti tha kanei


                                if (st.length() == 1) {//tsekaroume an edwse ena xarakthra
                                    epil2 = st.charAt(0); //pernoyme to xarakthra sthn thesi 0 mias kai diavazoyme mono string stin java

                                    switch (epil2) {

                                        case 'a': //an thelei na peiraksei thn lista toy
                                               innerw:
                                            while (true) {
                                                System.out.println("Choose an Entity.");
                                                if (sc.hasNextInt()) {
                                                    int choice;
                                                    choice = sc.nextInt(); //epilegei entity
                                                    sc.nextLine();


                                                    System.out.println("What do you want to do?");
                                                    System.out.println("1.Delete Offer");
                                                    System.out.println("2.Change an offer's quantity.");
                                                    System.out.println("Press 4 to go back");

                                                    if (sc.hasNextInt()) {
                                                        int chos; //epilegei ti thelei na kanei
                                                        chos = sc.nextInt();
                                                        sc.nextLine();

                                                        switch (chos) {
                                                            case 1://an thelei na diagrapsei prosfora toy
                                                                try {

                                                                //afairoyme thn epilogh toy -1 epeidh typwnontai me seira 1. 2. 3. enw ta panta arxizoyn apo to 0
                                                                    don.getOfferList().remove(don.getOfferList().getRdEntities().get(choice - 1));
                                                                    System.out.println("Offer was successfully removed");
                                                                    break;
                                                                //afairoyme apo thn lista poy periexei h offerlist ena stoixeio ayths ths listas


                                                                } catch (EntityOutOfBoundsException e) { //an dwsei entity ektos oriwn
                                                                    System.err.println(e + "You entity choice is not valid." );
                                                                    break;
                                                                }

                                                            case 2: //an thelei an tropoihsei mai posothta

                                                                System.out.println("Give quantity");
                                                                if (sc.hasNextDouble()) {

                                                                    double quantity;
                                                                    quantity = Math.abs(sc.nextDouble()); //dinei to poso se apolyth timh
                                                                    sc.nextLine();
                                                                    try {

                                                                        //thetei thn posothta ths prosforas toy me aythn p epelekse
                                                                        don.getOfferList().getRdEntities().get(choice - 1).setQuantity(quantity);
                                                                        System.out.println("Quantity was changed to given one.");
                                                                        break;
                                                                    } catch (EntityOutOfBoundsException e) { //omoios an exei dwsei entity ektos oriwn
                                                                        System.err.println(e + "\n" + "Choice of entity is not available");
                                                                        break;
                                                                    }
                                                                } else
                                                                    sc.nextLine(); //nextLine aparaithta opoy xrhsimopoieitai scanner


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
                                        case 'b': //an thelei na diagrapsei th lista toy kaloyme thn katallhlh methodo
                                            System.out.println("Deleting all offers...");
                                            don.getOfferList().reset();
                                            System.out.println("Success.");
                                            break;


                                        case 'c': //aplo commit me xeirismo sthn Offers.

                                            don.commit();
                                            break;


                                        case '4': //back
                                            break outerw;
                                        default://an dwsei mh epithimity epilogh pou prospernaei tis prohgoumenes sinthikes
                                            break;


                                    }
                                }


                            }
                            break;

                        } else {
                            System.out.println("You do not have any offers at this moment.");
                        }
                        break;


                    case 3: //commit opws kai pio panw
                        don.commit();
                        break;
                    case 4: //to back poy dn kanei exei ousia edw
                        break;

                    case 5:
                        System.out.println("Logging off...");
                        return; //epistrefei tpt afou einai void alla etsi termatizei thn methodo kai synexizoyme kanonika sthn check

                    case 6:
                        System.out.println("Exitting...");
                        sc.close();
                        System.exit(0); //kleinoyme to scanner kai termatizoyme to programma

                }


            }

    }

    public void printMenuAdmin(Admin ad){
        System.out.println("Welcome "+ad.getName()+ " Your Phone is: "+ad.getPhone());//emfanizei to onoma tou admin kai to thlefwno tou

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
                if (sc.hasNextInt()) {//me tin xrisi tis scanner o admin epilegei poies apo tis 5 periptwseis tha epileksei
                    epil = sc.nextInt();
                    sc.nextLine();
                    break;
                }else
                    sc.nextLine();
            }
            switch(epil) {
                case 1:
                    inner1:
                    while (true) {//tou emfanizei to kathe eidos ana sygkekrimenh kathgoria
                        int counter=0;
                        System.out.print("1.Material" );
                        for(int i=0;i<Organization.getEntityList().size();i++){
                            if (Organization.getEntityList().get(i) instanceof Material)//kanei elegxo an iparxoun material stin entityList
                                counter++;
                        }
                        System.out.println("("+counter+")");
                        System.out.println("2.Serivce "+ '(' + (Organization.getEntityList().size()-counter) +')' );//kanei print ta ypoloipa eidh pou den anoikoun stin material alla stin service
                        int epil1;
                        System.out.println("Which Category do you want?");
                        System.out.println("Press 3 to go back");
                        if(sc.hasNextInt()) {//ginetai xrhsh tis scanner gia to an o admin thelei na epileksei kapoia  apo tis 2 katigories twn entity h na kanei back
                            epil1 = sc.nextInt();
                            sc.nextLine();
                            switch (epil1) {//an epileksei tin kathgoria material trexei to case1
                                case 1:
                                    ArrayList<Entity> materials = new ArrayList<>();
                                    boolean keno = false;
                                    for (int i = 0; i < Organization.getEntityList().size(); i++) {//diapernaei ta entity tou organismou
                                        keno = false;
                                        if (Organization.getEntityList().get(i) instanceof Material) {//kanei elegxo an iparxei material
                                            materials.add(Organization.getEntityList().get(i)); //to prosthetei se mia arraylist
                                            System.out.print( materials.size() + "." + Organization.getEntityList().get(i).getName());
                                            //to material.size dhlwnei th thesi toy antikeimenoy poy typwnoume
                                            //kai sthn epomenh typwnoyme to onoma toy material mas


                                            for (RequestDonation currDon : Organization.getCurrentDonations().getRdEntities()) {

                                                if (currDon.getID() == Organization.getEntityList().get(i).getId()) {//an vrei to antikeimeno oti prosforetai posothta
                                                    keno=true;
                                                    System.out.println(" (" + currDon.getQuantity() + ')');//thn typwnei apo dipla
                                                }
                                            }if(!keno){
                                                System.out.println();//morfopoihsh twn prints
                                            }
                                        }
                                    }


                                    while (true) {
                                        int antik;
                                        System.out.println("Type the number of your desired Material: ");
                                        if (sc.hasNextInt()) {//zhtame apto xrhsth poio material thelei
                                            antik = sc.nextInt();
                                            sc.nextLine();//ta nextLine ypoxretwtika opoy xrhsimopoieitai scanner
                                            try {
                                                System.out.println(materials.get(antik - 1).toString() ) ;//typwnoyme oles tis leptomeries toy
                                                break;
                                            }catch (EntityOutOfBoundsException e){
                                                System.err.println(e);
                                            }
                                        }else
                                            sc.nextLine();
                                    }
                                    break;


                                //an epileksei tin kathgoria service trexei to case2
                                case 2:
                                    ArrayList<Entity> services = new ArrayList<>();

                                    for(int i=0;i<Organization.getEntityList().size();i++){//diapernaei ta entity tou organismou
                                        keno=false;
                                        if (Organization.getEntityList().get(i) instanceof Service){//kanei elegxo an iparxei to service
                                            services.add(Organization.getEntityList().get(i));//to prosthetei se mia arraylist
                                            System.out.print( services.size()+ "."+Organization.getEntityList().get(i).getName());
                                            //to service.size dhlwnei th thesi toy antikeimenoy poy typwnoume
                                            //kai sthn epomenh typwnoyme to onoma toy service mas


                                            for(RequestDonation currDon: Organization.getCurrentDonations().getRdEntities()){

                                                if (currDon.getID()==Organization.getEntityList().get(i).getId()){//an vrei to antikeimeno oti prosforetai posothta
                                                    keno=true;
                                                    System.out.println(" ("+currDon.getQuantity()+')');//tin typwnei apo dipla
                                                }
                                            }
                                            if(!keno){
                                                System.out.println();//morfopoihsh twn prints
                                            }

                                        }
                                    }

                                    while (true) {
                                        int antik;
                                        System.out.println("Type the number of your desired Service: ");
                                        if (sc.hasNextInt()) {//zhtame apto xrhsth poio service thelei
                                            antik = sc.nextInt();
                                            sc.nextLine();//ta nextLine ypoxretwtika opoy xrhsimopoieitai scanner
                                            try {
                                                System.out.println( services.get(antik - 1).toString() );//typwnoyme oles tis leptomeries toy
                                                break;
                                            }catch (EntityOutOfBoundsException e){
                                                System.err.println(e);
                                            }
                                        }else
                                            sc.nextLine();
                                    }
                                    break;


                                case 3:
                                    break inner1;//se periptwsh pou o admin epileksei tin trith epilogh kanei back

                                default:
                                    System.out.println("Number doesnt match any category");//an o admin den epleksei kapoia apo tis 3 epiloges
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
                        st = sc.nextLine().strip();//.strip wste na mhn parei ta kena toy input aptin arxi kai telos

                        if (st.length() == 1) {//tsekaroume an edwse ena xarakthra
                            epil2 = st.charAt(0);//pernoyme to xarakthra sthn thesi 0 mias kai diavazoyme mono string stin java

                            switch (epil2) {
                                case 'a'://an thelei na tou emfanisei tous beneficiaries

                                    int inp=0;
                                    boolean notNull = false;
                                    while (true) {

                                        Organization.listBeneficiaries();

                                        if (Organization.getBeneficiaryList().size() != 0) {
                                            System.out.println("Type the number of the Beneficiary you want.");
                                            if (sc.hasNextInt()) {
                                                inp = sc.nextInt();//epilegei beneficiary
                                                sc.nextLine();
                                                try {
                                                    Organization.getBeneficiaryList().get(inp - 1).getRecievedList().monitor();
                                                    break;

                                                } catch (EntityOutOfBoundsException e) {
                                                    System.out.println(e);
                                                }

                                            } else
                                                sc.nextLine();
                                        }
                                        else{//tsekarei an h lista me tous beneficiaries einai kenh
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
                                            inp2 = sc.nextInt();//pairnei apo ton xrhsth mia  apo tis treis epiloges
                                            sc.nextLine();
                                            switch (inp2){
                                                case 1:
                                                    Organization.getBeneficiaryList().get(inp-1).getRecievedList().reset();//diagrafei ta stoixeia ths listas
                                                    System.out.println("Benefiaciary's recieved list cleared.");
                                                    break inner3;
                                                case 2:
                                                    Organization.removeBeneficiary(Organization.getBeneficiaryList().get(inp-1),currUserPhone);//diagrafei ton pou kataxwrei o xrhsths beneficiary
                                                    System.out.println("Beneficiary deleted.");
                                                    break inner3;
                                                case 3:
                                                    break inner3;//kanei back

                                                default://an o xrhsths den epileksei kati apo ta parapanw emfanizetai auto to minima
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
                                                Organization.listDonators(); //print olous tous donator
                                                if(Organization.getDonatorList().size()!=0) { // an den einai kenh h lista
                                                    System.out.println("Type the number of the Donator you want.");
                                                    if (sc.hasNextInt()) {
                                                        inpd = sc.nextInt(); //zhtame poio donator thelei o admin
                                                        sc.nextLine();
                                                        try {
                                                            Organization.getDonatorList().get(inpd - 1).getOfferList().monitor();
                                                            //typwnei analutika ta stoixeia aytoy toy donator
                                                            while (true) {
                                                                System.out.println("Do you want to delete the donator? Type yes to proceed.");
                                                                System.out.println("Press 3 to go back. ");
                                                                String checked;
                                                                {
                                                                    checked = sc.nextLine().toLowerCase();
                                                                //pernoume input gia an thelei na diagrapsei ton Dona se mikrh grammatoseira
                                                                    //wste na apofygoume extra anousious elegxous
                                                                    if (checked.equals("yes")) {
                                                                        Organization.removeDonator(Organization.getDonatorList().get(inpd - 1));
                                                                        //remove ton Dona
                                                                        System.out.println("Donator deleted. ");
                                                                        break inner3;

                                                                    } else if (checked.equals("3")) { // to back
                                                                        break inner3;
                                                                    }
                                                                    //gia opoiodhpote allo input pera toy 3 kai tou yes toy ksanazhtaei ti thelei na kanei
                                                                    break;
                                                                }

                                                            }
                                                        } catch (EntityOutOfBoundsException e) {//an den exei epilsksei egkyro arithmo donator
                                                            System.out.println(e);
                                                        }

                                                    } else
                                                        sc.nextLine();
                                                }else { //an einai adeia h lista
                                                    System.out.println("There are not donators currently.");
                                                    break inner3;
                                                }
                                            }

                                            break;


                                        case 'c':
                                            for (Beneficiary currBen : Organization.getBeneficiaryList()){
                                                currBen.getRecievedList().reset();
                                            } //diagrafei th lista me ta antikeimena p phre o kathe Bene
                                            System.out.println("All Beneficiaries lists were Reset.");
                                            break;

                                        case '3': //to back
                                            break inner2;
                                    }
                                }

                        }
                        break;

                    case 3:
                        break;
                    case 4:
                        System.out.println("Logging off...");
                        break outer; //break to outer kai teleiwnei h methodos

                    case 5:
                        System.out.println("Exitting...");
                        sc.close(); //kleinoume thn scanner kai termatizei to programma
                        System.exit(0);


                }

        }


    }


}