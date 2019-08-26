package com.worldwarofants.game.util;

import java.util.Random;

/**
 * Utility class that provides an abstraction of Java's Random class. Its goal
 * is to provide developers with a simple way to work with random number
 * generation, as well as allow for precise tweaking of exact methods used.
 * Please make sure to generate your random numbers within the project
 * exclusively using this package.
 * 
 * @author Plat251
 * @since 2019-08-15
 */

public class RandomGenerator extends Random {
    private static final long serialVersionUID = -5378246343912387722L;
    private static final String VALID_LONG_REGEX = "-?\\d+(\\.\\d+)?";

    private Random generator;
    private long seed;
    private String seedString;

    public RandomGenerator() {
        this.generator = new Random();
        this.seed = generator.nextLong();
        this.seedString = Long.toString(this.seed);
        this.generator.setSeed(seed);

    }

    public RandomGenerator(String seedString) {
        if (seedString.matches(VALID_LONG_REGEX)) {
            this.seed = Long.parseLong(seedString);
            this.seedString = Long.toString(this.seed);
        } else {
            this.seed = seedString.hashCode();
            this.seedString = seedString;
        }
        this.generator = new Random(seed);
    }

    /**
     * @return long Returns the numeric seed used.
     */
    public long getSeed() {
        return this.seed;
    }

    /**
     * @return String Returns the string seed used. May be same as non-string seed.
     */
    public String getSeedString() {
        return this.seedString;
    }

    /**
     * Generate an int in range defined by two ints, start and end.
     * Start must be greater than end. Otherwise end will be returned.
     * 
     * @return int Returns a random integer between start and end.
     */
    public int getIntInRange(int start, int end) {
            if (start > end) {
                return end;
            }
            int randomNumber = this.generator.nextInt(end - start);
            randomNumber += start;
            return randomNumber;
    }

    /**
     * @return int an int in range from 0 to end.
     */
    public int getIntInRange(int end) {
        int randomNumber = this.generator.nextInt(end);
        return randomNumber;
    }
}