package annotations;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class OpenCSVReader {
    private static final String SampleCSVFile = "C:\\Users\\Asus\\OneDrive\\Desktop\\democsv.csv";


    public static void main(String[] args) throws IOException, CsvValidationException {
        CSVReader csvReader = null;
        try {
            Reader reader = Files.newBufferedReader(Paths.get(SampleCSVFile));
            csvReader = new CSVReader(reader);
        } finally
        {
            //Reading records one by one in string array
            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null){
                {
                    System.out.println("Name:" + nextRecord[0]);
                    System.out.println("Email:" + nextRecord[1]);
                    System.out.println("Phone:" + nextRecord[2]);
                    System.out.println("Country:" + nextRecord[3]);
                    System.out.println("=========================");

                }
            }


        }
    }
}
