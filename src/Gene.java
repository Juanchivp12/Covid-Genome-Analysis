/**
 * This class represents a gene with its amino acid sequence, start and end nucleotide positions, and gene length.
 * COSC-1437.200
 * @author Juan Villegas
 * @author Zander Tashman
 * @author Brian Pak
 */

import java.util.ArrayList;

public class Gene
{
    private String aminoAcidSequence;
    private int startNucleotide;
    private int endNucleotide;
    private int geneLength;

    public Gene()
    {
        this.aminoAcidSequence = "N/A";
        this.startNucleotide = 0;
        this.endNucleotide = 0;
        this.geneLength = 0;
    }

    /**
     * Constructs a Gene object with the given amino acid sequence, start and end nucleotide positions, and gene length.
     * @param aminoAcidSequence the amino acid sequence of the gene
     * @param startNucleotide the start nucleotide position of the gene
     * @param endNucleotide the end nucleotide position of the gene
     * @param geneLength the length of the gene
     */
    public Gene(ArrayList<String> aminoAcidSequence, int startNucleotide, int endNucleotide, int geneLength)
    {
        this.aminoAcidSequence = codonToLetter(aminoAcidSequence);
        this.startNucleotide = startNucleotide;
        this.endNucleotide = endNucleotide;
        this.geneLength = geneLength;
    }

    // SETTERS
    public void setAminoAcidSequence(String aminoAcidSequence)
    {
        this.aminoAcidSequence = aminoAcidSequence;
    }

    public void setStartNucleotide(int startNucleotide)
    {
        this.startNucleotide = startNucleotide;
    }

    public void setEndNucleotide(int endNucleotide)
    {
        this.endNucleotide = endNucleotide;
    }

    public void setGeneLength(int geneLength)
    {
        this.geneLength = geneLength;
    }

    // GETTERS
    public String getAminoAcidSequence()
    {
        return aminoAcidSequence;
    }

    public int getStartNucleotide()
    {
        return startNucleotide;
    }

    public int getEndNucleotide()
    {
        return endNucleotide;
    }

    public int getGeneLength()
    {
        return geneLength;
    }

    /**
     * Converts codons to single-letter amino acid codes.
     * @param aminoAcidCodon the list of codons to be converted
     * @return the amino acid sequence represented by single-letter codes
     */
    public static String codonToLetter(ArrayList<String> aminoAcidCodon)
    {
        String aminoAcidSingleLetters = "";
        for(String s: aminoAcidCodon)
        {
            switch (s)
            {
                case "GCT": case "GCC": case "GCA": case "GCG":
                    aminoAcidSingleLetters += "A"; break;

                case "CGT": case "CGC": case "CGA": case "CGG": case "AGA": case "AGG":
                    aminoAcidSingleLetters += "R"; break;

                case "AAT": case "AAC":
                    aminoAcidSingleLetters += "N"; break;

                case "GAT": case "GAC":
                    aminoAcidSingleLetters += "D"; break;

                case "TGT": case "TGC":
                    aminoAcidSingleLetters += "C"; break;

                case "CAA": case "CAG":
                    aminoAcidSingleLetters += "Q"; break;

                case "GAA": case "GAG":
                    aminoAcidSingleLetters += "E"; break;

                case "GGT": case "GGC": case "GGA": case "GGG":
                    aminoAcidSingleLetters += "G"; break;

                case "CAT": case "CAC":
                    aminoAcidSingleLetters += "H"; break;

                case "ATT": case "ATC": case "ATA":
                    aminoAcidSingleLetters += "I"; break;

                case "TTA": case "TTG": case "CTT": case "CTC": case "CTA": case "CTG":
                    aminoAcidSingleLetters += "L"; break;

                case "AAA": case "AAG":
                    aminoAcidSingleLetters += "K"; break;

                case "ATG":
                    aminoAcidSingleLetters += "M"; break;

                case "TTT": case "TTC":
                    aminoAcidSingleLetters += "F"; break;

                case "CCT": case "CCC": case "CCA": case "CCG":
                    aminoAcidSingleLetters += "P"; break;

                case "TCT": case "TCC": case "TCA": case "TCG": case "AGT": case "AGC":
                    aminoAcidSingleLetters += "S"; break;

                case "ACT": case "ACC": case "ACA": case "ACG":
                    aminoAcidSingleLetters += "T"; break;

                case "TGG":
                    aminoAcidSingleLetters += "W"; break;

                case "TAT": case "TAC":
                    aminoAcidSingleLetters += "Y"; break;

                case "GTT": case "GTC": case "GTA": case "GTG":
                    aminoAcidSingleLetters += "V"; break;

                case "TAG": case "TAA": case "TGA":
                    aminoAcidSingleLetters += "*"; break;
                default:
                    aminoAcidSingleLetters += "?";
            }
        }
        return aminoAcidSingleLetters;
    }

    /**
     * Returns a string representation of the gene, including its amino acid sequence and nucleotide positions.
     * @return a string representation of the gene
     */
    @Override
    public String toString()
    {
        return "Gene: " + aminoAcidSequence + "\nStart position: " + startNucleotide + "\nEnd position: " + endNucleotide;
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     * Genes are considered equal if they have the same amino acid sequence, start and end nucleotide positions, and gene length.
     * @param geneTest the reference object with which to compare
     * @return true if this object is the same as the obj argument; false otherwise
     */
    public boolean equals(Gene geneTest)
    {
        return this.aminoAcidSequence == geneTest.aminoAcidSequence
                && this.startNucleotide == geneTest.startNucleotide
                && this.endNucleotide == geneTest.endNucleotide
                && this.geneLength == geneTest.geneLength;
    }

    /**
     * Creates and returns a copy of this object.
     * @return a clone of this instance
     */
    public Gene clone()
    {
        ArrayList<String> clonedAminoAcidSequence = new ArrayList<>(Integer.parseInt(this.aminoAcidSequence));
        return new Gene(clonedAminoAcidSequence, startNucleotide, endNucleotide, geneLength);
    }
}