package juego.com.example.guessGame;

import juego.com.example.guessGame.Controller.GameController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class GuessGameControllerTests {

    @Autowired
    private GameController gameController;

    @BeforeEach
    public void setUp() {
        gameController.reiniciarJuego();
    }

    @Test
    public void testReiniciarJuego() {

        int initialAttempts = gameController.getIntentos();
        int initialRandomNumber = gameController.getNumeroAleatorio();
        boolean initialGameStatus = gameController.isJuegoTerminado();

        gameController.reiniciarJuego();


        assertEquals(1, gameController.getIntentos());
        assertTrue(gameController.getNumeroAleatorio() >= 1 && gameController.getNumeroAleatorio() <= 100);
        assertEquals(false, gameController.isJuegoTerminado());
    }

    @Test
    public void testAdivinarCorrectGuess() {

        gameController.reiniciarJuego();
        gameController.setNumeroAleatorio(42);

        // Make a correct guess
        String result = gameController.adivinar(42);

        // Check if the result is as expected
        assertTrue(result.contains("¡Felicidades! Has adivinado el número en"));
        assertTrue(gameController.isJuegoTerminado());
    }

    @Test
    public void testAdivinarLowerGuess() {

        gameController.reiniciarJuego();
        gameController.setNumeroAleatorio(42);


        String result = gameController.adivinar(30);


        assertTrue(result.contains("La suposición es más baja que el número a adivinar."));
        assertEquals(2, gameController.getIntentos());
        assertFalse(gameController.isJuegoTerminado());
    }



    @Test
    public void testGetIntentos() {
        // Check if the initial attempts value is returned
        assertEquals(1, gameController.getIntentos());
    }
}
