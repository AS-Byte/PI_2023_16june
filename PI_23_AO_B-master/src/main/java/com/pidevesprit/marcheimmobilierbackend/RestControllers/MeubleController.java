package com.pidevesprit.marcheimmobilierbackend.RestControllers;

import com.pidevesprit.marcheimmobilierbackend.Services.Interfaces.IMeubleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class MeubleController {


    @Autowired
    private IMeubleService meubleService;

   /* @PostMapping("addMeuble")
    Meuble addMeuble(@RequestBody Meuble meuble){

        return meubleService.addMeuble(meuble);
    }

    @PutMapping("updateMeuble")
    Meuble updateMeuble(@RequestBody Meuble meuble){

        return meubleService.updateMeuble(meuble);
    }

    @DeleteMapping("deleteMeuble")
    void  deleteMeuble(@RequestBody Meuble meuble) {
        meubleService.deleteMeuble(meuble);
    }

    @DeleteMapping("deleteMeubleById")
    void deleteMeubleByid(@RequestParam Long id){
        meubleService.deleteMeubleByid(id);
    }

    @GetMapping("findAllMeubles")
    List<Meuble> findAllMeubles(){
        return meubleService.findAllMeubles();
    }

    @GetMapping("findMeubleBId")
    Meuble findMeubleBId(@RequestParam Long id){
        return meubleService.findMeubleById(id);

    }*/
}
