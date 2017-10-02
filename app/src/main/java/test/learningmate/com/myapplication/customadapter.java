package test.learningmate.com.myapplication;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by amey on 10/2/2017.
 */

public class customadapter extends RecyclerView.Adapter<customadapter.ViewHolder> {

    private List<String> mydata;

    public customadapter(List<String> mydata) {
        this.mydata = mydata;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()), parent);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final String name = mydata.get(position);
        holder.txtHeader.setText(name);
        holder.txtFooter.setText("Footer: " + name);
    }

    @Override
    public int getItemCount() {
        return mydata.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView txtHeader;
        public TextView txtFooter;

        public ViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.row_layout, parent, false));
            txtHeader = (TextView) itemView.findViewById(R.id.firstLine);
            txtFooter = (TextView) itemView.findViewById(R.id.secondLine);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    System.out.println("Clicke Position---->" + getAdapterPosition());
                }
            });
        }
    }
}
