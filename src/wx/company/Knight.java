package wx.company;

import java.util.concurrent.atomic.DoubleAccumulator;

/**
 * @description:
 * @author: DELL
 * @date: Created in 2020/6/14 13:31
 * @version: 1.0
 * @modified By:
 */
public class Knight {
    String name;
    int maxLife;
    int life;
    int attack;
    int defend;
    int cirticalRate;
    int cirtivalVal;
    int missRate;
    int exp;
    int level;
    int levelExp;
    boolean isDead;
    public Knight(String name){
        this.name=name;
        life=100;
        maxLife=100;
        attack=25;
        defend=15;
        cirticalRate=10;
        cirtivalVal=100;
        missRate=8;
        exp=0;
        level=1;
        isDead=false;
        levelExp=30;
    }
    public boolean rateCheck(int rate){
        int ran=(int)(Math.random()*100);
        if (ran<rate){
            return true;
        }else {
            return false;
        }
    }
    public void fight(Monster m){
        while (!this.isDead && !m.isDead){
            boolean isCirtical=rateCheck(cirticalRate);
            int attack=this.attack;
            if (isCirtical){
                System.out.println("我的大刀早已饥渴难耐了");
                attack=attack+(cirtivalVal/100)*attack;
            }else {
                System.out.println("看招，平A你");
            }
            m.injured(attack);
            if (!m.isDead){
                m.fight(this);
            }else {
                this.exp+=m.sendExp;
                checkUpgrade();
            }
        }
    }
    public void checkUpgrade(){
        if (this.exp>=levelExp){
            upgrade();
        }
    }
    public void upgrade(){
        System.out.println("当当当"+name+"升级");
        attack*=1.2;
        defend*=1.2;
        maxLife*=1.2;
        life=maxLife;
        cirticalRate*=1.5;
        cirtivalVal*=1.2;
        missRate*=1.2;
        levelExp*=1.5;
        level+=1;
        exp=0;
    }
    public void injured(int loseLife){
        boolean isMiss=rateCheck(this.missRate);
        if (isMiss){
            System.out.println(name+",打不到");
            return;
        }
        if (loseLife-defend>0){
            System.out.println(name+",哇，中招了");
            this.life-=(loseLife-defend);
        }
        if (this.life<0){
            this.isDead=true;
            System.out.println(name+"甜度英才,成功击退怪兽进入城堡寻找宝藏吧");
        }
    }
    public void show(){
        System.out.println("---------------------");
        System.out.println(name+",attack"+attack+",defend"+defend+",life"+life);
    }
}
