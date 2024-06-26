// Reference for Lanterna 3: https://github.com/mabe02/lanterna/blob/master/docs/contents.md
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

public class ConwaysLife {
    public static void main(String[] args) {
        try {
            Terminal terminal = new DefaultTerminalFactory().createTerminal();
            Screen screen = new TerminalScreen(terminal);
            TextGraphics graphics = screen.newTextGraphics();

            TerminalSize size = screen.getTerminalSize();
            LifeSimulator simulation = new LifeSimulator(size.getColumns(), size.getRows());

            // INSERT PATTERNS:
            simulation.insertPattern(new PatternBlinker(), 15, 5);
            simulation.insertPattern(new PatternBlinker(), 10, 5);
            simulation.insertPattern(new PatternAcorn(), 10, 10);
            simulation.insertPattern(new PatternAcorn(), 14, 25);

            screen.startScreen();
            screen.setCursorPosition(null);

            for (int i = 0; i < 10000; i++) {
                render(simulation, screen, graphics);   // Render the current state of the simulation
                Thread.yield();                         // Let the JVM have some time to update other things
                Thread.sleep(150);              // Sleep for a bit to make for a nicer paced animation
                simulation.update();                    // Tell the simulation to update
            }

            screen.stopScreen();
        } catch (Exception ex) {
            System.out.println("Something bad happened: " + ex.getMessage());
        }
    }
    public static void render(LifeSimulator lifeSimulator, Screen screen, TextGraphics graphics) {
        // Loop through and render alive cells.
        for (int x = 0; x < lifeSimulator.getSizeX(); x++) {
            for (int y = 0; y < lifeSimulator.getSizeY(); y++) {
                if (lifeSimulator.getCell(x, y)) {
                    graphics.setCharacter(y, x, 'U');
                } else {
                    graphics.setCharacter(y, x, ' ');
                }
            }
        }

        // Render new state.
        try {
            screen.refresh();
        } catch (Exception ex) {
            System.out.println("Error refreshing screen: " + ex.getMessage());
        }
    }
}