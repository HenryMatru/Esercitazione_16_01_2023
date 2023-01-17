package it.course.esercizio_valutativo_springboot.controllers;

import it.course.esercizio_valutativo_springboot.businesses.interfaces.ProjectBO;
import it.course.esercizio_valutativo_springboot.models.Category;
import it.course.esercizio_valutativo_springboot.models.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProjectController {

    @Autowired
    ProjectBO projectBO;

    @GetMapping(path = {"/projects"})
    public ModelAndView projects() {
        return new ModelAndView("/jsp/projects.jsp", "ListProjects", this.projectBO.getProjects());
    }

    @GetMapping(path = {"/createProject"})
    public ModelAndView createProject() {
        return new ModelAndView("/jsp/createProject.jsp");
    }

    @PostMapping(path = {"/createProject"})
    public ModelAndView createProject(@RequestParam("nameProject") String nameProject,
                                      @RequestParam("descriptionProject") String descriptionProject,
                                      @RequestParam("linkProject") String linkProject) {
        Project project = new Project();
        project.setName(nameProject);
        project.setDescription(descriptionProject);
        project.setLink(linkProject);
        this.projectBO.insertProject(project);
        return new ModelAndView("/jsp/projects.jsp", "operation", "The new project has been inserted");
    }

    @GetMapping(path = {"/updateProject"})
    public ModelAndView updateProject(@RequestParam("id") long id) {
        return new ModelAndView("/jsp/updateProject.jsp", "project", this.projectBO.getProject(id));
    }

    @PostMapping(path = {"/updateProject"})
    public ModelAndView updateProject(@RequestParam("id") long id,
                                      @RequestParam("nameProject") String nameProject,
                                      @RequestParam("descriptionProject") String descriptionProject,
                                      @RequestParam("linkProject") String linkProject) {
        Project project = this.projectBO.getProject(id);
        project.setName(nameProject);
        project.setDescription(descriptionProject);
        project.setLink(linkProject);
        this.projectBO.updateProject(id, project);
        return new ModelAndView("/jsp/projects.jsp", "operation", "The project has been updated");
    }

    @GetMapping(path = {"/deleteProject"})
    public ModelAndView deleteProject(@RequestParam long id) {
        return new ModelAndView("/jsp/deleteProject.jsp", "category", this.projectBO.getProject(id));
    }

    @PostMapping(path = {"/deleteProject"})
    public ModelAndView deleteProject(@RequestParam long id,
                                      @RequestParam("nameProject") String nameProject,
                                      @RequestParam("descriptionProject") String descriptionProject,
                                      @RequestParam("linkProject") String linkProject) {
        Project project = this.projectBO.getProject(id);
        this.projectBO.deleteProject(project.getId());
        ModelAndView modelAndView = new ModelAndView("/jsp/projects.jsp", "operation", "Elimination of:\n");
        modelAndView.addObject("nameProject", nameProject);
        modelAndView.addObject("descriptionProject", descriptionProject);
        modelAndView.addObject("linkProject", linkProject);
        return modelAndView;
    }

}
