package asono;

import java.util.Arrays;
import java.util.Random;

public class AsonO {

    public static void kiir(int[][] Domb) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(Domb[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        //Domborzat létrehozása
        Random rnd = new Random();
        //[Sor] [Oszlop]
        int[][] Domb = new int[4][4];
        Domb[0][0] = rnd.nextInt(4) + 1;
        for (int j = 1; j <= 3; j++) {
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
        for (int i = 1; i <= 3; i++) {
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

        kiir(Domb);

        //Első legkisebb
        int s = 4;
        int ct = 0;

        for (int i = 0; i < Domb.length; i++) {
            for (int j = 0; j < Domb.length; j++) {
                if (s > Domb[i][j]) {
                    s = Domb[i][j];
                }
            }
        }
        for (int i = 0; i < Domb.length; i++) {
            for (int j = 0; j < Domb.length; j++) {
                if (s == Domb[i][j]) {
                    ct++;
                }
            }
        }

        int r = rnd.nextInt(ct);
        ct = -1;
        int k1 = 0;
        int k2 = 0;

        for (int i = 0; i < Domb.length; i++) {
            for (int j = 0; j < Domb.length; j++) {
                if (s == Domb[i][j]) {
                    ct++;
                    if (ct == r) {
                        Domb[i][j] *= -1;
                        k1 = i;
                        k2 = j;
                    }
                }
            }
        }

        kiir(Domb);

        //Terjedés
        int count = 0;
        int cnsz = 0; // Count: Nem szomszédos

        do {
            count = 0;
            do {
                cnsz = 0;
                for (int e = 0; e < Domb.length; e++) {
                    for (int k = 0; k < Domb.length; k++) {
                        if (Domb[e][k] < 0) {
                            if (e != 0) {

                                if (count != 4 && Domb[e][k] == Domb[e - 1][k] * -1) {
                                    Domb[e - 1][k] = Domb[e][k];
                                    count++;
                                    cnsz++;
                                }
                            }
                            if (k != 0) {

                                if (count != 4 && Domb[e][k] == Domb[e][k - 1] * -1) {
                                    Domb[e][k - 1] = Domb[e][k];
                                    count++;
                                    cnsz++;
                                }
                            }
                            if (k != 3) {

                                if (count != 4 && Domb[e][k] == Domb[e][k + 1] * -1) {
                                    Domb[e][k + 1] = Domb[e][k];
                                    count++;
                                    cnsz++;
                                }
                            }
                            if (e != 3) {

                                if (count != 4 && Domb[e][k] == Domb[e + 1][k] * -1) {
                                    Domb[e + 1][k] = Domb[e][k];
                                    count++;
                                    cnsz++;
                                }
                            }
                        }

                    }
                }

            } while (count != 4 && cnsz != 0);

            kiir(Domb);
            System.out.println(count);
            System.out.println(cnsz);
        } while (cnsz != 0);

        //Emelkedés
        int l = Domb[k1][k2]; // Legkisebb
        for (int i = 0; i < Domb.length; i++) {
            for (int j = 0; j < Domb.length; j++) {
                if (Domb[i][j] == l) {
                    Domb[i][j] -= 1;
                }

            }

        }
        kiir(Domb);

        //2. terjedési sorozat 1. lépése
        count = 0;
        do {
            cnsz = 0;
            for (int e = 0; e < Domb.length; e++) {
                for (int k = 0; k < Domb.length; k++) {
                    if (Domb[e][k] < 0) {
                        if (e != 0) {

                            if (count != 4 && Domb[e][k] == Domb[e - 1][k] * -1) {
                                Domb[e - 1][k] = Domb[e][k];
                                count++;
                                cnsz++;
                            }
                        }
                        if (k != 0) {

                            if (count != 4 && Domb[e][k] == Domb[e][k - 1] * -1) {
                                Domb[e][k - 1] = Domb[e][k];
                                count++;
                                cnsz++;
                            }
                        }
                        if (k != 3) {

                            if (count != 4 && Domb[e][k] == Domb[e][k + 1] * -1) {
                                Domb[e][k + 1] = Domb[e][k];
                                count++;
                                cnsz++;
                            }
                        }
                        if (e != 3) {

                            if (count != 4 && Domb[e][k] == Domb[e + 1][k] * -1) {
                                Domb[e + 1][k] = Domb[e][k];
                                count++;
                                cnsz++;
                            }
                        }
                    }

                }
            }

        } while (count != 4 && cnsz != 0);

        kiir(Domb);

        //Lefolyás vizsgálata
        int a = 0; //Alacsonyabb. 232->23-2->23-3->2-3-3-> 2=>a
        count = 0;
        for (int e = 0; e < Domb.length; e++) {
            for (int k = 0; k < Domb.length; k++) {
                if (Domb[e][k] < 0) {
                    if (e != 0) {
                        if (count != 4 && Math.abs(Domb[e][k]) > Math.abs(Domb[e - 1][k]) && Domb[e - 1][k] > 0) {
                            Domb[e - 1][k] *= -1;
                            a++;
                            count++;
                            cnsz++;
                        }
                    }
                    if (k != 0) {

                        if (count != 4 && Math.abs(Domb[e][k]) > Math.abs(Domb[e][k - 1])&& Domb[e][k-1] > 0) {
                            Domb[e][k - 1] *= -1;
                            a++;
                            count++;    
                            cnsz++;
                        }
                    }
                    if (k != 3) {

                        if (count != 4 && Math.abs(Domb[e][k]) > Math.abs(Domb[e][k + 1])&& Domb[e][k + 1] > 0) {
                            Domb[e][k + 1] *= -1;
                            a++;
                            count++;
                            cnsz++;
                        }
                    }
                    if (e != 3) {
                        if (count != 4 && Math.abs(Domb[e][k]) > Math.abs(Domb[e + 1][k])&& Domb[e + 1][k] > 0) {
                            Domb[e + 1][k] *= -1;
                            a++;
                            count++;
                            cnsz++;
                        }
                    }
                }

            }

        }
        kiir(Domb);
    }

}
