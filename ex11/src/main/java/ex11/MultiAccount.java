package ex11;

import java.util.Collections;
import java.util.LinkedList;

import ex11.annotations.composite.Add;
import ex11.annotations.composite.Composite;
import ex11.annotations.composite.GetChild;
import ex11.annotations.composite.Operation;
import ex11.annotations.composite.Remove;
import ex11.annotations.observer.Attach;
import ex11.annotations.observer.ConcreteSubject;
import ex11.annotations.observer.GetState;
import ex11.annotations.observer.ModifyState;

@ConcreteSubject
@Composite
public class MultiAccount extends BankAccount {
    LinkedList<BankAccount> subAccounts = new LinkedList<>();
    private static int idctr = 0;

    public MultiAccount(BankAccount... subAccounts) {
        this.ID = getNextID();
        Collections.addAll(this.subAccounts, subAccounts);
    }

    private static String getNextID() {
        return String.valueOf(idctr++);
    }

    @Override
    @Attach
    void addListener(AccountUpdatedListener listener) {
        subAccounts.forEach(a -> a.addListener(listener));
    }

    @Add
    public void addBankAccount(BankAccount ba) {
        subAccounts.add(ba);
    }

    @Override
    @GetState
    public int getAmount() {
        int entireAmount = 0;
        for(BankAccount a: subAccounts)
            entireAmount += a.getAmount();
        return entireAmount;
    }

    @Override
    @ModifyState
    @Operation
    void applyInterestRate(float interestRate) {
        subAccounts.forEach(a -> a.applyInterestRate(interestRate));
    }

    @Remove
    public void removeBankAccount(BankAccount ba) {
        subAccounts.remove(ba);
    }

    @GetChild
    public BankAccount getBankAccountByPosition(int position) {
        return subAccounts.get(position);
    }

}
