package tutorial.ciudadesobjetospass.CiudadesList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import tutorial.ciudadesobjetospass.VerCiudadActivity;

/**
 * Created by pc 9 on 21/09/2020.
 */
public class Ciudad {
    public static Ciudad ciudadtemporal;//Variable a usar para pasar temporalmente

    String nombre;
    String descripcion;
    float chords_lat,chords_long;
    int idResourceImg;
    //Constructor
    public Ciudad(String nombre, String descripcion, float chords_lat, float chords_long, int idResourceImg) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.chords_lat = chords_lat;
        this.chords_long = chords_long;
        this.idResourceImg = idResourceImg;
    }
    public Ciudad() {
        this.nombre = "";
        this.descripcion = "";
        this.chords_lat = 0;
        this.chords_long = 0;
        this.idResourceImg = 0;
    }

    //Gets and Sets
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public float getChords_lat() {
        return chords_lat;
    }
    public void setChords_lat(float chords_lat) {
        this.chords_lat = chords_lat;
    }
    public float getChords_long() {
        return chords_long;
    }
    public void setChords_long(float chords_long) {
        this.chords_long = chords_long;
    }
    public int getIdResourceImg() {
        return idResourceImg;
    }
    public void setIdResourceImg(int idResourceImg) {
        this.idResourceImg = idResourceImg;
    }

    public static void sendObject(Ciudad ciudad,Intent intent)
    {   //Creamos Bundle donde guardaremos las variables a enviar
        Bundle bundle=new Bundle();
        bundle.putString("Nombre",ciudad.getNombre());
        bundle.putString("Descripcion",ciudad.getDescripcion());
        bundle.putFloat("lat",ciudad.getChords_lat());
        bundle.putFloat("long",ciudad.getChords_long());
        bundle.putInt("idimagedrawable",ciudad.getIdResourceImg());
        intent.putExtras(bundle);
    }
    public static Ciudad recibirObject(Activity activity,Bundle bundle)
    {   Ciudad ciudad=new Ciudad();


            ciudad.setNombre(bundle.getString("Nombre"));
            ciudad.setDescripcion(bundle.getString("Descripcion"));
            ciudad.setChords_lat(bundle.getFloat("lat"));
            ciudad.setChords_long(bundle.getFloat("long"));
            ciudad.setIdResourceImg(bundle.getInt("idimagedrawable"));

        return ciudad;
    }
}
