package com.instructure.groupdocs;

import com.groupdocs.conversion.config.ConversionConfig;
import com.groupdocs.conversion.converter.option.OutputType;
import com.groupdocs.conversion.converter.option.PdfSaveOptions;
import com.groupdocs.conversion.handler.ConversionHandler;

import java.io.*;


/**
 * Created by ben on 1/19/17.
 */
public class App {
    /*
     * For more examples,
     * https://github.com/groupdocs-conversion/GroupDocs.Conversion-for-Java/blob/master/Examples/GroupDocs.Conversion.Examples.Java/src/main/java/com/groupdocs/conversion/examples/Conversion.java#L312
     * may be helpful
     */
    public static String storagePath = "./storage";
    public static String outputPath = "./output";
    public static String cachePath = "./cache";

    public static ConversionConfig getConfiguration() {
        try {
            // Setup Conversion configuration
            ConversionConfig conversionConfig = new ConversionConfig();
            conversionConfig.setStoragePath(storagePath);
            conversionConfig.setOutputPath(outputPath);
            conversionConfig.setCachePath(cachePath);
            conversionConfig.setUseCache(true);
            return conversionConfig;
        } catch (Exception exp) {
            System.out.println("Exception: " + exp.getMessage());
            exp.printStackTrace();
            return null;
        }
    }

    public static String convertToPdfAsFilePath(String fileName) throws java.io.IOException {
        throwUnlessFileExists(fileName);
        // Instantiating the conversion handler
        ConversionHandler conversionHandler = new ConversionHandler(getConfiguration());
        FileInputStream fis = new FileInputStream(fileName);
        PdfSaveOptions saveOption = new PdfSaveOptions();
        saveOption.setOutputType(OutputType.String);

        // return the path of the converted document
        return conversionHandler.<String> convert(fis, fileName, saveOption);
    }

    public static void throwUnlessFileExists(String fileName) throws FileNotFoundException {
        File f = new File(fileName);
        if (!(f.exists() && !f.isDirectory())) {
            throw new FileNotFoundException(fileName);
        }
    }

    public static void main(String[] args) {
        try {
            System.out.println("Beginning conversion of " + args[0]);
            convertToPdfAsFilePath(args[0]);
        } catch(FileNotFoundException ex) {
            System.err.println("Oh no!  It looks like your file doesn't exist :-(");
            System.exit(1);
        } catch(java.lang.ArrayIndexOutOfBoundsException ex) {
            System.err.println("Oh noes!  You gotta pass a filename in bro");
            System.exit(1);
        } catch (java.io.IOException ex) {
            ex.printStackTrace();
            System.err.println("Oh noes!  Error with the conversion");
            System.exit(1);
        }
    }
}
