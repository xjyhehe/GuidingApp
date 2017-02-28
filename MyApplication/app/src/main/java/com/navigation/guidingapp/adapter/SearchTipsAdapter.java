package com.navigation.guidingapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.amap.api.services.help.Tip;
import com.navigation.guidingapp.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by teamtek on 17-2-28.
 */

public class SearchTipsAdapter extends RecyclerView.Adapter<SearchTipsAdapter.SearchTipsViewHolder> {


    /**
     * 子项点击监听接口
     */
    public interface OnItemClickListener {
        void OnItemClick(int position);
    }

    private OnItemClickListener mOnItemClickListener;
    private LayoutInflater inflater;
    /**
     * 返回提示信息
     */
    private List<Tip> tips;

    public SearchTipsAdapter(Context context) {
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public SearchTipsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_search_tip, parent, false);
        SearchTipsViewHolder holder = new SearchTipsViewHolder(view);
        return holder;
    }

    @Override
    public int getItemCount() {
        return tips == null ? 0 : tips.size();
    }

    @Override
    public void onBindViewHolder(SearchTipsViewHolder holder, final int position) {
        Tip tip = tips.get(position);
        holder.tvName.setText(tip.getName());
        holder.tvAddress.setText(tip.getAddress());

        if(mOnItemClickListener != null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickListener.OnItemClick(position);
                }
            });
        }

    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.mOnItemClickListener = onItemClickListener;
    }

    /**
     * 刷新数据
     *
     * @param tipList
     */
    public void refreshData(List<Tip> tipList) {
        this.tips = tipList;
        notifyDataSetChanged();
    }

    public class SearchTipsViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.tv_address)
        TextView tvAddress;

        public SearchTipsViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
