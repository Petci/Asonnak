package asonnakteszt;

import java.util.Arrays;
import java.util.Random;

public class AsonnakTeszt {

    public static void main(String[] args) {
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
                    if (Domb[i - 1][j] == Domb[i - 1][j + 1]) {
                        if (Domb[i - 1][j] == 1) {
                            int random = rnd.nextInt(2);
                            if (random == 0) {
                                Domb[i][j] = Domb[0][j];
                            } else {
                                Domb[i][j] = Domb[0][j] + 1;
                            }
                        } else if (Domb[i - 1][j] == 4) {
                            int random = rnd.nextInt(2);
                            if (random == 0) {
                                Domb[i][j] = Domb[0][j];
                            } else {
                                Domb[i][j] = Domb[0][j] - 1;
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
                    } else {
                        int random = rnd.nextInt(2);
                        if (random == 0) {
                            Domb[i][j] = Domb[i - 1][j];
                        } else {
                            Domb[i][j] = Domb[i - 1][j + 1];
                        }
                    }
                } else if (j > 0 && j < 3) {
                    if (Domb[i - 1][j] == Domb[i][j - 1] && Domb[i][j - 1] == Domb[i - 1][j + 1]) {
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
                    } else if (Domb[i - 1][j] != Domb[i][j - 1] && Domb[i][j - 1] != Domb[i - 1][j + 1] && Domb[i - 1][j] != Domb[i - 1][j + 1]) {
                        Domb[i][j] = (Domb[i - 1][j] + Domb[i][j - 1] + Domb[i - 1][j + 1]) / 3;
                    } else {
                        if (Domb[i - 1][j] == 1 || Domb[i][j - 1] == 1 || Domb[i - 1][j + 1] == 1) {
                            int random = rnd.nextInt(2);
                            if (random == 0) {
                                Domb[i][j] = 1;
                            } else {
                                Domb[i][j] = 2;
                            }
                        } else if (Domb[i - 1][j] == 4 || Domb[i][j - 1] == 4 || Domb[i - 1][j + 1] == 4) {
                            int random = rnd.nextInt(2);
                            if (random == 0) {
                                Domb[i][j] = 4;
                            } else {
                                Domb[i][j] = 3;
                            }
                        } else {
                            int random = rnd.nextInt(3);
                            if (random == 0) {
                                Domb[i][j] = Domb[i - 1][j];
                            } else if (random == 1) {
                                Domb[i][j] = Domb[i][j - 1];
                            } else {
                                Domb[i][j] = Domb[i - 1][j + 1];
                            }
                        }
                    }
                } else {
                    if (Domb[i - 1][j] == Domb[i][j - 1]) {
                        if (Domb[i - 1][j] == 1) {
                            int random = rnd.nextInt(2);
                            if (random == 0) {
                                Domb[i][j] = 1;
                            } else {
                                Domb[i][j] = 2;
                            }
                        } else if (Domb[i - 1][j] == 4) {
                            int random = rnd.nextInt(2);
                            if (random == 0) {
                                Domb[i][j] = 4;
                            } else {
                                Domb[i][j] = 3;
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
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(Domb[i][j]);
            }
            System.out.println();
        }
    }
}
