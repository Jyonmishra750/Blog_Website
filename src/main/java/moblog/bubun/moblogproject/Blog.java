package moblog.bubun.moblogproject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class Blog {
    @GetMapping({ "/home", "/" })
    public String getHome(Model model) {
        return "home";
    }

    @GetMapping("/add")
    public String getAddBlog() {
        return "add";
    }

    @GetMapping("explore")
    public String getExplopreBlog() {
        return "explore";
    }
}
