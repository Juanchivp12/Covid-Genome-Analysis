import java.io.*;
import java.util.Scanner;

public class AnalysisTestCode
{
    public static void main(String[] args) throws IOException
    {   
        Scanner kbd = new Scanner(System.in);
        File[] files = new File[3];
        PrintWriter outFile = new PrintWriter("OutputFile.txt");

        // Maybe make an array of files containing all 3 csv's? not sure
        files[0] = new File("covidSequenceRF1.csv");
        files[1] = new File("covidSequenceRF2.csv");
        files[2] = new File("covidSequenceRF3.csv");
        
        System.out.print("Enter the genome sequence: ");
        String genomeSequence = kbd.nextLine().toUpperCase(); // something like this is going to be needed to get user input
    }

}
