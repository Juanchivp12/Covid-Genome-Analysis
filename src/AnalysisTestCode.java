// file for code testing
// Not sure how many class files we need to make yet
import java.io.*;
import java.util.Scanner;

public class AnalysisTestCode
{
    public static void main(String[] args) throws IOException
    {
        // Maybe make an array of files containing all 3 csv's?
        File[] files = new File[3];
        files[0] = new File("covidSequenceRF1.csv");
        files[1] = new File("covidSequenceRF2.csv");
        files[2] = new File("covidSequenceRF3.csv");
    }
}