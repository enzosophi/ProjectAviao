package com.example.projectaviao;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ViagemAdapter  extends RecyclerView.Adapter<ViagemAdapter.ViagemViewHolder> implements Filterable {

    public static final String TAG="Viagem Adapter";

    private View.OnClickListener mOnClickListener;

    private  View.OnLongClickListener mOnLongClickListener;

    private Context mContext;

    //select da classe dentro do ViagemDao
    private List<Viagem> mViagemList;
    private List<Aeroporto> mAeroportoList;
    private List<Aviao> mAviaoList;

    //listagem completa
    private List<Viagem> mViagemListFull;
    private List<Aeroporto> mAeroportoListFull;
    private List<Aviao> mAviaoListFull;

    public ViagemAdapter(Context mContext, List<Viagem> mViagemList, List<Aeroporto> mAeroportoList, List<Aviao> mAviaoList) {
        this.mContext = mContext;
        this.mViagemList = mViagemList;
        this.mAeroportoList = mAeroportoList;
        this.mAviaoList = mAviaoList;
    }


    @Override
    public Filter getFilter() {
        return null;
    }

    @NonNull
    @Override
    public ViagemAdapter.ViagemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViagemAdapter.ViagemViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViagemViewHolder extends RecyclerView.ViewHolder {
        public ViagemViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
