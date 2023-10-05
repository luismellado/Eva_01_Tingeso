package tingeso.proyecto1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tingeso.proyecto1.entities.EstudianteEntity;
import tingeso.proyecto1.services.EstudianteService;

import java.util.ArrayList;

@Controller
@RequestMapping
public class EstudianteController {

    @Autowired
    EstudianteService estudianteService;
    //Recordar que esto es solo momentaneo y se deben adaptar las fucionalidades de acuerdo al proyecto
    @GetMapping("/listar")
    public String listar(Model model){
        ArrayList<EstudianteEntity>estudiantes=estudianteService.obtenerEstudiantes();
        model.addAttribute("estudiantes",estudiantes);
        return "index";
    }
}
