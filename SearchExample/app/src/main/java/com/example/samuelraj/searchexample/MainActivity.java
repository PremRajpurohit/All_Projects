package com.example.samuelraj.searchexample;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayAdapter<String> arrayAdapter;
    List<String> list;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = new ArrayList<>();
        prepareData();
        arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(arrayAdapter);
        String[] fruits = {"Apple", "Banana", "Cherry", "Date", "Grape", "Kiwi", "Mango", "Pear","apple","app","Apple"};

            //Creating the instance of ArrayAdapter containing list of fruit names
            ArrayAdapter<String> adapter = new ArrayAdapter<String>
                    (this, android.R.layout.select_dialog_item, fruits);
            //Getting the instance of AutoCompleteTextView
            AutoCompleteTextView actv = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
            actv.setThreshold(1);//will start working from first character
            actv.setAdapter(adapter);//setting the adapter data into the AutoCompleteTextView
            actv.setTextColor(Color.RED);
    }

    public void prepareData()
    {
        list.add("jodhpur");
        list.add("jaipur");
        list.add("udaipur");
        list.add("mumbai");
        list.add("delhi");
        list.add("sirohi");
        list.add("balotra");
        list.add("kanpur");
        list.add("bikaner");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);
        MenuItem menuItem = menu.findItem(R.id.menuSearch);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
        final SearchView.SearchAutoComplete searchAutoComplete = searchView.findViewById(android.support.v7.appcompat.R.id.search_src_text);
        searchAutoComplete.setDropDownBackgroundResource(android.R.drawable.editbox_background);
        searchAutoComplete.setThreshold(1);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, list);
        searchAutoComplete.setAdapter(adapter);

        searchAutoComplete.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String str =((TextView) view).getText().toString();
                searchAutoComplete.setText(str);
            }
        });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                Log.d("App:",s);
                if(!s.isEmpty())
                {
                    String found = "Not Found";
                    boolean status = false;
                    for(int i=0;i<list.size();i++)
                    {
                        String curr = list.get(i);
                        if(s.equals(curr)){
                            found = curr;
                            status = true;
                            break;
                        }
                    }
                    Toast.makeText(MainActivity.this,found,Toast.LENGTH_SHORT).show();
                    Log.d("App:",String.valueOf(status));
                    if(status){
                        return true;}
                    else {return false;}
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                /*if(!s.isEmpty())
                {
                    String found = "Not Found";
                    boolean status = false;
                    ArrayList<String> found_list = new ArrayList<String>();
                    for(int i=0;i<list.size();i++)
                    {
                        if(list.get(i).contains(s))
                        {
                            found_list.add(list.get(i));
                        }
                    }

                    Toast.makeText(MainActivity.this,found,Toast.LENGTH_SHORT).show();
                    Log.d("App:",String.valueOf(status));
                    if(status){
                        return true;}
                    else {return false;}
                }*/
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}
