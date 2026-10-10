import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList daftarBuku = new LinkedList();
        int pilihan = 0;

        do {
            System.out.println("\n===== SISTEM DATA BUKU =====");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Hapus Buku");
            System.out.println("3. Cari Buku");
            System.out.println("4. Lihat Semua Buku");
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
                    System.out.print("Masukkan Kode Buku: ");
                    String kode = scanner.nextLine();
                    System.out.print("Masukkan Judul: ");
                    String judul = scanner.nextLine();
                    System.out.print("Masukkan Penulis: ");
                    String penulis = scanner.nextLine();
                    daftarBuku.tambahBuku(kode, judul, penulis);
                    break;
                case 2:
                    daftarBuku.hapusBuku();
                    break;
                case 3:
                    System.out.print("Masukkan Kode Buku: ");
                    String cariKode = scanner.nextLine();
                    daftarBuku.cariBuku(cariKode);
                    break;
                case 4:
                    daftarBuku.tampilkanSemua();
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