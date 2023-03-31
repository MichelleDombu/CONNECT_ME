import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Carre {

	private boolean lat = false;
	private boolean horizontal = false;
	private boolean roter = false;
	private String type;
	private int[] connect = new int[4];
	private int x, xNat;
	private int y, yNat;
	private Image img;
	private static final int taille = 140;
	private boolean[] estConnecte = { false, false, false, false };

	// Constructeur permettant de créer un plateau
	public Carre(String type, int[] connect, int x, int y) throws SlickException {
		this.type = type;
		this.connect = connect;

		if (type == "all") {
			img = new Image("Images/OrRotation.jpg");
			lat = true;
			horizontal = true;
			roter = true;
		}
		if (type == "all direction") {
			img = new Image("Images/vert.jpg");
			lat = true;
			horizontal = true;

		}
		if (type == "rot") {
			img = new Image("Images/bleu.jpg");

			roter = true;
		}
		if (type == "nothing") {
			img = new Image("Images/rouge.jpg");
		}
		if (type == "lateral") {
			img = new Image("Images/violetHorizontal.jpg");
			lat = true;

		}
		if (type == "Horizontal") {
			img = new Image("Images/violetttttt.jpg");
			

			horizontal = true;

		}
		this.x = x;
		this.y = y;
		xNat = x; // Pour qu'à chaque fois qu'on fait un déplacement la case précedente ne reste
					// pas vide
		yNat = y;
	}

	// Accesseurs
	public boolean isLat() {
		return lat;
	}

	public void setLat(boolean lat) {
		this.lat = lat;
	}

	public boolean isHorizontal() {
		return horizontal;
	}

	public void setHorizontal(boolean horizontal) {
		this.horizontal = horizontal;
	}

	public boolean isRoter() {
		return roter;
	}

	public void setRoter(boolean roter) {
		this.roter = roter;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int[] getConnect() {
		return connect;
	}

	public void setConnect(int[] connect) {
		this.connect = connect;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getXNat() {
		return xNat;
	}

	public void setXNat(int xNat) {
		this.xNat = xNat;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getYNat() {
		return yNat;
	}

	public void setYNat(int yNat) {
		this.yNat = yNat;
	}

	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
	}

	public boolean[] getEstConnecte() {
		return estConnecte;
	}

	public boolean isConnect() {
		for (int i = 0; i < 4; i++) {
			if (!estConnecte[i] && connect[i] != 0)
				return false;
		}
		return true;
	}

	public void setEstConnecte(boolean[] estConnecte) {
		this.estConnecte = estConnecte;
	}

	public static int getTaille() {
		return taille;
	}

	// Méthodes permettant de remplir le tableau de booléens
	public void setConnectHaut(boolean h) {
		this.estConnecte[0] = h;
	}

	public void setConnectBas(boolean b) {
		this.estConnecte[2] = b;
	}

	public void setConnectGauche(boolean g) {
		this.estConnecte[3] = g;
	}

	public void setConnectDroite(boolean d) {
		this.estConnecte[1] = d;
	}

	// Constructeur permettant de créer des careés vides
	public Carre(int x, int y) {
		this.type = "vide";
		this.x = x;
		this.y = y;
		xNat = x;
		yNat = y;
	}

	// Méthode permettant la représentation des pions
	public void dessinerPieces(Graphics g) {
		float xbegin;
		float ybegin;

		if (type != "vide") {
			Color connectColor = g.getColor();
			g.setColor(Color.white);

			for (int i = 0; i < connect.length; i++) {
				if (i % 2 == 0) {
					if (connect[i] > 1)
						xbegin = x + 20 + img.getWidth() / 2 - (connect[i] * 10 + (connect[i] - 1) * 10) / 2;
					else
						xbegin = x + 20 + img.getWidth() / 2 - (connect[i] * 10) / 2;
					for (int j = 0; j < connect[i]; j++)
						g.fillRect(xbegin + j * 20, y + (img.getHeight() / 2 + 10) * i, 10, 20);
				} else {
					if (connect[i] > 1)
						ybegin = y + 20 + img.getHeight() / 2 - (connect[i] * 9 + (connect[i] - 1) * 9) / 2;
					else
						ybegin = y + 20 + img.getHeight() / 2 - connect[i] * 9 / 2;
					for (int j = 0; j < connect[i]; j++)
						g.fillRect(x - (img.getHeight() / 2 + 9) * (i - 1) + 120, ybegin + j * 20, 20, 9);
				}
			}
			g.drawImage(img, x + 20, y + 20);
			g.setColor(connectColor);
		}
	}

	// Méthode permettant de vérifier que le clic effectuer soit bien délimitée dans la case
	public boolean isClicked(int x, int y) {
		if (this.x < x && this.x + taille > x && this.y < y && this.y + taille > y)
			return true;
		return false;
	}

	// Méthode permettant le déplacement des pions
	public void deplacer(int x1, int y1) {
		this.x = x1;
		this.y = y1;

	}

	public void deplacerH(int x1) {
		this.x = x1;

	}

	public void deplacerV(int y1) {
		this.y = y1;

	}

	// Méthode permettant de faire roter les pions
	public void rotation() {
		if (type == "rot" || type=="all") {
			int permut = 0;
			for (int i = connect.length - 1; i > 0; i--) {
				if (this.type == "rot" || this.type == "all") {
					permut = connect[i];
					connect[i] = connect[i - 1];
					connect[i - 1] = permut;
				}
			}
		}
	}

	

}
