package j.tvrtko.projekt126;

import java.io.Serializable;

/**
 * Created by Korisnik on 25.6.2017..
 */

public class BeeFamily implements Serializable {

    private int beeFamilyID=0;
    private int beeFamilyStrenght=0;
    String beeFamilyType;
    String description;

    public BeeFamily (int beeFamilyID,int beeFamilyStrenght,String beeFamilyType , String description){
        this.beeFamilyID=beeFamilyID;
        this.beeFamilyStrenght=beeFamilyStrenght;
        this.beeFamilyType=beeFamilyType;
        this.description=description;
    }

    public String toStringCustom(){
        StringBuilder sb= new StringBuilder();

        return String.valueOf(beeFamilyID) +" : " +  beeFamilyType +" : " + String.valueOf(beeFamilyStrenght)  ;
    }

    public String toStringI(){


        return "ID" +" : "+ String.valueOf(beeFamilyID) +"   " + "Bee Family Strenght" +" : " + String.valueOf(beeFamilyStrenght)  ;
    }

    public String toStringS(){


        return "Description"  +" : " +  description +"   " +  "Bee Family Type" +" : " +  beeFamilyType  ;
    }


}
