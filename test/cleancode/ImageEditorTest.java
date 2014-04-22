/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cleancode;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author jerome
 */
public class ImageEditorTest {

    private ImageEditor imageEditor;

    public ImageEditorTest() {
    }

    @Before
    public void setUp() {
        Image image = new Image(15, 30);
        imageEditor = new ImageEditor(image);
    }

    /**
     * Test of ScaleToOneDimension method, of class ImageEditor.
     */
    @Test
    public void shouldNotScaleImageWhenSameSize() {
        givenIHaveAnImage();

        whenIScaleImageWidthTo(14.999f);

        thenTheImageWidthIs(15);
    }

    @Test
    public void shouldScaleImageWhenNotSameSize() {
        givenIHaveAnImage();

        whenIScaleImageWidthTo(5);

        thenTheImageWidthIs(5).andTheHeightIs(10);
    }

    @Test
    public void shouldRotateImage() {
        imageEditor.Rotate(90);

        assertThat(imageEditor.image().getWidth(), is(equalTo(30)));
    }

    private void givenIHaveAnImage() {

    }

    private ThenImage thenTheImageWidthIs(int expectedWidth) {
        assertThat(imageEditor.image().getWidth(), is(equalTo(expectedWidth)));
        return new ThenImage(imageEditor);
    }

    private void whenIScaleImageWidthTo(float desiredWidth) {
        imageEditor.ScaleToOneDimension(desiredWidth);
    }

    private class ThenImage {

        private final ImageEditor imageEditor;

        public ThenImage(ImageEditor imageEditor) {
            this.imageEditor = imageEditor;
        }

        public void andTheHeightIs(int expectedHeight) {
            assertThat(imageEditor.image().getHeight(), is(equalTo(expectedHeight)));
        }
    }

}
