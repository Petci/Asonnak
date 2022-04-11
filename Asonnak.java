/*
Hegység és forrás szimuláció

1. feladat 

Készíts egy programot, ami véletlenszerűen, de nagyjából életszerű terepet generál, dombokkal, völgyekkel. A mérete legyen paraméterezhető.
 Találd meg a legalacsonyabb pontját/pontjait.

2. feladat
 Tegyük fel, hogy az egyik legalacsonyabb pontjában feltör egy forrás és elkezdi feltölteni a völgyeket. Szimuláld ezt a folyamatot!
 
 Megj.:
 - használj egy int[N][N] 2 dimenziós tömböt a terep tárolásához, amiben az egyes koordinátákhoz tartozó magasságot tárolod.
 - a terep szélei végtelen magas falnak tekinthetők.
 - a terep nem kell teljesen valószerű legyen, de alakuljanak ki nagyobb dombok és völgyek
 - a víz jelölésére használj negatív számokat a tömbben (aminek az abszolút értéke a vízszint magassága, és a negatív előjele jelzi, hogy ott víz van és nem föld.)
 - víz csak a 4 szomszédos területre folyhat át, ha elérte annak a magasságát vagy a szomszéd nála alacsonyabb. Ha nem tud átfolyni sehova, akkor növekszik a víz szintje.
 - előfordul, hogy egy szomszédos völgybe átfolyik a víz és azt is elkezdi telíteni, ezért mindig csak a legalacsonyabb víz szintje növekszik.
 - a console-ra írd ki mindig az aktuális állapotot minden egyes lépés után
//*/

package asonnak;

import java.util.Arrays;
import java.util.Random;

public class Asonnak {

    public static void kiir(int[][] Domb) { //Kiírja a tömböt
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(Domb[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean vége(int[][] Domb) {
        boolean vége = true;
        int cn4 = 0; //Count: negative 4. Megnézi hogy az összem elem -4-es, vagy sem;
        for (int i = 0; i < Domb.length; i++) {
            for (int j = 0; j < Domb.length; j++) {
                if (Domb[i][j] == -4) {
                    cn4++;
                }
            }
        }
        if (cn4 == 4 * 4) { //Azért 4*4, hogyha át akarom majd írni manuálisan jobban lássam, hogy ezt is kell.
            vége = false;
        }
        return vége;
    }

    public static void main(String[] args) {
        //Domborzat létrehozása
        Random rnd = new Random();
        //[Sor] [Oszlop]
        int[][] Domb = new int[4][4];
        Domb[0][0] = rnd.nextInt(4) + 1; //Első létrehozása
        for (int j = 1; j <= 3; j++) { //Első sor kitöltése
            if (Domb[0][j - 1] == 1) {
                int random = rnd.nextInt(2);
                if (random == 0) {
                    Domb[0][j] = Domb[0][j - 1];
                } else {
                    Domb[0][j] = Domb[0][j - 1] + 1;
                }
            } else if (Domb[0][j - 1] == 4) {
                int random = rnd.nextInt(2);
                if (random == 0) {
                    Domb[0][j] = Domb[0][j - 1];
                } else {
                    Domb[0][j] = Domb[0][j - 1] - 1;
                }
            } else {
                int random = rnd.nextInt(3);
                if (random == 0) {
                    Domb[0][j] = Domb[0][j - 1] - 1;
                } else if (random == 1) {
                    Domb[0][j] = Domb[0][j - 1];
                } else {
                    Domb[0][j] = Domb[0][j - 1] + 1;
                }
            }
        }
        for (int i = 1; i <= 3; i++) { //Az egész tömb feltöltése
            for (int j = 0; j <= 3; j++) {
                if (j == 0) {
                    if (Domb[i - 1][j] == 1) {
                        int random = rnd.nextInt(2);
                        if (random == 0) {
                            Domb[i][j] = Domb[i - 1][j];
                        } else {
                            Domb[i][j] = Domb[i - 1][j] + 1;
                        }
                    } else if (Domb[i - 1][j] == 4) {
                        int random = rnd.nextInt(2);
                        if (random == 0) {
                            Domb[i][j] = Domb[i - 1][j];
                        } else {
                            Domb[i][j] = Domb[i - 1][j] - 1;
                        }
                    } else {
                        int random = rnd.nextInt(3);
                        if (random == 0) {
                            Domb[i][j] = Domb[i - 1][j] - 1;
                        } else if (random == 1) {
                            Domb[i][j] = Domb[i - 1][j];
                        } else {
                            Domb[i][j] = Domb[i - 1][j] + 1;
                        }
                    }
                }
                if (j > 0 && j < 4) {
                    if (Domb[i - 1][j] == Domb[i][j - 1]) {
                        if (Domb[i - 1][j] == 1) {
                            int random = rnd.nextInt(2);
                            if (random == 0) {
                                Domb[i][j] = Domb[i - 1][j];
                            } else {
                                Domb[i][j] = Domb[i - 1][j] + 1;
                            }
                        } else if (Domb[i - 1][j] == 4) {
                            int random = rnd.nextInt(2);
                            if (random == 0) {
                                Domb[i][j] = Domb[i - 1][j];
                            } else {
                                Domb[i][j] = Domb[i - 1][j] - 1;
                            }
                        } else {
                            int random = rnd.nextInt(3);
                            if (random == 0) {
                                Domb[i][j] = Domb[i - 1][j] - 1;
                            } else if (random == 1) {
                                Domb[i][j] = Domb[i - 1][j];
                            } else {
                                Domb[i][j] = Domb[i - 1][j] + 1;
                            }
                        }
                    } else if (Domb[i - 1][j] != Domb[i][j - 1] && (Domb[i - 1][j] - Domb[i][j - 1] == 2 || Domb[i][j - 1] - Domb[i - 1][j] == 2)) {
                        Domb[i][j] = (Domb[i - 1][j] + Domb[i][j - 1]) / 2;
                    } else {
                        if (Domb[i - 1][j] == 1 || Domb[i][j - 1] == 1) {
                            int random = rnd.nextInt(2);
                            if (random == 0) {
                                Domb[i][j] = 1;
                            } else {
                                Domb[i][j] = 2;
                            }
                        } else if (Domb[i - 1][j] == 4 || Domb[i][j - 1] == 4) {
                            int random = rnd.nextInt(2);
                            if (random == 0) {
                                Domb[i][j] = 4;
                            } else {
                                Domb[i][j] = 3;
                            }
                        } else {
                            int random = rnd.nextInt(2);
                            if (random == 0) {
                                Domb[i][j] = Domb[i - 1][j];
                            } else {
                                Domb[i][j] = Domb[i][j - 1];
                            }
                        }
                    }
                }
            }

        }

        kiir(Domb); //A domborzat szimulálva

        //A víz feltörése
        int f = 4; //Forrás
        int fh = 0; //A forrás helyeinek az összege

        for (int i = 0; i < Domb.length; i++) {
            for (int j = 0; j < Domb.length; j++) {
                if (f > Domb[i][j]) {
                    f = Domb[i][j];
                }
            }
        }
        for (int i = 0; i < Domb.length; i++) {
            for (int j = 0; j < Domb.length; j++) {
                if (f == Domb[i][j]) {
                    fh++;
                }
            }
        }

        int r = rnd.nextInt(fh);
        fh = -1;

        for (int i = 0; i < Domb.length; i++) {
            for (int j = 0; j < Domb.length; j++) {
                if (f == Domb[i][j]) {
                    fh++;
                    if (fh == r) {
                        Domb[i][j] *= -1;
                    }
                }
            }
        }

        kiir(Domb);//A forráspont kitört

        //Lefolyás, átfolyás, és töltődés a legvégéig. 
        int cá; // Count: Átfolyt. Számon tartja mennyi területre folyt már át.
        int cnsz; // Count: Nem szomszédos
        int L; //Legkisebb
        int A; //Alacsonyabb

        do {
            do { //ÁTFOLYÁS //Addig csinálja amíg nem tud átfolyni.
                do { //LEFOLYÁS //Legkisebb meghatározása és lefolyások. (Itt a legkisebb miatt fontos, hogy min 1szer megcsinálja.
                    L = -5;
                    for (int i = 0; i < Domb.length; i++) {
                        for (int j = 0; j < Domb.length; j++) {
                            if (Domb[i][j] < 0 && Domb[i][j] > L) {
                                L = Domb[i][j];
                            }
                        }
                    }

                    A = 0;
                    cá = 0; //Lefolyhat egyszerre 5 helyre is akár.
                    for (int i = 0; i < Domb.length; i++) {
                        for (int j = 0; j < Domb.length; j++) {
                            if (Domb[i][j] == L) {
                                if (i != 0) {
                                    if (cá != 4 && Domb[i][j] < Domb[i - 1][j] * -1 && Domb[i - 1][j] > 0) {
                                        Domb[i - 1][j] *= -1;
                                        cá++;
                                        A++;
                                    }
                                }

                                if (j != 0) {
                                    if (cá != 4 && Domb[i][j] < Domb[i][j - 1] * -1 && Domb[i][j - 1] > 0) {
                                        Domb[i][j - 1] *= -1;
                                        cá++;
                                        A++;
                                    }
                                }

                                if (j != 3) {
                                    if (cá != 4 && Domb[i][j] < Domb[i][j + 1] * -1 && Domb[i][j + 1] > 0) {
                                        Domb[i][j + 1] *= -1;
                                        cá++;
                                        A++;
                                    }
                                }

                                if (i != 3) {
                                    if (cá != 4 && Domb[i][j] < Domb[i + 1][j] * -1 && Domb[i + 1][j] > 0) {
                                        Domb[i + 1][j] *= -1;
                                        cá++;
                                        A++;
                                    }
                                }
                            }
                        }
                    }
                    if (A != 0) {
                        kiir(Domb);
                    }
                } while (A != 0);

                cá = 0;
                do { //Ha átfolyt 4-re vagy nem tud átfolnyi akkor kiírja az átváltoztatottad. Mi van ha nem tud átfolyni akkor kiírja mégegyszer az előzőt?!!
                    cnsz = 0;
                    for (int i = 0; i < Domb.length; i++) {
                        for (int j = 0; j < Domb.length; j++) {
                            if (Domb[i][j] == L) {
                                if (i != 0) {
                                    if (cá != 4 && Domb[i][j] == Domb[i - 1][j] * -1) {
                                        Domb[i - 1][j] = Domb[i][j];
                                        cá++;
                                        cnsz++;
                                    }
                                }

                                if (j != 0) {
                                    if (cá != 4 && Domb[i][j] == Domb[i][j - 1] * -1) {
                                        Domb[i][j - 1] = Domb[i][j];
                                        cá++;
                                        cnsz++;
                                    }
                                }

                                if (j != 3) {
                                    if (cá != 4 && Domb[i][j] == Domb[i][j + 1] * -1) {
                                        Domb[i][j + 1] = Domb[i][j];
                                        cá++;
                                        cnsz++;
                                    }
                                }

                                if (i != 3) {
                                    if (cá != 4 && Domb[i][j] == Domb[i + 1][j] * -1) {
                                        Domb[i + 1][j] = Domb[i][j];
                                        cá++;
                                        cnsz++;
                                    }
                                }
                            }

                        }
                    }
                } while (cá != 4 && cnsz != 0);

                if (cá != 0) {
                    kiir(Domb); //Ha legalább 1 területre átfolyt akkor írja ki
                }

            } while (cnsz != 0);

            //EMELKEDÉS
            for (int i = 0; i < Domb.length; i++) {
                for (int j = 0; j < Domb.length; j++) {
                    if (Domb[i][j] == L && L != -4) {
                        Domb[i][j] -= 1;
                    }

                }
            }

            kiir(Domb);

        } while (vége(Domb));
    }

}
