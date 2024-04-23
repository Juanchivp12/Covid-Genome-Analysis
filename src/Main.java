/**
 * This class implements a program for analyzing Covid-19 genome sequences.
 * COSC-1437.200
 * @author Juan Villegas
 * @author Zander Tashman
 * @author Brian Pak
 */

import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        Scanner kbd = new Scanner(System.in);
        String readingFrameFile = "";

        // User chooses file
        System.out.println("****Covid-19 Genome Analysis****");
        System.out.print("Which reading frame would you like to analyze? (1, 2, or 3) ");
        int readingFrame = kbd.nextInt();
        System.out.println();

        readingFrameFile = switch (readingFrame)
        {
            case 1 -> "covidSequenceRF1.csv";
            case 2 -> "covidSequenceRF2.csv";
            case 3 -> "covidSequenceRF3.csv";
            default -> readingFrameFile;
        };

        // User chooses an analysis
        System.out.println("Which action would you like to perform?");
        System.out.println(" 1. Gene Analysis Report");
        System.out.print(" 2. Codon Bias Analysis ");

        int analysisChoice = kbd.nextInt();
        System.out.println();
        int codonBiasChoice = 0;

        if (analysisChoice == 2)
        {
            System.out.println("Which of these would you like to do?");
            System.out.println(" 1. Complete Amino Acid Codon Bias Report");
            System.out.print(" 2. Individual Amino Acid Codon Bias Analysis ");
            codonBiasChoice = kbd.nextInt();
            System.out.println();
        }

        // Read in file and tokenize the string into codons
        File file = new File(readingFrameFile);
        Scanner infile = new Scanner(file);
        String str = "";

        while (infile.hasNext())
        {
            str = infile.nextLine();
        }
        infile.close();

        // Makes an array list of genes
        ArrayList<Gene> geneSequences = new ArrayList<>();
        if (analysisChoice == 1)
        {
            // Read token array until start codon is read
            readTokens(geneSequences, str);

            // Prints gene information
            printGenomeSequence(geneSequences, readingFrameFile);

        }
        else if (analysisChoice == 2 && codonBiasChoice == 1)
        {
            String completeCodonBiasAnalysisFile = "completeCodonBiasAnalysis.txt";
            PrintWriter outfile = new PrintWriter(completeCodonBiasAnalysisFile);
            outfile.println("*********** Complete Codon Bias Report **********\n");

            ArrayList<AminoAcid> aminoAcidList = readFromAminoAcidTable();

            for (AminoAcid aminoAcid : aminoAcidList)
            {
                outfile.println(aminoAcid.toString());
                codonBiasAnalysis(readingFrameFile, aminoAcid.getCodons(), codonBiasChoice, outfile);
                outfile.println();
            }
            outfile.close();
            System.out.println("\nCodon bias analysis has been written to " + completeCodonBiasAnalysisFile);
        }
        else if (analysisChoice == 2 && codonBiasChoice == 2)
        {
            lookForAcidFromList(readingFrameFile, codonBiasChoice);
        }
        else
        {
            System.out.println("At least one invalid choice was made.");
        }
    }

    /**
     * This method reads tokens from a string and creates gene sequences.
     * @param geneSequences the list to store gene sequences
     * @param str the string to tokenize
     */
    public static void readTokens(ArrayList<Gene> geneSequences, String str)
    {
        String[] tokens = str.split(",");
        int endPosition = 0;

        for (int i = 0; i < tokens.length; i++)
        {
            if (tokens[i].equals("ATG"))
            {
                // Once a start codon is read, an array list of codons in created
                ArrayList<String> aminoAcidSequence = new ArrayList<>();
                int startPosition = i;
                aminoAcidSequence.add("ATG");

                // Each codon is added to the array list until a stop codon is reached
                for (i = startPosition + 1; i < tokens.length; i++)
                {
                    aminoAcidSequence.add(tokens[i]);
                    if (tokens[i].equals("TAG") || tokens[i].equals("TGA") || tokens[i].equals("TAA"))
                    {
                        endPosition = i;

                        // Once a stop codon is reached, the loop stops adding codons to the array list
                        break;
                    }
                }

                // Checks for the gene length to be greater than or equal to 50
                if (endPosition - startPosition >= 50)
                {
                    // Calculates gene length, start nucleotide, and stop nucleotide
                    int geneLength = endPosition - startPosition + 1;
                    int startNucleotide = startPosition * 3;
                    int endNucleotide = startNucleotide + (geneLength * 3);

                    // Adds a new gene of the previously found information into the first array list made
                    geneSequences.add(new Gene(aminoAcidSequence, startNucleotide, endNucleotide, geneLength));
                }
            }
        }
    }

    /**
     * This method prints the genome sequence.
     * @param geneSequences the list of gene sequences
     * @param readingFrameFile the reading frame file
     */
    public static void printGenomeSequence(ArrayList<Gene> geneSequences, String readingFrameFile) throws IOException
    {
        String geneSequenceFile = "geneSequence.txt";
        PrintWriter outfile = new PrintWriter(geneSequenceFile);
        outfile.println("** Gene analysis for file: " + readingFrameFile + " **\n");

        int geneIndex = 1;
        for (Gene g : geneSequences)
        {
            outfile.println("Gene " + geneIndex + " (" + g.getGeneLength() + ") :");
            outfile.println(g.getStartNucleotide() + ".." + g.getEndNucleotide());
            outfile.print("Sequence: ");
            outfile.println(g.getAminoAcidSequence());
            outfile.println();
            geneIndex++;
        }
        outfile.close();
        System.out.println("Genome sequence information has been written to " + geneSequenceFile);
    }

    /**
     * This method makes an array of AminoAcids using the aminoAcidTable file
     * @return the array list of amino acids
     * @throws IOException if an I/O error occurs
     */
    public static ArrayList<AminoAcid> readFromAminoAcidTable() throws IOException
    {
        File file = new File("aminoAcidTable.csv");
        Scanner infile = new Scanner(file);

        // Skip first line of the file
        infile.nextLine();

        ArrayList<AminoAcid> acidList = new ArrayList<>();

        while (infile.hasNext())
        {
            // Read items from file and extract tokens
            String str = infile.nextLine();
            String[] tokens = str.split(",");

            // Assign variables the values of tokens at specific positions
            String name = tokens[0];
            String abbreviation = tokens[2];

            // Make an array list for codons and read them from file and add them to it
            ArrayList<String> codons = new ArrayList<>();
            for (int i = 3; i < tokens.length; i++)
            {
                codons.add(tokens[i]);
            }

            // Make an instance of the AminoAcid class and add information from aminoAcidTable file
            acidList.add(new AminoAcid(name, abbreviation, codons));
        }
        infile.close();
        return acidList;
    }

    /**
     * This method asks the user to enter a letter and prints out the amino acid that contains that letter
     * @param readingFrameFile the reading frame file from which to read the amino acid table
     * @param codonBiasChoice the choice made by the user
     * @throws IOException if an I/O error occurs
     */
    public static void lookForAcidFromList(String readingFrameFile, int codonBiasChoice) throws IOException
    {
        ArrayList<AminoAcid> aminoAcidList = readFromAminoAcidTable();
        Scanner kbd = new Scanner(System.in);
        String aminoAcidLetter;

        do {
        System.out.print("Which Amino Acid would you like to see? (Enter its one letter abbreviation (Type 0 to quit)) ");
        aminoAcidLetter = kbd.nextLine().toUpperCase();
        System.out.println();

        for (AminoAcid aminoAcid : aminoAcidList)
        {
            if (aminoAcidLetter.equals(aminoAcid.getAbbreviation()))
            {
                System.out.println(aminoAcid);
                codonBiasAnalysis(readingFrameFile, aminoAcid.getCodons(), codonBiasChoice, null);
            }
        }
        System.out.println();
        } while (!aminoAcidLetter.equals("-1"));
    }

    /**
     * This method reads the codons from a file chosen by the user and adds each codon into an array list
     * @param readingFrameFile the reading frame file
     * @return codonsFromFile the array list of codons
     * @throws IOException if an I/O error occurs
     */
    public static ArrayList<String> readCodonsFromFile(String readingFrameFile) throws IOException
    {
        ArrayList<String> codonsFromFile = new ArrayList<>();
        File file = new File(readingFrameFile);
        Scanner infile = new Scanner(file);

        while (infile.hasNext())
        {
            String str = infile.nextLine();
            String[] tokens = str.split(",");

            for (String s : tokens)
            {
                codonsFromFile.add(s);
            }
        }
        infile.close();

        return codonsFromFile;
    }

    /**
     * This method performs codon bias analysis and writes the output to a file.
     * @param readingFrameFile the reading frame file
     * @param codons the list of codons
     * @param codonBiasChoice the choice made by the user
     * @throws IOException if an I/O error occurs
     */
    public static void codonBiasAnalysis(String readingFrameFile, ArrayList<String> codons, int codonBiasChoice, PrintWriter outfile) throws IOException
    {
        ArrayList<String> codonsFromFile = readCodonsFromFile(readingFrameFile);

        // Initialize arrays to store counts and percentages for each codon
        int[] codonCounts = new int[codons.size()];
        double[] codonPercentages = new double[codons.size()];

        // Initialize a variable to count the total number of codons
        int totalCount = 0;

        // Count occurrences of each codon
        if (codonBiasChoice == 1)
        {
            for (String codon : codonsFromFile)
            {
                int index = codons.indexOf(codon);
                if (index != -1)
                {
                    codonCounts[index]++;
                    totalCount++;
                }
            }
            // Output the complete codon bias report and iterate over each codon for the current amino acid
            for (int i = 0; i < codons.size(); i++)
            {
                int count = codonCounts[i];
                double percentage = ((double) count / totalCount) * 100;
                codonPercentages[i] = percentage;
                outfile.printf("%s: %d %.2f%%\n", codons.get(i), count, percentage);
            }
        }
        else
        {
            for (String codon : codonsFromFile)
            {
                int index = codons.indexOf(codon);
                codonCounts[index]++;
                totalCount++;
            }
        }
    }
}