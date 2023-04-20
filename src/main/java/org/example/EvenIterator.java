package org.example;

import java.util.Iterator;

public class EvenIterator implements Iterator<Integer>{
    private final Iterator<Integer> fullIterator;
    private boolean calledHasNext;
    private Integer next;

    public EvenIterator(Iterator<Integer> fullIterator) {
        this.fullIterator = fullIterator;
        calledHasNext = false;
    }

    @Override
    public boolean hasNext() {
        if (!calledHasNext) {
            calledHasNext = true;
            while (fullIterator.hasNext()) {
                next = fullIterator.next();
                if (next % 2 == 0) {
                    return true;
                }
            }
        }
        return next != null;
    }

    @Override
    public Integer next() {
        if (calledHasNext) {
            calledHasNext = false;
            Integer t = next;
            next = null;
            return t;
        } else {
            if (this.hasNext()) {
                calledHasNext = false;
                Integer t = next;
                next = null;
                return t;
            }
        }
        return null;
    }
}
