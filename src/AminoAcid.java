import java.util.ArrayList;

public class AminoAcid
{
    private final String fullName;
    private final String abbreviation;
    private final ArrayList<String> codons;

    public AminoAcid(String fullName, String abbreviation, ArrayList<String> codons)
    {
        this.fullName = fullName;
        this.abbreviation = abbreviation;
        this.codons = codons;
    }

    // GETTERS
    public String getFullName()
    {
        return fullName;
    }

    public String getAbbreviation()
    {
        return abbreviation;
    }

    public ArrayList<String> getCodons()
    {
        return codons;
    }

    @Override
    public String toString()
    {
        return "The codons for " + fullName + "(" + abbreviation + ")" + " are: " + String.join(" ", codons);
    }

//    public boolean equals(AminoAcid aminoAcidTest)
//    {
//        return this.fullName == aminoAcidTest.fullName
//                && this.abbreviation == aminoAcidTest.abbreviation
//                && this.codons == aminoAcidTest.codons;
//    }
//
//    public AminoAcid clone()
//    {
//        return new AminoAcid(fullName, abbreviation, codons);
//    }
}