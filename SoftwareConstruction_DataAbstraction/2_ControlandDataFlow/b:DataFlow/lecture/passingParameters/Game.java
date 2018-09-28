public class Game {
    public void playGame() {
        Ball ball = new Ball();
        ball.setSpeed(10);
        passBall(ball);
        ball.setSpeed(30);
        System.out.println("the final ball speed is = " + ball.getSpeed());
    }
    
    public void passBall(Ball ball) {
        ball.setSpeed(ball.getSpeed() + 5);     // (1)
        System.out.println("ballSpeed() + 5 = " + ball.getSpeed());
        catchBall(ball);                        // (2)
        // System.out.println("catchBall() = " + catchBall(ball));
    }
    
    public void catchBall(Ball ball) {
        Ball newBall = new Ball();
        newBall.setSpeed(40);
        newBall.setSpeed(0);                   // (3)
        System.out.println("newBall.setSpeed(0) = " + newBall.getSpeed());
        ball = newBall;                        // (4)
        System.out.println("(4) = " + ball.getSpeed());
        System.out.println("Caught the Ball");
    }
}
