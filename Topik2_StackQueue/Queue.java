public class Queue {
    NodePelanggan front;
    NodePelanggan rear;
    int size;
    final int CAPACITY = 5;

    public Queue() {
        front = null;
        rear = null;
        size = 0;
    }

    public boolean isEmpty() {
        return front == null;
    }

    // Enqueue: tambah pelanggan baru ke belakang antrian,
    // maksimal 5 pelanggan
    public void enqueue(String nomorAntrian, String namaPelanggan,
            double totalBelanja) {
        if (size >= CAPACITY) {
            System.out.println("Antrian penuh, maksimal "
                    + CAPACITY + " pelanggan.");
            return;
        }

        NodePelanggan baru = new NodePelanggan(
                nomorAntrian, namaPelanggan, totalBelanja);

        if (isEmpty()) {
            front = baru;
            rear = baru;
        } else {
            rear.next = baru;
            rear = baru;
        }
        size++;
        System.out.println("Data pelanggan ditambahkan ke antrian!");
    }

    // Dequeue: hapus pelanggan dari depan antrian,
    // kembalikan data yang dihapus
    public NodePelanggan dequeue() {
        if (isEmpty()) {
            System.out.println("Antrian kosong, "
                    + "tidak ada pelanggan untuk dilayani.");
            return null;
        }

        NodePelanggan terdepan = front;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        size--;
        return terdepan;
    }

    public void tampilkanAntrian() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
            return;
        }

        System.out.println("Antrian saat ini:");
        NodePelanggan current = front;
        while (current != null) {
            System.out.println("Nomor: " + current.nomorAntrian
                    + " | Nama: " + current.namaPelanggan
                    + " | Total: " + current.totalBelanja);
            current = current.next;
        }
    }
}