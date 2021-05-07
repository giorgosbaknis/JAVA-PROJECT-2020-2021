package USER;
import REQUESTS.*;

public class Beneficiary extends User{
    private int noPersorns = 1;
    private RequestDonationList recievedList;
    private Requests requestsList;

    public Beneficiary(String name, String phone, int noPersorns) {
        super(name, phone);
        this.noPersorns = noPersorns;
    }
    
}
