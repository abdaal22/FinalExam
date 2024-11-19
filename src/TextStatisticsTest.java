import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TextStatisticsTest {

    @Test
    void testAddLine() {
        TextStatistics stats = new TextStatistics();
        stats.addLine("Hello world");

        assertEquals(1, stats.getLineCount(), "Should be 1 line");
        assertEquals(11, stats.getCharacterCount(), "Should be 11 characters");
        assertEquals(2, stats.getWordCount(), "Should be 2 words");
        assertEquals("Hello", stats.getLongestWord(), "Longest word should be 'Hello'");
    }
    @Test
    void testMultipleLines() {
        TextStatistics stats = new TextStatistics();
        stats.addLine("Java is fun");
        stats.addLine("Write clean code");

        assertEquals(2, stats.getLineCount(), "Should be 2 lines");
        assertEquals(26, stats.getCharacterCount(), "Should be 26 characters");
        assertEquals(5, stats.getWordCount(), "Should be 5 words");
        assertEquals("clean", stats.getLongestWord(), "Longest word should be 'clean'");
    }
    @Test
    void testIsStop() {
        TextStatistics stats = new TextStatistics();
        assertTrue(stats.isStop("stop"), "Input 'stop' should return true");
        assertTrue(stats.isStop("STOP"), "Input 'STOP' should return true");
        assertFalse(stats.isStop("continue"), "Input 'continue' should return false");
    }
}
