package cs.lab;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class DNASequencerTest {
    @Test
    public void testCase0() throws Exception {
        generic(0);
    }
    @Test(expectedExceptions = LenghtException.class)
    public void testCase1() throws Exception {
        generic(1);
    }
    @Test(expectedExceptions = QuantityException.class)
    public void tesCase2() throws Exception{
        generic(2);
    }
    @Test(invocationCount = 50, threadPoolSize = 50)
    public void testCase3() throws Exception{
        long starttime=System.currentTimeMillis();
        generic(0);
        long endtiem=System.currentTimeMillis();
        Assert.assertTrue((endtiem-starttime)<100);
    }
    private void generic(int i) throws IOException, Exception {
        List<String> input = readInput(i);
        String output = readOutput(i);
        DNASequencer sequencer = new DNASequencer();
        String response = sequencer.calculate(input);
        Assert.assertEquals(response, output);
    }

    private List<String> readInput(int testNumber){
        List<String> lines = readFile(testNumber, "input");
        return lines;
    }

    private String readOutput(int testNumber){
        List<String> lines = readFile(testNumber, "output");
        return lines.get(0);
    }

    public List<String> readFile(int testNumber, String type){
        String fileName = "test_case<testNumber>_<type>";
        fileName = fileName.replace("<testNumber>", Integer.toString(testNumber));
        fileName = fileName.replace("<type>", type);
        InputStream is = getClass().getClassLoader().getResourceAsStream(fileName);
        Scanner scan = new Scanner(is);
        List<String> lines = new ArrayList<String>();
        while(scan.hasNextLine()) {
            String line = scan.nextLine();
            lines.add(line);
        }
        return lines;
    }
}