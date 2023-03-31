import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class Main_ConnectMe {

	public static void main(String[] args) throws SlickException {
		AppGameContainer app = new AppGameContainer(new Jeu("Connect Me"));
		app.setShowFPS(false);
		app.setDisplayMode(1000, 1000, false);
		app.start();
	}
	public static void exit() {
		System.exit(0);
	}

}
