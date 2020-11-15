import java.util.Scanner;

public class graphicdart {

    public static void main(String[] args) {
        System.out.println(" GUI DART GAME!");
        while (true) {
            System.out.println("Welcome to Dart Game v.2");
            Scanner scn = new Scanner(System.in);
            System.out.println("Please select:\n[1]Dart Info\n[2]Graph + Dart Info\n[3]Graph\n[Q]Quit");
            String selection = scn.next();

            if (selection.equals("q") || selection.equals("Q")){
                break;
            }
            int selint = Integer.parseInt(selection);
            boolean dartinfo = false;
            boolean graph = false;

            if ((selint) == 1){
                dartinfo = true   ;

            }  else if (selint == 2) {
                dartinfo = true;
                graph = true;
            }else{
                graph = true;
            }


            System.out.println("Enter Dart Number:");
            int dart_sayisi = scn.nextInt();
            int sayac = 1;

            int A = 0;
            int B = 0;
            int C = 0;
            int D = 0;
            int E = 0;
            int F = 0;
            int U = 0;
            double toplam = dart_sayisi;
            String a[][] = new String[19][19];

            for (int y = 0; y < a.length; y++) {

                for (int x = 0; x < a.length; x++) {
                    if ((y == 9 || x == 9) || (x + y == 18 && x < 9) || (x == y + 9)) {
                        a[y][x] = ". ";

                    } else {
                        a[y][x] = "  ";
                    }


                }

            }
            a[7][12] = "A ";
            a[3][17] = "B ";
            a[5][5] = "C ";
            a[12][3] = "D ";
            a[15][7] = "E ";
            a[14][14] = "F ";


            while (dart_sayisi != 0) {
                double dartpos_x = ((int) (Math.random() * 10)) / 10.0;
                double dartpos_y = ((int) (Math.random() * 10)) / 10.0;
                if ((int) (Math.random() * 10) < 5) {
                    dartpos_x *= -1;
                }
                if ((int) (Math.random() * 10) < 5) {
                    dartpos_y *= -1;
                }
                if (dartinfo) {
                    System.out.println("\nDart " + sayac + ":");
                    System.out.println("Coordinates: (" + dartpos_x + " " + dartpos_y + ")");

                    if (dartpos_x == 0 || dartpos_y == 0 || (dartpos_x + dartpos_y == 1 && dartpos_x > 0) || (dartpos_x == dartpos_y && dartpos_x < 0)) {
                        System.out.println("Region: Undecided");
                        U++;
                    } else {
                        if (dartpos_x > 0 && dartpos_y < 0) {
                            System.out.println("Region: F");
                            F++;
                        } else if (dartpos_x < 0 && dartpos_y > 0) {
                            System.out.println("Region: C");
                            C++;
                        } else if (dartpos_x > 0 && dartpos_y > 0 && dartpos_x + dartpos_y < 1) {
                            System.out.println("Region: A");
                            A++;
                        } else if (dartpos_x > 0 && dartpos_y > 0 && dartpos_x + dartpos_y > 1) {
                            System.out.println("Region: B");
                            B++;
                        } else if (dartpos_x < 0 && dartpos_y < 0 && dartpos_x < dartpos_y) {
                            System.out.println("Region: D");
                            D++;
                        } else if (dartpos_x < 0 && dartpos_y < 0 && dartpos_x > dartpos_y) {
                            System.out.println("Region: E");
                            E++;
                        }
                    }
                }
                int X = (int) (dartpos_x * 10 + 9);
                int Y = (int) (dartpos_y * -10 + 9);


                String gecici = a[Y][X];
                a[Y][X] = "X ";
                if (graph) {
                    for (int y = 0; y < a.length; y++) {

                        for (int x = 0; x < a.length; x++) {

                            System.out.print(a[y][x]);


                        }
                        System.out.println();
                    }
                }
                a[(int) (dartpos_y * -10 + 9)][(int) (dartpos_x * 10 + 9)] = gecici;
                dart_sayisi--;
                sayac++;
            }
            System.out.println("Region Statics:");
            System.out.println("A:" + A + " Darts" + "(" + Math.round((A / toplam) * 100) + "%)");
            System.out.println("B:" + B + " Darts" + "(" + Math.round((B / toplam) * 100) + "%)");
            System.out.println("C:" + C + " Darts" + "(" + Math.round((C / toplam) * 100) + "%)");
            System.out.println("D:" + D + " Darts" + "(" + Math.round((D / toplam) * 100) + "%)");
            System.out.println("E:" + E + " Darts" + "(" + Math.round((E / toplam) * 100) + "%)");
            System.out.println("F:" + F + " Darts" + "(" + Math.round((F / toplam) * 100) + "%)");
            System.out.println("U:" + U + " Darts" + "(" + Math.round((U / toplam) * 100) + "%)");


        }

    }
}


