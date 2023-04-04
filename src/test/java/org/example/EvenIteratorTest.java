package org.example;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class EvenIteratorTest {
    @Test
    public void testIterator() {
        List<Integer> testList = Arrays.asList(1, 3, 6, 2, 11, 28, -4, -223, 0, -5, 8, 10, 456);
        EvenIterator evenIterator = new EvenIterator(testList.listIterator());
        EvenIterator evenIterator2 = new EvenIterator(testList.listIterator());
        List<Integer> evenList = new ArrayList<>();
        while (evenIterator.hasNext()) {
            evenList.add(evenIterator.next());
        }
        assertEquals(
                testList.stream().filter(i -> i % 2 == 0).collect(Collectors.toList()),
                evenList
        );

        List<Integer> evenList2 = new ArrayList<>();
        while (true) {
            Integer next = evenIterator2.next();
            if (next == null) {
                break;
            }
            if (next % 2 == 0) {
                evenList2.add(next);
            }
        }
        assertEquals(
                testList.stream().filter(i -> i % 2 == 0).collect(Collectors.toList()),
                evenList2
        );
    }
}
