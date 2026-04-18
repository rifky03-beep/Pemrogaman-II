import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KalkulatorSederhana extends JFrame {
    
    // Deklarasi Komponen Dasar Swing (Atomic Components)
    private JLabel lblAngka1, lblAngka2, lblHasil;
    private JTextField txtAngka1, txtAngka2, txtHasil;
    private JButton btnTambah, btnHapus, btnExit;

    public KalkulatorSederhana() {
        // Pengaturan Frame (Top-Level Container)
        setTitle("Desain GUI - Pertemuan 3");
        setSize(400, 320);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Agar window muncul di tengah layar
        setLayout(null); // Menggunakan null layout agar posisi komponen bisa diatur manual sesuai gambar

        // --- Membuat dan Mengatur Posisi JLabel & JTextField ---
        
        lblAngka1 = new JLabel("Angka Pertama");
        lblAngka1.setBounds(50, 40, 100, 25);
        add(lblAngka1);

        txtAngka1 = new JTextField();
        txtAngka1.setBounds(160, 40, 150, 25);
        add(txtAngka1);

        lblAngka2 = new JLabel("Angka Kedua");
        lblAngka2.setBounds(50, 90, 100, 25);
        add(lblAngka2);

        txtAngka2 = new JTextField();
        txtAngka2.setBounds(160, 90, 150, 25);
        add(txtAngka2);

        lblHasil = new JLabel("Hasil");
        lblHasil.setBounds(50, 140, 100, 25);
        add(lblHasil);

        txtHasil = new JTextField();
        txtHasil.setBounds(160, 140, 150, 25);
        txtHasil.setEditable(false); // Field hasil biasanya tidak bisa diedit manual
        add(txtHasil);

        // --- Membuat dan Mengatur Posisi JButton ---
        
        btnTambah = new JButton("Tambah");
        btnTambah.setBounds(40, 210, 85, 30);
        add(btnTambah);

        btnHapus = new JButton("Hapus");
        btnHapus.setBounds(145, 210, 85, 30);
        add(btnHapus);

        btnExit = new JButton("Exit");
        btnExit.setBounds(250, 210, 85, 30);
        add(btnExit);

        // --- Event Handling ---
        
        // Aksi untuk tombol "Tambah"
        btnTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Mengambil input, mengubahnya menjadi angka (Double), lalu menjumlahkannya
                    double angka1 = Double.parseDouble(txtAngka1.getText());
                    double angka2 = Double.parseDouble(txtAngka2.getText());
                    double hasil = angka1 + angka2;
                    
                    // Menampilkan hasil ke txtHasil
                    txtHasil.setText(String.valueOf(hasil));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Harap masukkan angka yang valid!");
                }
            }
        });

        // Aksi untuk tombol "Hapus"
        btnHapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtAngka1.setText("");
                txtAngka2.setText("");
                txtHasil.setText("");
                txtAngka1.requestFocus(); // Mengembalikan kursor ke textfield pertama
            }
        });

        // Aksi untuk tombol "Exit"
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Menutup aplikasi
            }
        });
    }

    public static void main(String[] args) {
        // Menjalankan GUI di Event Dispatch Thread (Sesuai standar Swing)
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new KalkulatorSederhana().setVisible(true);
            }
        });
    }
}