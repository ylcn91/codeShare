package platform.controller;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import platform.model.Code;
import platform.service.CodeService;


import java.util.List;

@RestController
@RequestMapping(path = "/api/code", produces = MediaType.APPLICATION_JSON_VALUE)
public class ApiController {

    private final CodeService storage;
    public ApiController(CodeService storage) {
        this.storage = storage;
    }

    @GetMapping("/{id}")
    public Code get(@PathVariable("id") String id) {
        return storage.findByUUID(id);
    }

    @GetMapping(value = "/latest")
    public List<Code> latest() {
        return storage.getLastTen();
    }

    @PostMapping(path = "/new", produces = MediaType.APPLICATION_JSON_VALUE)
    public String setApiCode(@RequestBody Code newCode) {
        Code toWrite = new Code(newCode.getCode(), newCode.getTime(), newCode.getViews());
        String uuid = storage.addCode(toWrite);
        System.out.println(uuid);
        return "{ \"id\" : \"" + uuid + "\" }";
    }
}