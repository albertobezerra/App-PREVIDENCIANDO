package equipebezerradasilva.previdenciando;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class adaptador extends BaseAdapter {

    private Context ctx;
    private int[] lista;

    public adaptador(Context ctx, int[] lista){
        this.ctx = ctx;
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return lista.length;
    }

    @Override
    public Object getItem(int position) {
        return lista[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ImageView ib = new ImageView(ctx);
        ib.setImageResource(lista[position]);
        ib.setAdjustViewBounds(true);

        return ib;
    }
}