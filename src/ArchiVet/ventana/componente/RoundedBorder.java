package ArchiVet.ventana.componente;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.geom.RoundRectangle2D;
import javax.swing.border.Border;

public class RoundedBorder implements Border {
    private final int radius;
    private final int thickness;
    private final Color color;
    private final Color colorr;

    public RoundedBorder(int radius, int thickness, Color color) {
        this.radius = radius;
        this.thickness = thickness;
        this.color = color;
        this.colorr = null;
    }
    
    public RoundedBorder(int radius, int thickness, Color color, Color colorr) {
        this.radius = radius;
        this.thickness = thickness;
        this.color = color;
        this.colorr = colorr;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(color);
        g2d.setStroke(new BasicStroke(thickness)); // Grosor de la línea

        // Dibuja un borde redondeado
        g2d.draw(new RoundRectangle2D.Double(x, y, width - 1, height - 1, radius, radius));
        
        if (colorr != null) {
            c.setBackground(colorr);
        }
    }

    @Override
    public Insets getBorderInsets(Component c) {
        int value = (int) Math.ceil(radius / 2.0);
        return new Insets(value, value, value, value);
    }

    @Override
    public boolean isBorderOpaque() {
        return true;
    }
}