package com.nttdatajava.factorial.Services;

import org.apache.commons.math3.util.CombinatoricsUtils;
import java.util.regex.*;
import org.springframework.stereotype.Service;

@Service
public class Factorial {
   
    public long factorialUsingApacheCommons(int n) {
    return CombinatoricsUtils.factorial(n);
}

public int SacaSoloNumeros (String numero){
     
    String entrada = numero; 
    String salida="";

     Pattern limpiar = Pattern
             .compile("([-0-9])");
     Matcher buscar = limpiar.matcher(entrada);
     while (buscar.find()) salida=salida+buscar.group(1);
  
     return salida.length()>0?Integer.parseInt(salida):0;

}

}
