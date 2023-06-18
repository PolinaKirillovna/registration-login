package controllers;



import entitities.Owner;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import services.OwnerService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class OwnerController {

    private final OwnerService ownerService;

    @GetMapping("/owners")
    @ApiOperation(value = "Get Owners", notes = "Returns a list of all owners")
    public List<Owner> getOwners() {
        return ownerService.findAll();
    }

    @ApiOperation(value = "Update Owner", notes = "Updates an existing owner")
    @PutMapping("/owners/{id}")
    public Owner updateOwner (@PathVariable Long id, @RequestBody Owner owner) {
        ownerService.updateOwner(id, owner);
        return owner;
    }

    @ApiOperation(value = "Save Owner", notes = "Creates a new owner")
    @PostMapping("/owners")
    public Owner createOwner(@RequestBody Owner owner) {
        ownerService.saveOwner(owner);
        return owner;
    }


    @ApiOperation(value = "Delete Owner", notes = "Deletes an owner by ID")
    @DeleteMapping("/owners/{id}")
    @ResponseStatus(HttpStatus.FOUND) // 302 redirect
    public String deleteOwner(@PathVariable Long id) {
        ownerService.deleteById(id);
        // redirect to getOwners endpoint
        return "redirect:/owners";
    }
    @GetMapping("/{id}")
    @PreAuthorize("@securityService.hasAccessToOwner(#username, #id)")
    public Optional<Owner> getOwner(@RequestParam String username, @PathVariable int id) {
        return ownerService.findById(id);
    }

}