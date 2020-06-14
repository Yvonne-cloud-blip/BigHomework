package wx.company;

/**
 * @description:
 * @author: DELL
 * @date: Created in 2020/6/14 13:40
 * @version: 1.0
 * @modified By:
 */
public class Monster {
    String name;
    int life;
    int attack;
    int maxLife;
    int defend;
    int sendExp;
    boolean isDead;
    boolean isRage;
    public Monster(String name,int maxLife,int attack,int defend,int sendExp){
        this.name=name;
        this.attack=attack;
        this.defend=defend;
        this.maxLife=maxLife;
        this.sendExp=sendExp;
        this.isDead=false;
        this.isRage=false;
    }
    public void injured(int loseLife){
        if(loseLife-defend>=0){
            this.life-=(loseLife-defend);
        }
        if (this.life<=0){
            System.out.println(name+",我一定会回来的");
        }
        if (this.life<this.maxLife/2){
            isRage=true;
        }
    }
    public void fight(Knight k){
        if (this.isDead){
            return;
        }
        int attack=this.attack;
        if (this.isRage){
            attack=attack*2;
            System.out.println(name+",我要粉碎你");
        }else {
            System.out.println("出击");
        }
        k.injured(attack);
    }
    public void show(){
        System.out.println("---------------------");
        System.out.println(name+",attack"+attack+",defend"+defend+",life"+life);
    }
}
