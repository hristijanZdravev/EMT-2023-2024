package app.lab.Web;

import app.lab.Model.Host;
import app.lab.Model.Housing;
import app.lab.Service.HostService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/host")
@CrossOrigin(origins = "http://localhost:3000")
public class HostController {

    public final HostService hostService;

    public HostController(HostService hostService) {
        this.hostService = hostService;
    }

    @GetMapping
    public List<Host> findAll(){
        return hostService.findAll();
    }

}
