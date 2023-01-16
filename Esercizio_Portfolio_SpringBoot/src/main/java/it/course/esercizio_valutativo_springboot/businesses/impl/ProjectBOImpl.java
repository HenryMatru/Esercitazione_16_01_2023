package it.course.esercizio_valutativo_springboot.businesses.impl;

import it.course.esercizio_valutativo_springboot.businesses.interfaces.ProjectBO;
import it.course.esercizio_valutativo_springboot.models.Project;
import it.course.esercizio_valutativo_springboot.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectBOImpl implements ProjectBO {

    @Autowired
    ProjectRepository projectRepository;

    @Override
    public List<Project> getProjects() {
        return this.projectRepository.findAll();
    }

}
