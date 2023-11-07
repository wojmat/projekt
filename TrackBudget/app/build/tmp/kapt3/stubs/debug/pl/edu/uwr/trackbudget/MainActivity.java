package pl.edu.uwr.trackbudget;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0006H\u0002J\b\u0010\u0011\u001a\u00020\u000fH\u0002J\u0012\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014J\b\u0010\u0015\u001a\u00020\u000fH\u0014J\b\u0010\u0016\u001a\u00020\u000fH\u0002J\b\u0010\u0017\u001a\u00020\u000fH\u0002J\b\u0010\u0018\u001a\u00020\u000fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\nX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lpl/edu/uwr/trackbudget/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "db", "Lpl/edu/uwr/trackbudget/AppDatabase;", "deletedTransaction", "Lpl/edu/uwr/trackbudget/Transaction;", "linearLayoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "oldTransactions", "", "transactionAdapter", "Lpl/edu/uwr/trackbudget/TransactionAdapter;", "transactions", "deleteTransaction", "", "transaction", "fetchAll", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "showSnackbar", "undoDelete", "updateDashboard", "app_debug"})
public final class MainActivity extends androidx.appcompat.app.AppCompatActivity {
    private pl.edu.uwr.trackbudget.Transaction deletedTransaction;
    private java.util.List<pl.edu.uwr.trackbudget.Transaction> transactions;
    private java.util.List<pl.edu.uwr.trackbudget.Transaction> oldTransactions;
    private pl.edu.uwr.trackbudget.TransactionAdapter transactionAdapter;
    private androidx.recyclerview.widget.LinearLayoutManager linearLayoutManager;
    private pl.edu.uwr.trackbudget.AppDatabase db;
    private java.util.HashMap _$_findViewCache;
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void fetchAll() {
    }
    
    private final void updateDashboard() {
    }
    
    private final void undoDelete() {
    }
    
    private final void showSnackbar() {
    }
    
    private final void deleteTransaction(pl.edu.uwr.trackbudget.Transaction transaction) {
    }
    
    @java.lang.Override()
    protected void onResume() {
    }
    
    public MainActivity() {
        super();
    }
}