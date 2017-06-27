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


public class AddTask extends AppCompatActivity {

    public int taskID=0;
    Button addTask;

    public List<Task> TaskList;
    TextView XMLtaskID;
    TextView XMLtaskDescription;
    String taskDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        final File file = new File(getApplicationContext().getFilesDir(),"Task.bin");
        try {
            FileInputStream fis = new FileInputStream(file);
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
        /////////////END ucitavanje filea//////////////////////////////////

        XMLtaskID=(TextView) findViewById(R.id.TaskID);
        XMLtaskDescription=(TextView) findViewById(R.id.TaskDescription);

        addTask=(Button)findViewById(R.id.AddTask);
        addTask.setOnClickListener(
                new View.OnClickListener(){

                    @Override
                    public  void onClick(View v){
                        // public Queen (int queenId,int hiveNo,String breed,String color,String description){
                        taskID =Integer.parseInt(XMLtaskID.getText().toString());
                        taskDescription=XMLtaskDescription.getText().toString();

                        Task newTask=new Task(taskID,taskDescription);
                        TaskList.add(newTask);
////////////////FILE output stream////////////////
                        final File file = new File(getApplicationContext().getFilesDir(),"Task.bin");


                        try {
                            FileOutputStream fos = new FileOutputStream(file);
                            ObjectOutputStream oos= new ObjectOutputStream(fos);
                            //oos.writeObject("Today");
                            oos.writeObject(TaskList);
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
