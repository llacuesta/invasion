package sprites;

import javafx.scene.image.Image;

public class Star extends PowerUp {
	// Class Attributes
	private final static Image STAR = new Image("assets/star.png");
	final static int DURATION = 5;
	
	// Instance Attributes
	private int duration;
	
	// Constructor
	public Star(int positionX, int positionY) {
		super(positionX, positionY);
		this.loadImage(Star.STAR);
		this.duration = Star.DURATION;
	}

	@Override
	public void modifyShip(Ship ship) {
		ship.setInvincible(true);
		System.out.println("Ship is invincible!");
		new Thread() {
			@Override
			public void run() {
				while (duration != 0) {
					try {
						Thread.sleep(1000);
						duration--;
					} catch (InterruptedException e) {
						System.out.println(e.getMessage());
					}
				}
				
				ship.setInvincible(false);
				System.out.println("Ship is now vulnerable!");
			}
		}.start();
	}
}
