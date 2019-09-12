package WebUIAutomation.Config;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static String alreadyRegisterUserName;
    private static String alreadyRegisterPassword;
    private static String incorrectPassword;
    private static String newUserName;
    private static String newName;
    private static String newAccountNumber;
    private static String newPassword;
    private static String newPassword2;


    public static void loadData()
    {
        //Declare a properties object
        Properties prop = new Properties();

        try {
            //Read config.properties file
            InputStream input = new FileInputStream("C:\\Users\\Luisa_Fernanda_Munoz\\Documents\\Mentoring\\TAM-2019\\src\\WebUIAutomation\\config.properties");

            //Get properties from configuration.properties
            prop.load(input);
            alreadyRegisterUserName = prop.getProperty("alreadyRegisterUserName");
            alreadyRegisterPassword = prop.getProperty("alreadyRegisterPassword");
            incorrectPassword = prop.getProperty("incorrectPassword");

            newUserName = prop.getProperty("newUserName");
            newName = prop.getProperty("newName");
            newAccountNumber = prop.getProperty("newAccountNumber");
            newPassword = prop.getProperty("newPassword");
            newPassword2 = prop.getProperty("newPassword2");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getAlreadyRegisterUserName() {
        return alreadyRegisterUserName;
    }

    public static String getAlreadyRegisterPassword() {
        return alreadyRegisterPassword;
    }

    public static String getIncorrectPassword() {
        return incorrectPassword;
    }

    public static String getNewUserName() {
        return newUserName;
    }

    public static String getNewName() {
        return newName;
    }

    public static String getNewAccountNumber() {
        return newAccountNumber;
    }

    public static String getNewPassword() {
        return newPassword;
    }

    public static String getNewPassword2() {
        return newPassword2;
    }
}
