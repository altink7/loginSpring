import static at.altin.loginspring.java21.NewFeatures.*;


void main(String[] args) {
        int numberOfThreads = 100;

        //when both methods are called, the virtual thread method waits for the normal thread method to finish
        // therefore the time is much longer
        testVirtualThread(numberOfThreads);
        testNormalThread(numberOfThreads);

        //when only the virtual thread method is called, the time is shorter
        testVirtualThread(numberOfThreads);

        //when only the normal thread method is called, the time is longer
        testNormalThread(numberOfThreads);
}


