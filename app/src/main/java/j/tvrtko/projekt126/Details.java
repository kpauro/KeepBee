package j.tvrtko.projekt126;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Details extends AppCompatActivity {
TextView textView;
    TextView textView4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        textView=(TextView)findViewById(R.id.textView);
        textView4=(TextView)findViewById(R.id.textView4);

        Intent i = getIntent();
        Hive descriptionHive =(Hive)i.getSerializableExtra("Hive");
        Queen descriptionQueen =(Queen)i.getSerializableExtra("Queen");
        int HivePosition =(int)i.getIntExtra("HiveNoForDelete",0xFFFFFF); //Position koja je u listi po redu prosljedena kosnica
                                                                //ako cemo je brisati... ucitaj file i izbrsi taj po redu
        int QueenPosition =(int)i.getIntExtra("QueenNoForDelete",0xFFFFFF);
       if(QueenPosition!=0xFFFFFF) {        //ako je primljena barem 1 matica

           textView.setText(descriptionQueen.toStringI());
           textView4.setText(descriptionQueen.toStringS());
          // textView4
        }
        if(HivePosition!=0xFFFFFF) {        //ako je primljena barem 1 Kosnica

            textView.setText(descriptionHive.toStringI());
            textView4.setText(descriptionHive.toStringS());
        }

        //
        Task descriptionTask =(Task)i.getSerializableExtra("Task");
        int TaskPosition =(int)i.getIntExtra("TaskForDelete",0xFFFFFF);
        if(TaskPosition!=0xFFFFFF) {        //ako je primljena barem 1 matica

            textView.setText(descriptionTask.toStringI());
            textView4.setText(descriptionTask.toStringS());
            // textView4
        }

        BeeFamily descriptionBeeFamily =(BeeFamily)i.getSerializableExtra("BeeFamily");
        int BeeFamilyPosition =(int)i.getIntExtra("BeeFamilyForDelete",0xFFFFFF);
        if(BeeFamilyPosition!=0xFFFFFF) {        //ako je primljena barem 1 matica
            textView.setText(descriptionBeeFamily.toStringI());
            textView4.setText(descriptionBeeFamily.toStringS());

        }

        //
    }//OnCreate
}
