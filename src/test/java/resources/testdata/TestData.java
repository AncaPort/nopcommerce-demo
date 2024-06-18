package resources.testdata;


import org.testng.annotations.DataProvider;

public class TestData {
    @DataProvider(name = "invalidCredentials")
    public Object[][] getInvalidCredentials() {
        Object[][] invalidData = new Object[][]{
                {"exam@gmail.com", "exam321"},
        };
        return invalidData;
    }

    @DataProvider(name = "validCredentials")
    public Object[][] getValidCredentialsData() {
        Object[][] validData = new Object[][]{
                {"prime123@gmail.com", "prime123"},
        };
        return validData;
    }

    @DataProvider(name = "registrationData")
    public Object[][] getRegistrationData() {
        Object[][] regisData = new Object[][]{
                {"Female", "Prime", "testing", "01", "12", "2000", "ptesting02@gmail.com", "prime124", "prime124"},
        };
        return regisData;
    }

    @DataProvider(name = "buildComData")
    public Object[][] getBuildComData() {
        Object[][] data = new Object[][]{
                {"2.2 GHz Intel Pentium Dual-Core E2200", "2 GB", "320 GB", "Vista Home [+$50.00]", "Microsoft Office [+$50.00]"},
                {"2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]", "4GB [+$20.00]", "400 GB [+$100.00]", "Vista Premium [+$60.00]", "Acrobat Reader [+$10.00]"},
                {"2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]", "8GB [+$60.00]", "320 GB", "Vista Home [+$50.00]", "Total Commander [+$5.00]"},
        };
        return data;
    }

}
