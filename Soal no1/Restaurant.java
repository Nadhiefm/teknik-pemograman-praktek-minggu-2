public class Restaurant {
   
    private String[] nama_makanan;
    private double[] harga_makanan;
    private int[] stok;
    private static byte id = 0;

    public Restaurant() {
        nama_makanan = new String[10];
        harga_makanan = new double[10];
        stok = new int[10];
    }


    public String getNamaMakanan(int index) {
        return nama_makanan[index];
    }

    public void setStok(int index, int stokBaru) {
        if (stokBaru >= 0) { 
            this.stok[index] = stokBaru;
        } else {
            System.out.println("Gagal: Stok tidak boleh negatif!");
        }
    }

    public int getStok(int index) {
        return stok[index];
    }

    public void tambahMenuMakanan(String nama, double harga, int stok) {
        this.nama_makanan[id] = nama;
        this.harga_makanan[id] = harga;
        this.stok[id] = stok;
    }

    public void tampilMenuMakanan() {
        System.out.println("===== MENU RESTORAN =====");
        for (int i = 0; i <= id; i++) {
            if (!isOutOfStock(i) && nama_makanan[i] != null) {
                System.out.println(i + ". " + nama_makanan[i] + "\t[" + stok[i] + "]\tRp. " + harga_makanan[i]);
            }
        }
    }

    public boolean isOutOfStock(int index) {
        return stok[index] == 0;
    }

    public static void nextId() {
        id++;
    }

    // FITUR BARU: Pemesanan Menu
    public void pesanMakanan(int idMakanan, int jumlah) {
        if (idMakanan > id || nama_makanan[idMakanan] == null) {
            System.out.println("Maaf, menu tidak tersedia.");
            return;
        }

        if (stok[idMakanan] >= jumlah) {
            // Stok otomatis berkurang
            setStok(idMakanan, stok[idMakanan] - jumlah);
            System.out.println("Berhasil memesan " + jumlah + " " + nama_makanan[idMakanan]);
        } else {
            // Pesan ditolak jika stok tidak mencukupi
            System.out.println("Maaf, stok " + nama_makanan[idMakanan] + " tidak mencukupi!");
        }
    }
}