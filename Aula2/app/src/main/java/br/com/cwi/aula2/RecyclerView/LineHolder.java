package br.com.cwi.aula2.RecyclerView;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import br.com.cwi.aula2.R;

/**
 * Created by juliano.nardon on 18/11/17.
 */

public class LineHolder extends RecyclerView.ViewHolder {

    public TextView textView;

    public LineHolder(View itemView) {
        super(itemView);

        textView = itemView.findViewById(R.id.name_text_view);
    }
}
