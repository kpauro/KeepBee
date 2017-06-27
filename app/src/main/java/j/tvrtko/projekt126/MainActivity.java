package j.tvrtko.projekt126;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public List<Hive> lHive1;
    public List<Queen> lQueen1;
    public List<Task> lTask1;
    public List<BeeFamily> lBee1;

Button addApiary;
    List novaLista;

    SharedPreferences prefs =null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //seting locked to

        prefs=getSharedPreferences("MyPrefs",0);

        SharedPreferences settings = getSharedPreferences("MyPrefs",0);
        SharedPreferences.Editor edit = settings.edit();

        addApiary = (Button) findViewById(R.id.addApiary);
        Boolean seen =prefs.getBoolean("MyPrefs",false);

        lHive1 = new ArrayList<Hive>();//Koristiti listu za spremanje kosnic i posebnu za matice
        lQueen1=new ArrayList<Queen>();
        lTask1=new ArrayList<Task>();
        lBee1=new ArrayList<BeeFamily>();

        if(!seen){     //Ako je prvi put upaljena, napravi file Hive.Bin. i vise ne ualzi ovdje
            edit.putBoolean("MyPrefs",true);
            edit.commit();
            Toast.makeText(MainActivity.this,
                    "Apiary created",
                    Toast.LENGTH_LONG).show();

            final File fileHive = new File(getApplicationContext().getFilesDir(),"Hive.bin");

        final File fileQueen = new File(getApplicationContext().getFilesDir(),"Queen.bin");

        final File fileTask = new File(getApplicationContext().getFilesDir(),"Task.bin");

        final File fileBee = new File(getApplicationContext().getFilesDir(),"BeeFamily.bin");

        try {
            FileOutputStream fos = new FileOutputStream(fileHive);
            ObjectOutputStream oos= new ObjectOutputStream(fos);
            //oos.writeObject("Today");
            oos.writeObject(lHive1);
            //oos.writeObject(lHive1);
            oos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
            try {
                FileOutputStream fos = new FileOutputStream(fileQueen);
                ObjectOutputStream oos= new ObjectOutputStream(fos);
                //oos.writeObject("Today");
                oos.writeObject(lQueen1);
                //oos.writeObject(lHive1);
                oos.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

        try {
            FileOutputStream fos = new FileOutputStream(fileTask);
            ObjectOutputStream oos= new ObjectOutputStream(fos);
            //oos.writeObject("Today");
            oos.writeObject(lTask1);
            //oos.writeObject(lHive1);
            oos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileOutputStream fos = new FileOutputStream(fileBee);
            ObjectOutputStream oos= new ObjectOutputStream(fos);
            //oos.writeObject("Today");
            oos.writeObject(lBee1);
            //oos.writeObject(lHive1);
            oos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

     }       //////


        addApiary.setOnClickListener(
                new View.OnClickListener(){

                    @Override
                    public  void onClick(View v){
                        Intent intent = new Intent(".MainMenu");//Konstruktro package name od druge aktivnsoti iz android manifessta

                        startActivity(intent);

                    }
                }
        );//on click listener


        if(seen) {

            Intent intent = new Intent(".MainMenu");//Konstruktro package name od druge aktivnsoti iz android manifessta

            startActivity(intent);


        }

    }


}

/*

   addApiary.setOnClickListener(
                new View.OnClickListener(){

                    @Override
                    public  void onClick(View v){


                    }
                }
        );//on click listener
 */
