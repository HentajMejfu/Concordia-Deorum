package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity {

    GamePanel gp;
    KeyHandler keyHandler;

    public Player(GamePanel gp, KeyHandler keyHandler) {

        this.gp = gp;
        this.keyHandler = keyHandler;

        setDefaultValues();
        getPlayerImage();
        
    }

    public final void setDefaultValues() {

        x = 100;
        y = 100;
        speed = 4;
        direction  = "down";

    }

    public final void getPlayerImage() {

        try {

            up0 = ImageIO.read(getClass().getResourceAsStream("/player/player_up_0.png"));
            up1 = ImageIO.read(getClass().getResourceAsStream("/player/player_up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/player_up_2.png"));
            right0 = ImageIO.read(getClass().getResourceAsStream("/player/player_right_0.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/player/player_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/player_right_2.png"));
            down0 = ImageIO.read(getClass().getResourceAsStream("/player/player_down_0.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/player/player_down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/player_down_2.png"));
            left0 = ImageIO.read(getClass().getResourceAsStream("/player/player_left_0.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/player/player_left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/player_left_2.png"));

        } catch (IOException e) {

            e.printStackTrace();

        }
    }

    public void update() {

        if (keyHandler.downPressed == true || keyHandler.leftPressed == true || keyHandler.rightPressed == true  || keyHandler.upPressed == true) {

            if (keyHandler.upPressed == true) {
                direction = "up";
                y -= speed;
            }

            if (keyHandler.downPressed == true) {
                direction = "down";
                y += speed;
            }

            if (keyHandler.leftPressed == true) {
                direction = "left";
                x -= speed;
            }

            if (keyHandler.rightPressed == true) {
                direction = "right";
                x += speed;
            }

            spriteCounter++;
            if (spriteNum == 0)
                spriteNum = 1;

            if (spriteCounter > 10) {

                if (spriteNum == 1)
                    spriteNum = 2;

                else if (spriteNum == 2)
                    spriteNum = 1;

                spriteCounter = 0;

            }

        } else {

            spriteNum = 0;
            spriteCounter = 0;

        }

    }

    public void draw(Graphics2D g2) {

        BufferedImage image = null;

        switch (direction) {
            case "up":

                if (spriteNum == 0)
                    image = up0;

                if (spriteNum == 1)
                    image = up1;

                if (spriteNum == 2)
                    image = up2;

                break;

            case "right":

                if (spriteNum == 0)
                    image = right0;

                if (spriteNum == 1)
                    image = right1;

                if (spriteNum == 2)
                    image = right2;

                break;

            case "down":
                if (spriteNum == 0) 
                    image = down0;
                    
                if (spriteNum == 1)
                    image = down1;

                if (spriteNum == 2)
                    image = down2;

                break;

            case "left":

                if (spriteNum == 0) 
                    image = left0;
                    
                if (spriteNum == 1)
                    image = left1;

                if (spriteNum == 2)
                    image = left2;

                break;

            default:
                image = down0;
                break;
        }

        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize * 2, null);

    }

}
