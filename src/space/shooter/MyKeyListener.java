package space.shooter;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import static space.shooter.Core.scale;
import static space.shooter.MyKeyListener.left;
import static space.shooter.MyKeyListener.right;
import static space.shooter.MyKeyListener.shoot;
import java.util.Timer;
import java.util.TimerTask;
import static space.shooter.Core.rasterAnimationList;

class AnimationRaster{
    
    public int x;
    public int y;
    public int ax;
    private int width;
    private int height;
    private int delay;
    private int delayActual;
    private int wybor=1;
    private boolean again = false;
    int keyFrame=0;
    private final BufferedImage bufferedImage;

    int maxFrame=12;
    int speed = -15;
    private int kroki=0;
    public int tag;
  
    public AnimationRaster(int x,int y, int width, int height,  int delay, int maxFrame, java.awt.image.BufferedImage bufferedImage, int tag){
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
        this.delay=delay; 
        this.delayActual=delay; 
        this.tag = tag;
        this.bufferedImage=bufferedImage;
        this.maxFrame=maxFrame;
    }
        
        public void action(){
           
            if(tag == 4){
                if(ax<=11&&kroki<=23){
                    ax++;
                    x=x+scale;
                    kroki++;
                } else{
                    x=x-scale;
                    kroki++;
                if(kroki>23){ ax=0; kroki=0; }
                }
                
                if(delayActual>0){
                        delayActual--;
                    } else{
                        delayActual=delay;
                        if(keyFrame<maxFrame){
                            keyFrame++;
                        } else{
                            keyFrame=0;
                        }
                }
                
            }
            
            if(tag == 3){
                if(ax<=11&&kroki<=23){
                    ax++;
                    x=x-scale;
                    kroki++;
                } else{
                    x=x+scale;
                    kroki++;
                if(kroki>23){ ax=0; kroki=0; }
                }
                
                if(delayActual>0){
                        delayActual--;
                    } else{
                        delayActual=delay;
                        if(keyFrame<maxFrame){
                            keyFrame++;
                        } else{
                            keyFrame=0;
                        }
                }
                
            }
            
            if(tag == 2){ 
            y+=speed;
            speed=speed-4;
                if(delayActual>0){
                        delayActual--;
                    } else{
                        delayActual=delay;
                        if(keyFrame<maxFrame){
                            keyFrame++;
                        } else{
                            keyFrame=0;
                        }
                }
            }
            
            if(tag == 5){ 
            y-=speed;
            //speed=speed+2;
                if(delayActual>0){
                        delayActual--;
                    } else{
                        delayActual=delay;
                        if(keyFrame<maxFrame){
                            keyFrame++;
                        } else{
                            keyFrame=0;
                        }
                }
            }
            
            if(tag == 6){ 
            x+=scale*4;
            }
            
            if(tag==0){
                if(delayActual>0){
                        delayActual--;
                    } else{
                        delayActual=delay;
                        if(keyFrame<maxFrame){
                            keyFrame++;
                        } else{
                            keyFrame=0;
                        }
                }
            }    

            if(tag==1){
                MyKeyListener.go();
                x = MyKeyListener.x;
                y = MyKeyListener.y;
                if(delayActual>0){
                        delayActual--;
                    } else{
                        delayActual=delay;                               
                if(!shoot){      
                    if(left){
                        if(!again){
                            this.keyFrame = 5;
                            this.maxFrame = 6;
                            again = true;
                            }
                            this.keyFrame = 6;
                            this.maxFrame = 6;                
                    }else if(right){
                        if(!again){
                            this.keyFrame = 12;
                            this.maxFrame = 13;
                            again = true;
                            }
                            this.keyFrame = 13;
                            this.maxFrame = 13;
                    }else if(!left&&!right){
                            this.keyFrame = 0;
                            this.maxFrame = 0;
                            again = false;
                    }
                }else{
                    this.maxFrame = 18;
                    switch(wybor) {
                    case 1:
                        if(right){ this.keyFrame = 13;
                        }else if(left){ this.keyFrame = 6;
                        }else this.keyFrame = 0; 
                        wybor = 2;
                        break;
                    case 2:
                        if(right){ this.keyFrame = 14;
                        }else if(left){ this.keyFrame = 7;
                        }else this.keyFrame = 1;
                        wybor = 3;
                        break;
                    case 3:
                        if(right){ this.keyFrame = 15;
                        }else if(left){ this.keyFrame = 8;
                        }else this.keyFrame = 2;
                        wybor = 4;
                        break;
                    case 4:
                        if(right){ this.keyFrame = 16;
                        }else if(left){ this.keyFrame = 9;
                        }else this.keyFrame = 3;
                        wybor = 5;
                        break;
                    case 5:
                        if(right){ this.keyFrame = 17;
                        }else if(left){ this.keyFrame = 10;
                        }else this.keyFrame = 4;
                        wybor = 1;
                        break;
                    }
            
                }       
                        
                } 
            
       
            }
                        
        }
        
    public void paintObject(Graphics graph){
        Graphics graphTemp = graph.create();
        Graphics2D graph2d = (Graphics2D) graphTemp;

        if(tag == 0){
        BufferedImage actualFrame = bufferedImage.getSubimage(keyFrame*192, 0, 192, 108);
        
        AffineTransform affineTransform = new AffineTransform();
        affineTransform.scale(scale, scale);
        graph2d.drawImage(actualFrame, affineTransform, null);
        } 
        
        if(tag == 7){
        BufferedImage actualFrame = bufferedImage.getSubimage(keyFrame*1728, 0, 1728, 972);
        
        AffineTransform affineTransform = new AffineTransform();
        affineTransform.translate(x, y);
        affineTransform.scale(scale, scale);
        graph2d.drawImage(actualFrame, affineTransform, null);
        } 
        
        if(tag == 6){
        BufferedImage actualFrame = bufferedImage.getSubimage(keyFrame*64, 0, 64, 24);
        
        AffineTransform affineTransform = new AffineTransform();
        affineTransform.translate(x, y);
        affineTransform.scale(scale, scale);
        graph2d.drawImage(actualFrame, affineTransform, null);
        }
        
        if(tag == 1){
            BufferedImage actualFrame=bufferedImage.getSubimage(keyFrame*12, 0, 12, 12);

            AffineTransform affineTransform = new AffineTransform();
            affineTransform.translate(x, y);
            affineTransform.scale(scale, scale);

            graph2d.drawImage(actualFrame, affineTransform, null);
            }
        
        if(tag == 2 || tag == 5){
            BufferedImage actualFrame=bufferedImage.getSubimage(keyFrame*6, 0, 6, 8);

            AffineTransform affineTransform = new AffineTransform();
            affineTransform.translate(x, y);
            affineTransform.scale(scale, scale);

            graph2d.drawImage(actualFrame, affineTransform, null);
        }
        
        if(tag == 3 || tag == 4){
            BufferedImage actualFrame=bufferedImage.getSubimage(keyFrame*12, 0, 12, 12);

            AffineTransform affineTransform = new AffineTransform();
            affineTransform.translate(x, y);
            affineTransform.scale(scale, scale);

            graph2d.drawImage(actualFrame, affineTransform, null);
        }
        
    }
    
    public int showTag(){
    return this.tag;
    }
    
    public int posX(){
    return this.x;
    }
        
    public int posY(){
    return this.y;
    }
     
}

   class MyKeyListener implements KeyListener {
        Timer timer;
        static int SPEED = scale;
        
        static int x = (96-6)*SPEED;
        static int y = (108-21)*SPEED;
        
        static private int vx = 0,vy = 0;
        
        static private boolean up=false, down=false;
        static boolean left=false, right=false, shoot = false;        
        
        static public void go() {
            x += vx;
            y += vy;
        }
        
        public void update(){
            vx = 0;
            vy = 0;
            if(up) vy = -SPEED*2;
            if(down) vy = SPEED*2;
            if(right) vx = SPEED*2;
            if(left) vx = -SPEED*2;
        }
        
 	@Override
	public void keyTyped(KeyEvent e) {
            if(e.getKeyChar() == 32){
                if(!shoot) new Reminder(5); 
            } 
        }
        

	@Override
	public void keyPressed(KeyEvent e) {
            switch(e.getKeyCode()) {
                case KeyEvent.VK_DOWN: down = true; break;
                case KeyEvent.VK_UP: up = true; break;
                case KeyEvent.VK_LEFT: left = true; break;
                case KeyEvent.VK_RIGHT: right = true; break;
            }
        update();
	}

	@Override
	public void keyReleased(KeyEvent e) {
            switch(e.getKeyCode()) {
	    case KeyEvent.VK_DOWN: down = false; break;
	    case KeyEvent.VK_UP: up = false; break;
	    case KeyEvent.VK_LEFT: left = false; break;
	    case KeyEvent.VK_RIGHT: right = false; break;
	}   
	update();
	}
    }