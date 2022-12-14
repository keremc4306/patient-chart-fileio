import java.time.LocalDate;
import java.time.LocalTime;

public class Appointment {
    private int appId;
    private String patientName;
    private String patientSurname;
    private String polyclinicName;
    private String appDate;
    private String startTime;
    private String endTime;

    public Appointment(int appId, String patientName, String patientSurname, String polyclinicName,
                       String appDate, String startTime, String endTime) {
        this.appId = appId;
        this.patientName = patientName;
        this.patientSurname = patientSurname;
        this.polyclinicName = polyclinicName;
        this.appDate = appDate;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getAppId() {
        return appId;
    }

    public void setAppId(int appId) {
        this.appId = appId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientSurname() {
        return patientSurname;
    }

    public void setPatientSurname(String patientSurname) {
        this.patientSurname = patientSurname;
    }

    public String getPolyclinicName() {
        return polyclinicName;
    }

    public void setPolyclinicName(String polyclinicName) {
        this.polyclinicName = polyclinicName;
    }

    public String getAppDate() {
        return appDate;
    }

    public void setAppDate(String appDate) {
        this.appDate = appDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return  appId           + "," +
                patientName     + "," +
                patientSurname  + "," +
                polyclinicName  + "," +
                appDate         + "," +
                startTime       + "," +
                endTime;
    }
}
