package pl.edu.uwr.trackbudget

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Main screen showing the dashboard totals and a list of transactions.
 */
class MainActivity : AppCompatActivity() {
    private lateinit var deletedTransaction: Transaction
    private lateinit var transactions : List<Transaction>
    private lateinit var oldTransactions : List<Transaction>
    private lateinit var transactionAdapter: TransactionAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var db : AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        transactions = arrayListOf()

        transactionAdapter = TransactionAdapter(transactions)
        linearLayoutManager = LinearLayoutManager(this)

        db = AppDatabase.getInstance(this)

        recyclerview.apply {
            adapter = transactionAdapter
            layoutManager = linearLayoutManager
        }


        // Swipe right to remove a transaction and show undo via Snackbar.
        val itemTouchHelper = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT){
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                deleteTransaction(transactions[viewHolder.adapterPosition])
            }

        }

        val swipeHelper = ItemTouchHelper(itemTouchHelper)
        swipeHelper.attachToRecyclerView(recyclerview)

        addBtn.setOnClickListener {
            val intent = Intent(this, AddTransactionActivity::class.java)
            startActivity(intent)
        }
    }

    private fun fetchAll() {
        lifecycleScope.launch {
            transactions = withContext(Dispatchers.IO) {
                db.transactionDao().getAll()
            }

            updateDashboard()
            transactionAdapter.setData(transactions)
        }
    }

    /**
     * Updates the dashboard totals based on the current [transactions].
     */
    private fun updateDashboard() {
        // Total is calculated from all transactions; budget covers positive amounts.
        val totalAmount = transactions.sumOf { it.amount }
        val budgetAmount = transactions.filter { it.amount > 0 }.sumOf { it.amount }
        val expenseAmount = totalAmount - budgetAmount

        balance.text = "%.2f".format(totalAmount)
        budget.text = "%.2f".format(budgetAmount)
        expense.text = "%.2f".format(expenseAmount)
    }

    private fun undoDelete() {
        lifecycleScope.launch {
            withContext(Dispatchers.IO) {
                db.transactionDao().insertAll(deletedTransaction)
            }

            transactions = oldTransactions

            transactionAdapter.setData(transactions)
            updateDashboard()
        }
    }

    private fun showSnackbar() {
        val view = findViewById<View>(R.id.coordinator)
        val snackbar = Snackbar.make(view, "Usunięto!",Snackbar.LENGTH_LONG)
        snackbar.setAction("Przywróć"){
            undoDelete()
        }
            .setActionTextColor(ContextCompat.getColor(this, R.color.red))
            .setTextColor(ContextCompat.getColor(this, R.color.white))
            .show()
    }

    private fun deleteTransaction(transaction: Transaction) {
        deletedTransaction = transaction
        oldTransactions = transactions

        lifecycleScope.launch {
            withContext(Dispatchers.IO) {
                db.transactionDao().delete(transaction)
            }

            transactions = transactions.filter { it.id != transaction.id }
            updateDashboard()
            transactionAdapter.setData(transactions)
            showSnackbar()
        }
    }

    override fun onResume() {
        super.onResume()
        fetchAll()
    }
}
