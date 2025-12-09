package preresponsi;
import java.util.Scanner;

public class preresponsi {

    static void menu() {
        System.out.println("========== Menu Restoran ==========");
        System.out.println("1. Ayam Geprek     Rp. 15.000");
        System.out.println("2. Ayam Krispi     Rp. 13.000");
        System.out.println("3. Ayam Goreng     Rp. 10.000");
        System.out.println("4. Magelangan      Rp. 12.000");
        System.out.println("5. Nasi Goreng     Rp. 10.000");
        System.out.println("===================================");
    }

    static double hitungDiskon(double totalHarga) {
        return totalHarga * 0.10;
    }

    static double struk(String menu , double harga , int jumlah, double totalHarga) {
        double diskon = 0;
        double totalBayar = totalHarga;

        if (totalHarga > 50000) {
            diskon = hitungDiskon(totalHarga);
            totalBayar = totalHarga - diskon;
        }

        System.out.println("=== Struk Pesanan ===");
        System.out.println("Menu            : " + menu);
        System.out.println("Harga Satuan    : Rp. " + harga);
        System.out.println("Jumlah          : " + jumlah);
        System.out.println("Total harga     : Rp. " + totalHarga);
        System.out.println("Total diskon    : Rp. " + diskon);
        System.out.println("Total bayar     : Rp. " + totalBayar);
        System.out.println("======================");

        return totalBayar;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int pillihan, jumlahPesan, harga = 0;
        double totalSemua = 0;
        String menu = "";
        boolean pesan = true;

        while (pesan) {
            menu();

            System.out.print("Pilih nomer menu (1-5) : ");
            pillihan = in.nextInt();

            System.out.print("Masukan jumlah pesanan : ");
            jumlahPesan = in.nextInt();

            switch (pillihan) {
                case 1:
                    harga = 15000;
                    menu = "Ayam Geprek";
                    break;
                
                case 2:
                    harga = 13000;
                    menu = "Ayam Krispi";
                    break;

                case 3:
                    harga = 10000;
                    menu = "Ayam Goreng";
                    break;

                case 4:
                    harga = 12000;
                    menu = "Magelangan";
                    break;

                case 5:
                    harga = 10000;
                    menu = "Nasi Goreng";
                    break;

                default:
                    System.out.println("Input yang anda masukan salah!!");
                    break;
            }

            double totalHarga = harga * jumlahPesan;

            double totalBayarPesanan = struk(menu, harga, jumlahPesan, totalHarga);

            totalSemua += totalBayarPesanan;

            System.out.print("Apakah anda ingin memesan lagi? (Y/N) ");
            char tanya = in.next().charAt(0);

            if (tanya == 'n' || tanya == 'N') {
                pesan = false;
            }

            System.out.println("===== TOTAL PEMBAYARAN AKHIR =====");
            System.out.println("Total Pembayaran Akhir : Rp. " + totalSemua);
            System.out.println("==================================");
        }

        in.close();
    }
}
