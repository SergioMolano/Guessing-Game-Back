package juego.com.example.guessGame.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class GameController {

    private int numeroAleatorio;
    private int intentos;
    private boolean juegoTerminado;

    public GameController() {
        reiniciarJuego();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/nuevo")
    public void reiniciarJuego() {
        Random random = new Random();
        numeroAleatorio = random.nextInt(100) + 1;
        intentos = 1;
        juegoTerminado = false;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/adivinar/{suposicion}")
    public String adivinar(@PathVariable int suposicion) {
        if (juegoTerminado) {
            return "El juego ha terminado. Reinicie para jugar de nuevo.";
        }

        intentos++;

        if (suposicion < 1 || suposicion > 100) {
            return "La suposición debe estar entre 1 y 100.";
        }

        if (suposicion == numeroAleatorio) {
            juegoTerminado = true;
            return "¡Felicidades! Has adivinado el número en " + intentos + " intentos.";
        } else if (suposicion < numeroAleatorio) {
            return "La suposición es más baja que el número a adivinar. Intenta de nuevo.";
        } else {
            return "La suposición es más alta que el número a adivinar. Intenta de nuevo.";
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/intentos")
    public int getIntentos() {
        return intentos;
    }

    public boolean isJuegoTerminado() {
        return juegoTerminado;
    }

    public int getNumeroAleatorio() {
        return numeroAleatorio;
    }
}
