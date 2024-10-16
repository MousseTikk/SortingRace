package esi.atl.g56583.sortingrace.model;

import esi.atl.g56583.sortingrace.model.sorts.*;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Objects;

public class SortingRace implements PropertyChangeListener {
    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }

    public void runSort(int threadSpinner, int nbRepeat, String sortValue) {
        var sortType = Objects.requireNonNull(SortType.fromString(sortValue));
        var job = new Job(nbRepeat);

        Sort sort = switch (sortType) {
            case BUBBLE -> new Bubble();
            case MERGE -> new Merge();
            case SELECTION -> new Selection();
            case INSERTION -> new Insertion();
            default -> new Quick();
        };

        for (int i = 0; i < threadSpinner; i++) {
            MyThread thread = new MyThread(job, sort);
            thread.addPropertyChangeListener(this);
            thread.start();
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        pcs.firePropertyChange("notUsed", evt.getOldValue(), evt.getNewValue());
    }
}
