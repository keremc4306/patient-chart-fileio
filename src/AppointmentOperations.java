import java.io.*;
import java.util.ArrayList;

public class AppointmentOperations {
    private static final File DB2 = new File("appointments.txt");

    private static BufferedReader reader;
    private static BufferedWriter writer;

    static {
        if (!DB2.exists()) {
            try {
                DB2.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static void save(Appointment appointment) throws IOException {
        writer = new BufferedWriter(new FileWriter(DB2, true));
        writer.write(appointment + "\n");
        writer.close();
    }

    public static ArrayList<Appointment> listAppRecords() throws IOException {
        reader = new BufferedReader(new FileReader(DB2));
        ArrayList<Appointment> appointments = new ArrayList<Appointment>();
        String line = "";
        while ((line = reader.readLine()) != null) {
            Appointment appointment = parseAppointment(line);
            appointments.add(appointment);
        }
        reader.close();
        return appointments;
    }

    private static Appointment parseAppointment(String line) {
        String[] apps =  line.split(",");
        return new Appointment(Integer.valueOf(apps[0]), apps[1], apps[2], apps[3], apps[4], apps[5], apps[6]);
    }

    public static Appointment getByAppId(int appId) throws IOException {
        ArrayList<Appointment> appList = AppointmentOperations.listAppRecords();
        for (Appointment appointment : appList) {
            if (appointment.getAppId() == appId) {
                return appointment;
            }
        }
        return null;
    }

    public static void updateAppointment(int appId, Appointment updatedAppointment) throws IOException {
        ArrayList<Appointment> appList = AppointmentOperations.listAppRecords();
        for (Appointment appointment : appList) {
            if (appId == appointment.getAppId()) {
                appList.remove(appointment);
                appList.add(updatedAppointment);
                break;
            }
        }
        
        saveAll(appList,false);
    }

    public static void saveAll(ArrayList<Appointment> appList, boolean addApp) throws IOException {
        writer = new BufferedWriter(new FileWriter(DB2, addApp));
        String allAppRecords = "";
        for (Appointment appointment : appList) {
            allAppRecords += appointment + "\n";
        }
        writer.write(allAppRecords);
        writer.close();
    }
}
