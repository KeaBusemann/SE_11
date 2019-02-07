package ex11;

import ex11.annotations.composite.Leaf;
import ex11.annotations.composite.Operation;
import ex11.annotations.observer.ConcreteSubject;
import ex11.annotations.observer.GetState;
import ex11.annotations.observer.ModifyState;

@ConcreteSubject
@Leaf
class BasicBankAccount extends BankAccount {
    private int amount;
    private static int idctr = 0;

    private static String getNextID() {
        return String.valueOf(idctr++);
    }

    BasicBankAccount(int initialAmount) {
        this.amount = initialAmount;
        this.ID = getNextID();
    }
    
    @Override
    @GetState
    public int getAmount() {
    	return amount;
    }

    @Override
    @ModifyState
    @Operation
    public void applyInterestRate(float interestRate) {
        float newAmount = ((float) amount) * interestRate;
        amount = (int) newAmount;
        notifyListeners();
    }
}
