package annotations;

import com.google.gson.Gson;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class OpenCsvAndGsonTester {
    private static final String SampleCSVFile = "C:\\Users\\Asus\\OneDrive\\Desktop\\demo1.csv";
    private static final String SampleJsonFile = "C:\\Users\\Asus\\IdeaProjects\\Annotations,CsvAndGson\\src\\main\\java\\annotations\\users.json";


    public static void main(String[] args) {
        try{
            Reader reader = Files.newBufferedReader(Paths.get(SampleCSVFile));
            CsvToBeanBuilder<CSVUser> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
            csvToBeanBuilder.withType(CSVUser.class);
            csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
            CsvToBean<CSVUser> csvToBean = csvToBeanBuilder.build();
            List<CSVUser> csvUsers = csvToBean.parse();
            Gson gson = new Gson();
            String json = gson.toJson(csvUsers);
            FileWriter writer = new FileWriter((SampleJsonFile));
            writer.write(json);
            writer.close();
            BufferedReader br = new BufferedReader((new FileReader(SampleJsonFile)));
            CSVUser[] useObj = gson.fromJson(br, CSVUser[].class);
            List<CSVUser> csvUserList = Arrays.asList(useObj);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
