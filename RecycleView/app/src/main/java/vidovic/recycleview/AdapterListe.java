package vidovic.recycleview;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterListe extends RecyclerView.Adapter<AdapterListe.Red> {

    private List<Osoba> osobe;
    private LayoutInflater layoutInflater;
    private ItemClickInterface itemClickInterface;

    public void setItemClickInterface(ItemClickInterface itemClickInterface) {
        this.itemClickInterface = itemClickInterface;
    }

    public AdapterListe(Context context){
        layoutInflater = LayoutInflater.from(context);
    }

    public void setOsobe(List<Osoba> osobe) {
        this.osobe = osobe;
    }

    @NonNull
    @Override
    public Red onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = layoutInflater.inflate(R.layout.red_liste, parent, false);
        return new Red(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Red holder, int position) {
        Osoba osoba = osobe.get(position);

        holder.tvSpol.setText(osoba.getSpol());
        holder.tvIme.setText(osoba.getIme());
        holder.tvPrezime.setText(osoba.getPrezime());
        if(position%2 == 0) {
            holder.setBackgroundColor();
        }

    }

    @Override
    public int getItemCount() {

        return osobe==null ? 0 : osobe.size();
    }

    public class Red extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView tvSpol;
        private TextView tvIme;
        private TextView tvPrezime;


        public Red(@NonNull View itemView) {
            super(itemView);
            

            tvSpol = itemView.findViewById(R.id.tvSpol);
            tvIme = itemView.findViewById(R.id.tvIme);
            tvPrezime = itemView.findViewById(R.id.tvPrezime);
            itemView.setOnClickListener(this);
            
        }


        public void setBackgroundColor() {
            itemView.setBackgroundColor(Color.BLUE);
        }

        @Override
        public void onClick(View view) {
            if(itemClickInterface == null){
                return;
            }
            itemClickInterface.onItemClick(osobe.get(getAdapterPosition()));
        }
    }

    public interface ItemClickInterface{
        void onItemClick(Osoba osoba);
    }

}
