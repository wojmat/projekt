package pl.edu.uwr.trackbudget;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class TransactionDao_Impl implements TransactionDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Transaction> __insertionAdapterOfTransaction;

  private final EntityDeletionOrUpdateAdapter<Transaction> __deletionAdapterOfTransaction;

  private final EntityDeletionOrUpdateAdapter<Transaction> __updateAdapterOfTransaction;

  public TransactionDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfTransaction = new EntityInsertionAdapter<Transaction>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `transactions` (`id`,`label`,`amount`,`description`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Transaction value) {
        stmt.bindLong(1, value.getId());
        if (value.getLabel() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getLabel());
        }
        stmt.bindDouble(3, value.getAmount());
        if (value.getDescription() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getDescription());
        }
      }
    };
    this.__deletionAdapterOfTransaction = new EntityDeletionOrUpdateAdapter<Transaction>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `transactions` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Transaction value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfTransaction = new EntityDeletionOrUpdateAdapter<Transaction>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `transactions` SET `id` = ?,`label` = ?,`amount` = ?,`description` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Transaction value) {
        stmt.bindLong(1, value.getId());
        if (value.getLabel() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getLabel());
        }
        stmt.bindDouble(3, value.getAmount());
        if (value.getDescription() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getDescription());
        }
        stmt.bindLong(5, value.getId());
      }
    };
  }

  @Override
  public void insertAll(final Transaction... transaction) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfTransaction.insert(transaction);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final Transaction transaction) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfTransaction.handle(transaction);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final Transaction... transaction) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfTransaction.handleMultiple(transaction);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Transaction> getAll() {
    final String _sql = "SELECT * from transactions";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfLabel = CursorUtil.getColumnIndexOrThrow(_cursor, "label");
      final int _cursorIndexOfAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "amount");
      final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
      final List<Transaction> _result = new ArrayList<Transaction>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Transaction _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpLabel;
        _tmpLabel = _cursor.getString(_cursorIndexOfLabel);
        final double _tmpAmount;
        _tmpAmount = _cursor.getDouble(_cursorIndexOfAmount);
        final String _tmpDescription;
        _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
        _item = new Transaction(_tmpId,_tmpLabel,_tmpAmount,_tmpDescription);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
