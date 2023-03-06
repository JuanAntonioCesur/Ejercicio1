/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Alumno implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    
    private String nombre;
    
    private String telefono;
    
    private String email;
    
    private double ad;
    
    private double di;
    
    public Alumno() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public Double getAd() {
        return ad;
    }

    public void setAd(Double ad) {
        this.ad = ad;
    }
    
    public Double getDi() {
        return di;
    }

    public void setDi(Double di) {
        this.di = di;
    }
    
    

    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", nombre=" + nombre + ", telefono=" + telefono + ", email=" + email +", AD=" + ad +", DI=" + di +'}';
    }
    
    public String toNombreNotas(){
        return "Alumno: "+nombre+"; Nota AD= "+ad+", Nota DI= "+di;
    }
    
}
