package enums;

import com.github.javafaker.Faker;

import java.io.File;

public class TestData {
    private static Faker faker = new Faker();
    private static String docName = faker.lorem().sentence(2);
    private static String folderPath = "src/test/java/enums";
    public static Users teacher = new Users("roxanne");

    public static Document document = new Document(docName, folderPath + File.separator + docName);

}
