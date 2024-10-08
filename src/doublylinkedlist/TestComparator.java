package doublylinkedlist;

import java.util.Comparator;

public class TestComparator implements Comparator<Minion> {
    @Override
    public int compare(Minion m1, Minion m2) {
        int result = Integer.compare(m1.getLevel() + m1.getEyesCount(), m2.getLevel() + m2.getEyesCount());

        if (result != 0) {
            return result;
        }
        result = m2.getName().compareTo(m1.getName());
        if (result != 0) {
            return result;
        }
        return Integer.compare((m2.getEyesCount() - m2.getLevel()), (m1.getEyesCount() - m1.getLevel()));
    }
}

