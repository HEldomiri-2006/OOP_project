public enum Gender {
    MALE,
    FEMALE;

    public String choosegender() {

        switch (this) {
            case MALE:
                return "Male";
            case FEMALE:
                return "Female";

            default:
                throw new IllegalArgumentException();
        }
    }
}