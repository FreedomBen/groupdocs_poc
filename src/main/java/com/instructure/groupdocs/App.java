package com.instructure.groupdocs;

import com.groupdocs.conversion.config.ConversionConfig;
import com.groupdocs.conversion.converter.option.OutputType;
import com.groupdocs.conversion.converter.option.PdfSaveOptions;
import com.groupdocs.conversion.handler.ConversionHandler;

/**
 * Created by ben on 1/19/17.
 */
public class App {
    /*
     * For more examples,
     * https://github.com/groupdocs-conversion/GroupDocs.Conversion-for-Java/blob/master/Examples/GroupDocs.Conversion.Examples.Java/src/main/java/com/groupdocs/conversion/examples/Conversion.java#L312
     * may be helpful
     */

    public static String storagePath = "/home/ben/groupdocs/storage";
    public static String outputPath = "/home/ben/groupdocs/output";
    public static String cachePath = "/home/ben/groupdocs/cache";

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
        // Instantiating the conversion handler
        ConversionHandler conversionHandler = new ConversionHandler(getConfiguration());
        PdfSaveOptions saveOption = new PdfSaveOptions();
        saveOption.setOutputType(OutputType.String);

        // return the path of the converted document
        return conversionHandler.<String> convert(fileName, saveOption);
    }

    public static void main(String[] args) {
        try {
            System.out.println("Beginning conversion of " + args[0]);
            convertToPdfAsFilePath(args[0]);
        } catch(java.io.IOException ex) {
            ex.printStackTrace();
            System.err.println("Oh noes!  Error with the conversion");
            System.exit(1);
        }
    }
}

