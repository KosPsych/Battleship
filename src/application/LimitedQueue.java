
package application;
import java.util.LinkedList; 

/**
 * Override of LinkedList implementation used to store the last
 * 5 moves from both the computer and the user
 * @author KosPsych
 */

public class LimitedQueue<E> extends LinkedList<E> {
    private int limit;

    public LimitedQueue(int limit) {
        this.limit = limit;
    }

    @Override
    public boolean add(E o) {
        super.add(o);
        while (size() > limit) { super.remove(); }
        return true;
    }
}
