package br.com.cwi.aula2.RecyclerView;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;

import br.com.cwi.aula2.R;

/**
 * Created by juliano.nardon on 18/11/17.
 */

public class LineAdapter extends RecyclerView.Adapter<LineHolder> {

    private ArrayList<String> nomes;

    public LineAdapter(ArrayList nomes) {
        this.nomes = nomes;
    }

    @Override
    public LineHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new LineHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(LineHolder holder, int position) {
        holder.textView.setText(nomes.get(position));
    }

    @Override
    public int getItemCount() {
        return nomes.size();
    }
}
