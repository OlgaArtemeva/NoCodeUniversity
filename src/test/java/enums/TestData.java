package enums;

import com.github.javafaker.Faker;

import java.io.File;

public class TestData {
    private static Faker faker = new Faker();
    private static String docName = faker.lorem().sentence(2);
    private static String folderPath = "src/test/java/enums";
    private static String folderPath = "Users/olgaartemeva/Documents/Olga/MyProject/ProjectQAForGitHub/NoCodeUniversity/src/test/resources";
    public static Users teacher = new Users("roxanne");

    public static Document document = new Document(docName, folderPath + File.separator + docName + ".txt");

}
