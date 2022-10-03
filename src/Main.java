import java.io.IOException;
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
            System.out.println("Çıkış -> 5");

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
                    Operations.save(p);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                System.out.println("\tKayıt işlemi başarılı!");

            } else if (selection == 2) {
                try {
                    for (Patient patient : Operations.listRecords()) {
                        System.out.println(patient);
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else if (selection == 3) {
                try {
                    for(Patient patient : Operations.listRecords()) {
                        System.out.println(patient);
                    }

                    System.out.print("Güncellenecek id'yi seçin: ");
                    int id = scanner.nextInt(); scanner.nextLine();

                    Patient willUpdatedPatient = Operations.getById(id);

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

                    Operations.update(id, willUpdatedPatient);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else if (selection == 4) {
                try {
                    for (Patient patient : Operations.listRecords()) {
                        System.out.println(patient);
                    }
                    System.out.print("Silinecek id'yi seçin: ");
                    int id = scanner.nextInt(); scanner.nextLine();

                    Operations.deleteById(id);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else if (selection == 5) {
                System.out.println("Çıkış yapıldı");
                break;
            }
        }
        scanner.close();
    }
}