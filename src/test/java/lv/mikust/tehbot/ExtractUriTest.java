package lv.mikust.tehbot;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mikus on 2016.11.19..
 */
public class ExtractUriTest {
    @org.junit.Test
    public void testURI() throws Exception {
        ExtractUri extractUri = new ExtractUri();
        assertEquals("test.com", extractUri.splitText("test.com"));
    }

    @Test
    public void testComma() throws Exception {
        ExtractUri extractUri = new ExtractUri();
        assertNull(extractUri.splitText("test.test.test,com"));
    }

    @Test
    public void testHyphen() throws Exception {
        ExtractUri extractUri = new ExtractUri();
        assertNull(extractUri.splitText("test.com-"));
        assertNull(extractUri.splitText("-test.com"));
        assertNull(extractUri.splitText("test-.com"));
        assertEquals("test-test.com", extractUri.splitText("test-test.com"));
    }

    @Test
    public void testTLD() throws Exception {
        ExtractUri extractUri = new ExtractUri();
        assertNull(extractUri.splitText("test.c"));
        assertEquals("test.co.uk", extractUri.splitText("test.co.uk"));
        assertEquals("t.co", extractUri.splitText("t.co"));
        assertNull(extractUri.splitText("test"));
    }
}