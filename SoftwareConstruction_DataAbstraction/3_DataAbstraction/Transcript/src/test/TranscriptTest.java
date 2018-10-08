package test;

import model.Transcript;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TranscriptTest {
    private Transcript testTranscript;

    @Before
    public void setup(){
        testTranscript = new Transcript("Mustafa", 999);
        //TODO: write new values in testTranscript constructor
    }

    @Test
    public void testTemplate(){
        //TODO: write tests for Transcript methods
        assertEquals(5, 5);
    }
}
