package Jsoup_crawler;


import Jsoup_crawler.exception.InvalidCrawlerException;
import Jsoup_crawler.exception.InvalidParametersCombinationException;
import Jsoup_crawler.exception.UnknownParametersException;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;



public class ArgumentParser {


//    parameters for TextProcesses

    @Parameter(names = "-p", description = "Paragraph crawler")
    private static boolean paragraph = false;

    //    file parameters
    @Parameter(names = "-input", description = "Input file")
    private static String inputFile = "";

    @Parameter(names = "-print", description = "Print text")
    private static boolean printText = false;

    @Parameter(names = "-newFile", description = "Create new file")
    private static String newFile = "";

    //  Jcommander instance
    public ArgumentParser(String[] args) throws InvalidParametersCombinationException, UnknownParametersException {
        JCommander jCommander = JCommander.newBuilder()
                .addObject(this)
                .build();
        try {
            jCommander.parse(args);

        }
        catch (ParameterException e) {
            throw new UnknownParametersException("Chyba: Zadane parametre neexistuju");
        }
    }

/*

    public String processCrawling(String text) throws InvalidCrawlerException {
        try{
            if (this.isParagraph()) {


            } else {
                return null;
            }
        }

        catch (Exception e) {
            throw new InvalidCrawlerException("Chyba: Funkcia processCrawling nemože spracovať dany process");
        }
    }


*/




    //  functions
    public static String getNewFileName() { return newFile;}



    public static boolean isParagraph() {
        return paragraph;
    }


    public static String getInputFile() {
        return inputFile;
    }
    public static boolean isPrintText() {
        return printText;
    }



}


