public class TorusGameofLife extends GameofLife{
    public TorusGameofLife(){
    }
    public TorusGameofLife(int size){
        this.size = size;
        gameBoard = new int[size][size];
        previous = new int[size][size];
    }
    public TorusGameofLife(int [][] board){

        int boardSize = board.length;

        previous = new int[boardSize][boardSize];

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                previous[i][j] = board[i][j];
            }
        }
        gameBoard = board;
    }
    @Override
    public int neighbors(int row ,int col){
        int numNeighbors = 0;

        if(gameBoard[((row - 1) + size) % size][((col - 1) + size) % size] == 1){
            numNeighbors++;
        }
        if(gameBoard[((row - 1) + size) % size][(col + size) % size] == 1){
            numNeighbors++;
        }
        if(gameBoard[((row - 1) + size) % size][((col + 1) + size) % size] == 1){
            numNeighbors++;
        }
        if(gameBoard[(row + size) % size][((col - 1) + size) % size] == 1){
            numNeighbors++;
        }
        if(gameBoard[(row + size) % size][((col + 1) + size) % size] == 1){
            numNeighbors++;
        }
        if(gameBoard[((row + 1) + size) % size][((col -1) + size) % size] == 1){
            numNeighbors++;
        }
        if(gameBoard[((row + 1) + size) % size][(col + size) % size] == 1){
            numNeighbors++;
        }
        if(gameBoard[((row + 1) + size) % size][((col + 1) + size) % size] == 1){
            numNeighbors++;
        }
        return numNeighbors;
    }
    public void oneStep(){
        //the rules
        //Copying current to previous
        for(int row = 0; row < gameBoard.length; row++){
            for(int col = 0; col < gameBoard[row].length; col++){
                previous[row][col] = gameBoard[row][col];
            }
        }
        for(int i = 0; i < previous.length; i++){
            for(int j = 0; j < previous[i].length; j++){
                //Calling neighbors
                int numNeighbors = neighbors(i, j);

                //Checking if cell is even alive
                if(previous[i][j] == 1){


                    //A live cell with less than 2 neighbors dies
                    if (numNeighbors <= 2){
                        previous[i][j] = 0;
                    }
                    //If live cell has 2 or 3 Neighbors
                    if(numNeighbors == 2 || numNeighbors == 3){
                        //Continues to live
                        previous[i][j] = 1;
                    }
                    //Live cell with > 3 neighbors dies
                    if(numNeighbors > 3){
                        previous[i][j] = 0;
                    }
                }
                if(numNeighbors == 3){
                    previous[i][j] = 1;
                }
            }
        }
        //Updating the game board with previous board
        for(int a = 0; a < previous.length; a++){
            for(int b = 0; b < previous[b].length; b++){
                gameBoard[a][b] = previous[a][b];
            }
        }
    }
    public void evolution(int n){
        System.out.println("Generation 0");
        //calls oneStep n times
        printBoard();
        int generation = 1;

        while(n != 0){

            oneStep();
            System.out.print("\n\nGeneration " + generation + ":");
            printBoard();

            generation++;
            n--;
        }
    }
    public void printBoard(){
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard.length; j++) {
                System.out.println(gameBoard[i][j]);
            }
        }
    }
    public void printPreviousBoard(){
        for(int i = 0; i < previous.length; i++){
            for(int j = 0; j < previous.length; j++){
                System.out.println(previous[i][j]);
            }
        }
    }
}