/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cleancode;

/**
 *
 * @author jerome
 */
public class Image {
    
    private int width;
    private int height;
    private int degrees;
    
    public Image(int width, int height) {
        this.width = width;
        this.height = height;
        this.degrees = 0;
    }

    public Image(Image image, int newWidth, int newHeight) {
        this(newWidth, newHeight);
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public void dispose() {
    }

    void rotate(int degrees) {
        this.degrees = degrees;
        if (degrees % 90 == 0 && (degrees / 90) % 2 == 1) {
            int width = this.width;
            this.width = this.height;
            this.height = width;
        } 
    }
}
