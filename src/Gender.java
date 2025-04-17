public enum Gender {
    MALE("Male"),
    FEMALE("Female");

    private final String displayName;

    // Constructor
    Gender(String displayName) {
        this.displayName = displayName;
    }

    // Get the display name
    public String getDisplayName() {
        return displayName;
    }

    // Optionally, add a method to get enum from display name
    public static Gender fromDisplayName(String displayName) {
        for (Gender gender : values()) {
            if (gender.displayName.equalsIgnoreCase(displayName)) {
                return gender;
            }
        }
        throw new IllegalArgumentException("No gender with display name: " + displayName);
    }
}

