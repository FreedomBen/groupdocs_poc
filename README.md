# GroupDocs Evaluation

## Requirements
1.  Java SDK 1.8
2.  Maven 3.3.9

## Compilation
From project root directory: `mvn package`

## Running Conversion
From project root directory for a single file you can run:

```bash
java -jar target/GroupDocs-1.0-SNAPSHOT.jar {input doc}
```

\*Note that input doc MUST BE A RELATIVE PATH

If you put all your input files into a directory called 'inputs' then you can run the script:

```bash
./convert_the_things.sh
```

You probably want to compensate for a bug in groupdocs that outputs the png files with windows
paths instead of platform dependent paths (i.e. the `/` on \*nix systems and `\` on windows
systems) by running the supplied fix-up script:

```bash
./fix_png_filenames.rb
```
