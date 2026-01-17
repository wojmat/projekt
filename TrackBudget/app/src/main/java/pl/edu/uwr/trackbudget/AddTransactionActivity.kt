package pl.edu.uwr.trackbudget

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import kotlinx.android.synthetic.main.activity_add_transaction.*
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Screen for adding a new transaction.
 */
class AddTransactionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_transaction)

        labelInput.addTextChangedListener {
            if(it!!.count() > 0)
                labelLayout.error = null
        }

        amountInput.addTextChangedListener {
            if(it!!.count() > 0)
                amountLayout.error = null
        }

        addTransactionBtn.setOnClickListener {
            val label = labelInput.text.toString()
            val description = descriptionInput.text.toString()
            val amount = amountInput.text.toString().toDoubleOrNull()

            if(label.isEmpty())
                labelLayout.error = "Wprowadź opis"

            else if(amount == null)
                amountLayout.error = "Wprowadź kwotę"
            else {
                val transaction  = Transaction(0, label, amount, description)
                insert(transaction)
            }
        }

        closeBtn.setOnClickListener {
            finish()
        }
    }

    /**
     * Persists a new [transaction] on a background thread.
     */
    private fun insert(transaction: Transaction){
        val db = AppDatabase.getInstance(this)
        lifecycleScope.launch {
            withContext(Dispatchers.IO) {
                db.transactionDao().insertAll(transaction)
            }
            finish()
        }
    }

}
