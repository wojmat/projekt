package pl.edu.uwr.trackbudget;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0012B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\bH\u0016J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bH\u0016J\u0014\u0010\u0011\u001a\u00020\n2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lpl/edu/uwr/trackbudget/TransactionAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lpl/edu/uwr/trackbudget/TransactionAdapter$TransactionHolder;", "transactions", "", "Lpl/edu/uwr/trackbudget/Transaction;", "(Ljava/util/List;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setData", "TransactionHolder", "app_debug"})
public final class TransactionAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<pl.edu.uwr.trackbudget.TransactionAdapter.TransactionHolder> {
    private java.util.List<pl.edu.uwr.trackbudget.Transaction> transactions;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public pl.edu.uwr.trackbudget.TransactionAdapter.TransactionHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    pl.edu.uwr.trackbudget.TransactionAdapter.TransactionHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    public final void setData(@org.jetbrains.annotations.NotNull()
    java.util.List<pl.edu.uwr.trackbudget.Transaction> transactions) {
    }
    
    public TransactionAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<pl.edu.uwr.trackbudget.Transaction> transactions) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lpl/edu/uwr/trackbudget/TransactionAdapter$TransactionHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "amount", "Landroid/widget/TextView;", "getAmount", "()Landroid/widget/TextView;", "label", "getLabel", "app_debug"})
    public static final class TransactionHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView label = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView amount = null;
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getLabel() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getAmount() {
            return null;
        }
        
        public TransactionHolder(@org.jetbrains.annotations.NotNull()
        android.view.View view) {
            super(null);
        }
    }
}