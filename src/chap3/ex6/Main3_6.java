package chap3.ex6;

import java.io.IOException;

public class Main3_6 {

    public static void main(String... args) throws IOException {
        Image uploadImage = new Image(new FileInputStream("C:\\Users\\Oleksandr_Storozhuk\\Pictures\\Hims.jpg"));
        Image brightenImage = transform(uploadImage, (c, arg) -> c.deriveColor(0, 1, arg, 1), 1);
        ImageIO.write(SwingFXUtils.fromFXImage(brightenImage, null), "jpg",
                new File("C:\\Users\\Oleksandr_Storozhuk\\Pictures\\Hims_br.jpg"));
    }

    public static <T> Image transform(Image in, BiFunction<Color, T, Color> f, T arg) {
        int width = (int) in.getWidth();
        int height = (int) in.getHeight();
        WritableImage out = new WritableImage(width, height);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                out.getPixelWriter().setColor(x, y,
                        f.apply(in.getPixelReader().getColor(x, y), arg));
            }
        }
        return out;
    }
}
