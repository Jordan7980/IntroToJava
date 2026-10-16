package instruments;

public interface Portable {
    double ONE_PERSON_LIMIT = 40.0;

    double weightLbs();

    default boolean isOnePersonCarry() { return weightLbs() <= ONE_PERSON_LIMIT; }

    default String caseType() { return isOnePersonCarry() ? "soft case" : "flight case"; }
}

