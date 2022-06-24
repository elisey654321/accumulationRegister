import Course.CodeWars.Finder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FinderTest {
    @Test
    public void sampleTests() {

        String a =  ".W.\n" +
                    ".W.\n" +
                    "...",

                b =     ".W.\n" +
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
                        "....W.",
                e = ".W.W.W.WW....W\n"+
                        "...W..WWWWW.W.\n"+
                        "...W....WWW...\n"+
                        "..W.......W.W.\n"+
                        "WW....W.......\n"+
                        ".......W.W....\n"+
                        "..........W...\n"+
                        "..W....WWW.W..\n"+
                        ".WW....W....W.\n"+
                        "...W...W...WWW\n"+
                        "........W.....\n"+
                        "W....W.....WW.\n"+
                        "W.W..W.WWW.W.W\n"+
                        "WW......WW..W.\n",
                f =     ".W...\n" +
                        ".W...\n" +
                        ".W.W.\n" +
                        "...W.\n" +
                        "...W.";


//        assertEquals(true, Finder.pathFinder(a));
//        assertEquals(false, Finder.pathFinder(b));
//        assertEquals(true, Finder.pathFinder(c));
//        assertEquals(false, Finder.pathFinder(d));
//        assertEquals(false, Finder.pathFinder(e));
        assertEquals(true, Finder.pathFinder(f));
    }

}