/**
 * This class represents an amino acid with its full name, abbreviation, and associated codons.
 * COSC-1437.200
 * @author Juan Villegas
 * @author Zander Tashman
 * @author Brian Pak
 */

import java.util.ArrayList;

public class AminoAcid
{
    private String fullName;
    private String abbreviation;
    private ArrayList<String> codons;

    public AminoAcid()
    {
        this.fullName = "N/A";
        this.abbreviation = "N/A";
        this.codons = new ArrayList<>();
    }

    /**
     * Constructs an AminoAcid object with the given full name, abbreviation, and codons.
     * @param fullName the full name of the amino acid
     * @param abbreviation the abbreviation of the amino acid
     * @param codons the list of codons associated with the amino acid
     */
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

    /**
     * Returns a string representation of the amino acid, including its full name, abbreviation, and codons.
     * @return a string representation of the amino acid
     */
    @Override
    public String toString()
    {
        return "The codons for " + fullName + "(" + abbreviation + ")" + " are: " + String.join(" ", codons);
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     * Amino acids are considered equal if they have the same full name, abbreviation, and codons.
     * @param aminoAcidTest the reference object with which to compare
     * @return true if this object is the same as the obj argument; false otherwise
     */
    public boolean equals(AminoAcid aminoAcidTest)
    {
        return this.fullName == aminoAcidTest.fullName
                && this.abbreviation == aminoAcidTest.abbreviation
                && this.codons == aminoAcidTest.codons;
    }


    /**
     * Creates and returns a copy of this object.
     * @return a clone of this instance
     */
    public AminoAcid clone()
    {
        return new AminoAcid(fullName, abbreviation, codons);
    }
}