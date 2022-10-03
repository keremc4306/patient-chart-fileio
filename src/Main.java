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