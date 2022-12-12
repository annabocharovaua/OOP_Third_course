package com.example.maze;

import android.graphics.Canvas;
import android.graphics.Rect;

 //The interface Drawable, so that during drawing we do not know what kind of object we are drawing

public interface Drawable {
   void draw(Canvas canvas, Rect rect);
}
