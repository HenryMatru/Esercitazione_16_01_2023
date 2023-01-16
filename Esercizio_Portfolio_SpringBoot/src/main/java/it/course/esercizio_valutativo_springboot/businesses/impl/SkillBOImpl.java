package it.course.esercizio_valutativo_springboot.businesses.impl;

import it.course.esercizio_valutativo_springboot.businesses.interfaces.SkillBO;
import it.course.esercizio_valutativo_springboot.models.Skill;
import it.course.esercizio_valutativo_springboot.repositories.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillBOImpl implements SkillBO {

    @Autowired
    SkillRepository skillRepository;

    @Override
    public List<Skill> getSkills() {
        return this.skillRepository.findAll();
    }

}
