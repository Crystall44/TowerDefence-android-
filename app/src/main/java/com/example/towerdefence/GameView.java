package com.example.towerdefence;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class GameView extends View {
    private Paint paint;
    private Bitmap towerBitmap;
    private Bitmap enemyBitmap;
    private int enemyX = 0;
    private int enemyY = 200;
    private Bitmap grass;
    private Bitmap road1;


    //private int[][] map = {
    //        {0, -1, 10, 1, 0, 0, 100, 100, 100, 100, 0, 0, 0},
    //       {98, -1, 10, 1, 98, 100, 100, 100, 100, 100, 0, 80, 0},
    //     {-3, 10, 10, 3, 0, 0, -2, 4, 4, 4, 0, 1, 0},
    //   {}
    //};
    private int[][] map = {
            {0, 1, 0, 0},
            {0, 1, 0, 0},
            {0, 1, 1, 1},
            {0, 0, 0, 1}
    };

    public GameView(Context context) {
        super(context);
        towerBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.archer);
        enemyBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.stone1);
        grass = BitmapFactory.decodeResource(getResources(), R.drawable.grass);
        road1 = BitmapFactory.decodeResource(getResources(), R.drawable.road1);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int screenWidth = getWidth();
        int screenHeight = getHeight();

        int tileWidth = screenWidth / map[0].length; // Делим ширину экрана на количество столбцов
        int tileHeight = screenHeight / map.length; // Делим высоту экрана на количество строк
        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[row].length; col++) {
                Bitmap tileToDraw = null;

                // Определяем, какой тайл рисовать
                switch (map[row][col]) {
                    case 0:
                        tileToDraw = grass;
                        break;
                    case 1:
                        tileToDraw = road1;
                        break;
                }

                // Рисуем тайл с учетом размера
                if (tileToDraw != null) {
                    Bitmap scaledTile = Bitmap.createScaledBitmap(tileToDraw, tileWidth, tileHeight, false);
                    canvas.drawBitmap(scaledTile, col * tileWidth, row * tileHeight, null);
                }
            }
        }
    }
}