public class Main {
    public static void main(String[] args) {

        PatientBST bst = new PatientBST();
        PatientHashTable hashTable = new PatientHashTable(10);

        // Create patients
        Patient p1 = new Patient(123, "Lolwa", 21, "Flu", "25-April");
        Patient p2 = new Patient(133, "Nod", 22, "Headache", "26-April");
        Patient p3 = new Patient(145, "Alyah", 20, "Allergy", "27-April");
        Patient p4 = new Patient(120, "Malak", 21, "Cough", "28-April");

        // Insert into both
        bst.insert(p1);
        bst.insert(p2);
        bst.insert(p3);
        bst.insert(p4);

        hashTable.insert(p1);
        hashTable.insert(p2);
        hashTable.insert(p3);
        hashTable.insert(p4);


        System.out.println("Search Time Comparison:");

        for (int i = 1; i <= 5; i++) {

            // Hash Table
            long start1 = System.nanoTime();
            hashTable.search(123);
            long end1 = System.nanoTime();

            long hashTime = end1 - start1;

            // BST
            long start2 = System.nanoTime();
            bst.search(123);
            long end2 = System.nanoTime();

            long bstTime = end2 - start2;

            System.out.println("Trial " + i +
                    " | Hash Table: " + hashTime +
                    " ns | BST: " + bstTime + " ns");
        }


        System.out.println("\nSearch Result:");
        System.out.println(hashTable.search(123));

        System.out.println("\nUpdate:");
        hashTable.update(123, "Lolwa", 21, "Recovered", "30-April");
        bst.update(123, "Lolwa", 21, "Recovered", "30-April");

        System.out.println("\nDelete:");
        hashTable.delete(133);
        bst.delete(133);

        System.out.println("\nHash Table Data:");
        hashTable.displayAll();

        System.out.println("\nBST Sorted Data:");
        bst.display();
    }
}
