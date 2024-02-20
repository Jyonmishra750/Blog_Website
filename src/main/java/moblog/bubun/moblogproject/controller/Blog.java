package moblog.bubun.moblogproject.controller;

import java.time.Year;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import moblog.bubun.moblogproject.model.Places;
import moblog.bubun.moblogproject.service.BlogService;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Blog {

    private final BlogService blogService;
    
    public Blog(@Qualifier("blogServiceClientImpl") BlogService blogService) {
        this.blogService = blogService;
    }

    Year year = Year.now();
    
    @GetMapping({ "/home", "/" })
    public String getHome(Model model) {
        var blogs = blogService.getBlogs();
        model.addAttribute("blogPlace", blogs);
        model.addAttribute("year", year);
        return "home";
    }

    @GetMapping("/add")
    public String getAddBlog(Model model) {
        Places place = new Places();
        model.addAttribute("blog", place);
        model.addAttribute("year", year);
        return "add";
    }

    @PostMapping("/addblog")
    public String getAdd(@ModelAttribute Places place) {
        if (place.getId()==0) {
            blogService.addBlog(place);
        }
        else{
            blogService.updateBlog(place);
        }
        return "redirect:/home";
    }

    @GetMapping("/update")
    public String getUpdateBlog(@RequestParam int id, Model model) {
        var update = blogService.updateBlogPage(id);
        model.addAttribute("blog", update);
        model.addAttribute("year", year);
        return "add";
    }

    @GetMapping("/explore")
    public String getExplopreBlog(@RequestParam int id, Model model) {
        var explore = blogService.getExplore(id);
        model.addAttribute("explore", explore);
        model.addAttribute("year", year);
        return "explore";
    }

    @GetMapping("/delete")
	public String getDeleteBlog(@RequestParam int id) {
		blogService.deleteBlog(id);
		return "redirect:/home";
	}

}
