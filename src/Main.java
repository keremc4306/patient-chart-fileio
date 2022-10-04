import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean result = true;
        while (result) {
            System.out.println("Hasta Ekle -> 1");
            System.out.println("Hastaları Listele -> 2");
            System.out.println("Hasta Güncelle -> 3");
            System.out.println("Hasta Sil -> 4");
            System.out.println("Randevu Ekle -> 5");
            System.out.println("Randevuları Listele -> 6");
            System.out.println("Randevu Güncelle -> 7");
            System.out.println("Randevu Sil -> 8");
            System.out.println("Çıkış -> 9");

            int selection = scanner.nextInt(); scanner.nextLine();

            if (selection == 1) {
                System.out.println("\tHASTA EKLE");

                System.out.print("Id: ");
                int id = scanner.nextInt(); scanner.nextLine();

                System.out.print("Adı: ");
                String name = scanner.nextLine();

                System.out.print("Soyadı: ");
                String surname = scanner.nextLine();

                System.out.print("Yaşı: ");
                int age = scanner.nextInt(); scanner.nextLine();

                System.out.print("Cinsiyeti: ");
                String gender = scanner.nextLine();

                System.out.print("Mesleği: ");
                String job = scanner.nextLine();

                Patient p = new Patient(id, name, surname, age, gender, job);

                try {
                    PatientOperations.save(p);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                System.out.println("\tKayıt işlemi başarılı!");

            } else if (selection == 2) {
                try {
                    for (Patient patient : PatientOperations.listRecords()) {
                        System.out.println(patient);
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else if (selection == 3) {
                try {
                    for(Patient patient : PatientOperations.listRecords()) {
                        System.out.println(patient);
                    }

                    System.out.print("Güncellenecek id'yi seçin: ");
                    int id = scanner.nextInt(); scanner.nextLine();

                    Patient willUpdatedPatient = PatientOperations.getById(id);

                    System.out.print("Adı (yeni): ");
                    String name = scanner.nextLine();

                    System.out.print("Soyadı (yeni): ");
                    String surname = scanner.nextLine();

                    System.out.print("Yaşı (yeni): ");
                    int age = scanner.nextInt(); scanner.nextLine();

                    System.out.print("Cinsiyeti (yeni): ");
                    String gender = scanner.nextLine();

                    System.out.print("Mesleği (yeni): ");
                    String job = scanner.nextLine();

                    willUpdatedPatient.setName(name);
                    willUpdatedPatient.setSurname(surname);
                    willUpdatedPatient.setAge(age);
                    willUpdatedPatient.setGender(gender);
                    willUpdatedPatient.setJob(job);

                    PatientOperations.update(id, willUpdatedPatient);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else if (selection == 4) {
                try {
                    for (Patient patient : PatientOperations.listRecords()) {
                        System.out.println(patient);
                    }
                    System.out.print("Silinecek id'yi seçin: ");
                    int id = scanner.nextInt(); scanner.nextLine();

                    PatientOperations.deleteById(id);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else if (selection == 5) {
                System.out.println("\tRANDEVU EKLE");

                System.out.print("Randevu id: ");
                int appId = scanner.nextInt(); scanner.nextLine();

                System.out.print("Adı: ");
                String patientName = scanner.nextLine();

                System.out.print("Soyadı: ");
                String patientSurname = scanner.nextLine();

                System.out.print("Poliklinik: ");
                String polyclinicName = scanner.nextLine();

                System.out.print("Tarih: ");
                String appDate = scanner.nextLine();

                System.out.print("Başlangıç saati: ");
                String startTime = scanner.nextLine();

                System.out.print("Bitiş saati: ");
                String endTime = scanner.nextLine();

                Appointment a = new Appointment(appId, patientName, patientSurname, polyclinicName,
                        appDate, startTime, endTime);

                try {
                    AppointmentOperations.save(a);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("\tKayıt işlemi başarılı!");
            } else if (selection == 6) {
                try {
                    for (Appointment appointment : AppointmentOperations.listAppRecords()) {
                        System.out.println(appointment);
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else if (selection == 7) {
                System.out.println("\tHASTA GÜNCELLE");
                try {
                    for (Appointment appointment : AppointmentOperations.listAppRecords()) {
                        System.out.println(appointment);
                    }

                    System.out.print("Güncellenecek randevu id'yi seçin: ");
                    int appId = scanner.nextInt();

                    Appointment willUpdatedAppointment = AppointmentOperations.getByAppId(appId);

                    System.out.print("Adı (yeni): ");
                    String patientName = scanner.next();

                    System.out.print("Soyadı (yeni): ");
                    String patientSurname = scanner.next();

                    System.out.print("Poliklinik (yeni): ");
                    String polyclinicName = scanner.next();

                    System.out.print("Randevu tarihi (yeni): ");
                    String appDate = scanner.next();

                    System.out.print("Başlangıç saati: ");
                    String startTime = scanner.next();

                    System.out.print("Bitiş saati: ");
                    String endTime = scanner.next();

                    willUpdatedAppointment.setPatientName(patientName);
                    willUpdatedAppointment.setPatientSurname(patientSurname);
                    willUpdatedAppointment.setPolyclinicName(polyclinicName);
                    willUpdatedAppointment.setAppDate(appDate);;
                    willUpdatedAppointment.setStartTime(startTime);
                    willUpdatedAppointment.setEndTime(endTime);

                    AppointmentOperations.updateAppointment(appId, willUpdatedAppointment);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else if (selection == 8) {
                try {
                    for (Appointment appointment : AppointmentOperations.listAppRecords()) {
                        System.out.println(appointment);
                    }
                    System.out.print("Silinecek randevu id'yi seçin: ");
                    int appId = scanner.nextInt(); scanner.nextLine();

                    AppointmentOperations.deleteByAppId(appId);

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        scanner.close();
    }
}