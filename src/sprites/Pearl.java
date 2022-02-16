package sprites;

import javafx.scene.image.Image;

public class Pearl extends PowerUp {
	// Class Attributes
	private final static Image PEARL = new Image("assets/pearl.png");
	private final static int PEARL_BOOST = 5;
	
	// Constructor
	public Pearl(int positionX, int positionY) {
		super(positionX, positionY);
		this.loadImage(Pearl.PEARL);
	}
	
	// Methods
	@Override
	public void modifyShip(Ship ship) {
		ship.setStrength(ship.getStrength() + Pearl.PEARL_BOOST);
	}

}
