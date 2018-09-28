public class Game {
    public void playGame() {
        Ball ball = new Ball(10);
        Ball passedBall = passBall(ball);
        System.out.println("The ball's speed is " + passedBall.getSpeed());
    }
    
    public Ball passBall(Ball ball) {
        ball.setSpeed(ball.getSpeed() + 5);
        System.out.println("Passed the ball");
        Ball returnedBall = returnPass(ball);
        Ball caughtBall = catchBall(returnedBall);
        return caughtBall;
    }
    
    public Ball catchBall(Ball ball) {
        ball.setSpeed(0);
        System.out.println("Caught the Ball");
        return ball;
    }
    
    public Ball returnPass(Ball ball) {
        ball.setSpeed(ball.getSpeed() + 10);
        System.out.println("Returned the pass");
        return ball;
    }
}
