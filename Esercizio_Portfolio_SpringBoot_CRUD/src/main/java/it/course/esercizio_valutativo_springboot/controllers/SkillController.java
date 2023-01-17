package it.course.esercizio_valutativo_springboot.controllers;

import it.course.esercizio_valutativo_springboot.businesses.interfaces.CategoryBO;
import it.course.esercizio_valutativo_springboot.businesses.interfaces.SkillBO;
import it.course.esercizio_valutativo_springboot.models.Category;
import it.course.esercizio_valutativo_springboot.models.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SkillController {

    @Autowired
    SkillBO skillBO;

    @Autowired
    CategoryBO categoryBO;

    @GetMapping(path = {"/skills"})
    public ModelAndView skills() {
        return new ModelAndView("/jsp/skills.jsp", "ListSkills", this.skillBO.getSkills());
    }

    @GetMapping(path = {"/createSkill"})
    public ModelAndView createSkill() {
        return new ModelAndView("/jsp/createSkill.jsp", "ListCategories", this.categoryBO.getCategories());
    }

    @PostMapping(path = {"/createSkill"})
    public ModelAndView createSkill(@RequestParam("nameSkill") String nameSkill,
                                    @RequestParam("descriptionSkill") String descriptionSkill,
                                    @RequestParam("categorySkill") long categorySkill) {
        Skill skill = new Skill();
        skill.setName(nameSkill);
        skill.setDescription(descriptionSkill);
        Category category = categoryBO.getCategory(categorySkill);
        skill.setCategory(category);
        this.skillBO.insertSkill(skill);
        return new ModelAndView("/jsp/skills.jsp", "operation", "The new skill has been inserted");
    }

    @GetMapping(path = {"/updateSkill"})
    public ModelAndView updateSkill() {
        return new ModelAndView("/jsp/updateSkill.jsp", "ListCategories", this.categoryBO.getCategories());
    }

    @PostMapping(path = {"/updateSkill"})
    public ModelAndView updateSkill(@RequestParam("id") long id,
                                    @RequestParam("nameSkill") String nameSkill,
                                    @RequestParam("descriptionSkill") String descriptionSkill,
                                    @RequestParam("categorySkill") long categorySkill) {
        Skill skill = this.skillBO.getSkill(id);
        skill.setName(nameSkill);
        skill.setDescription(descriptionSkill);
        Category category = categoryBO.getCategory(categorySkill);
        skill.setCategory(category);
        this.skillBO.updateSkill(id, skill);
        return new ModelAndView("/jsp/skills.jsp", "operation", "The new skill has been inserted");
    }

    @GetMapping(path = {"/deleteSkill"})
    public ModelAndView deleteSkill(@RequestParam long id) {
        return new ModelAndView("/jsp/deleteProject.jsp", "category", this.skillBO.getSkill(id));
    }

    @PostMapping(path = {"/deleteSkill"})
    public ModelAndView deleteSkill(@RequestParam long id,
                                    @RequestParam("nameSkill") String nameSkill,
                                    @RequestParam("descriptionSkill") String descriptionSkill,
                                    @RequestParam("categorySkill") long categorySkill) {
        Skill skill = this.skillBO.getSkill(id);
        this.skillBO.deleteSkill(skill.getId());
        ModelAndView modelAndView = new ModelAndView("/jsp/skills.jsp", "operation", "Elimination of:\n");
        modelAndView.addObject("nameSkill", nameSkill);
        modelAndView.addObject("descriptionSkill", descriptionSkill);
        modelAndView.addObject("categorySkill", categorySkill);
        return modelAndView;
    }

}
