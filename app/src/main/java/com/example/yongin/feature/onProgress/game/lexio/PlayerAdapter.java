package com.example.yongin.feature.onProgress.game.lexio;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;

import com.example.yongin.R;
import com.example.yongin.databinding.HolderBlankBinding;
import com.example.yongin.databinding.HolderPlayerNameBinding;
import com.example.yongin.model.Member;
import com.example.yongin.recyclerView.BaseViewHolder;
import com.example.yongin.recyclerView.MyAdapter;

public class PlayerAdapter extends MyAdapter<BaseViewHolder> {
    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        if (viewType == 0) {
            HolderBlankBinding binding = DataBindingUtil.inflate(inflater, R.layout.holder_blank, parent, false);
            return new BlankHolder(binding);
        } else {
            HolderPlayerNameBinding binding = DataBindingUtil.inflate(inflater, R.layout.holder_player_name, parent, false);
            return new PlayerNameHolder(binding);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        if (position > 0) {
            ((PlayerNameHolder) holder).bind(((Member) itemList.get(position)).getName());
        }
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }
}

class PlayerNameHolder extends BaseViewHolder {
    HolderPlayerNameBinding binding;

    public PlayerNameHolder(@NonNull HolderPlayerNameBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(String name) {
        binding.setName(name);
        binding.executePendingBindings();
    }
}

class BlankHolder extends BaseViewHolder {
    HolderBlankBinding binding;

    public BlankHolder(@NonNull HolderBlankBinding binding) {
        super(binding.getRoot());
    }
}