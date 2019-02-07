package ex11;

import ex11.annotations.composite.Client;
import ex11.annotations.observer.Observer;
import ex11.annotations.observer.Update;
import ex11.annotations.strategy.Algorithm;
import ex11.annotations.strategy.Strategy;

@Strategy
@Observer
@Client
public interface AccountUpdatedListener {
	@Algorithm
	@Update
    void accountUpdated(BankAccount bankAccount);
}
