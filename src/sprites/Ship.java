package sprites;

import java.util.ArrayList;
import java.util.Random;

import javafx.scene.image.Image;
import template.GameStage;

public class Ship extends Sprite {
	// Class Attributes
	public final static Image SHIP = new Image("assets/ship.png");
	public final static int SHIP_SPEED = 10;
	
	// Instance attributes
	private int strength;
	private boolean alive;
	private ArrayList<Bullet> bullets;
	private int score;
	private boolean invincible;
	
	// Constructor
	public Ship(int positionX, int positionY) {
		super(positionX, positionY);
		Random r = new Random();
		this.strength = r.nextInt(51) + 100;
		this.alive = true;
		this.loadImage(Ship.SHIP);
		this.bullets = new ArrayList<Bullet>();
		this.score = 0;
		this.invincible = false;
	}
	
	// Methods
	public void move() {
		// Restricting movement outside of the screen
		if (this.positionX > GameStage.WINDOW_WIDTH - Ship.SHIP.getWidth()) {
			this.positionX = GameStage.WINDOW_WIDTH - Ship.SHIP.getWidth();
		} else if (this.positionY > GameStage.WINDOW_HEIGHT - Ship.SHIP.getHeight()) {
			this.positionY = GameStage.WINDOW_HEIGHT - Ship.SHIP.getHeight();
		} else if (this.positionX < 0) { 
			this.positionX = 0;
		} else if (this.positionY < 0) {
			this.positionY = 0;
		} else {
			this.positionX += this.dX;
			this.positionY += this.dY;
		}
	}
	
	public void stop() {
		this.dX = 0;
		this.dY = 0;
	}
	
	public void shoot() {
		// getting position
		int x = (int) (this.positionX + Ship.SHIP.getWidth() - 10);
		int y = (int) (this.positionY + Ship.SHIP.getHeight()/3);
		
		this.bullets.add(new Bullet(x, y, this));
	}
	
	private void checkStrength() {
		if (this.strength <= 0) {
			this.alive = false;
		}
	}
	
	// Setter
	void setStrength(int strength) {
		this.strength = strength;
	}
	
	void setScore(int score) {
		this.score = score;
	}
	
	void setInvincible(boolean invincible) {
		this.invincible = invincible;
	}
	
	// Getter
	public ArrayList<Bullet> getBulletList() {
		return this.bullets;
	}
	
	public boolean isAlive() {
		this.checkStrength();
		return this.alive;
	}
	
	public int getStrength() {
		return this.strength;
	}
	
	public int getScore() {
		return this.score;
	}

	public boolean isInvincible() {
		return this.invincible;
	}
}
