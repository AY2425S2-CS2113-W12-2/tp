package seedu.navi.canteenfinder.nus;

import java.util.ArrayList;

public class NUS {
    private final ArrayList<Faculty> faculties;

    public NUS() {
        this.faculties = new ArrayList<>();
    }

    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }
}
