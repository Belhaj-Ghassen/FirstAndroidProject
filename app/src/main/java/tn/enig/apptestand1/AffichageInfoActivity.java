package tn.enig.apptestand1;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AffichageInfoActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affichage_info);

        // Récupérer les données transmises via l'Intent
        String nomPrenom = getIntent().getStringExtra("name");
        String specialite = getIntent().getStringExtra("department");
        String matiere = getIntent().getStringExtra("matieres");
        String niveau = getIntent().getStringExtra("niveau");

        // Afficher les données dans les TextView correspondants
        TextView nomPrenomTextView = findViewById(R.id.nomPrenomTextView);
        nomPrenomTextView.setText("Le Nom est: " + nomPrenom);

        TextView specialiteTextView = findViewById(R.id.specialiteTextView);
        specialiteTextView.setText("Votre Departement est: " + specialite);

        TextView matiereTextView = findViewById(R.id.matiereTextView);
        matiereTextView.setText("Les Matières: " + matiere);

        TextView niveauTextView = findViewById(R.id.niveauTextView);
        niveauTextView.setText("Votre Niveau est: " + niveau);
    }
}
