public class Patient {
    private String name;
    private String surname;
    private int age;
    private String gender;
    private String job;

    public Patient(String name, String surname, int age, String gender, String job) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gender = gender;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return  name        +","+
                surname       +","+
                age    +","+
                gender +","+
                job;
    }
}
