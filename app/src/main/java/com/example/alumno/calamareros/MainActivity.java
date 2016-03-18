package com.example.alumno.calamareros;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Llamado cuando se presiona sobre el checkBoxes al_ajillo_checkbox
     */


    public void onCheckboxClicked_al_ajillo(View view) {
        ImageView calamarView = (ImageView) findViewById(R.id.calamar_image_view);
        calamarView.setImageResource(R.drawable.calamares_al_ajillo);
    }

    /**
     * Llamado cuando se presiona sobre el checkBoxes con_arroz_checkbox
     */

    public void onCheckboxClicked_con_arroz(View view) {
        ImageView calamarView = (ImageView) findViewById(R.id.calamar_image_view);
        calamarView.setImageResource(R.drawable.calamares_con_arroz);
    }

    /**
     * Llamado cuando se presiona sobre el checkBoxes con_salsa_checkbox
     */

    public void onCheckboxClicked_con_salsa(View view) {
        ImageView calamarView = (ImageView) findViewById(R.id.calamar_image_view);
        calamarView.setImageResource(R.drawable.calamares_en_salsa);
    }

    /**
     * Llamado cuando se presiona sobre el checkBoxes fritos_checkbox
     */

    public void onCheckboxClicked_fritos(View view) {
        ImageView calamarView = (ImageView) findViewById(R.id.calamar_image_view);
        calamarView.setImageResource(R.drawable.calamares_fritos);
    }

    /**
     * Llamado cuando se presiona sobre el checkBoxes rellenos_checkbox
     */

    public void onCheckboxClicked_rellenos(View view) {
        ImageView calamarView = (ImageView) findViewById(R.id.calamar_image_view);
        calamarView.setImageResource(R.drawable.calamares_rellenos);
    }
    /**
     * Llamado cuando se presiona sobre el botón comparte_receta
     */


    public void comparteReceta(View view) {

        /**
         * Toma los datos de los checkboxes
         */


        CheckBox alAjilloCheckBox = (CheckBox) findViewById(R.id.al_ajillo_checkbox);
        boolean isAlAjilloCheckBoxChecked = alAjilloCheckBox.isChecked();

        CheckBox conArrozCheckBox = (CheckBox) findViewById(R.id.con_arroz_checkbox);
        boolean isConArrozCheckBoxChecked = conArrozCheckBox.isChecked();

        CheckBox conSalsaCheckBox = (CheckBox) findViewById(R.id.con_salsa_checkbox);
        boolean isConSalsaCheckBoxChecked = conSalsaCheckBox.isChecked();

        CheckBox fritosCheckBox = (CheckBox) findViewById(R.id.fritos_checkbox);
        boolean isFritosCheckBoxChecked = fritosCheckBox.isChecked();

        CheckBox rellenosCheckBox = (CheckBox) findViewById(R.id.rellenos_checkbox);
        boolean isRellenosCheckBoxChecked = rellenosCheckBox.isChecked();

        /**
         * Verifica si al menos uno de los checkboxes tiene valor TRUE
         */

        if (isAlAjilloCheckBoxChecked == false && isConArrozCheckBoxChecked == false && isConSalsaCheckBoxChecked == false && isFritosCheckBoxChecked == false && isRellenosCheckBoxChecked == false) {
            Toast.makeText(getApplicationContext(), "Debe elegir al menos una receta", Toast.LENGTH_SHORT).show();
            return;
        }

        /**
         * Toma los datos de name_friend
         */


        EditText nameFriend = (EditText) findViewById(R.id.name_friend);
        String hasNameFriend = nameFriend.getText().toString();

        /**
         * Verifica que se haya introducido un valor en name_friend
         */

        if (hasNameFriend.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Debe escribir el nombre de un amigo", Toast.LENGTH_SHORT).show();
            return;
        }

        String recipesMessage = createRecipesMessage(isAlAjilloCheckBoxChecked, isConArrozCheckBoxChecked, isConSalsaCheckBoxChecked, isFritosCheckBoxChecked, isRellenosCheckBoxChecked);

        /**
         * Genera un correo con los datos introducidos en la aplicación y con otros datos generados desde le sistema
         */

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_SUBJECT, "Recetas para " + hasNameFriend);
        intent.putExtra(Intent.EXTRA_TEXT,recipesMessage );
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    /**
     * Llamado  en el método comparteReceta
     */

    public String createRecipesMessage(boolean ajillo, boolean arroz, boolean salsa, boolean fritos, boolean rellenos) {

        /**
         * La variable message es utilizada para generar el texto que va a salir en el cuerpo dle mail generado
         */


        String message = "He pensado en vos y quiero compartirte lo siguiente:"+"\n"+"\n";
        if (ajillo == true) {
            message = message + "Receta de calamares al ajillo"+"\n";
            message = message + "https://www.youtube.com/watch?v=AzWujV5_4AI"+"\n"+"\n";
        }

        if (arroz == true) {
            message = message + "Receta de calamares en salsa"+"\n";
            message = message + "https://www.youtube.com/watch?v=pgov4f3SB5c"+"\n"+"\n";
        }


        if (salsa == true) {
            message = message + "Receta de calamares en salsa"+"\n";
            message = message + "https://www.youtube.com/watch?v=pgov4f3SB5c"+"\n"+"\n";
        }


        if (fritos == true) {
            message = message + "Receta de calamares a la romana (Rabas)"+"\n";
            message = message + "https://www.youtube.com/watch?v=KB7c6FG_9Ko"+"\n"+"\n";
        }

        if (rellenos == true) {
            message = message + "Receta de calamares rellenos"+"\n";
            message = message + "https://www.youtube.com/watch?v=DE9VicoOel0"+"\n"+"\n";
        }

        message = message + "Espero que sea de tu agrado."+"\n";
        message = message + "Preparalo y dsfrutalo con la familia y los amigos.";
        return message;
    }

}




