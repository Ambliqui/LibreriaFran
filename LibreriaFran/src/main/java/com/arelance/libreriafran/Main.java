/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.libreriafran;

import com.arelance.libreriafran.modelo.Credenciales;
import com.arelance.libreriafran.modelo.DatosPersonales;
import com.arelance.libreriafran.modelo.Usuario;
import com.arelance.libreriafran.controlador.Leer;
import com.arelance.libreriafran.controlador.Escribir;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author frans
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {

        List<Usuario> usuarios = new ArrayList<>();
        Usuario user1 = new Usuario(new Credenciales("frasko", "1234"), new DatosPersonales("Fran", "Saavedra"));

        usuarios.add(user1);

        FileOutputStream lectura = new FileOutputStream("biblioteca.tmp");
        ObjectOutputStream oos = new ObjectOutputStream(lectura);

        FileInputStream escritura = new FileInputStream("biblioteca.tmp");
        ObjectInputStream ois = new ObjectInputStream(escritura);

        oos.writeObject(new Usuario(new Credenciales("ee","ee"),new DatosPersonales("ff","ff")));
        Usuario users = (Usuario) ois.readObject();
        oos.close();
        ois.close();

        usuarios.forEach(u -> System.out.println(u.getDatosPersonales()));
        System.out.println(users);
    }
}
