package com.example.checkConnectors.tasks.services;


import com.example.checkConnectors.tasks.models.Pair;

import java.util.*;

public class CheckConnectors {
    private HashSet<Integer> viewed;

    public int check(List<Pair> pairList) {
        List<Set<Integer>> graphs = prepareGraphList(pairList);
        System.out.println(graphs);
        mergeConnectors(graphs);
        System.out.println(graphs);
        return graphs.size();
    }

    private List<Set<Integer>> prepareGraphList(List<Pair> pairList) {
        viewed = new HashSet<>();
        List<Set<Integer>> graphs = new ArrayList<>();
        pairList.forEach(pair -> {
            Integer a = pair.getA();
            Integer b = pair.getB();
            if (!viewed.contains(a) && !viewed.contains(b)) {
                Set<Integer> set = new HashSet<>();
                set.add(a);
                set.add(b);
                graphs.add(set);
            } else if (!checkAndSet(a, b, graphs)) {
                checkAndSet(b, a, graphs);
            }
            viewed.add(a);
            viewed.add(b);
        });
        return graphs;
    }

    private boolean checkAndSet(Integer a, Integer b, List<Set<Integer>> graphs){
        if (viewed.contains(b)){
            for (Set<Integer> set : graphs) {
                if (set.contains(b)) {
                    set.add(a);
                }
            }
            return true;
        }
        return false;
    }

    private void mergeConnectors(List<Set<Integer>> graphs){
        viewed.forEach(view -> {
            Set<Integer> finalSet = new HashSet<>();
            Iterator<Set<Integer>> iterator = graphs.iterator();
            while (iterator.hasNext()){
                Set<Integer> next = iterator.next();
                if (next.contains(view)){
                    finalSet.addAll(next);
                    iterator.remove();
                }
            }
            graphs.add(finalSet);
        });
    }
}
