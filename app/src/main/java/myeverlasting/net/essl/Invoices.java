package myeverlasting.net.essl;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class Invoices extends AppCompatActivity {
    private static final String LOG_TAG="Invoices Activity";
    TableLayout tl;
    TableRow tr;
    TextView sn,desc,amount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invoices);
        tl= (TableLayout) findViewById(R.id.tblInvoices);
        addHeader();
        addRow();
    }

    public void addHeader(){
        // create row
        tr = new TableRow(this);
        tr.setLayoutParams(new TableLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        // create textview
        TextView serial = new TextView(this);
        serial.setText("EW01");
        tr.addView(serial);

        // another texview
        TextView descr = new TextView(this);
        descr.setText("Domain Name Reg");
        tr.addView(desc);

        TextView amot = new TextView(this);
        amot.setText("$12.99");
        tr.addView(amot);

        tl.addView(tr, new TableLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        // secoond column
        tr = new TableRow(this);
        tr.setLayoutParams(new TableLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        /** Creating another textview **/
        TextView divider = new TextView(this);
        divider.setText("-----------------");
        divider.setTextColor(Color.GREEN);
        divider.setPadding(5, 0, 0, 0);
        divider.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        tr.addView(divider); // Adding textView to tablerow.

        TextView divider2 = new TextView(this);
        divider2.setText("-------------------------");
        divider2.setTextColor(Color.GREEN);
        divider2.setPadding(5, 0, 0, 0);
        divider2.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        tr.addView(divider2); // Adding textView to tablerow.

        // Add the TableRow to the TableLayout
        tl.addView(tr, new TableLayout.LayoutParams(
                ActionBar.LayoutParams.FILL_PARENT,
                ActionBar.LayoutParams.WRAP_CONTENT));

    }

    String companies[] = {"Google","Windows","iPhone","Nokia","Samsung",
            "Google","Windows","iPhone","Nokia","Samsung",
            "Google","Windows","iPhone","Nokia","Samsung"};
    String os[]       =  {"Android","Mango","iOS","Symbian","Bada",
            "Android","Mango","iOS","Symbian","Bada",
            "Android","Mango","iOS","Symbian","Bada"};

    public void addRow(){
        for (int i =0; i < companies.length; i++  ){
            /** Create a TableRow dynamically **/
            tr = new TableRow(this);
            tr.setLayoutParams(new TableLayout.LayoutParams(
                    TableLayout.LayoutParams.FILL_PARENT,
                    TableLayout.LayoutParams.WRAP_CONTENT));

            /** Creating a TextView to add to the row **/
            desc = new TextView(this);
            desc.setText(companies[i]);
            desc.setTextColor(Color.RED);
            desc.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
            desc.setPadding(5, 5, 5, 5);
            tr.addView(desc);  // Adding textView to tablerow.

            /** Creating another textview **/
            amount = new TextView(this);
            amount.setText(os[i]);
            amount.setTextColor(Color.GREEN);
            amount.setPadding(5, 5, 5, 5);
            amount.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
            tr.addView(amount); // Adding textView to tablerow.

            // Add the TableRow to the TableLayout
            tl.addView(tr, new TableLayout.LayoutParams(
                    TableLayout.LayoutParams.FILL_PARENT,
                    TableLayout.LayoutParams.WRAP_CONTENT));
        }

    }
}
