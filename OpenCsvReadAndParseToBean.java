package annotations;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class OpenCsvReadAndParseToBean {
    private static final String SampleCSVFile = "C:\\Users\\Asus\\OneDrive\\Desktop\\demo1.csv";

    public static void main(String[] args) throws IOException {

        Reader reader = null;
        try {
            reader = Files.newBufferedReader((Paths.get(SampleCSVFile)));

        } finally {
            CsvToBean<CSVUser> csvToBean;

            csvToBean = new CsvToBeanBuilder<CSVUser>(reader)
                    .withType(CSVUser.class)
                    .withIgnoreLeadingWhiteSpace(true).build();

            Iterator<CSVUser> csvUserIterator = csvToBean.iterator();

            while (csvUserIterator.hasNext()) {
                CSVUser csvUser = csvUserIterator.next();
                System.out.println("Name : " + csvUser.getName());
                System.out.println("Email:" + csvUser.getEmail());
                System.out.println("PhoneNo:" + csvUser.getPhoneNo());
                System.out.println("Country:" + csvUser.getCountry());
                System.out.println("============================");
            }


        }


    }
}
