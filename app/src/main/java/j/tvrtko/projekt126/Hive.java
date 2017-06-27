package j.tvrtko.projekt126;

import java.io.Serializable;

/**
 * Created by Korisnik on 12.6.2017..
 */

public class Hive implements Serializable {


    private int hiveID=0;
    private int noOfFrames=0;
    String bottomType;
    String state;
    String beeFamily;

    String description;

    private int strenght;
    private int queenNumber[];

   // String []type = {"Vertical","Horisontal", "Nucleus","Other"}; //Use ArrayAdapter later


    private Queen[] hiveQueens;     //Polje za pohranu matica

        public Hive(int hiveID, int noOfFrames,String bottomType,String state,String beeFamily ,int strenght, String description ) {
            this.hiveID=hiveID;
            this.noOfFrames=noOfFrames;

            this.bottomType=bottomType;
            this.state=state;
            this.beeFamily=beeFamily;

            this.strenght=strenght;
            this.description=description;
            //this.queenNumber[0]=queen;
        }

    public Hive() {

    }

        public void setType(String bottomType){
        this.bottomType=bottomType;

    }
    public String getType(){
        return bottomType;

    }
        public int setHiveId(){
           return 0;
        }

public String toStringCustom(){
    StringBuilder sb= new StringBuilder();

    return Integer.toString(hiveID)+" : " + Integer.toString(noOfFrames) +" : " + description+" : " + bottomType +" : " + state +" : " + beeFamily+" : " + String.valueOf(strenght);
}
    public String toStringI(){


        return "ID" +" : "+ String.valueOf(hiveID) +"   " + "No of frames" +" : " + String.valueOf(noOfFrames)+"   " + "Strenght" + String.valueOf(strenght)  ;
    }

    public String toStringS(){


        return "Description" +" : " +  description +"   " + "Bottom type"  +" : " +  bottomType +"   " + "State"  +" : " +  state +"   " + "Bee Family"  +" : " +  beeFamily;
    }
}

/*

    private int hiveID;
    private int noOfFrames;
    String bottomType;
    String state;
    String beeFamily;

    private int strenght;
    private int queenNumber[];
 */




