import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TextStatisticsTest {

    @Test
    void testAddLine() {
        TextStatistics stats = new TextStatistics();
        stats.addLine("Testing is easy");
        assertEquals(3, stats.getWordCount(), "Should be 3 words");
        assertEquals("Testing", stats.getLongestWord(), "Longest word should be 'Testing'");
    }

    @Test
    void testLine() {
        TextStatistics stats = new TextStatistics();
        stats.addLine("Malmö");
        stats.addLine("Intro to Programming");
        assertEquals(2, stats.getLineCount(), "Should be 2 lines");
        assertEquals(22, stats.getCharacterCount(), "Should be 22 characters");
    }

    @Test
    void testIsStop() {
        TextStatistics stats = new TextStatistics();
        assertTrue(stats.isStop("stop"), "Input 'stop' should return true");
        assertTrue(stats.isStop("STOP"), "Input 'STOP' should return true");
        assertFalse(stats.isStop("continue"), "Input 'continue' should return false");
    }
}

