package org.example.Maas_Hesabi;
public class Maas_Hesabi {
    int k = 250;
    int default_day = 25;
    int work_day = 27;

    public void maas_cal(){
        System.out.println("Maaş = " + (k * work_day));
    }

    //prim hesabi
    public int prim = ((work_day - default_day) * 1000);

    public void primli_maas(){
        System.out.println("Primli maaş = " + (prim + (k * work_day)));
    }

    public static void main(String[] args) {
        Maas_Hesabi m1 = new Maas_Hesabi();

        System.out.println("Personelin çalıştığı gün sayısı : " + m1.work_day);
        String prim = (m1.work_day > 25) ? "Prim alabilirsin!" : "Maalesef prim alamazsın.";
        System.out.println(prim);

        if(m1.work_day < 25){
            m1.maas_cal();
        }
        else if (m1.work_day > 25){
            m1.primli_maas();
        }
    }
}