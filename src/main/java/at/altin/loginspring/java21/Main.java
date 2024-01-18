import java.util.Collections;
import java.util.List;

import static at.altin.loginspring.java21.NewFeatures.*;

void main(String[] args) throws InterruptedException {
        mapObject(1);
        mapObject("1");
        mapObject(1.0);
        mapObject(1L);
        mapObject(new Object());

        stringTemplate("You");

        justNormalCoding(List.of("A", "B", "C"));
        justNormalCoding(List.of("Adsadas", "Badad", "Cadad", "Dadad"));
        justNormalCoding(Collections.emptyList());

        int numberOfThreads = 100;
        testVirtualThread(numberOfThreads);
        testNormalThread(numberOfThreads);
}
