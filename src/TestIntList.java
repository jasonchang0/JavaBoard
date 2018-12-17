package src;

import org.junit.Assert;
import org.junit.Test;

public class TestIntList {

    @Test
    public void verifyInsertHead() {
        IntList lst = new IntList(2, null);
        lst.insertHead(5);
        lst.insertHead(6);
        lst.insertHead(9);

        IntList solution = new IntList(5, new IntList(2, null));
        solution = new IntList(6, solution);

        Assert.assertEquals(lst, new IntList(9, solution));
    }

}
