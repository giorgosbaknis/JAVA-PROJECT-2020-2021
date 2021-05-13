package USER;
import REQUESTS.*;

public class Beneficiary extends User{
    private int noPersorns = 1;
    private RequestDonationList recievedList;
    private Requests requestsList;


    public RequestDonationList getRecievedList() {
        return recievedList;
    }

    public Requests getRequestsList() {
        return requestsList;
    }

    public int getNoPersorns() {
        return noPersorns;
    }


    public Beneficiary(String name, String phone, int noPersorns) {
        super(name, phone);
        this.noPersorns = noPersorns;
    }

    public void addRequest(RequestDonation rd){
        requestsList.add(rd);
    }

    public void showRequests(){
        requestsList.monitor();
    }

    public void commitRequests(){
        requestsList.commit();
    }







}
