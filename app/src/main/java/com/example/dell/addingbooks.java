package com.example.dell;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class addingbooks extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private EditText bname,bauthor,bcost;
    private Button submit;
    private Spinner spinner;

    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addingbooks);

        spinner=findViewById(R.id.spinner);
        bname=findViewById(R.id.bname);
        bauthor=findViewById(R.id.bauthor);
        bcost=findViewById(R.id.bcost);
        submit=findViewById(R.id.submit);

        databaseReference= FirebaseDatabase.getInstance().getReference("Book");



        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.clss,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String book_name,book_author,book_class;
                double book_cost;

                book_class=spinner.getSelectedItem().toString().trim();
                book_name=bname.getText().toString().trim();
                book_author=bauthor.getText().toString().trim();
                book_cost=Double.parseDouble(bcost.getText().toString().trim());

                String id=databaseReference.push().getKey();

                Book book=new Book(id,book_class,book_name,book_author,book_cost);

                databaseReference.child(id).setValue(book);

                Toast.makeText(addingbooks.this, "Book Added Successfully", Toast.LENGTH_SHORT).show();
            }
        });



    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text=parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),text,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Toast.makeText(this, "select one class", Toast.LENGTH_SHORT).show();
    }
}
