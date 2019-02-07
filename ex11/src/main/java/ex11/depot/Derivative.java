package ex11.depot;

import ex11.annotations.observer.Attach;
import ex11.annotations.observer.Detach;
import ex11.annotations.observer.Notify;
import ex11.annotations.observer.Subject;

import java.util.LinkedList;
import java.util.List;

/**
 * Wertpapier
 */
@Subject
abstract public class Derivative {

    private long id;
    private String name;
    protected double value;

    private List<StockValueUpdatedListener> valueUpdatedListeners = new LinkedList<>();

    public Derivative(long id, String name, double initValue) {
        this.id = id;
        this.name = name;
        this.value = initValue;
    }


    abstract public void updateValue(double val);

    @Attach
    public void addValueUpdatedListener(StockValueUpdatedListener listener) {
        valueUpdatedListeners.add(listener);
    }

    @Detach
    public void removeValueUpdatedListener(StockValueUpdatedListener listener) {
        valueUpdatedListeners.remove(listener);
    }

    @Notify
    protected void notifyValueUpdatedListeners() {
        valueUpdatedListeners.forEach(listener -> listener.stockValueUpdated(this));
    }



    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getValue() {
        return value;
    }
}
