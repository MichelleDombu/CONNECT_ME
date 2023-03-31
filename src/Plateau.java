import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Plateau {

	private Carre[][] pl;
	private int timer;
	static private int niveau;
	private final int x = 200; // position du plateau de jeu dans la fenêtre
	private final int y = 200;
	private boolean moving;
	private int iTemp, jTemp;
	private boolean toutEstConnecte;

	// Constructeur 
	public Plateau(int niveau) throws SlickException {
		pl = new Carre[4][4];
		for (int i = 0; i < pl.length; i++) {
			for (int j = 0; j < pl.length; j++) {
				pl[i][j] = new Carre(x + 140 * j, y + 140 * i);
			}
		}
		if (niveau == 1) {
			this.chargePlateau(1);
		} else if (niveau == 2) {
			this.chargePlateau(2);
		}else if(niveau==3) {
			this.chargePlateau(3);
		}
	}

	// Accesseurs
	public Carre[][] getPl() {
		return pl;
	}
	

	public int getTimer() {
		return timer;
	}

	public void setTimer(int timer) {
		this.timer = timer;
	}

	public int getNiveau() {
		return niveau;
	}

	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}

	public boolean isMoving() {
		return moving;
	}

	public void setMoving(boolean moving) {
		this.moving = moving;
	}

	public int getiTemp() {
		return iTemp;
	}

	public void setiTemp(int iTemp) {
		this.iTemp = iTemp;
	}

	public int getjTemp() {
		return jTemp;
	}

	public void setjTemp(int jTemp) {
		this.jTemp = jTemp;
	}

	public boolean isToutEstConnecte() {
		return toutEstConnecte;
	}

	public void setToutEstConnecte(boolean toutEstConnecte) {
		this.toutEstConnecte = toutEstConnecte;
	}

	public void setPl(Carre[][] pl) {
		this.pl = pl;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	

	// Méthode permettant de charger le plateau d'un niveau
	public void chargePlateau(int niveau) throws SlickException {
		int[] con;
		Carre[] c;

		if (niveau == 1) {
			con = new int[4];
			con[0] = 2;
			con[1] = 4;
			con[2] = 0;
			con[3] = 0;
			pl[1][1] = new Carre("all direction", con, pl[1][1].getX(), pl[1][1].getY());

			con = new int[4];
			con[0] = 0;
			con[1] = 2;
			con[2] = 0;
			con[3] = 0;
			pl[3][0] = new Carre("all direction", con, pl[3][0].getX(), pl[3][0].getY());

			con = new int[4];
			con[0] = 4;
			con[1] = 0;
			con[2] = 2;
			con[3] = 4;
			pl[3][3] = new Carre("all direction", con, pl[3][3].getX(), pl[3][3].getY());

			con = new int[4];
			con[0] = 0;
			con[1] = 3;
			con[2] = 2;
			con[3] = 2;
			pl[0][2] = new Carre("nothing", con, pl[0][2].getX(), pl[0][2].getY());

			con = new int[4];
			con[0] = 0;
			con[1] = 0;
			con[2] = 4;
			con[3] = 3;
			pl[0][3] = new Carre("nothing", con, pl[0][3].getX(), pl[0][3].getY());

			con = new int[4];
			con[0] = 2;
			con[1] = 0;
			con[2] = 0;
			con[3] = 3;
			pl[1][3] = new Carre("lateral", con, pl[1][3].getX(), pl[1][3].getY());

			con = new int[4];
			con[0] = 0;
			con[1] = 3;
			con[2] = 0;
			con[3] = 0;
			pl[2][3] = new Carre("Horizontal", con, pl[2][3].getX(), pl[2][3].getY());

		}

		else if (niveau == 2) {
			con = new int[4];
			con[0] = 0;
			con[1] = 0;
			con[2] = 0;
			con[3] = 4;
			pl[0][0] = new Carre("all direction", con, pl[0][0].getX(), pl[0][0].getY());

			con = new int[4];
			con[0] = 0;
			con[1] = 1;
			con[2] = 3;
			con[3] = 0;
			pl[1][2] = new Carre("all direction", con, pl[1][2].getX(), pl[1][2].getY());

			con = new int[4];
			con[0] = 1;
			con[1] = 0;
			con[2] = 0;
			con[3] = 4;
			pl[3][2] = new Carre("all direction", con, pl[3][2].getX(), pl[3][2].getY());

			con = new int[4];
			con[0] = 0;
			con[1] = 4;
			con[2] = 0;
			con[3] = 1;
			pl[1][1] = new Carre("all", con, pl[1][1].getX(), pl[1][1].getY());

			con = new int[4];
			con[0] = 1;
			con[1] = 0;
			con[2] = 3;
			con[3] = 0;
			pl[2][3] = new Carre("all", con, pl[2][3].getX(), pl[2][3].getY());

			con = new int[4];
			con[0] = 0;
			con[1] = 0;
			con[2] = 0;
			con[3] = 4;
			pl[2][0] = new Carre("rot", con, pl[2][0].getX(), pl[2][0].getY());
		}

		else if (niveau == 3) {
			con = new int[4];
			con[0] = 2;
			con[1] = 0;
			con[2] = 0;
			con[3] = 4;
			pl[0][1] = new Carre("all", con, pl[0][1].getX(), pl[0][1].getY());

			con = new int[4];
			con[0] = 0;
			con[1] = 0;
			con[2] = 0;
			con[3] = 4;
			pl[0][2] = new Carre("all direction", con, pl[0][2].getX(), pl[0][2].getY());

			con = new int[4];
			con[0] = 2;
			con[1] = 0;
			con[2] = 1;
			con[3] = 0;
			pl[0][3] = new Carre("all direction", con, pl[0][3].getX(), pl[0][3].getY());

			con = new int[4];
			con[0] = 2;
			con[1] = 0;
			con[2] = 4;
			con[3] = 4;
			pl[1][1] = new Carre("rot", con, pl[1][1].getX(), pl[1][1].getY());

			con = new int[4];
			con[0] = 4;
			con[1] = 4;
			con[2] = 0;
			con[3] = 0;
			pl[1][3] = new Carre("all", con, pl[1][3].getX(), pl[1][3].getY());

			con = new int[4];
			con[0] = 0;
			con[1] = 4;
			con[2] = 2;
			con[3] = 4;
			pl[2][3] = new Carre("all direction", con, pl[2][3].getX(), pl[2][3].getY());

			con = new int[4];
			con[0] = 0;
			con[1] = 1;
			con[2] = 0;
			con[3] = 0;
			pl[3][1] = new Carre("rot", con, pl[3][1].getX(), pl[3][1].getY());

		}
	}

	// Méthode permettant de dessinner la grille de jeu
	public void dessinerPlateau(Graphics g) {
		int taille = Carre.getTaille();
		int x, y;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				x = pl[i][j].getXNat();
				y = pl[i][j].getYNat();
				g.setColor(new Color(34, 66, 124));
				g.fillRect(x, y, taille, taille);
				g.setColor(Color.black);
				g.drawRect(x, y, taille, taille);
				pl[i][j].dessinerPieces(g);
			}
		}
		pl[iTemp][jTemp].dessinerPieces(g);
	}

	// Méthode permettant de vérifier si les pions sont connectés
	public void updateStateCarre() {
		for (int i = 0; i < pl.length; i++) {
			for (int j = 0; j < pl.length; j++) {
				if (pl[i][j].getType() != "vide") {
					if (i - 1 >= 0 && pl[i][j].getConnect()[0] == pl[i - 1][j].getConnect()[2])
						pl[i][j].setConnectHaut(true);
					else
						pl[i][j].setConnectHaut(false);

					if (i + 1 < pl.length && pl[i][j].getConnect()[2] == pl[i + 1][j].getConnect()[0])
						pl[i][j].setConnectBas(true);
					else
						pl[i][j].setConnectBas(false);

					if (j + 1 < pl.length && pl[i][j].getConnect()[1] == pl[i][j + 1].getConnect()[3])
						pl[i][j].setConnectDroite(true);
					else
						pl[i][j].setConnectDroite(false);

					if (j - 1 >= 0 && pl[i][j].getConnect()[3] == pl[i][j - 1].getConnect()[1])
						pl[i][j].setConnectGauche(true);
					else
						pl[i][j].setConnectGauche(false);
				}
			}
		}
	}

	//Méthode permettant de déterminer si tous les pions ont été connectés
	public boolean allIsConnect() {
		for (int i = 0; i < pl.length; i++) {
			for (int j = 0; j < pl.length; j++) {
				if (!pl[i][j].isConnect()) {
					return false;
				}
			}
		}
		return true;
	}

	//Méthode permettant de vérifier que toutes les conditions du jeu sont belles et biens respectées lors d'une action effectuée
	public void manageClick(int x, int y) {
		if (!moving)
			for (int i = 0; i < pl.length; i++) {
				for (int j = 0; j < pl.length; j++) {
					if (pl[i][j].isClicked(x, y) && pl[i][j].getType() != "nothing" && pl[i][j].getType() != "rot") {
						iTemp = i;
						jTemp = j;
						moving = true;
					} else if (pl[i][j].isClicked(x, y) && pl[i][j].getType() == "rot") {
						pl[i][j].rotation();

					} else if (pl[i][j].isClicked(x, y) && pl[i][j].getType() == "all direction") {
						iTemp = i;
						jTemp = j;
						moving = true;
					}
				}
			}
		else {
			Carre tempo;
			for (int i = 0; i < pl.length; i++) {
				for (int j = 0; j < pl.length; j++) {
					if (pl[i][j].isClicked(x, y) && pl[i][j].getType() == "vide"
							&& ((pl[iTemp][jTemp].getType() == "Horizontal" && i == iTemp)
									|| (pl[iTemp][jTemp].getType() == "lateral" && j == jTemp)
									|| ((pl[iTemp][jTemp].getType() != "Horizontal"
											&& pl[iTemp][jTemp].getType() != "lateral")))) {

						pl[i][j].deplacer(pl[iTemp][jTemp].getXNat(), pl[iTemp][jTemp].getYNat());
						pl[iTemp][jTemp].deplacer(pl[i][j].getXNat(), pl[i][j].getYNat());
						pl[i][j].setXNat(pl[i][j].getX());
						pl[i][j].setYNat(pl[i][j].getY());
						pl[iTemp][jTemp].setXNat(pl[iTemp][jTemp].getX());
						pl[iTemp][jTemp].setYNat(pl[iTemp][jTemp].getY());
						tempo = pl[i][j];
						pl[i][j] = pl[iTemp][jTemp];
						pl[iTemp][jTemp] = tempo;
						moving = false;
					}
					// Si on sort du plateau, le pion revient à sa position initiale
					else if (i == pl.length - 1 && j == pl.length - 1 && moving) {
						pl[iTemp][jTemp].deplacer(pl[iTemp][jTemp].getXNat(), pl[iTemp][jTemp].getYNat());

						moving = false;
					}
				}
			}
		}
	}

	//Méthode permettant de gérer les rotations
	public void manageRot(int x, int y) {
		if (!moving) {
			for (int i = 0; i < pl.length; i++) {
				for (int j = 0; j < pl.length; j++) {
					if (pl[i][j].isClicked(x, y) && pl[i][j].getType() == "all") {
						pl[i][j].rotation();
					}
				}
			}
		}
	}

	//Méthode permettant de gérer les déplacements
	public void moveCarre(int x, int y, GameContainer gc) {
		if (x > 0 && x < gc.getWidth() && y > 0 && y < gc.getHeight() && moving)
			pl[iTemp][jTemp].deplacer(x, y);
	}

}
