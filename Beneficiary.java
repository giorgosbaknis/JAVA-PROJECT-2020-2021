

//klash epofeloumenou
public class Beneficiary extends User{

    private int noPersorns = 1;//arithmos melwn oikogeneias
    private RequestDonationList recievedList = new RequestDonationList();//lista twn eidwn kai twn posothtwn poy exei lavei
    private Requests requestsList = new Requests();//lista twn eidwn kai twn posothtwn poy zhta na tou dwthoun

    //epistrefei thn lista twn eidwn kai twn posothtwn pou exei lavei
    public RequestDonationList getRecievedList() {
        return recievedList;
    }
    //epistrefei thn lista twn eidwn kai twn posothtwn pou zhta
    public Requests getRequestsList() {
        return requestsList;
    }
    //epistrefei ton arithmo twn melwn ths oikogeneias
    public int getNoPersorns() {
        return noPersorns;
    }

    //constructor gia arxikopoihsh twn varibles tou beneficiary
    public Beneficiary(String name, String phone, int noPersorns) {
        super(name, phone);
        this.noPersorns = noPersorns;
    }
    //prosthetei ena antikeimeno rd sthn lista requestsList.
    public void addRequest(RequestDonation rd){
        requestsList.add(rd);
    }
    //emfanizei ola ta dedomena(eidh kai posothtes) ths requestList.
    public void showRequests(){requestsList.monitor();}
    //
    public void commitRequests(){
        requestsList.commit();
    }



}
