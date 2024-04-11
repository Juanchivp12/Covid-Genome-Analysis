import java.util.ArrayList;

public class AminoAcid
{
    // ATTRIBUTES
    private String fullName = " ";
    private String abbreviation = " ";
    private ArrayList<String> codons = new ArrayList<String>();

    // CONSTRUCTORS
    public AminoAcid() {}

    public AminoAcid(String fullName, String abbreviation, ArrayList<String> codons)
    {
        this.fullName = fullName;
        this.abbreviation = abbreviation;
        this.codons = codons;
    }

    // SETTERS
    public void setFullName(String fullName)
    {
        this.fullName = fullName;
    }

    public void setAbbreviation(String abbreviation)
    {
        this.abbreviation = abbreviation;
    }

    public void setCodons(ArrayList<String> codons)
    {
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

    // toString, equals, and clone methods
    public String toString()
    {
        return "";
    }

    public boolean equals(AminoAcid aminoAcidTest)
    {
        return this.fullName == aminoAcidTest.fullName
                && this.abbreviation == aminoAcidTest.abbreviation
                && this.codons == aminoAcidTest.codons;
    }

    public AminoAcid clone()
    {
        return new AminoAcid(fullName, abbreviation, codons);
    }
}
