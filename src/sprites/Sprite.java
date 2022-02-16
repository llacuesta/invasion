package sprites;

import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Sprite {
	// Instance Attributes
	protected Image image;
    protected double positionX, positionY;    
    protected double dX, dY;
    protected double width, height;
    
    // Constructor
    public Sprite(int positionX, int positionY) {
    	this.positionX = positionX;
    	this.positionY = positionY;
    }
    
    // Methods
    protected void loadImage(Image image) {
    	try {
    		this.image = image;
    		this.width = this.image.getWidth();
    		this.height = this.image.getHeight();
    	} catch (Exception e) {
    		System.out.println("Error loading image asset!");
    	}
    }
    
    public void render(GraphicsContext gc) {
    	gc.drawImage(this.image, this.positionX, this.positionY);
    }
    
    public boolean collidesWith(Sprite s) {
    	return s.getBoundary().intersects(this.getBoundary());
    }
    
    // Getters
    private Rectangle2D getBoundary() {
    	return new Rectangle2D(this.positionX, this.positionY, this.width, this.height);
    }
    
	public Image getImage() {
		return this.image;
	}
    
    // Setters
    public void setdX(int dX) {
    	this.dX = dX;
    }
    
    public void setdY(int dY) {
    	this.dY = dY;
    }
}
