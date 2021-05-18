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

    }
    public void printMenuBene(Donator don){

    }
    public void printMenuBene(Admin ad){

    }




}
