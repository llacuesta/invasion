package sprites;

public abstract class PowerUp extends Sprite {
	// Class Attributes
	public final static int POWERUP_SPEED = 1;
	public final static int POWERUP_DURATION = 5;
	
	// Instance Attributes
	private Timer timer;
	private boolean expired;
	
	// Constructor
	public PowerUp(int positionX, int positionY) {
		super(positionX, positionY);
		this.timer = new Timer(this);
		this.expired = false;
	}
	
	// Methods
	public void move() {
		this.setdY();
		this.positionY += this.dY;
	}
	
	public abstract void modifyShip(Ship ship);

	// Getters
	public int getPositionY() {
		return (int) this.positionY;
	}
	
	public boolean isExpired() {
		return this.expired;
	}
	
	public Timer getTimer() {
		return this.timer;
	}
	
	// Setters
	private void setdY() {
		this.dY = PowerUp.POWERUP_SPEED;
	}

	void expire() {
		this.expired = true;
	}
}
