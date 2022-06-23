import Course.CodeWars.Finder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FinderTest {
    @Test
    public void sampleTests() {

        String a = ".W.\n" +
                ".W.\n" +
                "...",

                b = ".W.\n" +
                        ".W.\n" +
                        "W..",

                c = "......\n" +
                        "......\n" +
                        "......\n" +
                        "......\n" +
                        "......\n" +
                        "......",

                d = "......\n" +
                        "......\n" +
                        "......\n" +
                        "......\n" +
                        ".....W\n" +
                        "....W.";

        Assertions.assertEquals(true, Finder.pathFinder(a));
        assertEquals(false, Finder.pathFinder(b));
        assertEquals(true, Finder.pathFinder(c));
        assertEquals(false, Finder.pathFinder(d));
    }

}