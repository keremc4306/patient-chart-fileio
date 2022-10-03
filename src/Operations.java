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
        return new Patient(Integer.valueOf(parts[0]),
                parts[1], parts[2], Integer.valueOf(parts[3]), parts[4], parts[5]);
    }

    public static Patient getById(int id) throws IOException {
        ArrayList<Patient> patientList = Operations.listRecords();
        for(Patient patient : patientList) {
            if (patient.getId() == id) {
                return patient;
            }
        }
        return null;
    }

    public static void update(int id, Patient updated) throws IOException {
        ArrayList<Patient> patientList = Operations.listRecords();
        for(Patient patient : patientList) {
            if (id == patient.getId()) {
                patientList.remove(patient);
                patientList.add(updated);
            }
            break;
        }
        saveAll(patientList, false);
    }

    public static void saveAll(ArrayList<Patient> patientList, boolean add) throws IOException {
        writer = new BufferedWriter(new FileWriter(DB, add));
        String allRecords = "";
        for (Patient patient : patientList) {
            allRecords += patient + "\n";
        }
        writer.write(allRecords);
        writer.close();
    }

    public static void deleteById(int id) throws IOException {
        ArrayList<Patient> patients = Operations.listRecords();
        Patient patient = null;
        for (Patient object : patients) {
            if (id == object.getId()) {
                patient = object;
                break;
            }
        }
        patients.remove(patient);
        saveAll(patients, false);
    }
}
