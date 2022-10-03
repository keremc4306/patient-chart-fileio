import java.io.*;

public class Operations {
    private static final File DB = new File("patients.txt");

    private static BufferedReader reader;
    private static BufferedWriter writer;

    static {
        if (!DB.exists()) {
            try {
                DB.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void save(Patient patient) throws IOException {
        writer = new BufferedWriter(new FileWriter(DB, true));
        writer.write(patient + "\n");
        writer.close();
    }
}
