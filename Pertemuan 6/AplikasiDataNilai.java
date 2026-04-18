import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class AplikasiDataNilai extends JFrame {

    // 1. Deklarasi Komponen GUI
    private JTextField nimTF, namaTF, nil1TF, nil2TF, rataTF;
    private JButton btnCari, btnUpdate, btnHapus;
    
    // Variabel Koneksi Database
    private Connection Lconnection;
        
    public AplikasiDataNilai() {
        // Pengaturan Frame
        setTitle("Aplikasi Data Nilai - Pertemuan 6");
        setSize(400, 400);
        shttps://gemini.google.com/app/bb58b08617e4b6e7?pli=1etDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // Inisialisasi Koneksi Database
        bukaKoneksi();

        // --- Membuat Label & TextField ---
        JLabel lblNim = new JLabel("NIM");
        lblNim.setBounds(30, 30, 100, 25);
        add(lblNim);
        nimTF = new JTextField();
        nimTF.setBounds(140, 30, 200, 25);
        add(nimTF);

        JLabel lblNama = new JLabel("Nama");
        lblNama.setBounds(30, 70, 100, 25);
        add(lblNama);
        namaTF = new JTextField();
        namaTF.setBounds(140, 70, 200, 25);
        add(namaTF);

        JLabel lblNil1 = new JLabel("Nilai 1");
        lblNil1.setBounds(30, 110, 100, 25);
        add(lblNil1);
        nil1TF = new JTextField();
        nil1TF.setBounds(140, 110, 200, 25);
        add(nil1TF);

        JLabel lblNil2 = new JLabel("Nilai 2");
        lblNil2.setBounds(30, 150, 100, 25);
        add(lblNil2);
        nil2TF = new JTextField();
        nil2TF.setBounds(140, 150, 200, 25);
        add(nil2TF);

        JLabel lblRata = new JLabel("Rata-rata");
        lblRata.setBounds(30, 190, 100, 25);
        add(lblRata);
        rataTF = new JTextField();
        rataTF.setBounds(140, 190, 200, 25);
        add(rataTF);

        // --- Membuat Button ---
        btnCari = new JButton("Cari (Nama)");
        btnCari.setBounds(30, 250, 100, 30);
        add(btnCari);

        btnUpdate = new JButton("Update");
        btnUpdate.setBounds(140, 250, 90, 30);
        add(btnUpdate);

        btnHapus = new JButton("Hapus");
        btnHapus.setBounds(240, 250, 100, 30);
        add(btnHapus);

        // --- EVENT HANDLING  ---

        // A. Pencarian Data (Berdasarkan Nama)
        btnCari.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Statement st = Lconnection.createStatement();
                    // Mencari field dengan data sebagian (menggunakan LIKE)
                    ResultSet rs = st.executeQuery("SELECT * FROM datanil WHERE nama LIKE '%" + namaTF.getText() + "%'");

                    if (rs.next()) {
                        // Menampilkan data ke TextField
                        nimTF.setText(rs.getString("nim"));
                        nil1TF.setText(rs.getString("nil1"));
                        nil2TF.setText(rs.getString("nil2"));
                        rataTF.setText(rs.getString("rata"));
                    } else {
                        JOptionPane.showMessageDialog(null, "Data tidak ada/Salah", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (SQLException ex) {
                    System.out.println("Koneksi gagal: " + ex.toString());
                }
            }
        });

        // B. Update Data
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    PreparedStatement pS = Lconnection.prepareStatement("UPDATE datanil SET nama=?, nil1=?, nil2=?, rata=? WHERE nim=?");
                    pS.setString(1, namaTF.getText());
                    pS.setString(2, nil1TF.getText());
                    pS.setString(3, nil2TF.getText());
                    pS.setString(4, rataTF.getText());
                    pS.setString(5, nimTF.getText()); // nim sebagai kunci (key)

                    if (pS.executeUpdate() > 0) {
                        JOptionPane.showMessageDialog(null, "Edit sukses", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Edit gagal: " + ex.toString(), "Informasi", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        // C. Hapus Data (Delete)
        btnHapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Munculkan konfirmasi TERLEBIH DAHULU sebelum dihapus
                int x = JOptionPane.showConfirmDialog(null, "Data Yakin akan Dihapus?", "Konfirmasi Hapus Data", JOptionPane.YES_NO_OPTION);
                
                if (x == JOptionPane.YES_OPTION) {
                    try {
                        PreparedStatement pS = Lconnection.prepareStatement("DELETE FROM datanil WHERE nim=?");
                        pS.setString(1, nimTF.getText());

                        
                        if (pS.executeUpdate() > 0) {
                            JOptionPane.showMessageDialog(null, "Data Telah Dihapus", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                            kosongkanField(); // Panggil fungsi untuk mengosongkan textfield
                        } else {
                            JOptionPane.showMessageDialog(null, "Data Gagal Dihapus", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                        }
                        pS.close();
                    } catch (SQLException ex) {
                        System.out.println("Koneksi gagal: " + ex.toString());
                    }
                }
            }
        });
    }

    // --- Metode Tambahan ---

    // Metode untuk mengkoneksikan ke Database MySQL
    private void bukaKoneksi() {
        try {
            // Sesuaikan "jdbc:mysql://localhost/namadatabase", "username", "password"
            String url = "jdbc:mysql://localhost/sekolah"; 
            String user = "root";
            String pass = "";
            Lconnection = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Koneksi Database Gagal! Pastikan XAMPP/MySQL menyala.");
        }
    }

    // Metode untuk membersihkan textfield setelah dihapus
    private void kosongkanField() {
        nimTF.setText("");
        namaTF.setText("");
        nil1TF.setText("");
        nil2TF.setText("");
        rataTF.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AplikasiDataNilai().setVisible(true);
            }
        });
    }
}