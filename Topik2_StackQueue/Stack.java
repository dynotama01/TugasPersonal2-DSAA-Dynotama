public class Stack {
    NodePelanggan top;

    public Stack() {
        top = null;
    }

    public boolean isEmpty() {
        return top == null;
    }

    // Push: simpan data transaksi pelanggan yang sudah dilayani
    // ke puncak stack
    public void push(NodePelanggan data) {
        data.next = top;
        top = data;
    }

    // Tampilkan riwayat dari transaksi terbaru ke yang paling lama
    // (urutan LIFO alami)
    public void tampilkanRiwayat() {
        if (isEmpty()) {
            System.out.println("Belum ada riwayat transaksi.");
            return;
        }

        System.out.println("Riwayat Transaksi (terbaru ke lama):");
        NodePelanggan current = top;
        while (current != null) {
            System.out.println("Nomor: " + current.nomorAntrian
                    + " | Nama: " + current.namaPelanggan
                    + " | Total: " + current.totalBelanja);
            current = current.next;
        }
    }
}