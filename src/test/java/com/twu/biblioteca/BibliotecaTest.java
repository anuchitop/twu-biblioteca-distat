package test.java.com.twu.biblioteca;

import main.java.com.twu.Biblioteca;
import main.java.com.twu.menu.Menu;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BibliotecaTest {
    private Biblioteca app = new Biblioteca();

    @Test
    public void welcomeMessageShouldAppearWhenRunningTheApp() {
        assertEquals("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!", app.showWelcomeMessage());
    }

    @Test
    public void choosingMenuIDShouldReturnTheRightMenu() {
        // Valid input
        assertEquals("ListOfBooks", app.getMenu(1).getClass().getSimpleName());
        assertEquals("ListOfMovies", app.getMenu(2).getClass().getSimpleName());
    }

    @Test
    public void choosingInvalidMenuReturnNull() {
        // Input as zero
        Menu className = app.getMenu(0);
        assertEquals(null, className);
    }
}