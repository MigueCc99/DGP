package com.dgp.appvale;

public class Simbolo {
   private TipoSimbolo tipo;
   private String direccion_foto;

   Simbolo(TipoSimbolo tipo, String direccion_foto){
       this.direccion_foto = direccion_foto;
       this.tipo = tipo;
   }

   public String getDireccion_foto(){
       return this.direccion_foto;
   }

   public TipoSimbolo getTipo(){
       return this.tipo;
   }

   public boolean equals(Simbolo otro){ return (this.tipo.equals( otro.getTipo() )); }

}