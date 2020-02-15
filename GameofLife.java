public class GameofLife {
    public static void main(String[] args){
    }
    int size;
    int[][] gameBoard;
    int[][] previous;

    public GameofLife(){

    }
    public GameofLife(int size){
        this.size = size;
        this.gameBoard = new int[size][size];
        this.previous = new int [size][size];
    }
    public int [][] getBoard(){
        return gameBoard;
    }

    public GameofLife(int[][] board) {
        int size = board.length;
        previous = new int[size][size];
        //Initialize your board and previous
        //Nested for loop: copying from board to previous
        for(int i = 0; i < board.length; i++){
            for(int j = 0 ; j < board.length; j++){
                this.previous[i][j] = board[i][j];
            }
        }
        gameBoard = board;
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
    public int neighbors(int row, int col){
        //To determine how many dead and live neighbors a cell has
        int numNeighbors = 0;

        for(int i = row - 1; i <= row + 1; i++){
            for(int j = col -1; j <= col + 1; j++){
                //System.out.println("\ni: " + i + "\nj: " + j);
                //If out of bounds
                if(i < 0 || i >= gameBoard.length || j < 0 || j >= gameBoard[i].length){
                    continue;
                }
                //Ignoring itself when parsing through the array
                if(row == i && col == j){
                    continue;
                }
                //Checking for live neighbors
                if(gameBoard[i][j] == 1){
                    numNeighbors++;
                }
            }
        }
        return numNeighbors;
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
            for (int j = 0; j < gameBoard.length; j++){
                System.out.print(gameBoard[i][j] + " ");
            }
            System.out.println();
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
