package th.co.ask.eip_mobile.utils;

import android.content.Context;
import android.graphics.Typeface;

import th.co.ask.eip_mobile.manager.Contextor;

public class RobotoType {
    private int ROBOTO = 0;
    private int ROBOTO_BOLD = 1;
    private int ROBOTO_ITALIC = 2;
    private int ROBOTO_BOLD_ITALIC = 3;
    private int ROBOTO_THIN = 4;
    private int ROBOTO_THIN_ITALIC = 5;
    private int ROBOTO_BLACK = 6;
    private int ROBOTO_BLACK_ITALIC = 7;
    private int ROBOTO_LIGHT = 8;
    private int ROBOTO_LIGHT_ITALIC = 9;
    private int ROBOTO_MEDIUM = 10;
    private int ROBOTO_MEDIUM_ITALIC = 11;

    private static RobotoType instance;

    public static  RobotoType getInstance() {
        if (instance == null)
            instance = new RobotoType();
        return instance;
    }

    private Context mContext;

    private RobotoType() {
        mContext = Contextor.getInstance().getContext();
    }

    public Typeface getTypeface(int typeface) {
        if (typeface == ROBOTO)
            return Typeface.createFromAsset(Contextor.getInstance().getContext().getAssets(), "fonts/Roboto-Regular.ttf");
        else if (typeface == ROBOTO_BOLD)
            return Typeface.createFromAsset(Contextor.getInstance().getContext().getAssets(), "fonts/Roboto-Bold.ttf");
        else if (typeface == ROBOTO_ITALIC)
            return Typeface.createFromAsset(Contextor.getInstance().getContext().getAssets(), "fonts/Roboto-Italic.ttf");
        else if (typeface == ROBOTO_BOLD_ITALIC)
            return Typeface.createFromAsset(Contextor.getInstance().getContext().getAssets(), "fonts/Roboto-BoldItalic.ttf");
        else if (typeface == ROBOTO_THIN)
            return Typeface.createFromAsset(Contextor.getInstance().getContext().getAssets(), "fonts/Roboto-Thin.ttf");
        else if (typeface == ROBOTO_THIN_ITALIC)
            return Typeface.createFromAsset(Contextor.getInstance().getContext().getAssets(), "fonts/Roboto-ThinItalic.ttf");
        else if (typeface == ROBOTO_BLACK)
            return Typeface.createFromAsset(Contextor.getInstance().getContext().getAssets(), "fonts/Roboto-Black.ttf");
        else if (typeface == ROBOTO_BLACK_ITALIC)
            return Typeface.createFromAsset(Contextor.getInstance().getContext().getAssets(), "fonts/Roboto-BlackItalic.ttf");
        else if (typeface == ROBOTO_LIGHT)
            return Typeface.createFromAsset(Contextor.getInstance().getContext().getAssets(), "fonts/Roboto-Light.ttf");
        else if (typeface == ROBOTO_LIGHT_ITALIC)
            return Typeface.createFromAsset(Contextor.getInstance().getContext().getAssets(), "fonts/Roboto-LightItalic.ttf");
        else if (typeface == ROBOTO_MEDIUM)
            return Typeface.createFromAsset(Contextor.getInstance().getContext().getAssets(), "fonts/Roboto-Medium.ttf");
        else if (typeface == ROBOTO_MEDIUM_ITALIC)
            return Typeface.createFromAsset(Contextor.getInstance().getContext().getAssets(), "fonts/Roboto-MediumItalic.ttf");

        return Typeface.createFromAsset(Contextor.getInstance().getContext().getAssets(), "fonts/Roboto-Regular.ttf");
    }

}
