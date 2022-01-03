package com.dalhousie.group14.BusinessLogic.manager;

import java.util.*;
/**
 * @Author: Harjot Singh
 * @NameofFile: EvaluatorComparator.java
 * @ClassDescription: This class is responsible for implementing the
 * Evaluator Comparator which sorts the given Map of ratings of employees in
 * a descending order.
 */
public class EvaluatorComparator {

    static <K,V extends Comparable<? super V>>
    List<Map.Entry<K, V>> entriesSortedByValues(Map<K,V> ratingsMap) {

        List<Map.Entry<K,V>> sortEmployeeRatings = new ArrayList<Map.Entry<K,V>>(ratingsMap.entrySet());

        Collections.sort(sortEmployeeRatings,
                new Comparator<Map.Entry<K,V>>() {
                    @Override
                    public int compare(Map.Entry<K,V> e1, Map.Entry<K,V> e2) {
                        return e2.getValue().compareTo(e1.getValue());
                    }
                }
        );

        return sortEmployeeRatings;
    }
}
