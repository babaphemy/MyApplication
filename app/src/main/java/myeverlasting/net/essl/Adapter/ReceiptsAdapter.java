package myeverlasting.net.essl.Adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import myeverlasting.net.essl.R;
import myeverlasting.net.essl.model.Receipt;

/**
 * Created by babafemi on 10/11/2017.
 */

public class ReceiptsAdapter extends RecyclerView.Adapter<ReceiptsAdapter.ReceiptObjHolder> {
    private static String LOG_TAG="ReceiptsAdapter";
    private ArrayList<Receipt> receipts;
    private static MyClickListener myClickListener;

    public static class ReceiptObjHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView title,intro,date,amount;


        public ReceiptObjHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.txtRecTitle);
            intro = (TextView) itemView.findViewById(R.id.txtRecIntro);
            date = (TextView) itemView.findViewById(R.id.txtRecDate);
            amount = (TextView) itemView.findViewById(R.id.txtRecAmount);
            Log.i(LOG_TAG, "Adding listener");
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            myClickListener.onItemClick(getAdapterPosition(), view);
        }
    }

    public void setOnItemClickListener(MyClickListener myClickListener){
        this.myClickListener = myClickListener;
    }

    public ReceiptsAdapter(ArrayList<Receipt> recs){
        receipts = recs;
    }


    @Override
    public ReceiptObjHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.receipt_items,parent,false);
        ReceiptObjHolder objHolder = new ReceiptObjHolder(view);
        return objHolder;
    }

    @Override
    public void onBindViewHolder(ReceiptObjHolder holder, int position) {
        holder.title.setText(receipts.get(position).getTitle());
        holder.intro.setText(receipts.get(position).getIntro());
        holder.date.setText(receipts.get(position).getDate());
        holder.amount.setText(receipts.get(position).getAmount());


    }

    @Override
    public int getItemCount() {
        return receipts.size();
    }


    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }

}
