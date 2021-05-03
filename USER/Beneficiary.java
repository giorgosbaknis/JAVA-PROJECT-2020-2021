package USER;

public class Beneficiary extends User{
    private int noPersorns = 1;

    public Beneficiary(String name, String phone, int noPersorns) {
        super(name, phone);
        this.noPersorns = noPersorns;
    }

}
