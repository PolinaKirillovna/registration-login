package controllers;

import entitities.Flea;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import services.FleaService;

import java.util.List;
@RestController
@RequiredArgsConstructor
public class FleaController {

    private final FleaService fleaService;

    @GetMapping("/fleas")
    @ApiOperation(value = "Get Fleas", notes = "Returns a list of all fleas")
    public List<Flea> getFleas() {
        return fleaService.findAll();
    }

    @ApiOperation(value = "Update flea", notes = "Updates an existing flea")
    @PutMapping("/fleas/{id}")
    public Flea updateFlea (@PathVariable Long id, @RequestBody Flea flea) {
        fleaService.updateFlea(id, flea);
        return flea;
    }


    @ApiOperation(value = "Save Flea", notes = "Creates a new flea")
    @PostMapping("/fleas")
    public Flea createFlea(@RequestBody Flea flea) {
        fleaService.saveFlea(flea);
        return flea;
    }


    @ApiOperation(value = "Delete Flea", notes = "Deletes a flea by ID")
    @DeleteMapping("/fleas/{id}")
    @ResponseStatus(HttpStatus.FOUND) // 302 redirect
    public String deleteFlea(@PathVariable Long id) {
        fleaService.deleteById(id);
        return "redirect:/fleas";
    }
}
