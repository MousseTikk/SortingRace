package esi.atl.g56583.sortingrace.model;

import esi.atl.g56583.sortingrace.model.sorts.Sort;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.time.LocalTime;

import static java.time.temporal.ChronoUnit.MILLIS;
//Recoit le job donc le tableau qu'il doit trier
public class MyThread extends Thread {
    private final Job job;
    private final Sort sortType;
    //mesure le temps de tri et informe les autres composants via un système d'écouteurs
    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public MyThread(Job job, Sort sortType) {
        this.job = job;
        this.sortType = sortType;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }

    @Override
    public void run() {
        long duration;
        int[] tabToSort = job.makeJob();

        while (tabToSort != null) {
            LocalTime start = LocalTime.now();
            duration = sortType.sort(tabToSort);
            LocalTime end = LocalTime.now();

            pcs.firePropertyChange("notUsed", null, new long[]{
                    tabToSort.length,
                    duration,
                    (int) MILLIS.between(start, end)
            });
            tabToSort = job.makeJob();
        }
    }
}
