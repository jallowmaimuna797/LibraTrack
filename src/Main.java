public class Main {
    public static void main(String[] args) {

        String[] titles = {"Java Basics", "Database Systems", "Web Development", "Cybersecurity", "Networking",};
        String[] authors = {"Ebrima Touraye", "Ebrima Faal", "Muhammed Chaw", "Maimuna Jallow", "Ebou Badjie"};
        String[] isbn = {"1001", "1002", "1003", "1004", "1005"};
        boolean[] available = {true, true, false, true, false,};

        System.out.println("LibraTrack Library Catalog");
        System.out.println();

        for (int i = 0; i < titles.length; i++) {
            System.out.println("Title: " + titles[i]);
            System.out.println("Author: " + authors[i]);
            System.out.println("ISBN: " + isbn [i]);
            System.out.println("Available: " + available[i]);
            System.out.println();
        }
    }
}