package esi.atl.g56583.sortingrace.model;

import java.util.Random;
//Créé les tableaux d'entiers de taille croissante pour tester les performances de mes tris
public class Job {
    private final static Random nbRdm = new Random();
    private final int max;
    private final int jump;
    private int current;

    public Job(int max) {
        this.max = max;
        this.jump = max / 10;
        this.current = 0;
    }

    public synchronized int[] makeJob() {
        if (current > max) {
            return null;
        }
        int[] tab = new int[current];
        for (int i = 0; i < current; i++) {
            tab[i] = nbRdm.nextInt();
        }
        current += jump;
        return tab;
    }
}
