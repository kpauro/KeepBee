package j.tvrtko.projekt126;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class MainMenu extends AppCompatActivity {
    private Button adHiveBtn;
    private Button addQueenBtn;
    private Button reportsBtn;
    private Button addTaskBtn;
    private Button addBeeBtn;

    private TextView text;

    List novaLista;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);  //za skidanje project namea
        setContentView(R.layout.activity_main_menu);

        reportsBtn=(Button)findViewById(R.id.Reports);
        adHiveBtn=(Button)findViewById(R.id.AddHive1);
        addQueenBtn=(Button)findViewById(R.id.AddQueen);
        addTaskBtn=(Button)findViewById(R.id.AddTask);
        addBeeBtn=(Button)findViewById(R.id.AddBeeFamily);
/*
        final File file = new File(getApplicationContext().getFilesDir(),"Hive.bin");


        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            //String today =(String) ois.readObject();


            novaLista=(List)ois.readObject();
            //   Hive kosnica2=(Hive) nova.get(0);

           Hive kosnica2=(Hive) novaLista.get(0);

            Toast.makeText(MainMenu.this,
                    kosnica2.getType(),
                    Toast.LENGTH_LONG).show();




            ois.close();


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
*/
        adHiveBtn.setOnClickListener(new View.OnClickListener() {


        @Override
        public void onClick(View v) {

            Intent intent = new Intent(".AddHive");//Konstruktro package name od druge aktivnsoti iz android manifessta

            startActivity(intent);

        }


    });//on click
        reportsBtn.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                Intent intent = new Intent(".Reports");//Konstruktro package name od druge aktivnsoti iz android manifessta

                startActivity(intent);

            }


        });//on click

        addQueenBtn.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                Intent intent = new Intent(".AddQueen");//Konstruktro package name od druge aktivnsoti iz android manifessta

                startActivity(intent);

            }


        });//on click

        addTaskBtn.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                Intent intent = new Intent(".AddTask");//Konstruktro package name od druge aktivnsoti iz android manifessta

                startActivity(intent);

            }


        });//on click

        addBeeBtn.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                Intent intent = new Intent(".AddBeeFamily");//Konstruktro package name od druge aktivnsoti iz android manifessta

                startActivity(intent);

            }


        });//on click


    };//end


    }

/*
lHive1 = new ArrayList<Hive>();//Koristiti listu za spremanje kosnic i posebnu za matice
        adHiveBtn = (Button) findViewById(R.id.AddHive1);
        text=(TextView)findViewById(R.id.text);
        Hive kosnica=new Hive(1,1+2,"Vertical");
        kosnica.setType("tvrtkica");
        lHive1.add(kosnica);
        //File used for File output/input steam
        final File file = new File(getApplicationContext().getFilesDir(),"Hive.bin");


        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos= new ObjectOutputStream(fos);
            //oos.writeObject("Today");
            oos.writeObject(lHive1);
            //oos.writeObject(lHive1);
            oos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


 */