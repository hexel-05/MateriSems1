import java.util.Scanner; // Author Iqbal Ahnaf Fadholi

public class array {

    static Scanner input = new Scanner(System.in);

    static String[][] pasien = {
            { "P111", "Asep", "18" },
            { "P221", "Cecep", "19" },
            { "P331", "Supri", "20" },
            { "P441", "Yanto", "21" }
    };

    static void tampilkan() {
        System.out.println("\n------------------------------------------");
        System.out.printf("| %-2s | %-12s | %-10s | %-5s |\n", "No", "Nomor Pasien", "Nama", "Usia");
        System.out.println("------------------------------------------");
        for (int i = 0; i < pasien.length; i++) {
            System.out.printf(
                    "| %-2d | %-12s | %-10s | %-5s |\n",
                    (i + 1),
                    pasien[i][0],
                    pasien[i][1],
                    pasien[i][2]);
        }
        System.out.println("------------------------------------------\n");
    }

    static void tambah() {
        String nomor_pasien, nama_pasien, usia_pasien;
        String[][] tambah = new String[pasien.length + 1][3];

        for (int i = 0; i < pasien.length; i++) {
            tambah[i][0] = pasien[i][0];
            tambah[i][1] = pasien[i][1];
            tambah[i][2] = pasien[i][2];
        }

        System.out.print("\nMasukan nomor pasien : ");
        nomor_pasien = input.nextLine();
        while (!nomor_pasien.matches("^P\\d{3}$")) {
            System.out.print("Nomor pasien yang anda masukan salah!!\nMasukan nomor pasien : ");
            nomor_pasien = input.nextLine();
        }
        tambah[tambah.length - 1][0] = nomor_pasien;

        System.out.print("Masukan nama pasien : ");
        nama_pasien = input.nextLine();
        while (nama_pasien.equals("")) {
            System.out.print("Nama pasien yang anda masukan salah!!\nMasukan nama pasien : ");
            nama_pasien = input.nextLine();
        }
        tambah[tambah.length - 1][1] = nama_pasien;

        System.out.print("Masukan usia pasien : ");
        usia_pasien = input.nextLine();
        while (!usia_pasien.matches("\\d+") || usia_pasien.equals("")) {
            System.out.print("Usia yang anda masukan salah!!\nMasukan usia pasien : ");
            usia_pasien = input.nextLine();
        }
        tambah[tambah.length - 1][2] = usia_pasien;

        pasien = tambah;
        System.out.println("Data berhasil di masukan!\n");
    }

    static void cari() {
        System.out.print("Masukan nomor pasien yang ingin di cari : ");
        String cari = input.nextLine();

        while (!cari.matches("^P\\d{3}$")) {
            System.out.print(
                    "Nomor pasien yang anda masukan salah!!\nMasukan nomor pasien yang ingin di cari : ");
            cari = input.nextLine();
        }

        boolean pencarian = false;

        for (int i = 0; i < pasien.length; i++) {
            if (pasien[i][0].equalsIgnoreCase(cari)) {
                System.out.println("\n------------------------------------------");
                System.out.printf("| %-2s | %-12s | %-10s | %-5s |\n", "No", "Nomor Pasien", "Nama",
                        "Usia");
                System.out.println("------------------------------------------");

                System.out.printf(
                        "| %-2d | %-12s | %-10s | %-5s |\n",
                        (i + 1),
                        pasien[i][0],
                        pasien[i][1],
                        pasien[i][2]);
                pencarian = true;
                System.out.println("------------------------------------------\n");
                break;
            }
        }

        if (!pencarian) {
            System.out.println("Data tidak ditemukan!!");
        }
    }

    static void ubah() {
        int ubah_data, index;

        while (true) {
            System.out.print("Masukan nomor data yang ingin di ubah : ");

            if (!input.hasNextInt()) {
                System.out.print("Angka yang anda masukan salah!!\nMasukan nomor data yang ingin di ubah : ");
                input.nextLine();
                continue;
            }

            ubah_data = input.nextInt();
            input.nextLine();
            index = ubah_data - 1;

            if (index < 0 || index >= pasien.length) {
                System.out.print("Nomor data tidak ditemukan!\n");
                continue;
            }

            break;
        }

        System.out.println("\n------------------------------------------");
        System.out.printf("| %-2s | %-12s | %-10s | %-5s |\n", "No", "Nomor Pasien", "Nama", "Usia");
        System.out.println("------------------------------------------");
        System.out.printf(
                "| %-2d | %-12s | %-10s | %-5s |\n",
                (index + 1),
                pasien[index][0],
                pasien[index][1],
                pasien[index][2]);
        System.out.println("------------------------------------------\n");

        System.out.print("\nMasukan nomor pasien : ");
        String nomor_pasien = input.nextLine();
        while (!nomor_pasien.matches("^P\\d{3}$")) {
            System.out.print("Nomor pasien yang anda masukan salah!!\nMasukan nomor pasien : ");
            nomor_pasien = input.nextLine();
        }
        pasien[index][0] = nomor_pasien;

        System.out.print("Masukan nama pasien : ");
        String nama_pasien = input.nextLine();
        while (nama_pasien.equals("")) {
            System.out.print("Nama pasien yang anda masukan salah!!\nMasukan nama pasien : ");
            nama_pasien = input.nextLine();
        }
        pasien[index][1] = nama_pasien;

        System.out.print("Masukan usia pasien : ");
        String usia_pasien = input.nextLine();
        while (!usia_pasien.matches("\\d+") || usia_pasien.equals("")) {
            System.out.print("Usia yang anda masukan salah!!\nMasukan usia pasien : ");
            usia_pasien = input.nextLine();
        }
        pasien[index][2] = usia_pasien;
        System.out.println("Data berhasil di ubah\n");
    }

    static void hapus() {
        String[][] hapus = new String[pasien.length - 1][3];
        int hapus_data, index, newIndex;

        while (true) {
            System.out.print("Masukan nomor data yang ingin di ubah : ");

            if (!input.hasNextInt()) {
                System.out.print("Angka yang anda masukan salah!!\nMasukan nomor data yang ingin di ubah : ");
                input.nextLine();
                continue;
            }

            hapus_data = input.nextInt();
            input.nextLine();
            index = hapus_data - 1;

            if (index < 0 || index >= pasien.length) {
                System.out.print("Nomor data tidak ditemukan!\n");
                continue;
            }
            break;
        }

        System.out.println("\n------------------------------------------");
        System.out.printf("| %-2s | %-12s | %-10s | %-5s |\n", "No", "Nomor Pasien", "Nama", "Usia");
        System.out.println("------------------------------------------");
        System.out.printf(
                "| %-2d | %-12s | %-10s | %-5s |\n",
                (index + 1),
                pasien[index][0],
                pasien[index][1],
                pasien[index][2]);
        System.out.println("------------------------------------------\n");

        System.out.print("Apakah anda ingin menghapus data ini (y/n) : ");
        String konfirmasi = input.nextLine();

        if (!konfirmasi.equalsIgnoreCase("y")) {
            return;
        }

        System.out.println();

        newIndex = 0;
        for (int i = 0; i < pasien.length; i++) {
            if (i == index)
                continue;
            hapus[newIndex] = pasien[i];
            newIndex++;
        }

        System.out.println("Data berhasil dihapus!!\n");
        pasien = hapus;
    }

    public static void statistik() {
        int totalPasien = pasien.length;

        if (totalPasien == 0) {
            System.out.println("Tidak ada data pasien!");
            return;
        }

        int usiaTermuda = Integer.MAX_VALUE;
        int usiaTertua = Integer.MIN_VALUE;
        int totalUsia = 0;

        int balita = 0;
        int anak = 0;
        int remaja = 0;
        int dewasa = 0;
        int lansia = 0;

        for (int i = 0; i < pasien.length; i++) {
            int usia = Integer.parseInt(pasien[i][2]);

            if (usia < usiaTermuda)
                usiaTermuda = usia;
            if (usia > usiaTertua)
                usiaTertua = usia;

            totalUsia += usia;

            if (usia >= 0 && usia <= 5)
                balita++;
            else if (usia <= 12)
                anak++;
            else if (usia <= 17)
                remaja++;
            else if (usia <= 59)
                dewasa++;
            else
                lansia++;
        }

        double rataRata = (double) totalUsia / totalPasien;

        System.out.println("\n===========================================");
        System.out.println("        STATISTIK DATA PASIEN");
        System.out.println("===========================================");
        System.out.printf("Total Pasien                : %d\n", totalPasien);
        System.out.printf("Usia Termuda                : %d tahun\n", usiaTermuda);
        System.out.printf("Usia Tertua                 : %d tahun\n", usiaTertua);
        System.out.printf("Rata-rata Usia              : %.2f tahun\n", rataRata);
        System.out.println("-------------------------------------------");
        System.out.println("        Jumlah Pasien per Kelompok Usia");
        System.out.println("-------------------------------------------");
        System.out.printf("Balita (0-5)                : %d\n", balita);
        System.out.printf("Anak (6-12)                 : %d\n", anak);
        System.out.printf("Remaja (13-17)              : %d\n", remaja);
        System.out.printf("Dewasa (18-59)              : %d\n", dewasa);
        System.out.printf("Lansia (60+)                : %d\n", lansia);
        System.out.println("===========================================\n");
    }

    public static void main(String[] args) {
        boolean ulang = true;

        while (ulang) {
            System.out.print(
                    "1. Tampilkan data\n2. Tambah data\n3. Cari data\n4. Ubah data\n5. Hapus data\n6. Statistik\n7. Keluar\nPilih menu : ");
            int tanya = input.nextInt();
            input.nextLine();

            switch (tanya) {
                case 1:
                    tampilkan();
                    break;

                case 2:
                    tambah();
                    break;

                case 3:
                    cari();
                    break;

                case 4:
                    ubah();
                    break;

                case 5:
                    hapus();
                    break;

                case 6:
                    statistik();
                    break;

                case 7:
                    ulang = false;
                    break;

                default:
                    break;
            }
        }

        System.out.println("\nTerimakasih telah menggunakan program ini!!\n");
    }
}