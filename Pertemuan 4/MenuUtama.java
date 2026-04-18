import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuUtama extends JFrame {
    
    // Deklarasi JDesktopPane sebagai wadah form anak
    private JDesktopPane desktopPane;

    public MenuUtama() {
        // Pengaturan JFrame Utama (Parent Form)
        setTitle("Aplikasi Utama (MDI) - Pertemuan 4");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Tampil di tengah layar

        // Mengatur desktop pane sebagai background aplikasi
        desktopPane = new JDesktopPane();
        setContentPane(desktopPane);

        // --- Membuat Menu Bar ---
        JMenuBar menuBar = new JMenuBar();
        JMenu menuFile = new JMenu("File");
        
        JMenuItem itemBukaForm = new JMenuItem("Buka Form Data");
        JMenuItem itemLogout = new JMenuItem("Logout");

        // Menambahkan item ke dalam menu
        menuFile.add(itemBukaForm);
        menuFile.addSeparator(); // Garis pemisah menu
        menuFile.add(itemLogout);
        
        menuBar.add(menuFile);
        setJMenuBar(menuBar);

        // --- Event Handling untuk Menu "Buka Form Data" ---
        itemBukaForm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Memanggil classTujuan (FormDataMahasiswa) sesuai instruksi slide
                FormDataMahasiswa formTujuan = new FormDataMahasiswa();
                
                // Masukkan form internal ke dalam desktop pane
                desktopPane.add(formTujuan);
                
                // Tampilkan form internal
                formTujuan.setVisible(true);
            }
        });

        // --- Event Handling untuk Menu "Logout" ---
        itemLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Menutup seluruh aplikasi
            }
        });
    }

    // Titik utama berjalannya program
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MenuUtama().setVisible(true);
            }
        });
    }
}