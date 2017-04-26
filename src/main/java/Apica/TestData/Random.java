package Apica.TestData;

class Random {
    private final java.util.Random random = new java.util.Random();

    public String randomString() {
        StringBuilder sb = new StringBuilder(7);
        for (int i = 0; i < 7; i++) {
            String chars = "abcdefghijklmnopqrstuvwxyz";
            sb.append(chars.charAt(random.nextInt(chars.length())));
        }
        return sb.toString();
    }
}
