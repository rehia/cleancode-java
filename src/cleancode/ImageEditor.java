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
public class ImageEditor {

    private Image image;

    public ImageEditor(Image image) {
        this.image = image;
    }

    public void ScaleToOneDimension(float desiredDimension) {
        if (Math.abs(desiredDimension - image.getWidth()) < 0.01f) {
            return;
        }

        float scalingFactor = desiredDimension / image.getWidth();
        scalingFactor = (float) (Math.floor(scalingFactor * 100) * 0.01f);

        Image scaledImage = ImageUtilities.getScaledImage(image, scalingFactor);

        image.dispose();
		System.gc();
		image = scaledImage;
    }

    public void Rotate(int degrees) {
        Image rotatedImage = ImageUtilities.getRotatedImage(image, degrees);

        image.dispose();
		System.gc();
		image = rotatedImage;
    }

    public Image image() {
        return image;
    }

    private static class ImageUtilities {

        public static Image getScaledImage(Image image, float scalingFactor) {
            return new Image(image, scaleDimension(image.getWidth(), scalingFactor), scaleDimension(image.getHeight(), scalingFactor));
        }

        private static int scaleDimension(int dimension, float scalingFactor) {
            return (int) Math.round(dimension * scalingFactor);
        }

        public static Image getRotatedImage(Image image, int degrees) {
            image.rotate(degrees);
            return image;
        }
    }
}
