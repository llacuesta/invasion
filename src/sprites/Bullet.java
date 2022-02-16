package sprites;

import javafx.scene.image.Image;

public class Bullet extends Sprite {
	// Class Attributes
	public final static Image BULLET = new Image("assets/bullet.png");
	public final static int BULLET_SPEED = 20;
	
	// Instance Attributes
	private Ship ship;
	private int damage;
	
	// Constructor
	public Bullet(int positionX, int positionY, Ship ship) {
		super(positionX, positionY);
		this.loadImage(Bullet.BULLET);
		this.ship = ship;
		this.damage = this.ship.getStrength();
	}
	
	// Methods
	public void move() {
		this.setdX();
		this.positionX += this.dX;
	}
	
	public void doDamage(Fish f) {
		f.setHealth(f.getHealth() - this.damage);
		this.ship.setScore(this.ship.getScore() + 1);
	}
	
	// Setters
	// Overriding setdX from Sprite to not take inputs
	private void setdX() {
		this.dX = Bullet.BULLET_SPEED;
	}
	
	// Getters
	public int getPositionX() {
		return (int) this.positionX;
	}
}
