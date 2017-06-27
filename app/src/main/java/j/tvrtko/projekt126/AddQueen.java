package j.tvrtko.projekt126;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
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

public class AddQueen extends AppCompatActivity {
    public int queenID=0;
    public int hiveID=0;



    String description;
    String []breed={"Italian","Corniolan","Caucasian","Russian-Hybrid","Minessota-Hybrid"};
    String []color={"Red","Green","Blue","Yellow","white", "Black"};

    Button addQueen;


    String breedSpinnerString;
    String colorSpinenrString;

    TextView XMLqueenID;
    TextView XMLhiveID;

    public List<Queen> QueenList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_queen);

        final File file = new File(getApplicationContext().getFilesDir(),"Queen.bin");
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            //String today =(String) ois.readObject();
            QueenList=(List<Queen>)ois.readObject();
            //   Hive kosnica2=(Hive) nova.get(0);

            ois.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        /////////////END ucitavanje filea//////////////////////////////////



        XMLqueenID=(TextView) findViewById(R.id.QueenID);
        XMLhiveID=(TextView) findViewById(R.id.QueenHive);




        //Pokusaj spinera
        Spinner breedSpinner=(Spinner) findViewById(R.id.breedSpinner);
        ArrayAdapter<String> bottomSpinerAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,breed );
        breedSpinner.setAdapter(bottomSpinerAdapter);
        //
        Spinner colorSpinner=(Spinner) findViewById(R.id.colorSpinner);
        ArrayAdapter<String> stateSpinnerAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,color );
        colorSpinner.setAdapter(stateSpinnerAdapter);
        //


        breedSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                                   @Override
                                                   public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                                       breedSpinnerString=String.valueOf(parent.getItemAtPosition(position));         //String bottomSelec je odabir iz bottom[]

                                            //           Toast.makeText(AddQueen.this,
                                          //                     breedSpinnerString,
                                         //                      Toast.LENGTH_LONG).show();
                                                   }

                                                   @Override
                                                   public void onNothingSelected(AdapterView<?> parent) {

                                                   }
                                               }
        );

        colorSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                                   @Override
                                                   public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                                       colorSpinenrString=String.valueOf(parent.getItemAtPosition(position));         //String bottomSelec je odabir iz bottom[]

                                  //                     Toast.makeText(AddQueen.this,
                                  //                             colorSpinenrString,
                                  //                             Toast.LENGTH_LONG).show();
                                                   }

                                                   @Override
                                                   public void onNothingSelected(AdapterView<?> parent) {

                                                   }
                                               }
        );





        addQueen=(Button)findViewById(R.id.AddQueen);
        addQueen.setOnClickListener(
                new View.OnClickListener(){

                    @Override
                    public  void onClick(View v){
                        // public Queen (int queenId,int hiveNo,String breed,String color,String description){
                        queenID =Integer.parseInt(XMLqueenID.getText().toString());
                        hiveID =Integer.parseInt(XMLhiveID.getText().toString());

                        Queen newQueen=new Queen(hiveID,queenID,breedSpinnerString,colorSpinenrString,description);
                        QueenList.add(newQueen);
////////////////FILE output stream////////////////
                        final File file = new File(getApplicationContext().getFilesDir(),"Queen.bin");


                        try {
                            FileOutputStream fos = new FileOutputStream(file);
                            ObjectOutputStream oos= new ObjectOutputStream(fos);
                            //oos.writeObject("Today");
                            oos.writeObject(QueenList);
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
