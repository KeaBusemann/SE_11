package ex11.depot;

public class Stock extends Derivative {

    public Stock(long id, String name, double initValue) {
        super(id, name, initValue);
    }

    public void updateValue(double val) {
        value += val;
        notifyValueUpdatedListeners();
    }
}
