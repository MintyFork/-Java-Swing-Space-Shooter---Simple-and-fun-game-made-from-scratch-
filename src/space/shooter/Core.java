package space.shooter;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.event.KeyListener;
import javax.swing.JComponent;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.sound.sampled.FloatControl;
import static space.shooter.MyKeyListener.shoot;

public class Core extends JComponent implements java.awt.event.ActionListener {
javax.swing.Timer componentTimer;
BufferedImage imagePattern;
static java.util.List<AnimationRaster> rasterAnimationList = new java.util.ArrayList();
Random rand = new Random();
int iter = 2;
java.awt.image.BufferedImage gracz;
java.awt.image.BufferedImage back;
java.awt.image.BufferedImage pocisk;
java.awt.image.BufferedImage pociskE;
java.awt.image.BufferedImage ENEMY1;
java.awt.image.BufferedImage ENEMY2;
java.awt.image.BufferedImage ENEMY3;
java.awt.image.BufferedImage ENEMY4;
java.awt.image.BufferedImage s1;
java.awt.image.BufferedImage s2;
java.awt.image.BufferedImage s3;
java.awt.image.BufferedImage s4;
java.awt.image.BufferedImage s5;
java.awt.image.BufferedImage gameover;
java.awt.image.BufferedImage credits;

    URL pociskS = getClass().getClassLoader().getResource("music/pocisk.wav");
    AudioClip PociskS = Applet.newAudioClip(pociskS);
    
    URL kontaktS = getClass().getClassLoader().getResource("music/Kontakt.wav");
    AudioClip KontaktS = Applet.newAudioClip(kontaktS);
    
    URL themeS = getClass().getClassLoader().getResource("music/theme.wav");
    AudioClip ThemeS = Applet.newAudioClip(themeS);
    
    URL endS = getClass().getClassLoader().getResource("music/end.wav");
    AudioClip EndS = Applet.newAudioClip(endS);

int width = 500;
int height = 500;
int enList = 2;
int ENEMYPociskSpeed = 11;
boolean oneShoot = true, oneShootE = true, dead = false, deadend = false, quit = false;
int s = 1;
static int scale=1000, myXE = 0, myYE = 0;
static boolean shootE = false, wait = false;

public Core(){
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    scale = (int)(screenSize.getWidth()/192);
    componentTimer = new javax.swing.Timer(30,this);
    componentTimer.start();
    
    KeyListener listener = new MyKeyListener();
    addKeyListener(listener);
    setFocusable(true);
    try{
        ENEMY1 = javax.imageio.ImageIO.read(Core.class.getResource("/obrazki/ENEMY1.png"));
        ENEMY2 = javax.imageio.ImageIO.read(Core.class.getResource("/obrazki/ENEMY2.png"));
        ENEMY3 = javax.imageio.ImageIO.read(Core.class.getResource("/obrazki/ENEMY3.png"));
        ENEMY4 = javax.imageio.ImageIO.read(Core.class.getResource("/obrazki/ENEMY4.png"));
        pocisk = javax.imageio.ImageIO.read(Core.class.getResource("/obrazki/pocisk.png"));
        pociskE = javax.imageio.ImageIO.read(Core.class.getResource("/obrazki/ENEMYPocisk.png"));
        gracz = javax.imageio.ImageIO.read(Core.class.getResource("/obrazki/gracz.png"));
        back = javax.imageio.ImageIO.read(Core.class.getResource("/obrazki/tlo.png"));
        s1 = javax.imageio.ImageIO.read(Core.class.getResource("/obrazki/stage1.png"));
        s2 = javax.imageio.ImageIO.read(Core.class.getResource("/obrazki/stage2.png"));
        s3 = javax.imageio.ImageIO.read(Core.class.getResource("/obrazki/stage3.png"));
        s4 = javax.imageio.ImageIO.read(Core.class.getResource("/obrazki/stage4.png"));
        s5 = javax.imageio.ImageIO.read(Core.class.getResource("/obrazki/stage5.png"));    
        gameover = javax.imageio.ImageIO.read(Core.class.getResource("/obrazki/gameover.png"));
        credits = javax.imageio.ImageIO.read(Core.class.getResource("/obrazki/credits.png"));
    }catch(Exception ex){}
    
    addBackground();
    addHero();
}

public void actionPerformed(java.awt.event.ActionEvent evt)
{
    
java.util.Iterator<AnimationRaster> rasterAnimationIterator = rasterAnimationList.iterator();

while(rasterAnimationIterator.hasNext()){
rasterAnimationIterator.next().action();    
}

repaint();  
        
        java.util.Iterator<AnimationRaster> rasterAnimationIterator2 = rasterAnimationList.iterator();
        java.util.Iterator<AnimationRaster> rasterAnimationIterator3 = rasterAnimationList.iterator();
        java.util.Iterator<AnimationRaster> rasterAnimationIterator4 = rasterAnimationList.iterator();
        java.util.Iterator<AnimationRaster> rasterAnimationIterator5 = rasterAnimationList.iterator();
        AnimationRaster b = null;
        AnimationRaster a = null;
        int myX = 0;
        int myY = 0;
        enList = 2;
        
        while(rasterAnimationIterator2.hasNext()){  
            a = rasterAnimationIterator2.next();
            if(a.showTag() == 2 && a.posY()<-100){ 
                rasterAnimationIterator2.remove();
            }
            
            if(a.showTag() == 5 && a.posY()>200*scale){ 
                rasterAnimationIterator2.remove();
            }
            
            if(a.showTag() == 2){
                myX = a.posX();
                myY = a.posY();
                break;
            }
            if(a.showTag() == 3 || a.showTag() == 4) enList++;
            
        } 

        while(rasterAnimationIterator3.hasNext()){  
             try{b = rasterAnimationIterator3.next();
                if((b.posX()-2*scale<=myX && b.posX()+8*scale>=myX && b.posY()>=myY && b.posY()-12*scale<=myY)  && (b.showTag() == 3 || b.showTag() == 4)){
                    rasterAnimationIterator3.remove();
                }
            }catch(java.util.ConcurrentModificationException e){break;}
        }        
        
        while(rasterAnimationIterator4.hasNext()){  
             try{b = rasterAnimationIterator4.next();
                if((b.posX()<rasterAnimationList.get(1).posX() && b.posX()+(6*scale)>rasterAnimationList.get(1).posX() && b.posY()>rasterAnimationList.get(1).posY() && b.posY()-(2*scale)<rasterAnimationList.get(1).posY()) && (b.showTag() == 5) && !dead)
                {
                    ThemeS.stop();
                    dead = true;
                    addgameover();
                    EndS.play();
                    new wait(30);
                    break;
                }
                if((rasterAnimationList.get(1).posX()+scale<b.posX() && rasterAnimationList.get(1).posX()+(12*scale)>b.posX() && rasterAnimationList.get(1).posY()>b.posY() && rasterAnimationList.get(1).posY()-(2*scale)<b.posY()) && (b.showTag() == 5) && !dead)
                {
                    ThemeS.stop();
                    dead = true;
                    addgameover();
                    EndS.play();
                    new wait(30);
                    break;
                }
            }catch(java.util.ConcurrentModificationException e){break;}
        } 
        
    if(dead == true && wait == false){
        ThemeS.stop();
        addcredits();
        if(deadend == true) System.exit(0);
        new wait(10);
        deadend = true;
    }
    
    if(enList == 2 && wait == false && dead == false){
        KontaktS.play();
        randomMap();
        addstage(s);
        s++;
        ENEMYPociskSpeed=ENEMYPociskSpeed-2;
        wait = true;
        new wait(3);
    }   
}           

public void paintComponent(Graphics graph){

    if(shoot&&oneShoot){ 
    addPocisk();
    oneShoot = false;
    }
    
    if(!shoot) oneShoot = true;
   
    if(!shootE&&!dead){
        enList = rand.nextInt(enList-1) + 2;
        myXE = rasterAnimationList.get(enList).posX() + 3*scale;
        myYE = rasterAnimationList.get(enList).posY() + 12*scale;
        new ENEMYPociskTimer(ENEMYPociskSpeed);
        addPociskE();
    }

Graphics2D graph2=(Graphics2D)graph;
graph2.drawImage(imagePattern,0,0,width, height,null);

java.util.Iterator<AnimationRaster> rasterAnimationIterator = rasterAnimationList.iterator();
while(rasterAnimationIterator.hasNext())
{
rasterAnimationIterator.next().paintObject(graph2);  
}
}

void randomMap(){
        List<Integer> r = new ArrayList<Integer>();
        int  n = rand.nextInt(2) + 1;
        if(n == 1) addENEMY1(7);
        
        for(int i = 0;i<5; i++){
            n = rand.nextInt(6) + 1;
            boolean a = false;
            Iterator<Integer> myListIterator = r.iterator();
            while (myListIterator.hasNext()) {
                int c = myListIterator.next();
                if(n == c) a = true;
            }
            r.add(n);
        }
        
        Iterator<Integer> myListIterator = r.iterator();
            while (myListIterator.hasNext()) {
                int c = myListIterator.next();
                addENEMY1(c);
                addENEMY1(14-c);
            }
        
        r.clear();
        n = rand.nextInt(2) + 1;
        if(n == 1) addENEMY2(7);
        
        for(int i = 0;i<5; i++){
            n = rand.nextInt(6) + 1;
            boolean a = false;
            Iterator<Integer> myListIterator2 = r.iterator();
            while (myListIterator2.hasNext()) {
                int c = myListIterator2.next();
                if(n == c) a = true;
            }
            r.add(n);
        }
        
        Iterator<Integer> myListIterator2 = r.iterator();
            while (myListIterator2.hasNext()) {
                int c = myListIterator2.next();
                addENEMY2(c);
                addENEMY2(14-c);
            }

                    
        r.clear();
        n = rand.nextInt(2) + 1;
        if(n == 1) addENEMY3(7);
        
        for(int i = 0;i<5; i++){
            n = rand.nextInt(6) + 1;
            boolean a = false;
            Iterator<Integer> myListIterator3 = r.iterator();
            while (myListIterator3.hasNext()) {
                int c = myListIterator3.next();
                if(n == c) a = true;
            }
            r.add(n);
        }
        
        Iterator<Integer> myListIterator3 = r.iterator();
            while (myListIterator3.hasNext()) {
                int c = myListIterator3.next();
                addENEMY3(c);
                addENEMY3(14-c);
            }
            
                
        r.clear();
        n = rand.nextInt(2) + 1;
        if(n == 1) addENEMY4(7);
        
        for(int i = 0;i<5; i++){
            n = rand.nextInt(6) + 1;
            boolean a = false;
            Iterator<Integer> myListIterator4 = r.iterator();
            while (myListIterator4.hasNext()) {
                int c = myListIterator4.next();
                if(n == c) a = true;
            }
            r.add(n);
        }
        
        Iterator<Integer> myListIterator4 = r.iterator();
            while (myListIterator4.hasNext()) {
                int c = myListIterator4.next();
                addENEMY4(c);
                addENEMY4(14-c);
            }
   
    }

public void addBackground(){
    rasterAnimationList.add(new AnimationRaster(0,0,192,108,2,12,back,0));
    ThemeS.loop();
}

public void addHero(){
    rasterAnimationList.add(new AnimationRaster(0,0,12,12,1,18,gracz,1));
}

public void addPocisk(){
    int myX;
    myX = (int)MyKeyListener.x; 
    PociskS.play();
    rasterAnimationList.add(new AnimationRaster(myX+3*scale,MyKeyListener.y-12*scale,6,12,1,4,pocisk,2));
}

public void addENEMY1(int x){
    rasterAnimationList.add(new AnimationRaster((13*x+1)*scale,(14*0+3)*scale,12,12,1,11,ENEMY1,3));
}

public void addENEMY2(int x){
    rasterAnimationList.add(new AnimationRaster((13*x)*scale,(14*1+3)*scale,12,12,1,11,ENEMY2,4));
}

public void addENEMY3(int x){
    rasterAnimationList.add(new AnimationRaster((13*x+1)*scale,(14*2+3)*scale,12,12,1,11,ENEMY3,3));
}

public void addENEMY4(int x){
    rasterAnimationList.add(new AnimationRaster((13*x)*scale,(14*3+3)*scale,12,12,1,11,ENEMY4,4));
}

public void addPociskE(){ 
    rasterAnimationList.add(new AnimationRaster(myXE,myYE,6,8,1,7,pociskE,5));
}

public void addgameover(){
    rasterAnimationList.add(new AnimationRaster(0,0,192,108,2,0,gameover,0));
}

public void addcredits(){
    rasterAnimationList.add(new AnimationRaster(0,0,192,108,2,0,credits,0));
}

public void addstage(int i){ 
   if(i == 1) rasterAnimationList.add(new AnimationRaster(-70*scale,20*scale,64,24,1,1,s1,6));
   if(i == 2) rasterAnimationList.add(new AnimationRaster(-70*scale,20*scale,64,24,1,1,s2,6));
   if(i == 3) rasterAnimationList.add(new AnimationRaster(-70*scale,20*scale,64,24,1,1,s3,6));
   if(i == 4) rasterAnimationList.add(new AnimationRaster(-70*scale,20*scale,64,24,1,1,s4,6));
   if(i == 5) rasterAnimationList.add(new AnimationRaster(-70*scale,20*scale,64,24,1,1,s5,6));
}
}