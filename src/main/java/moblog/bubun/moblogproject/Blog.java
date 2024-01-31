package moblog.bubun.moblogproject;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class Blog {

    private final BlogService blogService;
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
        model.addAttribute("year", year);
        return "add";
    }

    @PostMapping("/add")
    public String getAdd(@ModelAttribute Place place) {
        blogService.addPlace(place);
        return "redirect:/home";
    }

    @GetMapping("/explore")
    public String getExplopreBlog(@RequestParam int id, Model model) {
        var explore = blogService.getExplore(id);
        model.addAttribute("explore", explore);
        model.addAttribute("year", year);
        return "explore";
    }

}
