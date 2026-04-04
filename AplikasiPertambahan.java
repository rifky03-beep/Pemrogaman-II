import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AplikasiPertambahan extends JFrame {
    
    // Deklarasi komponen GUI
    private JTextField tfAngkaPertama, tfAngkaKedua, tfHasil;
    private JButton btnTambah, btnHapus, btnExit;

    public AplikasiPertambahan() {
        // 1. Pengaturan dasar Frame
        setTitle("Rifky irvianto-221011450522");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Menempatkan window di tengah layar

        // Panel utama dengan margin
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // 2. Panel untuk Input (JLabel dan JTextField)
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 2, 10, 15)); // 3 baris, 2 kolom, dengan jarak

        // Baris 1
        inputPanel.add(new JLabel("Angka Pertama"));
        tfAngkaPertama = new JTextField();
        inputPanel.add(tfAngkaPertama);

        // Baris 2
        inputPanel.add(new JLabel("Angka Kedua"));
        tfAngkaKedua = new JTextField();
        inputPanel.add(tfAngkaKedua);

        // Baris 3
        inputPanel.add(new JLabel("Hasil"));
        tfHasil = new JTextField();
        tfHasil.setEditable(false); // Kotak hasil dibuat agar tidak bisa diketik manual
        inputPanel.add(tfHasil);

        // 3. Panel untuk Tombol (JButton)
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 0));

        btnTambah = new JButton("Tambah");
        btnHapus = new JButton("Hapus");
        btnExit = new JButton("Exit");

        buttonPanel.add(btnTambah);
        buttonPanel.add(btnHapus);
        buttonPanel.add(btnExit);

        // Memasukkan panel input dan tombol ke panel utama
        mainPanel.add(inputPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Memasukkan panel utama ke dalam Frame
        add(mainPanel);

        // 4. Menambahkan Aksi (Event Listener) pada Tombol
        
        // Aksi Tombol Tambah
        btnTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double angka1 = Double.parseDouble(tfAngkaPertama.getText());
                    double angka2 = Double.parseDouble(tfAngkaKedua.getText());
                    double hasil = angka1 + angka2;
                    tfHasil.setText(String.valueOf(hasil));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Harap masukkan angka yang valid!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Aksi Tombol Hapus
        btnHapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfAngkaPertama.setText("");
                tfAngkaKedua.setText("");
                tfHasil.setText("");
                tfAngkaPertama.requestFocus(); // Mengembalikan kursor ke kotak pertama
            }
        });

        // Aksi Tombol Exit
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Menutup aplikasi
            }
        });
    }

    public static void main(String[] args) {
        // Menjalankan aplikasi GUI
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AplikasiPertambahan().setVisible(true);
            }
        });
    }
}