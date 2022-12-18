package com.gcu.store;

import com.gcu.store.business.ItemBusinessInterface;
import com.gcu.store.business.ItemBusinessService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Bean(name="ItemBusinessService")
    public ItemBusinessInterface getItemBusiness()
    {
        return new ItemBusinessService();
    }
}
