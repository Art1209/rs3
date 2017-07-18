package rs3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import rs3.persistence.entity.Department;
import rs3.persistence.service.interf.DepartmentService;
import rs3.tools.EntityUtils;
import rs3.tools.interf.DbInitializr;
import rs3.tools.interf.DepartmentsDataProvider;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/preapi")
public class MainController {

    @Autowired
    DepartmentService depService;

    @Autowired
    DbInitializr dbInit;

    @Autowired
    DepartmentsDataProvider dataProvider;


    @RequestMapping({"/", "/home"})
    public String showHomePage(Model model){
        if (depService.getAll().size()==0){
            dbInit.initialize(dataProvider.returnData());
        }
        List<Department> depsAll= depService.getAll();
        model.addAttribute("department1", EntityUtils.departmentToString(depsAll.get(0)));
        model.addAttribute("department2", EntityUtils.departmentToString(depsAll.get(1)));
        return "index";
    }
}
