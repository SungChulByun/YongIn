package com.example.yongin.feature.onProgress.game;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;

import com.example.yongin.R;
import com.example.yongin.databinding.HolderLexioScoreDetailBinding;
import com.example.yongin.model.LexioScore;
import com.example.yongin.recyclerView.BaseViewHolder;
import com.example.yongin.recyclerView.MyAdapter;

import static android.content.ContentValues.TAG;

public class LexioScoreDetailAdapter extends MyAdapter<LexioScoreDetailHolder> {
    @NonNull
    @Override
    public LexioScoreDetailHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        HolderLexioScoreDetailBinding binding = DataBindingUtil.inflate(inflater, R.layout.holder_lexio_score_detail, parent, false);
        return new LexioScoreDetailHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull LexioScoreDetailHolder holder, int position) {
        if (position == 0) {
            holder.binding.lexioScoreEditText.setVisibility(View.GONE);
        } else {
            holder.bind(itemList.get(position).toString());
        }
    }
}

class LexioScoreDetailHolder extends BaseViewHolder {
    HolderLexioScoreDetailBinding binding;

    EditText editText;

    public LexioScoreDetailHolder(@NonNull HolderLexioScoreDetailBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
//        focusTest();
    }

    public void bind(String text){
        binding.setText(text);
        binding.executePendingBindings();
    }

    private void focusTest(){
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    Log.d(TAG, "LexioScoreDetailHolder: has focus");
                    InputMethodManager imm = (InputMethodManager) itemView.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
                }
            }
        });
    }
}