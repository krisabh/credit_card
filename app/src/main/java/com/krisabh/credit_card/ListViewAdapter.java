package com.krisabh.credit_card;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ListViewAdapter extends BaseAdapter{

    //variables
    Context mContext;
    LayoutInflater inflater;
    List<Model> modellist;
    ArrayList<Model> arrayList;

    //constructor
    public ListViewAdapter(Context context, List<Model> modellist) {
        mContext = context;
        this.modellist = modellist;
        inflater = LayoutInflater.from(mContext);
        this.arrayList = new ArrayList<Model>();
        this.arrayList.addAll(modellist);
    }

    public class ViewHolder{
        TextView mTitleTv, mDescTv;
        ImageView mIconIv;
    }

    @Override
    public int getCount() {
        return modellist.size();
    }

    @Override
    public Object getItem(int i) {
        return modellist.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int postition, View view, ViewGroup parent) {
        ViewHolder holder;
        if (view==null){
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.row, null);

            //locate the views in row.xml
            holder.mTitleTv = view.findViewById(R.id.mainTitle);
            holder.mDescTv = view.findViewById(R.id.mainDesc);
            holder.mIconIv = view.findViewById(R.id.mainIcon);

            view.setTag(holder);

        }
        else {
            holder = (ViewHolder)view.getTag();
        }
        //set the results into textviews
        holder.mTitleTv.setText(modellist.get(postition).getTitle());
        holder.mDescTv.setText(modellist.get(postition).getDesc());
        //set the result in imageview
        holder.mIconIv.setImageResource(modellist.get(postition).getIcon());

        //listview item clicks
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //code later
                if (modellist.get(postition).getTitle().equals("ICICI")){

                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.icicibank.com/online-services/clicktopay/index.page"));
                    mContext.startActivity(browserIntent);
                }
                if (modellist.get(postition).getTitle().equals("SBI")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.billdesk.com/pgidsk/pgijsp/sbicard/SBI_card.jsp"));
                    mContext.startActivity(browserIntent);
                }
                if (modellist.get(postition).getTitle().equals("HDFC")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.billdesk.com/pgidsk/pgmerc/hdfccard/index.jsp"));
                    mContext.startActivity(browserIntent);
                }
                if (modellist.get(postition).getTitle().equals("Citi")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.billdesk.com/pgidsk/wap/citicard/citicard_index.jsp"));
                    mContext.startActivity(browserIntent);
                }
                if (modellist.get(postition).getTitle().equals("Kotak")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.billdesk.com/pgmerc/kotakcard/"));
                    mContext.startActivity(browserIntent);
                }
                if (modellist.get(postition).getTitle().equals("Axis")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://pgi.billdesk.com/axiscard/index1.htm"));
                    mContext.startActivity(browserIntent);
                }
                if (modellist.get(postition).getTitle().equals("RBL")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://pgi.billdesk.com/pgidsk/pgmerc/rtncard/index.jsp"));
                    mContext.startActivity(browserIntent);
                }
                if (modellist.get(postition).getTitle().equals("Yes Bank")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://pgi.billdesk.com/pgidsk/pgmerc/ybkcard/index.jsp"));
                    mContext.startActivity(browserIntent);
                }
                if (modellist.get(postition).getTitle().equals("Bank of India")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.billdesk.com/pgidsk/pgmerc/boicard/BOI_card.jsp"));
                    mContext.startActivity(browserIntent);
                }
                if (modellist.get(postition).getTitle().equals("Central Bank")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://pgi.billdesk.com/pgmerc/cbicard/"));
                    mContext.startActivity(browserIntent);
                }
                if (modellist.get(postition).getTitle().equals("PNB")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://pgi.billdesk.com/pgmerc/pnbcard/index1.htm"));
                    mContext.startActivity(browserIntent);
                }
                if (modellist.get(postition).getTitle().equals("American Express")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.billdesk.com/pgidsk/pgmerc/amexcard/amex_card.jsp"));
                    mContext.startActivity(browserIntent);
                }
                if (modellist.get(postition).getTitle().equals("Bank of Baroda")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.bobcards.in/insta-pay.htm"));
                    mContext.startActivity(browserIntent);
                }
                if (modellist.get(postition).getTitle().equals("Indusland")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.billdesk.com/pgmerc/induscard/index1.htm"));
                    mContext.startActivity(browserIntent);
                }
                if (modellist.get(postition).getTitle().equals("Union Bank")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.unionrewardz.com/creditcardbill/"));
                    mContext.startActivity(browserIntent);
                }
                if (modellist.get(postition).getTitle().equals("HSBC")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://billdesk.com/hsbccard/"));
                    mContext.startActivity(browserIntent);
                }
                if (modellist.get(postition).getTitle().equals("Andhra Bank")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.billdesk.com/pgidsk/pgmerc/adbcard/andhra_card.jsp"));
                    mContext.startActivity(browserIntent);
                }
                if (modellist.get(postition).getTitle().equals("IDBI")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.billdesk.com/pgidsk/pgmerc/idbicard/IDBI_card.jsp"));
                    mContext.startActivity(browserIntent);
                }


            }
        });


        return view;
    }

    //filter
    public void filter(String charText){
        charText = charText.toLowerCase(Locale.getDefault());
        modellist.clear();
        if (charText.length()==0){
            modellist.addAll(arrayList);
        }
        else {
            for (Model model : arrayList){
                if (model.getTitle().toLowerCase(Locale.getDefault())
                        .contains(charText)){
                    modellist.add(model);
                }
            }
        }
        notifyDataSetChanged();
    }

}

