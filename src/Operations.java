import java.io.*;
import java.util.ArrayList;

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

    public static ArrayList<Patient> listRecords() throws IOException {
        reader = new BufferedReader(new FileReader(DB));
        ArrayList<Patient> patients = new ArrayList<Patient>();
        String line = "";
        while((line = reader.readLine()) != null) {
            Patient patient = parsePatient(line);
            patients.add(patient);
        }
        reader.close();
        return patients;
    }

    private static Patient parsePatient(String line) {
        String[] parts = line.split(",");
        return new Patient(parts[0], parts[1], Integer.valueOf(parts[2]), parts[3], parts[4]);
    }
}
