package pl.edu.uwr.trackbudget

import androidx.room.*

/**
 * DAO for accessing [Transaction] records.
 */
@Dao
interface TransactionDao {
    @Query("SELECT * from transactions")
    suspend fun getAll(): List<Transaction>

    @Insert
    suspend fun insertAll(vararg transaction: Transaction)

    @Delete
    suspend fun delete(transaction: Transaction)

    @Update
    suspend fun update(transaction: Transaction)
}
