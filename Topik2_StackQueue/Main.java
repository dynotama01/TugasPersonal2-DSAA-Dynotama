import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue antrianPelanggan = new Queue();
        Stack riwayatTransaksi = new Stack();
        int pilihan = 0;

        do {
            System.out.println("\n=== SISTEM KASIR TOKO ===");
            System.out.println("1. Tambah Antrian");
            System.out.println("2. Layani Pelanggan");
            System.out.println("3. Tampilkan Antrian");
            System.out.println("4. Lihat Riwayat Transaksi");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");

            try {
                pilihan = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Masukan tidak valid.");
                continue;
            }

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan Nomor Antrian: ");
                    String nomor = scanner.nextLine();
                    System.out.print("Masukkan Nama Pelanggan: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan Total Belanja: ");
                    double total;
                    try {
                        total = Double.parseDouble(scanner.nextLine().trim());
                    } catch (NumberFormatException e) {
                        System.out.println("Total belanja harus berupa angka.");
                        break;
                    }
                    antrianPelanggan.enqueue(nomor, nama, total);
                    break;
                case 2:
                    NodePelanggan dilayani = antrianPelanggan.dequeue();
                    if (dilayani != null) {
                        System.out.println("Melayani pelanggan "
                                + dilayani.nomorAntrian + " ("
                                + dilayani.namaPelanggan + ")");
                        riwayatTransaksi.push(dilayani);
                        System.out.println("Transaksi disimpan ke riwayat.");
                    }
                    break;
                case 3:
                    antrianPelanggan.tampilkanAntrian();
                    break;
                case 4:
                    riwayatTransaksi.tampilkanRiwayat();
                    break;
                case 5:
                    System.out.println("Program selesai. Terima kasih!");
                    break;
                default:
                    System.out.println("Menu tidak tersedia.");
            }
        } while (pilihan != 5);

        scanner.close();
    }
}