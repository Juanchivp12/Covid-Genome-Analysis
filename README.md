# Covid-Genome-Analysis
- Perform an analysis on the COVID-19 virus (severe acute respiratory syndrome coronavirus 2 (SARS-CoV-2)).

1. Gene Analysis:

  - Output a report file detailing gene analysis for a specific reading frame.
  - The report includes:
    - Number of amino acids in the gene.
    - Start and stop positions of the gene (by nucleotide number).
    - Amino acid string for the gene.
  - Only genes with at least 50 amino acids are included in the report.

2. Codon Bias Analysis:

  - Users have two options:
    - Generate a complete report file of codon bias for every amino acid in the genome.
      - Data is written to a file; not displayed on the screen.
      - User is informed of the generated file's name.
    - Do a codon bias analysis for a single amino acid.
      - User selects the amino acid (using its one-letter representation).
      - Results include:
      - Full name and one-letter code of the amino acid.
      - Codons coding for that amino acid.
      - Percentage of occurrence of each codon for that amino acid in the genome.
  - Users can analyze multiple amino acids sequentially.
  - The report from the complete codon bias analysis is written to a file before exiting the program.



