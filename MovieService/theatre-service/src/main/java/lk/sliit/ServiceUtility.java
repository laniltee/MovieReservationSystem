package lk.sliit;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by VMARALA on 5/16/2017.
 */
public class ServiceUtility {

    private final int RAND_ORIGIN = 100, RAND_BOUND = 899;

    public static int getRandomNumber(){
        return ThreadLocalRandom.current().nextInt(100,899);
    }
}
