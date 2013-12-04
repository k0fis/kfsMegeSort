package kfs.kfsMegeSort;

import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author pavedrim
 */
public class MergeSort {

    public static <E> void sort(E[] a, Comparator<? super E> comp) {
        mergeSort(a, 0, a.length - 1, comp);
    }

    public static <T> void sort(List<T> list, Comparator<? super T> c) {
        Object[] a = list.toArray();
        sort(a, (Comparator)c);
        ListIterator i = list.listIterator();
        for (Object a1 : a) {
            i.next();
            i.set(a1);
        }
    }
    private static <E> void mergeSort(E[] a, int from, int to, Comparator<? super E> comp) {
        if (from == to) {
            return;
        }
        int mid = (from + to) / 2;
        // Sort the first and the second half
        mergeSort(a, from, mid, comp);
        mergeSort(a, mid + 1, to, comp);
        merge(a, from, mid, to, comp);
    }

    private static <E> void merge(E[] a, int from, int mid, int to, Comparator<? super E> comp) {
        int n = to - from + 1;
        Object[] values = new Object[n];

        int fromValue = from;

        int middleValue = mid + 1;

        int index = 0;

        while (fromValue <= mid && middleValue <= to) {
            if (comp.compare(a[fromValue], a[middleValue]) < 0) {
                values[index] = a[fromValue];
                fromValue++;
            } else {
                values[index] = a[middleValue];
                middleValue++;
            }
            index++;
        }

        while (fromValue <= mid) {
            values[index] = a[fromValue];
            fromValue++;
            index++;
        }
        while (middleValue <= to) {
            values[index] = a[middleValue];
            middleValue++;
            index++;
        }

        for (index = 0; index < n; index++) {
            a[from + index] = (E) values[index];
        }
    }

}
