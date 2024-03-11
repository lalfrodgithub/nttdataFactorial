package com.nttdatajava.factorial.Controllers;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.nttdatajava.factorial.Modelo.Numeros;
import com.nttdatajava.factorial.Services.Factorial;


@RestController
@RequestMapping("/api")
public class Factor {
    @Autowired
    Factorial factorial;

    @PostMapping( path = "/hola")
    public Map<String,?> getHola() {
        //return ResponseEntity.ok("hola");
        List list = new ArrayList<>(2);
        list.add("hola");
        list.add("como estan grupo desarrollo Nttdata!!");
         Map<String, List> map = new HashMap<String, List>(); // use new HashMap<String, Object>(); for single result
         map.put("saludo:",list);

        return map;
        }


        
    @GetMapping( path = "/factorial/{numero}")
    public ResponseEntity<?> getFactorial( @PathVariable("numero") String numero) {
    
    int resulNumero= factorial.SacaSoloNumeros(numero);
    Long calculoFactorial= factorial.factorialUsingApacheCommons(resulNumero);
    Numeros number = Numeros.builder().numeroEntero(resulNumero).calculoFactorial(calculoFactorial).build();
    
    return ResponseEntity.ok(number);
    }
     
}
