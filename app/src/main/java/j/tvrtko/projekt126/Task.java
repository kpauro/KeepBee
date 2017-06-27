package j.tvrtko.projekt126;

import java.io.Serializable;

/**
 * Created by Korisnik on 25.6.2017..
 */

public class Task implements Serializable {
    private int taskNo;
    private String description;

    public Task (int taskNo,String description){
        this.taskNo=taskNo;
        this.description=description;
    }

    public String toStringCustom(){
        StringBuilder sb= new StringBuilder();


       return String.valueOf(taskNo)+System.getProperty ("line.separator") +" : " +  description;
    }

    public String toStringI(){


        return "ID" +" : "+ String.valueOf(taskNo) ;
    }

    public String toStringS(){


        return  "Description"  +" : " +  description  ;
    }


}
