import static at.altin.loginspring.java21.NewFeatures.*;


void main(String[] args) {
        int numberOfThreads = 100;

        //when both methods are called, the virtual thread method waits for the normal thread method to finish,
        // therefore, the time is much longer
        testVirtualThread(numberOfThreads);
        testNormalThread(numberOfThreads);

        //when only the virtual thread method is called, the time is shorter
        testVirtualThread(numberOfThreads);

        //when only the normal thread method is called, the time is longer
        testNormalThread(numberOfThreads);

        //Run 1:
        //Virtual Thread Performance: 570 ms (waiting time for normal thread method)
        //Normal Thread Performance: 76 ms
        //Virtual Thread Performance: 6 ms
        //Normal Thread Performance: 23 ms
        //
        //Process finished with exit code 0

        //Run 2:
        //Virtual Thread Performance: 544 ms (waiting time for normal thread method)
        //Normal Thread Performance: 70 ms
        //Virtual Thread Performance: 7 ms
        //Normal Thread Performance: 24 ms
        //
        //Process finished with exit code 0


        //till the Virtual Thread System is triggered to wait also the normal Thread is blocked and the time is longer
        // difference = 76 - 23 = 53 ms and 70 - 24 = 46 ms
}


