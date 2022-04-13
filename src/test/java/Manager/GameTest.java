package Manager;

import Domain.NotRegisteredException;
import Domain.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    Game gameRound = new Game();

    public Player player1 = new Player(1, "First", 200);
    public Player player2 = new Player(2, "Second", 200);

    @BeforeEach
    public void prepareList() {
        gameRound.register(player1);
        gameRound.register(player2);
    }

    @Test
    void shouldReturnZeroTest() {
        String playerName1 = "First";
        String playerName2 = "Second";
        int expected = gameRound.round(playerName1, playerName2);
        int actual = 0;
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnOneTest() {
        String playerName1 = "First";
        String playerName2 = "Second";
        player1.setStrength(300);
        int expected = gameRound.round(playerName1, playerName2);
        int actual = 1;
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnTwoTest() {
        String playerName1 = "First";
        String playerName2 = "Second";
        player2.setStrength(300);
        int expected = gameRound.round(playerName1, playerName2);
        int actual = 2;
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({"Third, Second", "First, Third", "Third, Fourth"})
    void shouldTrowExceptionTest(String playerName1, String playerName2) {
        assertThrows(NotRegisteredException.class, () -> gameRound.round(playerName1, playerName2));
    }
}