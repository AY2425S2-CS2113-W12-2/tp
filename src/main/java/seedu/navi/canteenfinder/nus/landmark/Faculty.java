package seedu.navi.canteenfinder.nus.landmark;

public class Faculty extends Landmark {
    public Faculty(String name) {
        super(name);
    }
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