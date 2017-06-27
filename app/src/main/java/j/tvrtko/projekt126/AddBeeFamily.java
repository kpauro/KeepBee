package j.tvrtko.projekt126;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;


public class AddBeeFamily extends AppCompatActivity {

    public int BeeFamilyID=0;
    public int BeeFamilyStrenght=0;
    String BeeFamilyType;

    String []beeFamily={"Purchase","Own production","Artificial swarming","Capture swarming","Natural swarming", "Loss"};

    Button addBeeFamily;
    SeekBar beeFamilyStrenght;

    String beeFamilySpinner;
    String description;

    EditText XMLBeeFamilyID;
    EditText XMLbeeFamilyStrenght;
    EditText XMLBeeFamilyDesc;

    public List<BeeFamily> BeeFamilyList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_bee_family);

        /////////////Ucitavanje filea////////////////
        final File file = new File(getApplicationContext().getFilesDir(),"BeeFamily.bin");
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            //String today =(String) ois.readObject();
            BeeFamilyList=( List<BeeFamily>)ois.readObject();
            //   Hive kosnica2=(Hive) nova.get(0);

            ois.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        /////////////END ucitavanje filea//////////////////////////////////
        beeFamilyStrenght=(SeekBar)findViewById(R.id.hiveStrenght);

        Spinner bottomSpiner=(Spinner) findViewById(R.id.bottomSpiner);
        ArrayAdapter<String> bottomSpinerAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,beeFamily );
        bottomSpiner.setAdapter(bottomSpinerAdapter);

        bottomSpiner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                                   @Override
                                                   public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                                       beeFamilySpinner=String.valueOf(parent.getItemAtPosition(position));         //String bottomSelec je odabir iz bottom[]

                                                     //  Toast.makeText(AddBeeFamily.this,
                                                      //         beeFamilySpinner,
                                                      //         Toast.LENGTH_LONG).show();
                                                   }

                                                   @Override
                                                   public void onNothingSelected(AdapterView<?> parent) {

                                                   }
                                               }
        );

        beeFamilyStrenght.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener(){
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        BeeFamilyStrenght=progress; // u int sprema

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

        addBeeFamily=(Button)findViewById(R.id.AddBeeFamily);
        addBeeFamily.setOnClickListener(
                new View.OnClickListener(){

                    @Override
                    public  void onClick(View v){
                        // Hive(int hiveID, int noOfFrames,String bottomType,String state,String beeFamily ,int stenght ,int queenNumber) {
                        XMLBeeFamilyID=(EditText) findViewById(R.id.BeeFamilyNumber);
                        BeeFamilyID =Integer.parseInt(XMLBeeFamilyID.getText().toString());


                        XMLBeeFamilyDesc=(EditText) findViewById(R.id.description);
                        description=XMLBeeFamilyDesc.getText().toString();



                        BeeFamily beeFam=new BeeFamily(BeeFamilyID,BeeFamilyStrenght,beeFamilySpinner,description);
                        BeeFamilyList.add(beeFam);

////////////////FILE output stream////////////////
                        final File file = new File(getApplicationContext().getFilesDir(),"BeeFamily.bin");


                        try {
                            FileOutputStream fos = new FileOutputStream(file);
                            ObjectOutputStream oos= new ObjectOutputStream(fos);
                            //oos.writeObject("Today");
                            oos.writeObject(BeeFamilyList);
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

    }
}
