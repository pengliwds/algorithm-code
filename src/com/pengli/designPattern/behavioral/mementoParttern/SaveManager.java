package com.pengli.designPattern.behavioral.mementoParttern;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SaveManager {

    private Map<String, List<GameMemento>> saveMap = new HashMap<>();

    public void save(String name, GameMemento gameMemento) {
        if (saveMap.containsKey(name)) {
            saveMap.get(name).add(gameMemento);
        } else {
            List<GameMemento> list = new ArrayList<>();
            list.add(gameMemento);
            saveMap.put(name, list);
        }
    }

    public GameMemento load(String name, int index) {
        if (saveMap.containsKey(name)) {
            List<GameMemento> list = saveMap.get(name);
            if (index < list.size()) {
                return list.get(index);
            }
        }
        return null;
    }





}
