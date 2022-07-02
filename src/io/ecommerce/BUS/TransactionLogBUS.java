package io.ecommerce.BUS;

import io.ecommerce.DAL.TransactionLogDAL;
import io.ecommerce.DTO.TransactionLog;

import java.util.ArrayList;

public class TransactionLogBUS {
    private TransactionLogDAL _transactionLogDAL = new TransactionLogDAL();

    public ArrayList<TransactionLog> getAllTransactionLogs() {
        return _transactionLogDAL.getAllTransactionLogs();
    }

    public ArrayList<TransactionLog> getTransactionLogByIdOrDate(String key) {
        return _transactionLogDAL.getTransactionLogByIdOrDate(key);
    }

    public boolean addTransactionLog(TransactionLog transactionLog) {
        return _transactionLogDAL.addTransactionLog(transactionLog);
    }

    public boolean updateTransactionLogById(TransactionLog transactionLog) {
        return _transactionLogDAL.updateTransactionLogById(transactionLog);
    }

    public boolean deleteTransactionLogById(String id) {
        return _transactionLogDAL.deleteTransactionLogById(id);
    }
}