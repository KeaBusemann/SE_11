package ex11;

import ex11.annotations.composite.Component;
import ex11.annotations.composite.Operation;
import ex11.annotations.observer.Attach;
import ex11.annotations.observer.Detach;
import ex11.annotations.observer.GetState;
import ex11.annotations.observer.ModifyState;
import ex11.annotations.observer.Notify;
import ex11.annotations.observer.Subject;
import ex11.annotations.strategy.Context;

import java.util.LinkedList;

@Context
@Subject
@Component
public abstract class BankAccount {
    String ID;
    LinkedList<AccountUpdatedListener> listeners = new LinkedList<AccountUpdatedListener>();

    @ModifyState
    @Operation
    abstract void applyInterestRate(float interestRate);
    
    @GetState
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
