package my.reasolutions.rea_sys.inventory;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryService {
    private final InventoryRepository inventoryRepository;

    public Long addInventory(@Valid InventoryRequest request) {
        return null;
    }

    public List<InventoryResponse> getInventories() {
        return null;
    }

    public InventoryResponse getInventoryById(Long inventoryId) {
        return null;
    }

    public void updateInventory(@Valid InventoryRequest request) {

    }

    public void deleteInventory(Long inventoryId) {

    }
}
