package com.pochekuev.application;

import androidx.recyclerview.widget.RecyclerView;

public interface OnRecyclerItemClickListener<T> {
    void onItemClick(T itemType);
}
