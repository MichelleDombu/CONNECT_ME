import org.newdawn.slick.Color;
import org.newdawn.slick.Font;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Menu {
	private int page = 1;
	private Image im;
	private Image im2;
	private Image im3;
	private Image im4;
	private Image im5;
	private Image im6;
	private Image im7;
	private Image un;
	private Image deux;
	private Image trois;
	private Image quatre;
	private Image cinq;
	private Image six;
	private Image pause;
	private Image play;
	private Font font;

	public Menu() throws SlickException {
		this.page = page;
		this.im = new Image("Images/logo.jpg");
		this.im2 = new Image("Images/jouer.jpg");
		this.im3 = new Image("Images/bgWon.png");
		this.im4 = new Image("Images/home.png");
		this.im5 = new Image("Images/next.jpg");
		this.im6 = new Image("Images/lost.jpg");
		this.im7 = new Image("Images/texte1Aide.png");
		this.un= new Image("Images/un.png");
		this.deux = new Image("Images/deux.png");
		this.trois = new Image("Images/trois.png");
		this.quatre = new Image("Images/quatre.png");
		this.cinq = new Image("Images/cinq.png");
		this.six = new Image("Images/six.png");
		this.pause=new Image("Images/pause.png");
		this.play=new Image("Images/play.jpg");
	}

	//Accesseurs
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public Image getIm() {
		return im;
	}

	public void setIm(Image im) {
		this.im = im;
	}

	public Image getIm2() {
		return im2;
	}

	public void setIm2(Image im2) {
		this.im2 = im2;
	}
	

	public Image getIm3() {
		return im3;
	}

	public void setIm3(Image im3) {
		this.im3 = im3;
	}

	public Image getIm4() {
		return im4;
	}

	public void setIm4(Image im4) {
		this.im4 = im4;
	}

	public Image getIm5() {
		return im5;
	}

	public void setIm5(Image im5) {
		this.im5 = im5;
	}

	public Image getIm6() {
		return im6;
	}

	public void setIm6(Image im6) {
		this.im6 = im6;
	}
	public Image getIm7() {
		return im7;
	}

	public void setIm7(Image im7) {
		this.im6 = im7;
	}

	public Image getUn() {
		return un;
	}

	public void setUn(Image un) {
		this.un = un;
	}

	public Image getDeux() {
		return deux;
	}

	public void setDeux(Image deux) {
		this.deux = deux;
	}

	public Image getTrois() {
		return trois;
	}

	public void setTrois(Image trois) {
		this.trois = trois;
	}

	public Image getQuatre() {
		return quatre;
	}

	public void setQuatre(Image quatre) {
		this.quatre = quatre;
	}

	public Image getCinq() {
		return cinq;
	}

	public void setCinq(Image cinq) {
		this.cinq = cinq;
	}

	public Image getSix() {
		return six;
	}

	public void setSix(Image six) {
		this.six = six;
	}

	public Font getFont() {
		return font;
	}

	public void setFont(Font font) {
		this.font = font;
	}

	//Méthode permettant de dessiner la premièrepage qui s'ouvrira lorsqu'on lancera le jeu
	public void dessinerPageAcceuil(Graphics g) throws SlickException {
		g.drawImage(im, 350, 100);
		g.drawImage(im, 100, 300);
		g.drawImage(im, 600, 300);
		g.drawImage(im, 350, 500);
		g.setColor(Color.black);
		g.drawImage(im2, 350, 900);
	}
	
	//Méthode permettant de dessiner la page présentant le tabeau de niveaux
	public void pageNiveau(Graphics g) {
		g.drawImage(un, 100, 50);
		g.drawImage(deux, 400, 50);
		g.drawImage(trois, 700, 50);
		g.drawImage(quatre, 100, 450);
		g.drawImage(cinq, 400, 450);
		g.drawImage(six, 700, 450);
		
		g.setColor(Color.black);
		g.fillRect(470, 780, 100, 70);
		g.setColor(Color.white);
		g.drawString("Exit", 500, 800);
	}
	
	public void dessinerDescription(Graphics g) throws SlickException {
		g.drawImage(im7, 280, 250);
		g.drawImage(im2, 350, 750);
	}
	
	public int jouerEstCliqué(int x, int y) {
		if (x > 350 && x < 650 && y > 750 && y < 858) {
			page = 3;
		}
		return page;
	}
	
	//Méthode permettant de passer à la table des niveaux après avoir cliqué sur jouer à la première page
	public int jouerIsClicked(int x, int y) {
		if (x > 350 && x < 650 && y > 900 && y < 1008) {
			page = 2;
		}
		return page;
	}
	
	//Méthode permettant de passer au niveau cliqué
	public int niveauIsClicked(int x, int y) {
		if (x > 100 && x < 356 && y > 50 && y < 306) {
			page = 4;
		}
		else if(x > 400 && x < 656 && y > 50 && y < 306) {
			page=5;
		}
		else if(x > 700 && x < 956 && y > 50 && y < 306) {
			page=6;
		}
		else if(x > 100 && x < 356 && y > 450 && y < 706) {
			page=7;
		}
		return page;
	}
	
	//Méthode permetant de dessiner la page gagner après qu'un joueur ait gagné la partie
	public void dessinerPagewin(Graphics g) {
		g.drawImage(im3,0, 120);
		g.drawImage(im4, 190, 700);
		g.drawImage(im5, 800, 700);
	}
	
	//Méthode permettant de rentrer à la page de niveaux si l'icone de la maison est cliquée
	public int homeIsClicked(int x, int y) {
		if (x > 230 && x < 340 && y > 700 && y < 850) {
			page = 3;
		}
		else if(x > 800 && x < 950 && y > 700 && y < 850) {
			page++;
		}
		return page;
	}
	
	
}
