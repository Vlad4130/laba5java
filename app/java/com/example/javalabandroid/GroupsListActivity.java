package com.example.javalabandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ShareActionProvider;


public class GroupsListActivity extends AppCompatActivity {
    private android.widget.ShareActionProvider mShareActionProvider;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groups_list);
        AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String group = (String) adapterView.getItemAtPosition(i).toString();
                Intent intent = new Intent(GroupsListActivity.this, StudentsGroupActivity.class);
                intent.putExtra(StudentsGroupActivity.GROUP_NUMBER,group);
                startActivity(intent);
            }
        };

        ListView listView = (ListView) findViewById(R.id.groups_list);
        listView.setOnItemClickListener(listener);

    }
    protected void onStart()
    {
        super.onStart();
        ListView listView = (ListView) findViewById(R.id.groups_list);
        ArrayAdapter<Groups> adapter = new ArrayAdapter<Groups>(this, android.R.layout.simple_list_item_1,Groups.getGroups());
        listView.setAdapter(adapter);
    }
    public void onGrpAddClick(View view){
        startActivity(
                new Intent(this,AddStudentsGropsActivity.class)
        );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.groups_menu,menu);
        String text = "";
        for (Groups groups: Groups.getGroups()){
            text += groups.getNumber() + "\n";
        }
        MenuItem menuItem = menu.findItem(R.id.action_share);
        mShareActionProvider = (android.widget.ShareActionProvider) menuItem.getActionProvider();
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT,text);
        mShareActionProvider.setShareIntent(intent);

        return super.onCreateOptionsMenu(menu);

    }
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        switch (item.getItemId()){
            case R.id.action_add_grp:
                startActivity(new Intent(this, AddStudentsGropsActivity.class));
            default: return super.onOptionsItemSelected(item);
        }
    }

}