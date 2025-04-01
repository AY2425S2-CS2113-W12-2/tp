/* package seedu.navi.canteen.storage;

import seedu.navi.canteen.canteenfinder.landmark.Landmark;
import seedu.navi.canteen.canteenfinder.landmark.canteen.Canteen;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class HostelDataProcessor {

    private static final String HOSTEL_FILE = "data/hostel.txt";
    private final Map<String, Canteen> canteenMap;

    public HostelDataProcessor(Map<String, Canteen> canteenMap) {
        this.canteenMap = canteenMap;
    }

    public void processData(ArrayList<Landmark> hostels) throws FileNotFoundException {
        File f = new File(HOSTEL_FILE);
        assert f.exists() : "Hostel file does not exist: " + HOSTEL_FILE;
        Scanner s = new Scanner(f);
        while (s.hasNext()) {
            String hostelData = s.nextLine();
            insertHostelFromData(hostelData, hostels);
        }
    }

    private void insertHostelFromData(String hostelData, ArrayList<Landmark> hostels) {
        String[] parts = hostelData.split(": ");
        String hostelName = parts[0];
        Landmark hostel = new Landmark(hostelName);
        hostels.add(hostel);
        String[] canteenData = parts[1].split("\\|");
        for (String canteenInfo : canteenData) {
            String[] canteenParts = canteenInfo.trim().split("\\(");
            String canteenName = canteenParts[0].trim();
            int distance = 0;
            if (canteenParts.length > 1) {
                String distancePart = canteenParts[1].replaceAll("[^\\d]", "").trim();
                if (!distancePart.isEmpty()) {
                    distance = Integer.parseInt(distancePart);
                }
            }
            Canteen canteen = canteenMap.get(canteenName.trim());
            hostel.setNearestCanteens(canteen);
            hostel.setCanteenDistance(canteen, distance);
        }
    }
} */
package seedu.navi.canteen.storage;

import seedu.navi.canteen.canteenfinder.landmark.Landmark;
import seedu.navi.canteen.canteenfinder.landmark.canteen.Canteen;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HostelDataProcessor {

    private final Map<String, Canteen> canteenMap;

    public HostelDataProcessor(Map<String, Canteen> canteenMap) {
        this.canteenMap = canteenMap;
    }

    public void processData(ArrayList<Landmark> hostels) {
        List<String> hostelDataList = getHostelData();
        for (String hostelData : hostelDataList) {
            insertHostelFromData(hostelData, hostels);
        }
    }

    private void insertHostelFromData(String hostelData, ArrayList<Landmark> hostels) {
        String[] parts = hostelData.split(": ");
        String hostelName = parts[0].trim();
        Landmark hostel = new Landmark(hostelName);
        hostels.add(hostel);
        if (parts.length > 1) { // Check if canteen data exists
            String[] canteenData = parts[1].split("\\|");
            for (String canteenInfo : canteenData) {
                String[] canteenParts = canteenInfo.trim().split("\\(");
                String canteenName = canteenParts[0].trim();
                int distance = 0;
                if (canteenParts.length > 1) {
                    String distancePart = canteenParts[1].replaceAll("[^\\d]", "").trim();
                    if (!distancePart.isEmpty()) {
                        distance = Integer.parseInt(distancePart);
                    }
                }
                Canteen canteen = canteenMap.get(canteenName);
                if (canteen != null) { // Check if canteen exists in map
                    hostel.setNearestCanteens(canteen);
                    hostel.setCanteenDistance(canteen, distance);
                } else {
                    System.err.println("Warning: Canteen '" + canteenName + "' not found for hostel '" +
                            hostelName + "'.");
                }
            }
        }
    }

    private static List<String> getHostelData() {
        List<String> data = new ArrayList<>();
        data.add("Raffles: Techno Edge (550m) | Fine Food (650m) | " +
                "Flavours (750m) | Frontier (900m) | The Deck (1200m) | " +
                "Terrace (1800m) | PGP Canteen (2200m)");
        data.add("Eusoff: The Deck (400m) | Terrace (550m) | " +
                "Techno Edge (650m) | PGP Canteen (1500m) | " +
                "Fine Food (1500m) | Flavours (1600m) | " +
                "Frontier (1600m)");
        data.add("Temasek: The Deck (400m) | Terrace (550m) | " +
                "Techno Edge (650m) | PGP Canteen (1500m) | " +
                "Fine Food (1500m) | Flavours (1600m) | " +
                "Frontier (1600m)");
        data.add("Sheares: Terrace (550m) | The Deck (600m) | " +
                "PGP Canteen (1100m) | Techno Edge (1200m) | " +
                "Frontier (1900m) | Fine Food (2100m) | " +
                "Flavours (2200m)");
        data.add("Kent Ridge: Terrace (400m) | The Deck (500m) | " +
                "PGP Canteen (1100m) | Techno Edge (1100m) | " +
                "Frontier (1800m) | Fine Food (2000m) | " +
                "Flavours (2100m)");
        data.add("King Edward: PGP Canteen (600m) | Terrace (1100m) | " +
                "The Deck (1600m) | Frontier (850m) | " +
                "Techno Edge (2000m) | Fine Food (2300m) | " +
                "Flavours (2400m)");
        data.add("PGP: PGP Canteen (270m) | Terrace (600m) | " +
                "The Deck (1100m) | Frontier (1500m) | " +
                "Techno Edge (1700m) | Fine Food (2600m) | " +
                "Flavours (2700m)");
        data.add("UTR: Fine Food (100m) | Flavours (200m) | " +
                "Techno Edge (1300m) | Frontier (1600m) | " +
                "The Deck (2000m) | Terrace (2600m) | " +
                "PGP Canteen (3000m)");
        data.add("RC4: Flavours (350m) | Fine Food (500m) | " +
                "Techno Edge (1600m) | Frontier (1900m) | " +
                "The Deck (2200m) | Terrace (2800m) | " +
                "PGP Canteen (3200m)");
        data.add("CAPT: Flavours (400m) | Fine Food (550m) | " +
                "Techno Edge (1500m) | Frontier (1800m) | " +
                "The Deck (2100m) | Terrace (2700m) | " +
                "PGP Canteen (3100m)");
        data.add("RVRC: Frontier (400m) | Techno Edge (850m) | " +
                "Fine Food (1100m) | Flavours (1200m) | " +
                "The Deck (1500m) | PGP Canteen (1800m) | " +
                "Terrace (2100m)");
        data.add("Tembusu: Flavours (200m) | Fine Food (250m) | " +
                "Techno Edge (1400m) | Frontier (1700m) | " +
                "The Deck (2100m) | Terrace (2700m) | " +
                "PGP Canteen (3100m)");
        data.add("Cinnamon: Flavours (200m) | Fine Food (250m) | " +
                "Techno Edge (1400m) | Frontier (1700m) | " +
                "The Deck (2100m) | Terrace (2700m) | " +
                "PGP Canteen (3100m)");
        return data;
    }
}
