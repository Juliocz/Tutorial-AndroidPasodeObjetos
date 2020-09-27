package tutorial.ciudadesobjetospass;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;

import tutorial.ciudadesobjetospass.CiudadesList.Ciudad;

/**
 * Created by pc 9 on 21/09/2020.
 */
public class VerCiudadActivity extends AppCompatActivity {
    Ciudad ciudad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.verciudad);

        ciudad=new Ciudad();

        /**METODO1 por Bundle//opcion1*/
        /*Bundle bundle=getIntent().getExtras();//Recibimos el bundle
        if(bundle!=null) {
            ciudad.setNombre(bundle.getString("Nombre"));
            ciudad.setDescripcion(bundle.getString("Descripcion"));
            ciudad.setChords_lat(bundle.getFloat("lat"));
            ciudad.setChords_long(bundle.getFloat("long"));
            ciudad.setIdResourceImg(bundle.getInt("idimagedrawable"));
        }*/
        //opcion2
        /*Bundle bundle=getIntent().getExtras();//Recibimos el bundle
        if(bundle!=null) ciudad=Ciudad.recibirObject(this,bundle);  //objeto*/

        /**METODO2 Por Gson*/
        /*Bundle bundle=getIntent().getExtras();//Recibimos el bundle
        if(bundle!=null)
        {
            Gson gson=new Gson();
            String jsonRecibido=bundle.getString("ciudad");//Recibo json
            ciudad=gson.fromJson(jsonRecibido,Ciudad.class);//Convierto mi json a objeto
        }*/
        /**Metodo 3 simular pasar objetos, mediante variable staticas*/
        ciudad=Ciudad.ciudadtemporal;


        ((TextView)findViewById(R.id.textView)).setText(ciudad.getDescripcion());
        ((ImageView)findViewById(R.id.imageView)).setImageDrawable(ContextCompat.getDrawable(this,ciudad.getIdResourceImg()));
        ((TextView)findViewById(R.id.textViewtitle)).setText(ciudad.getNombre());

    }
}
