package com.example.expensetracker.data;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "transactions")
public class Transaction {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public double amount;

    public String merchant;

    public String category;

    public long transactionTime;

    public String source;
}