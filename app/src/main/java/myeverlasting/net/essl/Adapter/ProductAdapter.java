package myeverlasting.net.essl.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import myeverlasting.net.essl.Aproduct;
import myeverlasting.net.essl.QuoteActivity;
import myeverlasting.net.essl.R;
import myeverlasting.net.essl.model.Product;

/**
 * Created by babafemi on 10/8/2017.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.PdtObjectHolder> {
    private static String LOG_TAG = "ProductAdapter";
    private static List<Product> pdts;
    private static PdtClickListener myClickListener;
    private Context mcontext;

    public static class PdtObjectHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView title, intro, desc, cost;
        ImageView iv;
        Button btnQuote;

        public PdtObjectHolder(final View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.txtTitle);
            intro = (TextView) itemView.findViewById(R.id.txtIntro);
            cost = (TextView) itemView.findViewById(R.id.txtCost);

            iv = (ImageView) itemView.findViewById(R.id.pdtImg);
            btnQuote = (Button) itemView.findViewById(R.id.start_project);

            Log.i(LOG_TAG, "adding listener for product");
            itemView.setOnClickListener(this);

            btnQuote.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent in = new Intent(itemView.getContext(), QuoteActivity.class);
                    itemView.getContext().startActivity(in);
                }
            });

        }

        @Override
        public void onClick(View view) {
            //myClickListener.onItemClick(getAdapterPosition(), view);
            Log.i(LOG_TAG, "screen clicked " + getAdapterPosition());
            Intent it = new Intent(view.getContext(), Aproduct.class);
            Bundle bd = new Bundle();
            bd.putString("ptitle",pdts.get(getAdapterPosition()).getTitle());
            it.putExtras(bd);
            view.getContext().startActivity(it);
        }

    }

    public void setOnItemClickListener(PdtClickListener myClickListener){
        this.myClickListener = myClickListener;
    }

    public ProductAdapter(Context mconte, ArrayList<Product> prdts) {
        mcontext = mconte;
        pdts = prdts;
    }

    @Override
    public PdtObjectHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pdt_item,parent,false);
        PdtObjectHolder po = new PdtObjectHolder(view);

        return po;
    }

    @Override
    public void onBindViewHolder(PdtObjectHolder holder, int position) {
        holder.title.setText(pdts.get(position).getTitle());
        holder.intro.setText(pdts.get(position).getDescription());
        holder.cost.setText(pdts.get(position).getCost());
        //Log.i(LOG_TAG, pdts.get(position).getImage() + " : imagecradbra found");

        Glide.with(mcontext).load(pdts.get(position).getImage()).into(holder.iv);

    }







    @Override
    public int getItemCount() {
        return pdts.size();
    }



    public interface PdtClickListener{
        public void onItemClick(int position, View v);

    }


}
