package tn.enig.apptestand1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText nomPrenomEditText;
    private RadioGroup radioGroup;
    private CheckBox checkBox1;
    private CheckBox checkBox2;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nomPrenomEditText = findViewById(R.id.e1);
        radioGroup = findViewById(R.id.r1);
        checkBox1 = findViewById(R.id.chb1);
        checkBox2 = findViewById(R.id.chb2);
        spinner = findViewById(R.id.spinner);
        Button enregistrerButton = findViewById(R.id.b1);

        enregistrerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Récupérer les valeurs saisies dans les composants
                String nomPrenom = nomPrenomEditText.getText().toString();
                RadioButton radioButton = findViewById(radioGroup.getCheckedRadioButtonId());
                String specialite = radioButton.getText().toString();

                String matiere = "";

                if (checkBox1.isChecked()) {
                    matiere += checkBox1.getText().toString();
                }
                if (checkBox2.isChecked()) {
                    if (matiere.length() > 0) {
                        matiere += ",";
                    }
                    matiere += checkBox2.getText().toString();
                }

                // Si le string est toujours vide, signalez qu'aucune matière n'a été sélectionnée
                if (matiere.isEmpty()) {
                    matiere = "Vous n'avez pas sélectionné de matière";
                }

                String niveau = spinner.getSelectedItem().toString();

                // Créer un Intent pour passer à l'activité d'affichage des informations
                Intent intent = new Intent(MainActivity.this, AffichageInfoActivity.class);
                intent.putExtra("name", nomPrenom);
                intent.putExtra("department", specialite);
                intent.putExtra("matieres", matiere);
                intent.putExtra("niveau", niveau);

                // Démarrer l'activité d'affichage des informations
                startActivity(intent);
            }
        });


        Spinner spinner = findViewById(R.id.spinner);


        List<String> options = new ArrayList<>();
        options.add("1ère");
        options.add("2ème");
        options.add("3ème");


        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, options);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        spinner.setAdapter(adapter);

    }
}


