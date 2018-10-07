public class TestCoin {
    private Coin coin;

    @Before
    public void setup(){
        coin = new Coin();
    }

    //Make sure we are not always getting the same response
    @Test
    public void testFlipHeadsAndTails(){
        int timesChanged = 0;
        String lastStatus = "heads";
        for (int i=0; i<10; i++){
            coin.flip();
            String status = coin.checkStatus();
            System.out.println(status);
            if (!status.equals(lastStatus)){
                timesChanged++;
                lastStatus = status;
            }
        }
        assertFalse(timesChanged==0);
    }

    //Test to ensure the same value isn't returned >10 times
    @Test
    public void testFlipRandomness(){
        String lastStatus = "heads";
        int longestRunOfSameAnswer = 0;
        int currentRun = 0;
        for (int i=0; i<100; i++){
            coin.flip();
            String status = coin.checkStatus();
            System.out.println(status);
            if (status.equals(lastStatus)){
                currentRun++;
                if (currentRun > longestRunOfSameAnswer){
                    longestRunOfSameAnswer = currentRun;
                }
            }
            else {
                lastStatus = status;
                currentRun = 0;
            }
        }
        assertFalse(longestRunOfSameAnswer>10);
    }
}