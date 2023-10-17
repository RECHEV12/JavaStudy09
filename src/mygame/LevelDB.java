package mygame;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class LevelDB {
    private ArrayList<Level> levelArrayList = new ArrayList<>();

    public int LevelUP(int userLv) {
        int nextLevel = 0;
        for (Level lv : levelArrayList) {
            if (userLv == lv.getLevelNow()) {
                nextLevel = lv.getLevelExp();
            }
        }
        return nextLevel;
    }


    public LevelDB() {
        int a = 1;
        int b = 10;
        while (true) {
            levelArrayList.add(new Level(a, b));
            a++;
            b += 3;
            if (a == 10) {
                break;
            }
        }
        while (true) {
            levelArrayList.add(new Level(a, b));
            a++;
            b += 4;
            if (a == 20) {
                break;
            }
        }
        while (true) {
            levelArrayList.add(new Level(a, b));
            a++;
            b += 5;
            if (a == 30) {
                break;
            }
        }
        while (true) {
            levelArrayList.add(new Level(a, b));
            a++;
            b += 10;
            if (a == 40) {
                break;
            }
        }
    }

    public LevelDB(ArrayList<Level> levelArrayList) {
        this.levelArrayList = levelArrayList;
    }

    public ArrayList<Level> getLevelArrayList() {
        return levelArrayList;
    }

    public void setLevelArrayList(ArrayList<Level> levelArrayList) {
        this.levelArrayList = levelArrayList;
    }

    @Override
    public String toString() {
        return "LevelDB{" +
                "levelArrayList=" + levelArrayList +
                '}';
    }

    public void returnLevelDB() {
        for (Level lv : levelArrayList) {
        }
        System.out.println(levelArrayList);
    }
}