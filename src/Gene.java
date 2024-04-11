public class Gene
{
    // ATTRIBUTES
    private String aminoAcidSequence= " ";
    private int startPosition = 0;
    private int endPosition = 0;
    private int geneLength = 0;

    // CONSTRUCTORS
    public Gene() {}

    public Gene(String aminoAcidSequence, int startPosition, int endPosition, int geneLength)
    {
        this.aminoAcidSequence = aminoAcidSequence;
        this.startPosition = startPosition;
        this.endPosition = endPosition;
        this.geneLength = geneLength;
    }

    // SETTERS
    public void setAminoAcidSequence(String aminoAcidSequence)
    {
        this.aminoAcidSequence = aminoAcidSequence;
    }

    public void setStartPosition(int startPosition)
    {
        this.startPosition = startPosition;
    }

    public void setEndPosition(int endPosition)
    {
        this.endPosition = endPosition;
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

    // toString, equals, and clone methods
    public String toString()
    {
        return "";
    }

    public boolean equals(Gene geneTest)
    {
        return this.aminoAcidSequence == geneTest.aminoAcidSequence && this.startPosition == geneTest.startPosition
                && this.endPosition == geneTest.endPosition && this.geneLength == geneTest.geneLength;
    }

    public Gene clone()
    {
        return new Gene(aminoAcidSequence, startPosition, endPosition, geneLength);
    }
}
