package nilaimahasiswa;

import java.util.Scanner;

public class nilaimahasiswa {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Membatasi maksimal data yang bisa dimasukkan (misal: 100 mahasiswa)
        int maksimalData = 100; 
        
        // Deklarasi Array untuk menyimpan data-data mahasiswa
        String[] nim = new String[maksimalData];
        String[] nama = new String[maksimalData];
        double[] uts = new double[maksimalData];
        double[] uas = new double[maksimalData];
        double[] rata = new double[maksimalData];
        String[] grade = new String[maksimalData];
        
        int jumlahData = 0; // Untuk menghitung berapa banyak data yang sudah diinput
        int pilihanMenu;
        
        do {
            // Menampilkan Menu Utama
            System.out.println("=== PROGRAM NILAI MAHASISWA ===");
            System.out.println("1. Input Data");
            System.out.println("2. Tampil Data");
            System.out.println("3. Keluar Program");
            System.out.print("Pilih menu (1/2/3): ");
            pilihanMenu = input.nextInt();
            input.nextLine(); // Membersihkan sisa enter / newline
            
            System.out.println();
            
            if (pilihanMenu == 1) {
                // --- PROSES INPUT DATA ---
                System.out.print("Berapa banyak data mahasiswa yang ingin diinput? ");
                int n = input.nextInt();
                input.nextLine();
                
                for (int i = 0; i < n; i++) {
                    System.out.println("--- Masukkan Data ke-" + (jumlahData + 1) + " ---");
                    
                    System.out.print("NIM       : ");
                    nim[jumlahData] = input.nextLine();
                    
                    System.out.print("Nama      : ");
                    nama[jumlahData] = input.nextLine();
                    
                    System.out.print("Nilai UTS : ");
                    uts[jumlahData] = input.nextDouble();
                    
                    System.out.print("Nilai UAS : ");
                    uas[jumlahData] = input.nextDouble();
                    input.nextLine(); 
                    
                    // Proses hitung nilai rata-rata dan Grade (mengikuti contoh di modul)
                    rata[jumlahData] = (uts[jumlahData] + uas[jumlahData]) / 2;
                    
                    if (rata[jumlahData] < 50) {
                        grade[jumlahData] = "E";
                    } else if (rata[jumlahData] < 60) {
                        grade[jumlahData] = "D";
                    } else if (rata[jumlahData] < 70) {
                        grade[jumlahData] = "C";
                    } else if (rata[jumlahData] < 80) {
                        grade[jumlahData] = "B";
                    } else {
                        grade[jumlahData] = "A";
                    }
                    
                    jumlahData++; // Menambah jumlah data yang tersimpan
                    System.out.println();
                }
                System.out.println("Data berhasil disimpan!\n");
                
            } else if (pilihanMenu == 2) {
                // --- PROSES TAMPIL DATA ---
                if (jumlahData == 0) {
                    System.out.println("Belum ada data yang diinputkan!\n");
                } else {
                    System.out.println("==========================================================================");
                    System.out.println("NIM\t\tNama\t\tUTS\tUAS\tN.Rata\tGrade");
                    System.out.println("==========================================================================");
                    
                    // Looping untuk menampilkan semua isi array
                    for (int i = 0; i < jumlahData; i++) {
                        System.out.println(nim[i] + "\t" + nama[i] + "\t\t" + uts[i] + "\t" + uas[i] + "\t" + rata[i] + "\t" + grade[i]);
                    }
                    System.out.println("==========================================================================\n");
                }
                
            } else if (pilihanMenu == 3) {
                // --- KELUAR PROGRAM ---
                System.out.println("Terima kasih telah menggunakan program ini.");
                
            } else {
                System.out.println("Pilihan tidak valid! Silakan pilih 1, 2, atau 3.\n");
            }
            
        } while (pilihanMenu != 3); // Program akan terus mengulang selama belum memilih angka 3
        
        input.close();
    }
}