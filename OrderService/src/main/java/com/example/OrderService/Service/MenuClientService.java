package com.example.OrderService.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.example.OrderService.Dto.MenuItemDTO;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@Service
public class MenuClientService {
	 private static final String MENU_SERVICE_URL = "http://menu-service/menu/";
	   @Autowired
	    private RestTemplate restTemplate;
	   
	 @Retry(name = "menu-service", fallbackMethod = "getMenuItemFallback")
	 @CircuitBreaker(name = "menu-service", fallbackMethod = "getMenuItemFallback")
	 public MenuItemDTO getMenuItemById(Long menuItemId) {
	    	try {
	    		String url = MENU_SERVICE_URL + menuItemId;
	            MenuItemDTO menuItem = restTemplate.getForObject(url, MenuItemDTO.class);
	            return menuItem;
				
			} catch (Exception e) {
				// TODO: handle exception
				throw new RuntimeException("Service call failed",e );
			}
	        
	    }
	@Retry(name = "menu-service", fallbackMethod = "getMenuItemPriceFallback")
    @CircuitBreaker(name = "menu-service", fallbackMethod = "getMenuItemPriceFallback")
    public double getMenuPrice(Long menuItemId) {
    	try {
    		String url = MENU_SERVICE_URL + menuItemId;
            MenuItemDTO menuItem = restTemplate.getForObject(url, MenuItemDTO.class);
            return menuItem != null ? menuItem.getPrice() : 0.0;
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException("Service call failed",e );
		}
        
    }
	public MenuItemDTO getMenuItemFallback(Long menuId, Throwable t) {
        // Return default response or cached data
        MenuItemDTO fallbackItem = new MenuItemDTO();
        fallbackItem.setId(menuId);
        fallbackItem.setPrice(0.0);
        fallbackItem.setName("Unavailable");
        return fallbackItem;
    }

    public double getMenuItemPriceFallback(Long menuItemId, Throwable t) {
        System.out.println("Fallback triggered for menu item ID " + menuItemId + ", reason: " + t.getMessage());
        return 0.001;
    }
}
