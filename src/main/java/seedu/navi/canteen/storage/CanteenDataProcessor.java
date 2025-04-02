package seedu.navi.canteen.storage;

import seedu.navi.canteen.canteenfinder.landmark.canteen.Canteen;
import seedu.navi.canteen.canteenfinder.landmark.canteen.stall.Stall;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CanteenDataProcessor {

    private final Map<String, Canteen> canteenMap;
    private final List<String> canteenDataList;

    public CanteenDataProcessor(Map<String, Canteen> canteenMap) {
        this.canteenMap = canteenMap;
        this.canteenDataList = CanteenInfo.getCanteenData(); // Get data from CanteenInfo
    }

    public Map<String, Canteen> getCanteenMap() {
        return canteenMap;
    }

    public void processData() {
        for (String canteenData : canteenDataList) {
            insertCanteenFromData(canteenData);
        }
    }

    private void insertCanteenFromData(String canteenData) {
        String[] dataFields = canteenData.split("\\|");
        String canteenName = dataFields[0].trim();
        String stallName = dataFields[1].trim();
        boolean halal = dataFields[2].trim().equals("T");
        boolean muslim = dataFields[3].trim().equals("T");
        boolean aircon = dataFields[4].trim().equals("T");
        boolean vegetarian = dataFields[5].trim().equals("T");

        Canteen canteen = canteenMap.getOrDefault(canteenName, new Canteen(canteenName));
        canteen.addStall(new Stall(stallName, halal, muslim, vegetarian, aircon));
        canteenMap.put(canteenName, canteen);
    }

    // CanteenInfo class to hold the data
    public static class CanteenInfo {
        public static List<String> getCanteenData() {
            List<String> data = new ArrayList<>();
            data.add("Techno Edge | Western Food | F | F | F | F");
            data.add("Techno Edge | Nasi Padang | F | T | F | F");
            data.add("Techno Edge | Vegetarian | F | F | F | T");
            data.add("Techno Edge | Mala Hotpot | T | F | F | F");
            data.add("Techno Edge | Indian | F | F | F | F");
            data.add("Techno Edge | Mixed Rice | F | F | F | F");
            data.add("Techno Edge | Drinks & Snacks | F | F | F | F");
            data.add("Techno Edge | Fruit Juice | F | F | F | F");
            data.add("Techno Edge | Taiwan | F | F | F | F");
            data.add("Techno Edge | Ramen & Soup | F | F  |F | F");
            data.add("Techno Edge | Noodles | F | F | F | F");
            data.add("Techno Edge | Chicken Rice | F | F | F | F");
            data.add("Techno Edge | Bistro Box | T | F | T | F");
            data.add("Frontier | Vegetarian | F | F | F | T");
            data.add("Frontier | Korean | F | F | F | F");
            data.add("Frontier | Indian | F | F | F | F");
            data.add("Frontier | Noodles | F | F | F | F");
            data.add("Frontier | Hotplates | F | F | F | F");
            data.add("Frontier | Yong Tau Foo | F | F | F | F");
            data.add("Frontier | Chef Wok | F | F | F | F");
            data.add("Frontier | Muslim | F | T | F | F");
            data.add("Frontier | Mala Hotpot | F | F | F | F");
            data.add("Frontier | Western | F | T | F | F");
            data.add("Frontier | Chicken Rice | F | F | F | F");
            data.add("Frontier | Fruits & Juices | F | F | F | F");
            data.add("Frontier | Gong Cha | F | F | F | F");
            data.add("Frontier | Drinks & Snacks | F | F | F | F");
            data.add("Frontier | Uncle Penyet Fusion | T | F | T | F");
            data.add("Frontier | Li Ji Coffee House | F | F | T | F");
            data.add("Frontier | Pasta Express | F | F | T | F");
            data.add("Frontier | Taiwan Ichiban | F | F | T | F");
            data.add("The Deck | Yong Tau Foo & Laksa | F | F | F | F");
            data.add("The Deck | Chinese Cooked Food | F | F | F | F");
            data.add("The Deck | Japanese | F | F | F | F");
            data.add("The Deck | Snacks & Fried Kway Teow | F | F | F | F");
            data.add("The Deck | Thai | F | F | F | F");
            data.add("The Deck | Western | F | T | F | F");
            data.add("The Deck | Noodle | F | F | F | F");
            data.add("The Deck | Roasted Delights | F | F | F | F");
            data.add("The Deck | Vegetarian | F | F | F | T");
            data.add("The Deck | Indian Vegetarian | F | F | F | T");
            data.add("The Deck | Muslim | F | T | F | F");
            data.add("The Deck | Fresh Fruits & Juices | F | F | F | F");
            data.add("The Deck | Bubble Tea | F | F | F | F");
            data.add("The Deck | Drinks & Snacks | F | F | F | F");
            data.add("The Deck | Liang Ban Gong Fu | F | F | T | F");
            data.add("The Deck | Pasta Express | F | F | T | F");
            data.add("The Deck | Mrs Hen | T | F | T | F");
            data.add("Terrace | Local Noodles | F | F | F | F");
            data.add("Terrace | Five Grains Noodles | F | F | F | F");
            data.add("Terrace | Mixed Rice, Mala & Sichuan | F | F | F | F");
            data.add("Terrace | Korean & Japanese | F | F | F | F");
            data.add("Terrace | Drinks & Hot Foods | F | F | F | F");
            data.add("PGP Canteen | PGP Indian Veg | F | F | F | T");
            data.add("PGP Canteen | PGP Salad | F | F | F | F");
            data.add("PGP Canteen | PGP Dough Magic | F | F | F | F");
            data.add("PGP Canteen | PGP Fish Soup | F | F | F | F");
            data.add("PGP Canteen | PGP Mala Hotpot | F | F | F | F");
            data.add("PGP Canteen | PGP Vietnamese | F | F | F | F");
            data.add("PGP Canteen | PGP Mini Wok | F | F | F | F");
            data.add("PGP Canteen | PGP Western | F | F | F | F");
            data.add("PGP Canteen | PGP Mixed Veg Rice | F | F | F | F");
            data.add("PGP Canteen | PGP Chicken Rice | F | F | F | F");
            data.add("PGP Canteen | PGP Drinks and Snacks | F | F | F | F");
            data.add("Fine Food | Nasi Campur | T | F | F | F");
            data.add("Fine Food | Japanese Fusion | T | F | T | F");
            data.add("Fine Food | Duck & Chicken Rice | F | F | T | F");
            data.add("Fine Food | Five Grains Bee Hoon | F | F | T | F");
            data.add("Fine Food | Mala Hotpot | F | F | T | F");
            data.add("Fine Food | Indian Cuisine | F | F | T | F");
            data.add("Fine Food | Mixed Veg Rice | F | F | T | F");
            data.add("Fine Food | Xiao Long Bao | F | F | T | F");
            data.add("Fine Food | Hot Pot Snail Noodle | F | F | T | F");
            data.add("Fine Food | Taiwan Cuisine | F | F | T | F");
            data.add("Fine Food | Pasta/Fried Rice | F | F | T | F");
            data.add("Fine Food | Western Cuisine | T | F | T | F");
            data.add("Flavours | Dan Lao | F | F | F | F");
            data.add("Flavours | Tenderfresh | T | F | F | F");
            data.add("Flavours | Beverage | F | F | F | F");
            data.add("Flavours | Yong Tau Foo | F | F | F | F");
            data.add("Flavours | Chicken Rice | F | F | F | F");
            data.add("Flavours | Mini Wok | F | F | F | F");
            data.add("Flavours | Japanese | F | F | F | F");
            data.add("Flavours | Taiwanese | F | F | F | F");
            data.add("Flavours | Mala Hotpot | F | F | F | F");
            data.add("Flavours | Noodles | F | F | F | F");
            data.add("Flavours | Mixed Veg Rice | F | F | F | F");
            data.add("Flavours | Gong Cha | F | F | F | F");
            data.add("Flavours | Coconut Queen | F | F | F | F");
            return data;
        }
    }
}

