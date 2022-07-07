package processing;

import java.util.ArrayList;
import java.util.HashMap;

public class Apartment implements Comparable<HashMap> {

    private String mortgage;
    private String finishing;

    public Apartment(String mortgage, String finishing) {
        this.mortgage = mortgage;
        this.finishing = finishing;
    }

    public Apartment(FILTER all) {
    }

    public static ArrayList<Apartment> getAllApartment(){

        ArrayList<Apartment> apartments = new ArrayList<>();
        apartments.add(new Apartment("4.5%","Полная"));
        apartments.add(new Apartment("4.6%","Полная"));
        apartments.add(new Apartment("4.8%","Полная"));
        return apartments;
    }

    public String getMortgage() {
        return mortgage;
    }

    public void setMortgage(String mortgage) {
        this.mortgage = mortgage;
    }

    public String getFinishing() {
        return finishing;
    }

    public void setFinishing(String finishing) {
        this.finishing = finishing;
    }

    @Override
    public int compareTo(HashMap o) {
        return 0;
    }
}
