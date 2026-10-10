public class LinkedList {
    Node head;

    public LinkedList() {
        this.head = null;
    }

    // Tambah Buku: data baru dimasukkan di akhir daftar
    // (traversal dari head, karena tidak pakai tail pointer)
    public void tambahBuku(String kodeBuku, String judul, String penulis) {
        if (kodeBuku.length() > 5) {
            System.out.println("Kode buku maksimal 5 karakter!");
            return;
        }

        Node baru = new Node(kodeBuku, judul, penulis);

        if (head == null) {
            head = baru;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = baru;
        }
        System.out.println("Data berhasil ditambahkan!");
    }

    // Hapus Buku: menghapus data buku terakhir dari daftar
    public void hapusBuku() {
        if (head == null) {
            System.out.println("Tidak ada data untuk dihapus.");
            return;
        }

        if (head.next == null) {
            System.out.println("Buku \"" + head.judul
                    + "\" berhasil dihapus.");
            head = null;
            return;
        }

        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        System.out.println("Buku \"" + current.next.judul
                + "\" berhasil dihapus.");
        current.next = null;
    }

    // Cari Buku berdasarkan kodeBuku
    public void cariBuku(String kodeBuku) {
        Node current = head;
        while (current != null) {
            if (current.kodeBuku.equalsIgnoreCase(kodeBuku)) {
                System.out.println("Buku ditemukan!");
                System.out.println("Kode: " + current.kodeBuku
                        + " | Judul: " + current.judul
                        + " | Penulis: " + current.penulis);
                return;
            }
            current = current.next;
        }
        System.out.println("Buku tidak ditemukan.");
    }

    // Tampilkan semua buku sesuai urutan input
    public void tampilkanSemua() {
        if (head == null) {
            System.out.println("Daftar buku masih kosong.");
            return;
        }

        System.out.println("Daftar Buku:");
        Node current = head;
        int total = 0;
        while (current != null) {
            System.out.println("Kode: " + current.kodeBuku
                    + " | Judul: " + current.judul
                    + " | Penulis: " + current.penulis);
            current = current.next;
            total++;
        }
        System.out.println("Total Buku: " + total);
    }
}