package app.lab.Web;

import app.lab.Model.DTO.HousingDTO;
import app.lab.Model.Enum.HousingCategory;
import app.lab.Model.Housing;
import app.lab.Service.HousingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/housing")
@CrossOrigin(origins = "http://localhost:3000")
public class HousingController {
private final HousingService housingService;

    public HousingController(HousingService housingService) {
        this.housingService = housingService;
    }

    @GetMapping
    public List<Housing> findAll(){
        return housingService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Housing> findById(@PathVariable Long id) {
        return this.housingService.findById(id)
                .map(manufacturer -> ResponseEntity.ok().body(manufacturer))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<Housing> addHousing(@RequestBody HousingDTO housingDTO) {
        return this.housingService.create(housingDTO)
                .map(housing -> ResponseEntity.ok().body(housing))
                .orElseGet(() -> ResponseEntity.badRequest().build());

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable Long id) {
        return housingService.delete(id)
                .map(accommodation -> ResponseEntity.ok().body(accommodation))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PutMapping("/edit/{id}")
    public ResponseEntity<Housing> save(@PathVariable Long id, @RequestBody HousingDTO housingDTO) {
        return this.housingService.edit(id, housingDTO)
                .map(housing -> ResponseEntity.ok().body(housing))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }
    @PutMapping("/bookmark/{id}")
    public ResponseEntity<Housing> bookmark(@PathVariable Long id) {
        return this.housingService.bookmark(id)
                .map(housing -> ResponseEntity.ok().body(housing))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping("/rent/{id}")
    public ResponseEntity<Housing> rent(@PathVariable Long id) {
        return this.housingService.rent(id)
                .map(housing -> ResponseEntity.ok().body(housing))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @GetMapping("/categories")
    public List<HousingCategory> findAllCategories() {return List.of(HousingCategory.values());}

}
