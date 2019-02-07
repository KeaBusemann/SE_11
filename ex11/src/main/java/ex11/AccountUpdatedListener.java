package ex11;

import ex11.annotations.observer.Observer;
import ex11.annotations.observer.Update;

@Observer
public interface AccountUpdatedListener {
    @Update
    void accountUpdated(BankAccount bankAccount);
}
