package ex11;

import ex11.annotations.observer.ConcreteObserver;
import ex11.annotations.observer.Update;
import ex11.annotations.strategy.Algorithm;
import ex11.annotations.strategy.ConcreteStrategy;

import java.util.*;

@ConcreteStrategy
@ConcreteObserver
public class CustomerInterface implements AccountUpdatedListener {
    private HashMap<String, BankAccount> accounts = new HashMap<>();
    private Map<String, Date> updateHistory = new HashMap<>();

    CustomerInterface(BankAccount... accounts) {
        for (BankAccount bankAccount: accounts) {
            this.accounts.put(bankAccount.getID(), bankAccount);
        }
    }

    @Override
    @Algorithm
    @Update
    public void accountUpdated(BankAccount bankAccount) {
        this.accounts.get(bankAccount.getID()); // do some updates
        updateHistory.put(bankAccount.getID(), new Date());
    }

    public Map<String, Date> getUpdateHistory() {
        return updateHistory;
    }
}
