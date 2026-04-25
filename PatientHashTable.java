public class PatientHashTable {
    private class Node {
        Patient patient;
        Node next;

        public Node(Patient patient) {
            this.patient = patient;
            this.next = null;
        }
    }

    private Node[] table;
    private int size;

    public PatientHashTable(int size) {
        this.size = size;
        table = new Node[size];
    }

    private int hashFunction(int id) {
        return id % size;
    }

    public void insert(Patient patient) {
        int index = hashFunction(patient.id);
        Node newNode = new Node(patient);

        // If the bucket is empty, add the patient directly
        if (table[index] == null) {
            table[index] = newNode;
        } else {
            // Collision handling using chaining
            Node current = table[index];

            while (current.next != null) {
                current = current.next;
            }

            current.next = newNode;
        }
    }

    public Patient search(int id) {
        int index = hashFunction(id);
        Node current = table[index];

        while (current != null) {
            if (current.patient.id == id) {
                return current.patient;
            }
            current = current.next;
        }

        return null;
    }

    public void update(int id, String name, int age, String disease, String appointmentDate) {
        Patient patient = search(id);

        if (patient != null) {
            patient.name = name;
            patient.age = age;
            patient.disease = disease;
            patient.appointmentDate = appointmentDate;
        }
    }



    public void displayAll() {
        for (int i = 0; i < size; i++) {
            Node current = table[i];

            while (current != null) {
                System.out.println("Index " + i + ": " + current.patient);
                current = current.next;
            }
        }
    }

    public void delete(int id) {
        int index = hashFunction(id);
        Node current = table[index];
        Node previous = null;

        while (current != null) {
            if (current.patient.id == id) {

                if (previous == null) {
                    table[index] = current.next;
                } else {
                    previous.next = current.next;
                }

                return;
            }

            previous = current;
            current = current.next;
        }
    }
}


