package BellumAutemOrbis.GraphicObject;

import BellumAutemOrbis.BellumAutemOrbis;
import processing.core.PFont;

public class Text extends GraphicObject
{
    private static final String IMGPATH = "res/font/";
    private String text;
    private final PFont font;
    private final int coul;
    
    
    public Text(BellumAutemOrbis bao, int x, int y, int w, int h, int size, String text, String font, int color)
    {
        super(bao, x, y, w, h);
        this.text = text;
        this.font = bao.createFont(IMGPATH + font, size);
        this.coul = color;
    }

    @Override
    public void init(){}

    @Override
    public void draw()
    {
        bao.textFont(font);
        if(coul != 255)
            bao.fill(coul);
        else
            bao.fill(200, 0, 0);
        text(text, w/2, h/2);
    }

    @Override
    public void mousePressed(int x, int y, int type){}

    @Override
    public void mouseMoved(int x, int y){}
    
    public String getText(){return text;}
    public void setText(String txt){text = txt;}
}
