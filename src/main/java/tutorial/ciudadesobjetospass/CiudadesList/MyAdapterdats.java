package tutorial.ciudadesobjetospass.CiudadesList;

/**
 * Created by pc 9 on 21/09/2020.
 */

import android.content.Context;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import tutorial.ciudadesobjetospass.R;

public class MyAdapterdats extends RecyclerView.Adapter<MyAdapterdats.ViewHolderdatos>{
    ArrayList<Ciudad> listciudad;
    onclickitemListener listener;
    Context context;
    public interface onclickitemListener{
        void itemclick(int position,Ciudad ciudad);
        void itemverInfo(int position,Ciudad ciudad);
    }
    public void setonClickitemlisten(onclickitemListener l){listener=l;}
    //1-Primero le paso los datos al Adaptador en su constructor
    public MyAdapterdats(ArrayList<Ciudad> listciudad,Context c) {
        context=c;
        this.listciudad = listciudad;
        listener=new onclickitemListener() {@Override
            public void itemclick(int position, Ciudad ciudad) {}
            @Override
            public void itemverInfo(int position,Ciudad ciudad) {}};

    }

    @Override
    public ViewHolderdatos onCreateViewHolder(ViewGroup parent, int viewType) {


        View view= LayoutInflater.from(parent.getContext()) //2do creo el layoutxml completo y lo retorno
                .inflate(R.layout.itemciudad,null);
        // view.getLayoutParams().width=parent.getWidth();
        return new ViewHolderdatos(view);   //3ya creo el viewholder datos
    }

    @Override
    public void onBindViewHolder(ViewHolderdatos holder, int position) {

        holder.asignarDatos(listciudad.get(position)); //4-esto creara las vistas a medida llamara al metodo
    }

    @Override
    public int getItemCount() {

        return listciudad.size();
    }

    public class ViewHolderdatos extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView info;
        TextView name;
        ImageView img;
        Button b_install;
        public ViewHolderdatos(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            img=(ImageView)itemView.findViewById(R.id.imageView_ciudad);
            name=(TextView)itemView.findViewById(R.id.infociudad);
            b_install=(Button)itemView.findViewById(R.id.button_verinfo);
            b_install.setOnClickListener(this);
        }

        public void asignarDatos(Ciudad ciudad) {
            name.setText(ciudad.getNombre());
            img.setImageDrawable(ContextCompat.getDrawable(context,ciudad.getIdResourceImg()));
            img.setClipToOutline(true);
        }

        @Override
        public void onClick(View view) {
            int item_pos=getAdapterPosition();
            if(view.getId()==b_install.getId())//Si clicleo boton instalar
            {   listener.itemverInfo(item_pos,listciudad.get(item_pos));
            }
        }
    }
}

