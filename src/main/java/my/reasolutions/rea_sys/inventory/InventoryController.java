package my.reasolutions.rea_sys.inventory;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "Inventory")
@RequestMapping("inventory")
public class InventoryController {
    private final InventoryService inventoryService;

    @PostMapping
    public ResponseEntity<Long> addInventory(@RequestBody @Valid InventoryRequest request) {
        return ResponseEntity.ok(inventoryService.addInventory(request));
    }

    @GetMapping
    public ResponseEntity<List<InventoryResponse>> listInventory() {
        return ResponseEntity.ok(inventoryService.getInventories());
    }

    @GetMapping("/{inventory-id}")
    public ResponseEntity<InventoryResponse> getInventory(@PathVariable("inventory-id") Long inventoryId) {
        return ResponseEntity.ok(inventoryService.getInventoryById(inventoryId));
    }

    @PutMapping
    public ResponseEntity<Void> updateInventory(@RequestBody @Valid InventoryRequest request) {
        inventoryService.updateInventory(request);
        return ResponseEntity.accepted().build();
    }

    public ResponseEntity<Void> deleteInventory(@PathVariable("inventory-id") Long inventoryId) {
        inventoryService.deleteInventory(inventoryId);
        return ResponseEntity.accepted().build();
    }
}
