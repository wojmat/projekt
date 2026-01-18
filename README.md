# TrackBudget

TrackBudget is a simple Android app for tracking income and expenses. It lets you add transactions, review totals, and update or delete entries with an undo option.

## Features

- Add income or expense transactions with labels and descriptions.
- Dashboard summary showing balance, total budget, and expenses.
- Swipe-to-delete with an undo Snackbar.
- Edit existing transactions.

## Tech stack

- Kotlin
- AndroidX (AppCompat, RecyclerView, Lifecycle)
- Room (SQLite persistence)
- Material Components

## Getting started

### Prerequisites

- Android Studio Arctic Fox (or newer)
- Android SDK 30+

### Build and run

1. Open the project in Android Studio.
2. Let Gradle sync and download dependencies.
3. Run the `app` configuration on an emulator or device.

### Notes on data storage

Transactions are stored locally using Room in a database named `transactions`.

## Project structure

```
TrackBudget/
└── app/
    └── src/main/java/pl/edu/uwr/trackbudget/
        ├── MainActivity.kt
        ├── AddTransactionActivity.kt
        ├── DetailedActivity.kt
        ├── Transaction.kt
        ├── TransactionAdapter.kt
        ├── TransactionDao.kt
        └── AppDatabase.kt
```

## Documentation

See [`docs/architecture.md`](docs/architecture.md) for a deeper look at the architecture and data flow.
