# Architecture

## Overview

TrackBudget follows a simple activity-driven architecture with Room for persistence. The UI is composed of three screens backed by a single database.

## Key components

### Activities

- **MainActivity**
  - Displays the dashboard totals and the transaction list.
  - Fetches transactions from Room on a background dispatcher and updates the UI on the main thread.
  - Handles swipe-to-delete with a Snackbar undo.

- **AddTransactionActivity**
  - Validates input and inserts a new transaction.
  - Runs database writes on `Dispatchers.IO` via `lifecycleScope`.

- **DetailedActivity**
  - Displays and edits an existing transaction.
  - Updates the record in the database on a background dispatcher.

### Data layer

- **Transaction**
  - Room entity representing a transaction with amount, label, and description.

- **TransactionDao**
  - Provides suspend functions for CRUD operations.

- **AppDatabase**
  - Room database singleton that exposes the DAO.

## Data flow

1. UI actions (add/update/delete) call the DAO from a coroutine launched in `lifecycleScope`.
2. Database work occurs on `Dispatchers.IO`.
3. Updated data is rendered on the main thread.

## Threading model

- All database operations run on `Dispatchers.IO`.
- UI updates are performed on the main thread since `lifecycleScope.launch` runs on the main dispatcher by default.

## UI layer

- A `RecyclerView` lists transactions with a `TransactionAdapter`.
- Amounts are color-coded: green for income, red for expenses.
