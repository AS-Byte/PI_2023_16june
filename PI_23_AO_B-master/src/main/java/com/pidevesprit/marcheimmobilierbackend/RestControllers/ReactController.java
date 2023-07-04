package com.pidevesprit.marcheimmobilierbackend.RestControllers;


import com.pidevesprit.marcheimmobilierbackend.Services.Interfaces.IReactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/reacts")
public class ReactController {
    @Autowired
    private IReactService reactRest;
    
   /* @GetMapping("/allReact")
    @ResponseBody
    public List<React> getAllReact() { 
        return reactRest.getAllReact();
    }
    @GetMapping("/react/{react_id}")
    @ResponseBody
    public React getReact(@PathVariable("react_id") Long reactId) {
        return reactRest.getReact(reactId);
    }
    @PostMapping("/addReact")
    @ResponseBody
    public React addReact(@RequestBody React rc) {
        return reactRest.addReact(rc);
    }
    
    @DeleteMapping("/deleteReact/{react_id}")
    @ResponseBody
    public void deleteAnnonce(@PathVariable("react_id") Long reactId) {
        reactRest.deleteReact(reactId);
    }

  
    @PutMapping("/updateReact")
    @ResponseBody
    public React updateReact(@RequestBody React react) {
        return reactRest.updateReact(react);
    }*/
}
