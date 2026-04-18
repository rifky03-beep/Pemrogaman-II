// package latconsole;

import java.util.Scanner;

/**
 * @author Hendri Ardiansyah
 */
public class NilaiMhs {
    public static void main(String[] args) {
        // Membuat object Scanner untuk membaca input dari keyboard
        Scanner input = new Scanner(System.in);
        
        // Deklarasi variabel
        String nim, nama, grade;
        double uts, uas, rata;
        
        // --- Proses Input ---
        System.out.println("Data: ");
        System.out.print("nim: "); 
        nim = input.next();
        
        System.out.print("nama: "); 
        nama = input.next();
        
        System.out.print("nilai UTS: "); 
        uts = input.nextDouble();
        
        System.out.print("nilai UAS: "); 
        uas = input.nextDouble();
        
        // --- Proses Perhitungan ---
        // Menghitung rata-rata
        rata = (uts + uas) / 2;
        
        // Menentukan Grade menggunakan percabangan if-else
        if (rata < 50) {
            grade = "E";
        } else if (rata < 60) {
            grade = "D";
        } else if (rata < 70) {
            grade = "C";
        } else if (rata < 80) {
            grade = "B";
        } else {
            grade = "A";
        }
        
        // --- Proses Output ---
        // Menampilkan hasil dalam bentuk tabel sederhana
        System.out.println("=================================================");
        System.out.println("Nim\tNama\tUTS\tUAS\tRata2\tGrade");
        System.out.println("=================================================");
        System.out.println(nim + "\t" + nama + "\t" + uts + "\t" + uas + "\t" + rata + "\t" + grade);
    }
}