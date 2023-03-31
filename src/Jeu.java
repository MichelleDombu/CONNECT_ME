import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;

public class Jeu extends BasicGame {

	private Image bg = null;
	private Image bgMenu = null;
	private Image p1 = null;
	private Plateau p;
	private Plateau p2;
	private Plateau p3;
	private Plateau pTemp;
	private Menu m;
	private String[] type = { "all", "all direction", "nothing", "lateral", "horizontal", "rot" };
	private Carre c;
	private int[] con;
	private Music son;
	private int timer=0;

	public Jeu(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		
		
		if (m.getPage() == 1) {
			p1.draw();
			m.dessinerPageAcceuil(g);
		}else if (m.getPage() == 2) {
			bg.draw(0, 0);
			m.dessinerDescription(g);
		} else if (m.getPage() == 3) {
			bg.draw(0, 0);
			m.pageNiveau(g);
		} else if (m.getPage() == 4) {
			bg.draw(0, 0);
			g.drawString("Niveau 1", 480, 50);
		    p.dessinerPlateau(g);
			if (p.allIsConnect()) {
				m.dessinerPagewin(g);
			}
		} else if (m.getPage() == 5) {
			bg.draw(0,0);
			g.drawString("Niveau 2", 480, 50);
			p2.dessinerPlateau(g);
			if (p2.allIsConnect()) {
				m.dessinerPagewin(g);
			}
		} else if (m.getPage() == 6) {
			bg.draw();
			g.drawString("Niveau 3", 480, 50);
			p3.dessinerPlateau(g);
			if (p3.allIsConnect()) {
				m.dessinerPagewin(g);
			}
		}
		
		//Cette condition permet de définir le temps au niveau 3 et d'afficher l'image de fin si le temps est dépassé
		if(timer>8000f) {
			Image img1=new Image("Images/gameO.jpg");
			g.drawImage(img1, 0, 200);
			
		}

	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		// TODO Auto-generated method stub
		p1 = new Image("p1.jpg");
		bgMenu = new Image("Images/bgmenu.jpg");
		bg = new Image("plateau.jpg");
		p = new Plateau(2);
		p.updateStateCarre();
		p2 = new Plateau(1);
		p2.updateStateCarre();
		p3 = new Plateau(3);
		p3.updateStateCarre();
		m = new Menu();
		con = new int[4];
		son=new Music("Images/son.ogg");
		son.loop();
	}

	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		// TODO Auto-generated method stuby
		Input inp = gc.getInput();
		
		if (inp.isMousePressed(Input.MOUSE_RIGHT_BUTTON)) {
			if (m.getPage() == 4) {
				p.manageRot(inp.getMouseX(), inp.getMouseY());
				m.homeIsClicked(inp.getMouseX(), inp.getMouseY());
			} else if (m.getPage() == 5) {
				p2.manageRot(inp.getMouseX(), inp.getMouseY());
				m.homeIsClicked(inp.getMouseX(), inp.getMouseY());
			} else if (m.getPage() == 6) {
				
				if(delta<3000f)
				p3.manageRot(inp.getMouseX(), inp.getMouseY());
				m.homeIsClicked(inp.getMouseX(), inp.getMouseY());	
			}
		}
		if(m.getPage()==6) {
			timer=timer+delta;
		}
		
		if (inp.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
			
			if (m.getPage() == 1) {
				m.jouerIsClicked(inp.getMouseX(), inp.getMouseY());
			}
			if (m.getPage() == 2) {
				m.jouerEstCliqué(inp.getMouseX(), inp.getMouseY());
			}
			if (m.getPage() == 3) {
				m.niveauIsClicked(inp.getMouseX(), inp.getMouseY());
			}
			if (m.getPage() == 4) {
				p.manageClick(inp.getMouseX(), inp.getMouseY());
				p.updateStateCarre();
			} else if (m.getPage() == 5) {
				p2.manageClick(inp.getMouseX(), inp.getMouseY());
				p2.updateStateCarre();
			} else if (m.getPage() == 6) {
				p3.manageClick(inp.getMouseX(), inp.getMouseY());
				p3.updateStateCarre();
				
			}
			/*
			 * if (p.allIsConnect()) { m.dessinerPage3(g); }
			 */
		} else {
			if (m.getPage() == 4) {
				p.moveCarre(inp.getMouseX(), inp.getMouseY(), gc);

			} else if (m.getPage() == 5) {
				p2.moveCarre(inp.getMouseX(), inp.getMouseY(), gc);
			} else if (m.getPage() == 6) {
				p3.moveCarre(inp.getMouseX(), inp.getMouseY(), gc);
			}
		}

	}

}
