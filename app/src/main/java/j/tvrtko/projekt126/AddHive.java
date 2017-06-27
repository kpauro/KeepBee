package j.tvrtko.projekt126;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Spinner;
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

public class AddHive extends AppCompatActivity  {
    public int hiveID=0;
    public int noOfFrames=0;
    public int strenghtSpinner=0;

    String []bottom = {"AntiVaroa","Solid","Other"};

    String []state={"Active","Sored","Borrowed","Inactive","Gone","Given for free"};
    String []beeFamily={"Purchase","Own production","Artificial swarming","Capture swarming","Natural swarming", "Loss"};

    Button addHive;
    SeekBar hiveStrenght;

    String bottomSpinner;
    String stateSpinenr;
    String beeFamilySpinner;
    String description;

    EditText XMLhiveID;
    EditText XMLnoOfFrames;
    EditText XMLdescription;

   public List<Hive> HiveList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);  //za skidanje project namea
        setContentView(R.layout.activity_add_hive);
        /////////////Ucitavanje filea////////////////
        final File file = new File(getApplicationContext().getFilesDir(),"Hive.bin");
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            //String today =(String) ois.readObject();
            HiveList=( List<Hive>)ois.readObject();
         //   Hive kosnica2=(Hive) nova.get(0);





            ois.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        /////////////END ucitavanje filea//////////////////////////////////

        hiveStrenght=(SeekBar)findViewById(R.id.hiveStrenght);

        XMLhiveID=(EditText) findViewById(R.id.HiveID);
        XMLnoOfFrames=(EditText) findViewById(R.id.noOfFrames);

        XMLdescription=(EditText) findViewById(R.id.description);


        //Pokusaj spinera
        Spinner bottomSpiner=(Spinner) findViewById(R.id.bottomSpiner);
        ArrayAdapter<String> bottomSpinerAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,bottom );
        bottomSpiner.setAdapter(bottomSpinerAdapter);
        //
        Spinner stateSpinner=(Spinner) findViewById(R.id.stateSpinner);
        ArrayAdapter<String> stateSpinnerAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,state );
        stateSpinner.setAdapter(stateSpinnerAdapter);
        //
        Spinner beeFamilySpiner=(Spinner) findViewById(R.id.beeFamilySpinner);
        ArrayAdapter<String> beeFamilyAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,beeFamily );
        beeFamilySpiner.setAdapter(beeFamilyAdapter);

        bottomSpiner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                               @Override
                                               public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                                   bottomSpinner=String.valueOf(parent.getItemAtPosition(position));         //String bottomSelec je odabir iz bottom[]

                                                //   Toast.makeText(AddHive.this,
                                                //           bottomSpinner,
                                                 //          Toast.LENGTH_LONG).show();
                                               }

                                               @Override
                                               public void onNothingSelected(AdapterView<?> parent) {

                                               }
                                           }
        );

        stateSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                                   @Override
                                                   public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                                       stateSpinenr=String.valueOf(parent.getItemAtPosition(position));         //String bottomSelec je odabir iz bottom[]

                                                 //      Toast.makeText(AddHive.this,
                                                 //              stateSpinenr,
                                                 //              Toast.LENGTH_LONG).show();
                                                   }

                                                   @Override
                                                   public void onNothingSelected(AdapterView<?> parent) {

                                                   }
                                               }
        );

        beeFamilySpiner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                                   @Override
                                                   public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                                       beeFamilySpinner=String.valueOf(parent.getItemAtPosition(position));         //String bottomSelec je odabir iz bottom[]

                                                  //     Toast.makeText(AddHive.this,
                                                  //             beeFamilySpinner,
                                                  //             Toast.LENGTH_LONG).show();
                                                   }

                                                   @Override
                                                   public void onNothingSelected(AdapterView<?> parent) {

                                                   }
                                               }
        );
                hiveStrenght.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener(){
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        strenghtSpinner=progress;

                        String text=String.valueOf(progress);
                      //  Toast.makeText(AddHive.this, text,
                     //           Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }

                    int progressVal;

                }
                        );

        addHive=(Button)findViewById(R.id.AddHive);
        addHive.setOnClickListener(
                new View.OnClickListener(){

                    @Override
                    public  void onClick(View v){
                        // Hive(int hiveID, int noOfFrames,String bottomType,String state,String beeFamily ,int stenght ,int queenNumber) {
                        hiveID =Integer.parseInt(XMLhiveID.getText().toString());
                        noOfFrames =Integer.parseInt(XMLnoOfFrames.getText().toString());
                        description=XMLdescription.getText().toString();

                        Hive kosnica=new Hive(hiveID,noOfFrames,bottomSpinner,stateSpinenr,beeFamilySpinner,strenghtSpinner,description);
                        HiveList.add(kosnica);
                        Log.d("HIVVEIDD","Val" +hiveID);
////////////////FILE output stream////////////////
                        final File file = new File(getApplicationContext().getFilesDir(),"Hive.bin");


                        try {
                            FileOutputStream fos = new FileOutputStream(file);
                            ObjectOutputStream oos= new ObjectOutputStream(fos);
                            //oos.writeObject("Today");
                            oos.writeObject(HiveList);
                            //oos.writeObject(lHive1);
                            oos.close();

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        ////////////////End output strem
                        Intent intent = new Intent(".MainMenu");//Konstruktro package name od druge aktivnsoti iz android manifessta

                        startActivity(intent);

                        //finish();
                    }
                }
        );



    }//On create


}


/*
                ///pokusajspineraend
        //bottom selet
        ListAdapter bottmoAdapter =new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,bottom); //Coverting string to lsit
        ListView ListHiveBottom = (ListView)findViewById(R.id.ListHiveBottom);
        ListHiveBottom.setAdapter(bottmoAdapter); // what do you want to convert to lsit istems
        //state select
        ListAdapter stateAdapter =new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,state); //Coverting string to lsit
        ListView ListHiveState = (ListView)findViewById(R.id.ListHiveState);
        ListHiveState.setAdapter(stateAdapter); // what do you want to convert to lsit istems
        //beeFamily select
        ListAdapter BeeFamilyAdapter =new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,beeFamily); //Coverting string to lsit
        ListView ListHiveBeeFamily = (ListView)findViewById(R.id.ListHiveBeeFamily);
        ListHiveBeeFamily.setAdapter(BeeFamilyAdapter); // what do you want to convert to lsit istems

            //Add Hive button
        addHive=(Button)findViewById(R.id.AddHive);
        addHive.setOnClickListener(
                new View.OnClickListener(){

                    @Override
                    public  void onClick(View v){

                    }
                }
        );

        ListHiveBottom.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String bottomSelect=String.valueOf(parent.getItemAtPosition(position));         //String bottomSelec je odabir iz bottom[]

                    }
                }

        );

        ListHiveState.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String stateSelect=String.valueOf(parent.getItemAtPosition(position));         //String bottomSelec je odabir iz bottom[]

                    }
                }

        );
        ListHiveBeeFamily.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String beeFamilySelect=String.valueOf(parent.getItemAtPosition(position));         //String bottomSelec je odabir iz bottom[]

                    }
                }

        );

*/

