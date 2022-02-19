package com.codeblog.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codeblog.model.BlogModel;
import com.codeblog.repository.BlogRepository;

@Controller
public class BlogController {

	@Autowired
	BlogRepository blogRepository;
	
	public List<BlogModel> findAll() {
		return blogRepository.findAll();

	}

	public BlogModel findById(long id) {
		return blogRepository.findById(id).get();

	}

	public BlogModel save(BlogModel blogModel) {
		return blogRepository.save(blogModel);
	}


	@RequestMapping(value = "/posts", method = RequestMethod.GET)
	public ModelAndView getBlogModel() {
		ModelAndView mv = new ModelAndView("posts");
		List<BlogModel> blogModel = findAll();
		mv.addObject("posts", blogModel);
		return mv;

	}

	@RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
	public ModelAndView getBlogModelDetails(@PathVariable("id") long id) {
		ModelAndView mv = new ModelAndView("PostDetails");
		BlogModel blogModel = findById(id);
		mv.addObject("posts", blogModel);
		return mv;

	}

	@RequestMapping(value = "/newpost", method = RequestMethod.GET)
	public String getBlogModelForm() {
		return "postForm";
	}

	@RequestMapping(value = "/newpost", method = RequestMethod.POST)
	public String saveBlogModel(@Valid BlogModel blogModel, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique se os campos obrigatórios foram preenchidos!");
			return "redirect:/newpost";
		}
		blogModel.setData(LocalDate.now());
		blogRepository.save(blogModel);
		return "redirect:/posts";
	}
}
