package com.fuzzy.utilities;

/**
 *
 * Si Kami 088072
 */
public class HitungFuzzy {

    private double alfatotal = 0;

   
    public double miuHBMurah (double hargabaru){

        double hasil = (152 - hargabaru) / 3;
        return hasil;

    }

    public double miuHBMahal (double hargabaru){

        double hasil = (hargabaru - 149) / 3;
        return hasil;

    }

    public double miuKualSedang (double kualitas){

        double hasil = (95 - kualitas) / 15;
        return hasil;

    }

    public double miuKualBagus (double kualitas){

        double hasil = (kualitas - 80) / 15;
        return hasil;

    }

    public double hasilHSMurah (double miuHSMurah){

        double hasil = 140 - (10 * miuHSMurah);
        return hasil;

    }

    public double hasilHSMahal (double  miuHSMahal){

        double hasil = 130 + (10 * miuHSMahal);
        return hasil;

    }

    public double Rule1 (double hargabaru, double kualitas){

        //if harga baru tinggi and kualitas tinggi then harga second tinggi
        double alfa1 = Math.min(miuHBMahal(hargabaru), miuKualBagus(kualitas));
        double hasil = hasilHSMahal(alfa1);
        hasil = alfa1 * hasil;
        alfatotal = alfatotal + alfa1;
        System.out.println("Alfa1 : "+alfa1);
        System.out.println(hasil);
        return hasil;

    }

    public double Rule2 (double hargabaru, double kualitas){

        //if harga baru tinggi and kualitas sedang then harga second tinggi
        double alfa2 = Math.min(miuHBMahal(hargabaru), miuKualSedang(kualitas));
        double hasil = hasilHSMahal(alfa2);
        hasil = alfa2 * hasil;
        alfatotal = alfatotal + alfa2;
        System.out.println("Alfa2 : "+alfa2);
        System.out.println(hasil);
        return hasil;

    }

    public double Rule3 (double hargabaru, double kualitas){

        //if harga baru rendah and kualitas tinggi then harga second rendah
        double alfa3 = Math.min(miuHBMurah(hargabaru), miuKualBagus(kualitas));
        double hasil = hasilHSMurah(alfa3);
        hasil = alfa3 * hasil;
        alfatotal = alfatotal + alfa3;
        System.out.println("Alfa3 : "+alfa3);
        System.out.println(hasil);
        return hasil;

    }

    public double Rule4 (double hargabaru, double kualitas){

        //if harga baru rendah and kualitas rendah then harga second rendah
        double alfa4 = Math.min(miuHBMurah(hargabaru), miuKualSedang(kualitas));
        double hasil = hasilHSMurah(alfa4);
        hasil = alfa4 * hasil;
        alfatotal = alfatotal + alfa4;
        System.out.println("Alfa4 : "+alfa4);
        System.out.println(hasil);
        return hasil;

    }

    public double PerkiraanHarga (double hargabaru, double kualitas){

        double rule1 = Rule1(hargabaru, kualitas);
        double rule2 = Rule2(hargabaru, kualitas);
        double rule3 = Rule3(hargabaru, kualitas);
        double rule4 = Rule4(hargabaru, kualitas);
        double wek = rule1 + rule2 + rule3 + rule4;
        double hasil = wek / alfatotal;

        System.out.println("Rule1 : "+rule1);
        System.out.println("Rule2 : "+rule2);
        System.out.println("Rule3 : "+rule3);
        System.out.println("Rule4 : "+rule4);
        System.out.println("Jumlah Rule : "+wek);
        System.out.println("Alfa total : "+alfatotal);
        System.out.println(hasil);
        alfatotal = 0;
        return hasil;

    }

}
