/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.libreriafran.controlador;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author frans
 */
public class Escribir implements CommandFile {

    @Override
    public void execute() {
        try (FileOutputStream escritura = new FileOutputStream("biblioteca.bin"); ObjectOutputStream oos = new ObjectOutputStream(escritura)) {
            System.out.println("Escribiendo");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Escribir.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Escribir.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
