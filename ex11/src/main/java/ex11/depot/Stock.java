package ex11.depot;

import ex11.annotations.observer.ConcreteSubject;
import ex11.annotations.observer.ModifyState;

@ConcreteSubject
public class Stock extends Derivative {

    public Stock(long id, String name, double initValue) {
        super(id, name, initValue);
    }

    @ModifyState
    public void updateValue(double val) {
        value += val;
        notifyValueUpdatedListeners();
    }
}
