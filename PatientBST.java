public class PatientBST {
    private class Node {
        Patient patient;
        Node left, right;

        public Node(Patient patient) {
            this.patient = patient;
        }
    }

    private Node root;

    // Insert
    public void insert(Patient patient) {
        root = insertRec(root, patient);
    }

    private Node insertRec(Node current, Patient patient) {
        if (current == null) {
            return new Node(patient);
        }

        if (patient.id < current.patient.id) {
            current.left = insertRec(current.left, patient);
        } else if (patient.id > current.patient.id) {
            current.right = insertRec(current.right, patient);
        }

        return current;
    }

    // Search
    public Patient search(int id) {
        return searchRec(root, id);
    }

    private Patient searchRec(Node current, int id) {
        if (current == null) return null;

        if (id == current.patient.id) {
            return current.patient;
        } else if (id < current.patient.id) {
            return searchRec(current.left, id);
        } else {
            return searchRec(current.right, id);
        }
    }

    // Update
    public void update(int id, String name, int age, String disease, String appointmentDate) {
        Patient p = search(id);

        if (p != null) {
            p.name = name;
            p.age = age;
            p.disease = disease;
            p.appointmentDate = appointmentDate;
        }
    }

    // Delete
    public void delete(int id) {
        root = deleteRec(root, id);
    }

    private Node deleteRec(Node current, int id) {
        if (current == null) return null;

        if (id < current.patient.id) {
            current.left = deleteRec(current.left, id);
        } else if (id > current.patient.id) {
            current.right = deleteRec(current.right, id);
        } else {
            // Case 1: no children
            if (current.left == null && current.right == null) {
                return null;
            }

            // Case 2: one child
            if (current.left == null) return current.right;
            if (current.right == null) return current.left;

            // Case 3: two children
            Patient smallest = findMin(current.right);
            current.patient = smallest;
            current.right = deleteRec(current.right, smallest.id);
        }

        return current;
    }

    private Patient findMin(Node current) {
        while (current.left != null) {
            current = current.left;
        }
        return current.patient;
    }

    // Display (Sorted)
    public void display() {
        inorder(root);
    }

    private void inorder(Node current) {
        if (current != null) {
            inorder(current.left);
            System.out.println(current.patient);
            inorder(current.right);
        }
    }
}

