import org.ietf.jgss.GSSManager;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GOLTester {
    public int [][] array1 = {
            {0, 0, 0, 0, 0, 1},
            {0, 1, 1, 0, 0, 0},
            {0, 1, 1, 1, 1, 0},
            {1, 0, 1, 1, 0, 0},
            {0, 1, 0, 0, 0, 0},
            {0, 1, 0, 1, 0, 1},
    };
    public int [][] array2 = {
            {1, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 1},
    };
    public int [][] array3 = {
            {1, 1, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 1, 1, 1, 0},
            {0, 0, 1, 1, 1, 0},
            {0, 0, 1, 1, 1, 0},
            {1, 1, 1, 0, 0, 0},
    };

    @Test
    public void Torus_neighbors_test1(){
        TorusGameofLife board = new TorusGameofLife(array1);
        assertEquals(4, board.neighbors(3, 3));
    }
    @Test
    public void Torus_neighbors_test2(){
        TorusGameofLife board = new TorusGameofLife(array2);
        assertEquals(4, board.neighbors(5, 0));
    }
    @Test
    public void Torus_neighbors_test3(){
        TorusGameofLife board = new TorusGameofLife(array3);
        assertEquals(3, board.neighbors(5, 1));
    }
    @Test
    public void Torus_neighbors_test4(){
        TorusGameofLife board = new TorusGameofLife(array1);
        assertEquals(3, board.neighbors(1, 4));
    }
    @Test
    public void Torus_neighbors_test5(){
        TorusGameofLife board = new TorusGameofLife(array3);
        assertEquals(8, board.neighbors(3, 3));
    }
    @Test
    public void Torus_oneStep_test1(){
        int [][] a = {
                {1, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 1},
        };
        TorusGameofLife board = new TorusGameofLife(a);
        board.oneStep();
        assertArrayEquals(array1, board.getBoard());
    }
    @Test
    public void Torus_oneStep_test2(){
        int [][] b = {
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
        };
        TorusGameofLife board = new TorusGameofLife(b);
        assertArrayEquals(array2, board.getBoard());
    }
    @Test
    public void Torus_oneStep_test3(){
        int [][] c = {
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
        };
        TorusGameofLife board = new TorusGameofLife(c);
        assertArrayEquals(array3, board.getBoard());
    }
    @Test
    public void Torus_oneStep_test4(){
        int [][] d = {
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0},
        };
        TorusGameofLife board = new TorusGameofLife(d);
        assertArrayEquals(array1, board.getBoard());
    }
    @Test
    public void Torus_oneStep_test5(){
        int [][] e = {
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1},
        };
        TorusGameofLife board = new TorusGameofLife(e);
        assertArrayEquals(array3, board.getBoard());
    }
    @Test
    public void Torus_evolution_test1(){
        TorusGameofLife board = new TorusGameofLife();
        board.evolution(5);
        assertArrayEquals(array1, board.getBoard());
    }
    @Test
    public void Torus_evolution_test2(){
        TorusGameofLife board = new TorusGameofLife();
        board.evolution(3);
        assertArrayEquals(array2, board.getBoard());
    }
    @Test
    public void Torus_evolution_test3(){
        TorusGameofLife board = new TorusGameofLife();
        board.evolution(7);
        assertArrayEquals(array1, board.getBoard());
    }
    @Test
    public void Torus_evolution_test4(){
        TorusGameofLife board = new TorusGameofLife();
        board.evolution(5);
        assertArrayEquals(array3, board.getBoard());
    }
    @Test
    public void Torus_evolution_test5(){
        TorusGameofLife board = new TorusGameofLife(array1);
        board.evolution(3);
        assertArrayEquals(array1, board.getBoard());
    }
}
