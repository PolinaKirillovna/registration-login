package controllers;

import entitities.Cat;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import services.CatService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CatController {

    private final CatService catService;
    @GetMapping("/cats")
    @ApiOperation(value = "Get Cats", notes = "Cats")
    public List<Cat> getCats() {
        return catService.findAll();
    }

    @ApiOperation(value = "Update cat", notes = "cat")
    @PutMapping("/cat/{id}")
    public Cat updateCat (@PathVariable Long id, @RequestBody Cat cat) {
        catService.updateCat(id, cat);
        return cat;
    }

    @ApiOperation(value = "Save Cats", notes = "cat")
    @PostMapping("/cat")
    public Cat createCat(@RequestBody Cat cat) {
        catService.saveCat(cat);
        return cat;
    }

    @ApiOperation(value = "Delete Cats", notes = "cat")
    @DeleteMapping("/cats/{id}")
    @ResponseStatus(HttpStatus.FOUND) // 302 redirect
    public String deleteCat(@PathVariable Long id) {
        catService.deleteById(id);
        return "redirect:/cats";
    }

    @GetMapping("")
    @PreAuthorize("@securityService.hasAccessToCat(#username, #id)")
    public List<Cat> getAllCats(@RequestParam String username, @RequestParam int id) {
        return catService.findAll();
    }
}