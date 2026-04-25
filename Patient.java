public class Patient {
    int id;
    String name;
    int age;
    String disease;
    String appointmentDate;

    public Patient(int id, String name, int age, String disease, String appointmentDate) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.disease = disease;
        this.appointmentDate = appointmentDate;
    }

    public String toString() {
        return id + " - " + name + " - " + age + " - " + disease + " - " + appointmentDate;
    }
}

