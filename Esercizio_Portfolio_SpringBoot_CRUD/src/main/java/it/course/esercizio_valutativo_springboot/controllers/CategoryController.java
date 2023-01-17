package it.course.esercizio_valutativo_springboot.controllers;

import it.course.esercizio_valutativo_springboot.businesses.interfaces.CategoryBO;
import it.course.esercizio_valutativo_springboot.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CategoryController {

    @Autowired
    CategoryBO categoryBO;

    @GetMapping(path = {"/categories"})
    public ModelAndView categories() {
        return new ModelAndView("/jsp/categories.jsp", "ListCategories", this.categoryBO.getCategories());
    }

    @GetMapping(path = {"/createCategory"})
    public ModelAndView createCategory() {
        return new ModelAndView("/jsp/createCategory.jsp");
    }

    @PostMapping(path = {"/createCategory"})
    public ModelAndView createCategory(@RequestParam("nameCategory") String nameCategory) {
        Category category = new Category();
        category.setName(nameCategory);
        this.categoryBO.insertCategory(category);
        return new ModelAndView("/jsp/skills.jsp", "operation", "The new category has been inserted");
    }

    @GetMapping(path = {"/updateCategory"})
    public ModelAndView updateCategory(@RequestParam long id) {
        return new ModelAndView("/jsp/updateCategory.jsp", "category", this.categoryBO.getCategory(id));
    }

    @PostMapping(path = {"/updateCategory"})
    public ModelAndView updateCategory(@RequestParam long id, @RequestParam("nameCategory") String nameCategory) {
        Category category = this.categoryBO.getCategory(id);
        category.setName(nameCategory);
        this.categoryBO.updateCategory(category.getId(), category);
        ModelAndView modelAndView = new ModelAndView("/jsp/categories.jsp", "operation", "The object has been updated:\n");
        return modelAndView;
    }

    @GetMapping(path = {"/deleteCategory"})
    public ModelAndView deleteCategory(@RequestParam long id) {
        return new ModelAndView("/jsp/deleteCategory.jsp", "category", this.categoryBO.getCategory(id));
    }

    @PostMapping(path = {"/deleteCategory"})
    public ModelAndView deleteCategory(@RequestParam long id, @RequestParam("nameCategory") String nameCategory) {
        Category category = this.categoryBO.getCategory(id);
        this.categoryBO.deleteCategory(category.getId());
        ModelAndView modelAndView = new ModelAndView("/jsp/categories.jsp", "operation", "Elimination of:\n");
        modelAndView.addObject("nameCategory", nameCategory);
        return modelAndView;
    }

}
