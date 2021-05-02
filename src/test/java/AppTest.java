


import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;


class AppTest {
    /**
     * Rigorous Test.
     */
    @Rule
    public final ExpectedException exception = ExpectedException.none();
    public TenisGame tenisGame = new TenisGame();


    @Test
    void should_display_love_all_when_game_start() {
        assertEquals(tenisGame.score(), "love - all");
    }

    @Test
    void should_display_fifteen_loves_after_player1_as_scored() {
        gamePlayer1(1);
        assertEquals(tenisGame.score(), "Fifteen - Love");
    }


    @Test
    void should_display_love_fifteen_after_player2_as_scored() {
        gamePlayer2(1);
        assertEquals(tenisGame.score(), "Love - Fifteen");
    }

    @Test
    void should_display_thirty_love_after_player1_as_scored_twice() {
        gamePlayer1(2);
        assertEquals(tenisGame.score(), "Thirty - Love");
    }

    @Test
    void should_display_thirty_fifteen_after_player1_as_scored_twice_and_player2_one() {
        gamePlayer1(2);
        gamePlayer2(1);
        assertEquals(tenisGame.score(), "Thirty - Fifteen");
    }

    @Test
    void should_display_deuce_when_player1_as_scored_thrice_and_player2_the_same() {
        gamePlayer1(3);
        gamePlayer2(3);

        assertEquals(tenisGame.score(), "Deuce");
    }

    @Test
    void player1_should_take_advantage() {
        gamePlayer1(3);
        gamePlayer2(3);
        gamePlayer1(1);

        assertEquals(tenisGame.score(), "Advantage Player1");
    }

    @Test
    void player2_should_take_deuce_after_player1_advantage() {
        gamePlayer1(3);
        gamePlayer2(3);
        gamePlayer1(1);
        gamePlayer2(1);

        assertEquals(tenisGame.score(), "Deuce");
    }

    @Test
    void player1_should_take_deuce_after_player2_advantage() {
        gamePlayer1(3);
        gamePlayer2(3);
        gamePlayer2(1);
        gamePlayer1(1);


        assertEquals(tenisGame.score(), "Deuce");
    }

    @Test
    void player1_should_win_when_scored_fourth() {
        gamePlayer1(4);
        assertEquals(tenisGame.score(), "Game Player1");
    }

    @Test
    void player2_should_win_when_scored_after_advantage() {
        gamePlayer1(3);
        gamePlayer2(3);
        gamePlayer2(2);
        assertEquals(tenisGame.score(), "Game Player2");
    }


    private void gamePlayer1(int pointJoueur1){
        IntStream.range(0, pointJoueur1).forEach( d -> tenisGame.player1Scores());
    }

    private void gamePlayer2(int pointJoueur2){
        IntStream.range(0, pointJoueur2).forEach( d -> tenisGame.player2Scores());
    }


}