package tutorial.ciudadesobjetospass;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;

import java.util.ArrayList;
import tutorial.ciudadesobjetospass.CiudadesList.Ciudad;
import tutorial.ciudadesobjetospass.CiudadesList.MyAdapterdats;
import tutorial.ciudadesobjetospass.UtilidadesGenerales.MyToast;

public class MainActivity extends AppCompatActivity implements MyAdapterdats.onclickitemListener{

    RecyclerView mRecycler;
    ArrayList<Ciudad>ciudades;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecycler=(RecyclerView)findViewById(R.id.myrecycler);


        setupCiudades();
        MyAdapterdats adapterdats=new MyAdapterdats(ciudades,this);
        adapterdats.setonClickitemlisten(this);
        mRecycler.setAdapter(adapterdats);
        mRecycler.addItemDecoration(new DividerItemDecoration(getApplicationContext(),DividerItemDecoration.VERTICAL));
        mRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
    }

    @Override
    public void itemclick(int position, Ciudad ciudad) {
        //cuando fue clickeado otra parte del item
    }
    @Override
    public void itemverInfo(int position, Ciudad ciudad) {

        //Cuando fue clickeado en ver Info del

        Intent intent=new Intent(this,VerCiudadActivity.class);

        /**METODO 1 PARA ENVIAR OBJETO mediante Bundle*/
        //Creamos Bundle donde guardaremos las variables a enviar Opcion1
        /*Bundle bundle=new Bundle();
        bdle.putString("Nombre",ciudad.getNombre());un
        bundle.putString("Descripcion",ciudad.getDescripcion());
        bundle.putFloat("lat",ciudad.getChords_lat());
        bundle.putFloat("long",ciudad.getChords_long());
        bundle.putInt("idimagedrawable",ciudad.getIdResourceImg());
        intent.putExtras(bundle);
        this.startActivity(intent);*/
        //Opcion 2
        /*
        Ciudad.sendObject(ciudad,intent);//Envio objeto
        this.startActivity(intent);//iniciar actividad
        */
        /**METODO 2 PARA ENVIAR OBJETO mediante Gson*/
        /*Gson gson=new Gson();
        String ciudadjson=gson.toJson(ciudad);//Convertimos el objeto a ciudada json
        //MyToast.showToastInfo(this,ciudadjson);//Muestro json ciudad prueba
        System.out.println("JSON ENVIADO:\n"+ciudadjson);
        Bundle bundle=new Bundle();
        bundle.putString("ciudad",ciudadjson);
        intent.putExtras(bundle);
        this.startActivity(intent);*/
        /**Metodo 3 simular pasar objetos, mediante variable staticas*/
        Ciudad.ciudadtemporal=ciudad;//Guardamos la variable temporal
        this.startActivity(intent);
    }

    private void setupCiudades()
    {   ciudades=new ArrayList<>();
        String []title={"Colonia","Juan Lacaze","Montevideo","Punta del este","Salto"};
        String []info={"Una colonia es un conjunto de personas que proceden de un mismo territorio y que se establecen en otro. El término también se utiliza para nombrar al lugar donde se establecen estas personas y, por extensión, al territorio que es dominado por una potencia extranjera",
            "Ciudad del departamento de Colonia, sobre costas del Río de la Plata. Antiguamente en el lugar se acentó un saladero, pero las características naturales del lugar fueron atrayendo a familias. Cuenta con una tranquila costa sobre el Río de la Plata y numerosos monumentos que homenajean a la cultura indígena y a los personajes que, nacidos en sus tierras, han hecho conocerla ampliamente fuera de fronteras.",
                "La ciudad de Montevideo es la ciudad capital y más importante del país sudamericano de Uruguay. Montevideo fue fundada en el año 1726 y cuenta con una superficie actual de más de 525 kilómetros cuadrados",
                "Punta del Este es una ciudad peninsular situada en el extremo meridional de Uruguay, en el departamento de Maldonado. Es uno de los balnearios más exclusivos de América Latina y el más importante en Uruguay. ... \u200B Es uno de los centros del conurbano de Maldonado, que en 2011 tenía una población de 135 399 personas.",
                "Salto es el acto y el resultado de saltar. Este verbo tiene numerosas acepciones que, a su vez, derivan en múltiples usos del concepto de salto. Un salto puede ser el movimiento que se realiza para despegarse del suelo."
        };
        int []drawableId={R.drawable.colonia,R.drawable.juan_lacaze,R.drawable.montevideo,R.drawable.puntadeleste,R.drawable.salto};
        float []lat={-57.8397600f,-34.4311f,-34.8833f,-34.8833f,-34.8833f};
        float[]longi={-34.4626200f,-57.448334f,-56.1667f,-56.1667f,-56.1667f};
        for(int i=0;i<5;i++)
        {
            Ciudad ciudad=new Ciudad();
            ciudad.setDescripcion(info[i]);
            ciudad.setNombre(title[i]);
            ciudad.setIdResourceImg(drawableId[i]);
            ciudad.setChords_lat(lat[i]);ciudad.setChords_long(longi[i]);
            ciudades.add(ciudad);
            System.out.println(ciudades.get(i).getNombre());
        }
    }

}
