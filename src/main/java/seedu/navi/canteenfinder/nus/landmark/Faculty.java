package seedu.navi.canteenfinder.nus.landmark;

import seedu.navi.canteenfinder.nus.landmark.canteen.Canteen;
import seedu.navi.canteenfinder.nus.landmark.canteen.stall.Stall;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Faculty extends Landmark {

    //read both the files and store in hashmap
    private static final String CANTEEN_FILE = "C:\\CS2113\\tp\\data\\canteen.txt";
    private static final String LANDMARK_FILE = "C:\\CS2113\\tp\\data\\landmark.txt";
    private final Map<String, List<String>> facultyCanteens;
    private final Map<String, Canteen> canteenStalls;

    public Faculty(String name) {
        super(name);
        this.facultyCanteens = loadFacultyCanteens();
        this.canteenStalls = loadCanteenStalls();
        setNearestCanteens();
    }

    private Map<String, List<String>> loadFacultyCanteens() {
        Map<String, List<String>> facultyCanteens = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(CANTEEN_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(": ");
                if (parts.length == 2) {
                    String facultyName = parts[0];
                    String[] canteenNames = parts[1].split("\\|");
                    List<String> canteens = new ArrayList<>();
                    for (String canteenName : canteenNames) {
                        canteens.add(canteenName.trim());
                    }
                    facultyCanteens.put(facultyName, canteens);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return facultyCanteens;
    }

    private Map<String, Canteen> loadCanteenStalls() {
        Map<String, Canteen> canteenStalls = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(LANDMARK_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length >= 6) {
                    String canteenName = parts[0].trim();
                    String stallName = parts[1].trim();
                    boolean halal = parts[2].trim().equals("T");
                    boolean muslim = parts[3].trim().equals("T");
                    boolean vegetarian = parts[4].trim().equals("T");
                    boolean aircon = parts[5].trim().equals("T");

                    Canteen canteen = canteenStalls.getOrDefault(canteenName, new Canteen(canteenName));
                    canteen.addStall(new Stall(stallName, halal, muslim, vegetarian, aircon));
                    canteenStalls.put(canteenName, canteen);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return canteenStalls;
    }

    private void setNearestCanteens() {
        List<Canteen> nearest = new ArrayList<>();
        List<String> canteenNames = facultyCanteens.get(name);
        if (canteenNames != null) {
            for (String canteenName : canteenNames) {
                Canteen canteen = canteenStalls.get(canteenName.trim());
                if (canteen != null) {
                    nearest.add(canteen);
                }
            }
        }
        super.setNearestCanteens((ArrayList<Canteen>) nearest);
    }

    public String getName() {
        return name;
    }



    //test code
    /*
    public static void main(String args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the building name that you are located in or are nearest to.");
        String buildingName = scanner.nextLine().trim();

        Faculty faculty = new Faculty(getFacultyNameFromBuilding(buildingName));

        System.out.println("Ok. Do you have any dietary restrictions / preferences?");
        String dietaryRestriction = scanner.nextLine().trim().toLowerCase();

        CanteenStallPair pair = findNearestCanteenStall(faculty, dietaryRestriction);

        if (pair != null) {
            System.out.println("Understood, the nearest canteen is " + pair.getCanteen().getName() +
                    " and the nearest stall with " + dietaryRestriction + " food is " +
                    pair.getStall().getName() + ".");
        } else {
            System.out.println("Sorry, no matching canteen and stall found for your criteria.");
        }

        scanner.close();
    }

    private static String getFacultyNameFromBuilding(String buildingName) {
        if (buildingName.equals("COM1")) {
            return "COM";
        } else if (buildingName.equals("CDE")) {
            return "CDE";
        } else if (buildingName.equals("FASS")) {
            return "FASS";
        }

        return buildingName;
    }

    private static CanteenStallPair findNearestCanteenStall(Faculty faculty, String dietaryRestriction) {
        ArrayList<Canteen> nearestCanteens = faculty.getNearestCanteens();

        if (dietaryRestriction.isEmpty()) {
            if (!nearestCanteens.isEmpty() && !nearestCanteens.get(0).getStalls().isEmpty()) {
                return new CanteenStallPair(nearestCanteens.get(0), nearestCanteens.get(0).getStalls().get(0));
            } else {
                return null;
            }
        }

        for (Canteen canteen : nearestCanteens) {
            for (Stall stall : canteen.getStalls()) {
                if (dietaryRestriction.equals("halal") && stall.getStallCharacteristic().getHalalCertified()) {
                    return new CanteenStallPair(canteen, stall);
                } else if (dietaryRestriction.equals("vegetarian") && stall.getStallCharacteristic().getVegetarian()) {
                    return new CanteenStallPair(canteen, stall);
                } else if (dietaryRestriction.equals("muslim") && stall.getStallCharacteristic().getMuslimOwned()) {
                    return new CanteenStallPair(canteen, stall);
                }
            }
        }
        return null;
    } */
}
