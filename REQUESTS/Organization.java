
import java.util.ArrayList;

public class Organization {

    private static ArrayList<Entity> entityList= new ArrayList<>();
   private static ArrayList<Beneficiary> beneficiaryList = new ArrayList<>();
   private static ArrayList<Donator> donatorList = new ArrayList<>();
    private    Admin admin;
    private RequestDonationList currentDonations;





    public ArrayList<Entity> getEntitylist() {

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


            if (entityList.contains(entity) == true) ;
            {
                System.out.println("Error");

            }
            throw new RuntimeException("This entity already exists");
        }catch (RuntimeException e){
            System.err.println(e);
        }
         if (entityList.contains(entity) == false){
         entityList.add(entity);}



     }

    public   void  removeEntity(Entity entity){

        if(admin==getAdmin());{
            entityList.remove(entity);
        }


    }

    public void  insertDonator(Donator donator){


        try {


            if (donatorList.contains(donator) == true) ;
            {
                System.out.println("Error");

            }
            throw new RuntimeException("This donator already exists");
        }catch (RuntimeException e){
            System.err.println(e);
        }
        if (donatorList.contains(donator) == false) ;{
        donatorList.add(donator);}

    }



    void removeDonator(Donator donator){

        if(admin==getAdmin());{
        donatorList.remove(donator);}
    }

    public  void  insertBeneficiary(Beneficiary beneficiary){

        try {


            if (beneficiaryList.contains(beneficiary) == true) ;
            {
                System.out.println("Error");

            }
            throw new RuntimeException("This beneficiary already exists");
        }catch (RuntimeException e){
            System.err.println(e);
        }
        if (beneficiaryList.contains(beneficiary) == false) ;{
        beneficiaryList.add(beneficiary);}

    }



    public void removeBeneficiary (Beneficiary beneficiary){
        if(admin==getAdmin());{
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
