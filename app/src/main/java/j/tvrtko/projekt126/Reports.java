package j.tvrtko.projekt126;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Iterator;
import java.util.List;

public class Reports extends AppCompatActivity {

    String[] reportType={"Hives","Queens","Bee Families","Tasks"};
    String reportSelected;
    String[] HivesString;
    String[] QueensString;
    String[] BeeFamilyString;
    String[] TasksString;
    String[] NotesString;

    public List<Queen> QueenList;
    public List<Hive> HiveList;
    public List<Task> TaskList;
    public List<BeeFamily> BeeList;

    TextView textView;
    //Dodati tasks list
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reports);

        //U list view ispisi kosnice

        textView=(TextView)findViewById(R.id.textView);

        //////////////UCITAVANJE FILOVA////
        final File fileQueen = new File(getApplicationContext().getFilesDir(),"Queen.bin");
        try {
            FileInputStream fis = new FileInputStream(fileQueen);
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
        /////

        final File fileTask = new File(getApplicationContext().getFilesDir(),"Task.bin");
        try {
            FileInputStream fis = new FileInputStream(fileTask);
            ObjectInputStream ois = new ObjectInputStream(fis);
            //String today =(String) ois.readObject();
            TaskList=(List<Task>)ois.readObject();
            //   Hive kosnica2=(Hive) nova.get(0);

            ois.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        /////


        final File fileHive = new File(getApplicationContext().getFilesDir(),"Hive.bin");
        try {
            FileInputStream fis = new FileInputStream(fileHive);
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

        /////


        final File fileBee = new File(getApplicationContext().getFilesDir(),"BeeFamily.bin");
        try {
            FileInputStream fis = new FileInputStream(fileBee);
            ObjectInputStream ois = new ObjectInputStream(fis);
            //String today =(String) ois.readObject();
            BeeList=( List<BeeFamily>)ois.readObject();
            //   Hive kosnica2=(Hive) nova.get(0);
            ois.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ///////////////////////ucitavanje filoba/////////////


        Spinner reportSpiner=(Spinner) findViewById(R.id.reportSpiner);
        ArrayAdapter<String> reportSpinerAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,reportType );
        reportSpiner.setAdapter(reportSpinerAdapter);

        reportSpiner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                                   @Override
                                                   public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                                       reportSelected=String.valueOf(parent.getItemAtPosition(position));         //String bottomSelec je odabir iz bottom[]

                                                       ///Itarator




                                                       ///

                                    //                   Toast.makeText(Reports.this,
                                   //                            reportSelected,
                                   //                            Toast.LENGTH_LONG).show();
                                                       switch (position){

                                                           case 0:
                                                               HivesString = new String[HiveList.size()];
                                                               for (Hive temp :HiveList ){
                                                                   Hive kosnica2=temp;
                                                                  // textView.setText(kosnica2.toStringCustom());
                                                                   HivesString[HiveList.indexOf(temp)]=kosnica2.toStringCustom();

                                                               }

                                                               ListAdapter hivesAdapter =new ArrayAdapter<String>(Reports.this,android.R.layout.simple_spinner_dropdown_item,HivesString); //Coverting string to lsit
                                                               ListView ListHiveBottom = (ListView)findViewById(R.id.listView);
                                                               ListHiveBottom.setAdapter(hivesAdapter); // what do you want to convert to lsit istems

                                                               ListHiveBottom.setOnItemClickListener(
                                                                       new AdapterView.OnItemClickListener() {
                                                                           @Override
                                                                           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                                                               String bottomSelect=String.valueOf(parent.getItemAtPosition(position));         //String bottomSelec je odabir iz bottom[]

                                                                               Intent intent = new Intent(".Details");//Konstruktro package name od druge aktivnsoti iz android manifessta
                                                                               intent.putExtra("Hive",HiveList.get(position)); //ubaci hive za prijenos
                                                                               intent.putExtra("HiveNoForDelete",position);
                                                                               startActivity(intent);
                                                                                //Ovisno o odabiru prikazi tu kosnicu u fragmentu gdje su svi stats + remove
                                                                           }
                                                                       }

                                                               );

                                                               break;
                                                           case 1:
                                                               //matcie
                                                               QueensString = new String[QueenList.size()];

                                                               for (Queen temp1 :QueenList ){
                                                                   Queen queen=temp1;
                                                                //   textView.setText(queen.toStringCustom());
                                                                   QueensString[QueenList.indexOf(temp1)]=queen.toStringCustom();

                                                               }

                                                               ListAdapter queenAdapter =new ArrayAdapter<String>(Reports.this,android.R.layout.simple_spinner_dropdown_item,QueensString); //Coverting string to lsit
                                                               ListView ListQueenBottom = (ListView)findViewById(R.id.listView);
                                                               ListQueenBottom.setAdapter(queenAdapter); // what do you want to convert to lsit istems

                                                               ListQueenBottom.setOnItemClickListener(
                                                                       new AdapterView.OnItemClickListener() {
                                                                           @Override
                                                                           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                                                               String bottomSelect=String.valueOf(parent.getItemAtPosition(position));         //String bottomSelec je odabir iz bottom[]

                                                                               Intent intent = new Intent(".Details");//Konstruktro package name od druge aktivnsoti iz android manifessta
                                                                               intent.putExtra("Queen",QueenList.get(position)); //ubaci hive za prijenos
                                                                               intent.putExtra("QueenNoForDelete",position);
                                                                               startActivity(intent);
                                                                               //Ovisno o odabiru prikazi tu kosnicu u fragmentu gdje su svi stats + remove
                                                                           }
                                                                       }

                                                               );

                                                               break;
                                                           case 2:
                                                               //bee families
                                                               BeeFamilyString = new String[BeeList.size()];
                                                               for (BeeFamily temp :BeeList ){
                                                                   BeeFamily beeList=temp;
                                                                   // textView.setText(kosnica2.toStringCustom());
                                                                   BeeFamilyString[BeeList.indexOf(temp)]=beeList.toStringCustom();

                                                               }

                                                               ListAdapter beeAdapter =new ArrayAdapter<String>(Reports.this,android.R.layout.simple_spinner_dropdown_item,BeeFamilyString); //Coverting string to lsit
                                                               ListView ListBeeBottom = (ListView)findViewById(R.id.listView);
                                                               ListBeeBottom.setAdapter(beeAdapter); // what do you want to convert to lsit istems

                                                               ListBeeBottom.setOnItemClickListener(
                                                                       new AdapterView.OnItemClickListener() {
                                                                           @Override
                                                                           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                                                               String bottomSelect=String.valueOf(parent.getItemAtPosition(position));         //String bottomSelec je odabir iz bottom[]

                                                                               Intent intent = new Intent(".Details");//Konstruktro package name od druge aktivnsoti iz android manifessta
                                                                               intent.putExtra("BeeFamily",BeeList.get(position)); //ubaci hive za prijenos
                                                                               intent.putExtra("BeeFamilyForDelete",position);
                                                                               startActivity(intent);
                                                                               //Ovisno o odabiru prikazi tu kosnicu u fragmentu gdje su svi stats + remove
                                                                           }
                                                                       }

                                                               );

                                                               break;
                                                           case 3:
                                                               //TAsks
                                                               TasksString = new String[TaskList.size()];
                                                               for (Task temp :TaskList ){
                                                                   Task task2=temp;
                                                                   // textView.setText(kosnica2.toStringCustom());
                                                                   TasksString[TaskList.indexOf(temp)]=task2.toStringCustom();

                                                               }

                                                               ListAdapter taskAdapter =new ArrayAdapter<String>(Reports.this,android.R.layout.simple_spinner_dropdown_item,TasksString); //Coverting string to lsit
                                                               ListView ListTaskBottom = (ListView)findViewById(R.id.listView);
                                                               ListTaskBottom.setAdapter(taskAdapter); // what do you want to convert to lsit istems

                                                               ListTaskBottom.setOnItemClickListener(
                                                                       new AdapterView.OnItemClickListener() {
                                                                           @Override
                                                                           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                                                               String bottomSelect=String.valueOf(parent.getItemAtPosition(position));         //String bottomSelec je odabir iz bottom[]

                                                                               Intent intent = new Intent(".Details");//Konstruktro package name od druge aktivnsoti iz android manifessta
                                                                               intent.putExtra("Task",TaskList.get(position)); //ubaci hive za prijenos
                                                                               intent.putExtra("TaskForDelete",position);
                                                                               startActivity(intent);
                                                                               //Ovisno o odabiru prikazi tu kosnicu u fragmentu gdje su svi stats + remove
                                                                           }
                                                                       }

                                                               );

                                                               break;
                                                           case 4:
                                                               //Notes

                                                               break;


                                                       }



                                                   }//On item selected

                                                   @Override
                                                   public void onNothingSelected(AdapterView<?> parent) {      }
                                               } );



            }
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

