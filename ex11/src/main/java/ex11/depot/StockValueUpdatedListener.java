package ex11.depot;

import ex11.annotations.observer.Observer;
import ex11.annotations.observer.Update;

@Observer
public interface StockValueUpdatedListener {
    @Update
    void stockValueUpdated(Derivative derivative);
}
