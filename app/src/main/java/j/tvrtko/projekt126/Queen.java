package j.tvrtko.projekt126;

import java.io.Serializable;

/**
 * Created by Korisnik on 12.6.2017..
 */

public class Queen implements Serializable {
    private int queenId;
    private int hiveNo;

    String breed;

    String color;

    String queenDate;

    String description;

    public Queen (int queenId,int hiveNo,String breed,String color,String description){
        this.queenId=queenId;
        this.hiveNo=hiveNo;

        this.breed=breed;
        this.color=color;
        this.description=description;
    }
    public String toStringCustom(){
        StringBuilder sb= new StringBuilder();

        return String.valueOf(queenId) +" : " + String.valueOf(hiveNo) +" : " + breed +" : " + color +" : " + description;
    }

    public String toStringI(){


        return "ID" +" : "+ String.valueOf(queenId) +"   " + "Hive No" +" : " + String.valueOf(hiveNo)  ;
    }

    public String toStringS(){


        return "Breed" +" : " +  breed +"   " + "Color"  +" : " +  color +"   " + "Description"  +" : " +  description ;
    }
}



