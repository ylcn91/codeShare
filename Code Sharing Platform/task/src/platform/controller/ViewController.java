package platform.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import platform.service.CodeService;

@Controller
@RequestMapping(path = "/code")
public class ViewController {
    private CodeService storage;
    public ViewController(CodeService storage) {
        this.storage = storage;
    }

    @GetMapping(path = "/{id}")
    public String getCodeById(Model model, @PathVariable("id") String id) {
        model.addAttribute("singleCode", storage.findByUUID(id));
        return "singleCode";
    }

    @GetMapping(path = "/latest")
    public String getLatestCodes(Model model) {
        model.addAttribute("latestCodes", storage.getLastTen());
        return "latestCodes";
    }

    @GetMapping(path = "/new", produces = MediaType.TEXT_HTML_VALUE)
    public String newCode() {
        return "newCode";
    }
}
