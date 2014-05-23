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
        if (isTooClosedToImageWidth(desiredDimension)) {
            return;
        }

        float scalingFactor = calculateScalingFactor(desiredDimension);

        Image scaledImage = scaleImage(scalingFactor);

        ReplaceImage(scaledImage);
    }

    private Image scaleImage(float scalingFactor) {
        return ImageUtilities.getScaledImage(image, scalingFactor);
    }

    private float calculateScalingFactor(float desiredDimension) {
        float scalingFactor = desiredDimension / image.getWidth();
        scalingFactor = truncateNumberTo2Digits(scalingFactor);
        return scalingFactor;
    }

    private static float truncateNumberTo2Digits(float number) {
        return (float) (Math.floor(number * 100) * 0.01f);
    }

    private boolean isTooClosedToImageWidth(float desiredDimension) {
        return Math.abs(desiredDimension - image.getWidth()) < 0.01f;
    }

    private void ReplaceImage(Image transformedImage) {
        image.dispose();
        System.gc();
        image = transformedImage;
    }

    public void Rotate(int degrees) {
        Image rotatedImage = ImageUtilities.getRotatedImage(image, degrees);

        ReplaceImage(rotatedImage);
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
