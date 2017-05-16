package lk.sliit;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by VMARALA on 5/16/2017.
 */
public class ServiceUtility {

    public static int getRandomNumber(){
        return ThreadLocalRandom.current().nextInt(100,899);
    }
}
