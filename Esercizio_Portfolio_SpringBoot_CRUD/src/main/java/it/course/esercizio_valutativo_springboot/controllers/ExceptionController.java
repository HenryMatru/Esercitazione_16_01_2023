package it.course.esercizio_valutativo_springboot.controllers;

import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(Exception.class)
    public ModelAndView exception(Exception e) {
        ModelAndView modelAndView = new ModelAndView("/jsp/error.jsp");
        modelAndView.addObject("NameError", e.getClass().getSimpleName());
        modelAndView.addObject("MessageError", e.getMessage());
        return modelAndView;
    }

    @ExceptionHandler(DataAccessException.class)
    public ModelAndView exception(DataAccessException e) {
        ModelAndView modelAndView = new ModelAndView("/jsp/error.jsp");
        modelAndView.addObject("NameError", e.getClass().getSimpleName());
        modelAndView.addObject("MessageError", e.getMessage());
        return modelAndView;
    }

}
