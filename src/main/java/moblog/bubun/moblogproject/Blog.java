package moblog.bubun.moblogproject;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class Blog {

    private final List<Places> place;
    public Blog() {
        place = new ArrayList<>();
    }

    @GetMapping({ "/home", "/" })
    public String getHome(Model model) {
        return "home";
    }

    @GetMapping("/add")
    public String getAddBlog() {
        return "add";
    }


    @GetMapping("/explore")
    public String getExplopreBlog() {
        return "explore";
    }
}
