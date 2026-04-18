import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormDataMahasiswa extends JInternalFrame {
    
    private JTextField nimTxt, namaTxt, nilTxt;
    private JButton btnTambah;
    private JTable tabel;
    private DefaultTableModel mod;

    public FormDataMahasiswa() {
        // Pengaturan JInternalFrame (Child Form)
        setTitle("Form Data Mahasiswa");
        setSize(400, 300);
        setLayout(null);
        setClosable(true); // Agar frame internal ini ada tombol "X" untuk menutupnya
        setMaximizable(true);
        setIconifiable(true);

        // --- Komponen Input ---
        JLabel lblNim = new JLabel("N I M");
        lblNim.setBounds(20, 20, 120, 25);
        add(lblNim);
        
        nimTxt = new JTextField();
        nimTxt.setBounds(140, 20, 140, 25);
        add(nimTxt);

        JLabel lblNama = new JLabel("Nama Mahasiswa");
        lblNama.setBounds(20, 50, 120, 25);
        add(lblNama);
        
        namaTxt = new JTextField();
        namaTxt.setBounds(140, 50, 140, 25);
        add(namaTxt);

        JLabel lblNilai = new JLabel("Nilai");
        lblNilai.setBounds(20, 80, 120, 25);
        add(lblNilai);
        
        nilTxt = new JTextField();
        nilTxt.setBounds(140, 80, 140, 25);
        add(nilTxt);

        btnTambah = new JButton("TABEL");
        btnTambah.setBounds(290, 20, 80, 25);
        add(btnTambah);

        // --- Pengaturan JTable via Kode (Cara 2 di slide) ---
        mod = new DefaultTableModel();
        mod.addColumn("N I M");
        mod.addColumn("Nama Mahasiswa");
        mod.addColumn("Nilai");

        tabel = new JTable(mod);
        JScrollPane scrollPane = new JScrollPane(tabel);
        scrollPane.setBounds(20, 120, 350, 120);
        add(scrollPane);

        // --- Event Handling untuk Tombol TABEL ---
        btnTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Sintaks persis seperti di slide presentasi:
                // Menyimpan inputan textfield ke dalam array Object
                Object data[] = {nimTxt.getText(), namaTxt.getText(), nilTxt.getText()};
                
                // Menambahkan data array tersebut menjadi baris baru di tabel
                mod.addRow(data);

                // Mengosongkan isian form setelah data masuk
                nimTxt.setText("");
                namaTxt.setText("");
                nilTxt.setText("");
                nimTxt.requestFocus(); // Kembalikan kursor ke kolom NIM
            }
        });
    }
}