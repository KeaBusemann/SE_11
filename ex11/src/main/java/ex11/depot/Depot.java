package ex11.depot;

import ex11.annotations.observer.ConcreteObserver;
import ex11.annotations.observer.Update;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@ConcreteObserver
public class Depot implements StockValueUpdatedListener {

    private List<Derivative> derivatives = new ArrayList<>();

    public Depot(Collection<Derivative> derivatives) {
        this.derivatives.addAll(derivatives);
        derivatives.forEach(derivative -> {
            derivative.addValueUpdatedListener(this);
        });
        printSum();
    }

    public void addDerivative(Derivative derivative) {
        derivatives.add(derivative);
        derivative.addValueUpdatedListener(this);
        printSum();
    }

    public void removeDerivative(Derivative derivative) {
        derivatives.remove(derivative);
        derivative.removeValueUpdatedListener(this);
        printSum();
    }

    @Update
    @Override
    public void stockValueUpdated(Derivative derivative) {
        printSum();
    }

    private void printSum() {
        double sumValue = 0;
        for (Derivative d : derivatives) {
            sumValue += d.getValue();
        }
        System.out.println("depot value: " + sumValue);
    }
}
