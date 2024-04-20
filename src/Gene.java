import java.util.ArrayList;

public class Gene
{
    private final String aminoAcidSequence;
    private final int startPosition;
    private final int endPosition;
    private final int geneLength;

    public Gene(ArrayList<String> aminoAcidSequence, int startPosition, int endPosition, int geneLength)
    {
        this.aminoAcidSequence = codonToLetter(aminoAcidSequence);
        this.startPosition = startPosition;
        this.endPosition = endPosition;
        this.geneLength = geneLength;
    }

    // GETTERS
    public String getAminoAcidSequence()
    {
        return aminoAcidSequence;
    }

    public int getStartPosition()
    {
        return startPosition;
    }

    public int getEndPosition()
    {
        return endPosition;
    }

    public int getGeneLength()
    {
        return geneLength;
    }

    public static String codonToLetter(ArrayList<String> aminoAcidCodon)
    {
        String aminoAcidSingleLetters = "";
        for(String s: aminoAcidCodon)
        {
            switch (s)
            {
                case "GCT":
                case "GCC":
                case "GCA":
                case "GCG":
                    aminoAcidSingleLetters += "A";
                    break;
                case "CGT":
                case "CGC":
                case "CGA":
                case "CGG":
                case "AGA":
                case "AGG":
                    aminoAcidSingleLetters += "R";
                    break;
                case "AAT":
                case "AAC":
                    aminoAcidSingleLetters += "N";
                    break;
                case "GAT":
                case "GAC":
                    aminoAcidSingleLetters += "D";
                    break;
                case "TGT":
                case "TGC":
                    aminoAcidSingleLetters += "C";
                    break;
                case "CAA":
                case "CAG":
                    aminoAcidSingleLetters += "Q";
                    break;
                case "GAA":
                case "GAG":
                    aminoAcidSingleLetters += "E";
                    break;
                case "GGT":
                case "GGC":
                case "GGA":
                case "GGG":
                    aminoAcidSingleLetters += "G";
                    break;
                case "CAT":
                case "CAC":
                    aminoAcidSingleLetters += "H";
                    break;
                case "ATT":
                case "ATC":
                case "ATA":
                    aminoAcidSingleLetters += "I";
                    break;
                case "TTA":
                case "TTG":
                case "CTT":
                case "CTC":
                case "CTA":
                case "CTG":
                    aminoAcidSingleLetters += "L";
                    break;
                case "AAA":
                case "AAG":
                    aminoAcidSingleLetters += "K";
                    break;
                case "ATG":
                    aminoAcidSingleLetters += "M";
                    break;
                case "TTT":
                case "TTC":
                    aminoAcidSingleLetters += "F";
                    break;
                case "CCT":
                case "CCC":
                case "CCA":
                case "CCG":
                    aminoAcidSingleLetters += "P";
                    break;
                case "TCT":
                case "TCC":
                case "TCA":
                case "TCG":
                case "AGT":
                case "AGC":
                    aminoAcidSingleLetters += "S";
                    break;
                case "ACT":
                case "ACC":
                case "ACA":
                case "ACG":
                    aminoAcidSingleLetters += "T";
                    break;
                case "TGG":
                    aminoAcidSingleLetters += "W";
                    break;
                case "TAT":
                case "TAC":
                    aminoAcidSingleLetters += "Y";
                    break;
                case "GTT":
                case "GTC":
                case "GTA":
                case "GTG":
                    aminoAcidSingleLetters += "V";
                    break;
                case "TAG":
                case "TAA":
                case "TGA":
                    aminoAcidSingleLetters += "*";
            }
        }
        return aminoAcidSingleLetters;
    }

    @Override
    public String toString()
    {
        return "Gene: " + aminoAcidSequence + "\nStart position: " + startPosition + "\nEnd position: " + endPosition;
    }

//    public boolean equals(Gene geneTest)
//    {
//        return this.aminoAcidSequence == geneTest.aminoAcidSequence && this.startPosition == geneTest.startPosition
//                && this.endPosition == geneTest.endPosition && this.geneLength == geneTest.geneLength;
//    }
//
//    public Gene clone()
//    {
//        return new Gene(aminoAcidSequence, startPosition, endPosition, geneLength);
//    }
}
