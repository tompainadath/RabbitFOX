public class Rabbit extends Animal {
    private boolean haveSeenFox = false;
    private boolean canSeeFoxNow = false;
    private int distanceToFox;
    private int directionToFox;
    private int currentDirection;
    private int directionAwayFromFox;
    private int nextOptPosition;



    public Rabbit(Model model, int row, int column) {
        super(model, row, column);
    }

    int decideMove() {  //define decide move function
        canSeeFoxNow = false;  //initialize canSeeFoxNow to false
        for (int i = Model.MIN_DIRECTION; i <= Model.MAX_DIRECTION; i++) {  //for loop to look around for fox
            if (look(i) == Model.FOX) {  //check to see if fox is found
                canSeeFoxNow = true;  //set canSeeFoxNow to true
                directionToFox = i;  //set directionToFox to the direction the fox is seen at
                distanceToFox = distance(i);  //set distanceToFox using the function distance()
                if (distanceToFox + 4 > 7){  //if distanceToFox
                    directionAwayFromFox =- 4;
                } else {
                    directionAwayFromFox = directionToFox + 4;
                }

                if (canMove(directionAwayFromFox) == true) {
                    return Model.turn(directionAwayFromFox, 1);
                } else {
                    if(directionToFox == 0 | directionToFox == 1 | directionToFox == 7){
                        nextOptPosition = random(5, 7);
                    }
                    else if (directionToFox == 3 | directionToFox == 4 | directionToFox == 5){
                        nextOptPosition = random(0,2);
                    }
                    else {
                        nextOptPosition = random(Model.MIN_DIRECTION, Model.MAX_DIRECTION);
                    }
                    return Model.turn(nextOptPosition, -1);
                }
            }
        }

        return Model.STAY;
    }
}
