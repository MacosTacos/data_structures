package doublylinkedlist;

import java.util.Comparator;

public class Minion implements Comparable<Minion> {
    private int level;
    private String name;
    private int eyesCount;
// level + eyesCount по возрастанию
    //string по убыванию
    //eyeCount - level по убыванию
    public Minion(int level, String name, int eyesCount) {
        this.level = level;
        this.name = name;
        this.eyesCount = eyesCount;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEyesCount() {
        return eyesCount;
    }

    public void setEyesCount(int eyesCount) {
        this.eyesCount = eyesCount;
    }

    @Override
    public String toString() {
        return "Minion{" +
                "level=" + level +
                ", name='" + name + '\'' +
                ", eyesCount=" + eyesCount +
                '}';
    }

    @Override
    public int compareTo(Minion other) {
        return Comparator.comparingInt(Minion::getLevel)
                .thenComparingInt(Minion::getEyesCount)
                .thenComparing(Minion::getName)
                .compare(this, other);
    }
}
