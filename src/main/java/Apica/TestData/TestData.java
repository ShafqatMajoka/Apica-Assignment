package Apica.TestData;

public class TestData {
    private Random random;

    public TestData() {
        random = new Random();
    }

    public String getUserName() {
        return random.randomString() + "@" + random.randomString() + ".com";
    }

    public String getFullName() {
        return random.randomString() + " " + random.randomString();
    }

    public String getPassword() {
        return random.randomString();
    }
}