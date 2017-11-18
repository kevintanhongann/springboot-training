package com.example.springboottrainingproject.controller;

import com.example.springboottrainingproject.domain.Journal;
import com.example.springboottrainingproject.repository.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/journal")
public class JournalController {

  @Autowired
  JournalRepository repo;

  @RequestMapping(method = RequestMethod.GET, value = "/")
  public String index(Model model) {
    model.addAttribute("entries",repo.findAll());
    return "list";
  }

  @RequestMapping(method = RequestMethod.GET, value = "/show/{id}")
  public String show(Model model, @PathVariable Long id) {
    model.addAttribute("entry", repo.findOne(id));
    return "show";
  }

  @RequestMapping(method = RequestMethod.GET, value = "/create")
  public String create(Model model) {
    model.addAttribute("entry", new Journal());
    return "create";
  }

  @RequestMapping(method = RequestMethod.GET, value = "/delete/{id}")
  public String delete(@PathVariable Long id, Model model){
    repo.delete(id);
    return "redirect:/";
  }

  @RequestMapping(value = "save", method = RequestMethod.POST)
  public String save(Journal journal){
    repo.save(journal);
    return "redirect:/";
  }
}
