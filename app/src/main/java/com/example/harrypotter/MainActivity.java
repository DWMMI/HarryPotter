package com.example.harrypotter;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String [] casas = {"Gryffindor", "Hufflepuff", "Ravenclaw", "Slytherin"};
    int [] imagenes = {R.drawable.gryffindor, R.drawable.hufflepuff, R.drawable.ravenclaw, R.drawable.slytherin};
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
        CasaAdapter adapter = new CasaAdapter();
        spinner.setAdapter(adapter);
    }

    class CasaAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return casas.length;
        }

        @Override
        public Object getItem(int position) {
            return casas[position];
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
            convertView = inflater.inflate(R.layout.itemspinner, null);
            ImageView imageView = convertView.findViewById(R.id.imageView);
            TextView textView = convertView.findViewById(R.id.casa);
            imageView.setImageResource(imagenes[position]);
            textView.setText(casas[position]);
            return convertView;
        }
    }
}