package REQUESTS;

import ENTITY.Entity;

import java.util.ArrayList;

public class Organization {
    private static ArrayList<Entity> entitylist = new ArrayList<>();

    public static ArrayList<Entity> getEntitylist() {
        return entitylist;
    }
}
