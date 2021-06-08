

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


    //me autin tin methodo prosthetoume kapoio entity stin entityList kai ginetai xeirismos exception,
    //to opoio tsekarei an to entity poy prosthetoume yparxei idi stin lista
    public  void addEntity(Entity entity ){

        try {


            if (entityList.contains(entity)) // to contains einai boolean
            {
                System.out.println("Error");
                throw new EntityAlreadyExistingException("This entity already exists");

            }
            entityList.add(entity);
        }catch (EntityAlreadyExistingException e) {
            System.err.println(e);
        }
    }

    //kanei remove ena entity apo tin lista
    public  void  removeEntity(Entity entity,String phones){

        if(phones.equals(admin.getPhone())){
            entityList.remove(entity);
        }


    }

    //me autin tin methodo prosthetoume kapoio donator stin donatorList kai ginetai xeirismos exception,
    //to opoio tsekarei an o sigkekrimenos donator iparxei idi stin lista
    public static void  insertDonator(Donator donator){

        try {

            if (donatorList.contains(donator)) //H methodos contains se ena arraylist einai boolean
            {
                System.out.println("Error");
                throw new UserAlreadyExistsException("This donator already exists");

            }
            donatorList.add(donator);
        }catch (UserAlreadyExistsException e){
            System.err.println(e);
        }
    }



    //afairei enan donator apo tin lista
    public  static void removeDonator(Donator donator){

        if(Menu.getCurrUserPhone().equals(admin.getPhone())){ //tsekarei an o current User einai admin
            donatorList.remove(donator);}
    }

    //me autin tin methodo prosthetoume kapoio beneficiary stin beneficiaryList kai ginetai xeirismos exception,
    //to opoio tsekarei an o sigkekrimenos beneficiary
    public  static void  insertBeneficiary(Beneficiary beneficiary){

        try {

            if (beneficiaryList.contains(beneficiary))
            {
                System.out.println("Error");
                throw new UserAlreadyExistsException("This beneficiary already exists");

            }
            beneficiaryList.add(beneficiary);
        }catch (UserAlreadyExistsException e){
            System.err.println(e);
        }


    }



    //afairei enan beneficiary apo tin lista
    public static void removeBeneficiary (Beneficiary beneficiary,String phones){
        if(phones.equals(admin.getPhone())){
            beneficiaryList.remove(beneficiary);}

    }

    //se autin thn methodo me tin xrisi tis for tsekaroume poia entities pou iparxoun stin lista anoikoun
    //stin kathgoria twn material h twn service kai epeita typwnei ta entities ana sygkekrimeni kathgoria
   public static void listEntities(){

        int cout=0;

        for(int i=0;i<entityList.size();i++){
            if (entityList.get(i) instanceof Service){
                cout++;
                if (cout==1){ //me to poy vrei to prwto typwnei to service
                    System.out.println("Service");
                }

                System.out.println( cout+". "+entityList.get(i).getName() );
            }
        }

       cout=0;
       for(int i=0;i<entityList.size();i++){
           if (entityList.get(i) instanceof Material){
               cout++;
               if (cout==1){ //me to poy vrei to prwto typwnei to Material
                   System.out.println("Material");
               }
               System.out.println( cout+". "+entityList.get(i).getName() );
           }

       }


    }

    // se aytin tin methodo me tis xrhsh tis for pairnoume ton kathe beneficiary apo tin lista tou kai me tin
    // voitheia tis getRecievedList kai tis  monitor typwnoume ton kathe beneficiary mazi me tin trexousa katastasi se paroxes poy exei lavei
   public static void listBeneficiaries() {

       for (int i=0;i<beneficiaryList.size();i++) {
           int count1=0,count2=0;
           System.out.println((i+1) + ". " + beneficiaryList.get(i).getName());
           for(RequestDonation rd : beneficiaryList.get(i).getRecievedList().getRdEntities())
           {


               if(rd.getEntity() instanceof  Material) { //an einai material to typwnei katw apto material
                   if(count1==0)
                       System.out.println("\tMaterial:");
                   count1++;
                   System.out.println("\t " + rd.getEntity().getName());
               }

               if(rd.getEntity() instanceof  Service) { //an einai service to typwnei katw apto service
                   if(count2==0)
                       System.out.println("\tService:");
                   count2++;
                   System.out.println("\t " + rd.getEntity().getName());
               }
           }

       }

    }

    //h methodos ayti emfanizei tous donators pou einai apothikeumenoi stin donatorList
   public static void listDonators(){

       for (int i=0;i<donatorList.size();i++) {
           System.out.println((i+1) + ". " + donatorList.get(i).getName());
       }
    }



}

