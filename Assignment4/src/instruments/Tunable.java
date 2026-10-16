package instruments;

public interface Tunable {
    double CONCERT_A = 440.0;

    void tuneTo(double referenceHz);
    boolean isInTune();

    default void tune() { tuneTo(CONCERT_A); }

    static boolean isStandardPitch(double hz) {
        return Math.abs(hz - CONCERT_A) < 0.01;
    }
}
