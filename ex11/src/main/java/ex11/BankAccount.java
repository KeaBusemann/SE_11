package ex11;

import ex11.annotations.observer.Attach;
import ex11.annotations.observer.Detach;
import ex11.annotations.observer.Notify;
import ex11.annotations.observer.Subject;

import java.util.LinkedList;

@Subject
public abstract class BankAccount {
    String ID;
    LinkedList<AccountUpdatedListener> listeners = new LinkedList<AccountUpdatedListener>();

    abstract void applyInterestRate(float interestRate);
    abstract int getAmount();

    @Attach
    void addListener(AccountUpdatedListener listener) {
        listeners.add(listener);
    }

    @Detach
    void removeListener(AccountUpdatedListener listener) {
        listeners.remove(listener);
    }

    @Notify
    protected void notifyListeners() {
        listeners.forEach(l -> l.accountUpdated(this));
    }

    String getID() {
        return this.ID;
    }
}
