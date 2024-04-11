import java.io.*;
import java.util.Scanner;

public class AnalysisTestCode
{
    public static void main(String[] args) throws IOException
    {
        String file1 = "covidSequenceRF1.csv";
        String file2 = "covidSequenceRF2.csv";
        String file3 = "covidSequenceRF3.csv";

        Scanner kbd = new Scanner(System.in);
        PrintWriter outFile = new PrintWriter("OutputFile.txt");
        
        System.out.print("Enter the genome sequence (1, 2, 3): ");
        int genomeSequence = kbd.nextInt();

        // Switch for different RFs, im still brainstorming
        switch (genomeSequence)
        {
            case 1:
            File RF1 = new File(file1);
            Scanner infile1 = new Scanner(RF1);
            break;

            case 2:
            File RF2 = new File(file2);
            Scanner infile2 = new Scanner(RF2);
            break;

            default:
            File RF3 = new File(file3);
            Scanner infile3 = new Scanner(RF3);
        }
    }
}
// test