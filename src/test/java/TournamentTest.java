import org.testng.annotations.Test;
import ru.netology.Game;
import ru.netology.NotRegisteredException;
import ru.netology.data.Player;

import static org.junit.jupiter.api.Assertions.*;

public class TournamentTest {

    @Test
    void shouldFindWinnerDifferentStrengthPlayer1(){
        Game game = new Game();
        Player player1 = new Player(1, "Andrey", 5);
        Player player2 = new Player(2, "Sergey", 3);
        game.register(player1);
        game.register(player2);
        int expected = 1;
        int actual = game.round("Andrey", "Sergey");
        assertEquals(expected, actual);
    }

    @Test
    void shouldFindWinnerDifferentStrengthPlayer2(){
        Game game = new Game();
        Player player1 = new Player(1, "Andrey", 3);
        Player player2 = new Player(2, "Sergey", 5);
        game.register(player1);
        game.register(player2);
        int expected = 2;
        int actual = game.round("Andrey", "Sergey");
        assertEquals(expected, actual);
    }

    @Test
    void shouldFindWinnerEqualStrength(){
        Game game = new Game();
        Player player1 = new Player(1, "Andrey", 3);
        Player player2 = new Player(2, "Sergey", 3);
        game.register(player1);
        game.register(player2);
        int expected = 0;
        int actual = game.round("Andrey", "Sergey");
        assertEquals(expected, actual);
    }

    @Test
    void oneUnregisteredPlayer1(){
        Game game = new Game();
        Player player1 = new Player(1, "Andrey", 5);
        Player player2 = new Player(2, "Sergey", 3);
        game.register(player2);
        assertThrows(NotRegisteredException.class,() ->{
            game.round("Andrey", "Sergey");
        });
    }

    @Test
    void oneUnregisteredPlayer2(){
        Game game = new Game();
        Player player1 = new Player(1, "Andrey", 5);
        Player player2 = new Player(2, "Sergey", 3);
        game.register(player1);
        assertThrows(NotRegisteredException.class,() ->{
            game.round("Andrey", "Sergey");
        });
    }

    @Test
    void twoUnregisteredPlayers(){
        Game game = new Game();
        Player player1 = new Player(1, "Andrey", 5);
        Player player2 = new Player(2, "Sergey", 3);
        assertThrows(NotRegisteredException.class,() ->{
            game.round("Andrey", "Sergey");
        });
    }
}